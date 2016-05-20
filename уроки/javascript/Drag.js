function drag(elementToDrag, event){
	var array_of_points_to_white_lines = new Array();
	var array_of_lines_to_red_point = new Array();
	var tr = document.getElementById("pointsTable").getElementsByTagName('tr');
	var findX = null;
	var findY = null;
	var findR = null;
	for(var i = 0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName('td');
		for(var j = 0; j < td.length; j++){
			if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToDrag.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToDrag.style.width.replace(/\D+/g,""))/2)) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToDrag.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2))){
				findX = td[0];
				findY = td[1];
				findR = td[3];
				break;
			}
		}
	}

	var startX = event.clientX;
	var startY = event.clientY;
	var origX = elementToDrag.offsetLeft;
	var origY = elementToDrag.offsetTop;
	var deltaX = startX - origX;
	var deltaY = startY - origY;

	var x = event.clientX - deltaX;
	var y = event.clientY - deltaY;

	var radiusOfCentralPoint = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
	var svg = document.getElementsByTagName("svg");
	var offset_SVG = svg[0].getBoundingClientRect();
	var lines = document.getElementsByTagName("line");
	var findedLines = new Array();
	var j = 0;
	for(var i = 0; i < lines.length; i++){
		if(lines[i].getAttribute("x1") == (x-offset_SVG.left+radiusOfCentralPoint) && lines[i].getAttribute("y1") == (y-offset_SVG.top+radiusOfCentralPoint)){
			findedLines[j] = lines[i];
			findedLines[j].setAttribute("ch", "1");
			j++;
		}
		if(lines[i].getAttribute("x2") == (x-offset_SVG.left+radiusOfCentralPoint) && lines[i].getAttribute("y2") == (y-offset_SVG.top+radiusOfCentralPoint)){
			findedLines[j] = lines[i];
			findedLines[j].setAttribute("ch", "2");
			j++;
		}
	}

	var l = 0;
	var findTR = new Array();
	for(var i = 0; i < findedLines.length; i++){
		var table = document.getElementById("linesTable");
		var tr = document.getElementById("linesTable").getElementsByTagName('tr');
		for(var j = 0; j < tr.length; j++){
			var td = tr[j].getElementsByTagName('td');
			if(parseInt(Number(findedLines[i].getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
				findTR[l] = tr[j];
				l++;
			}
		}
	}

	function dragG(elementToDrag, e){
		var polygons = document.getElementsByTagName("polygon");
		var p = 0;
		for(var i = 0; i < findedLines.length; i++){
			if(findedLines[i].getAttribute("lengthLine")){
				p++;
			}
		}
		if(p == 0){
			if(!e) e = window.event;
			elementToDrag.style.left = (e.clientX - deltaX) + "px";
			elementToDrag.style.top = (e.clientY - deltaY) + "px";

			for(var i = 0; i < findedLines.length; i++){
				var fLine = findedLines[i];
				var x1 = Number(fLine.getAttribute("x1"))-radiusOfCentralPoint+offset_SVG.left;
				var y1 = Number(fLine.getAttribute("y1"))-radiusOfCentralPoint+offset_SVG.top;
				var x2 = Number(fLine.getAttribute("x2"))-radiusOfCentralPoint+offset_SVG.left;
				var y2 = Number(fLine.getAttribute("y2"))-radiusOfCentralPoint+offset_SVG.top;
				if(fLine.getAttribute("ch") == "1"){
					changePolyAndLinesCH1(fLine, findTR, offset_SVG, elementToDrag, radiusOfCentralPoint, polygons);
				}
				else if(fLine.getAttribute("ch") == "2"){
					findPolyAndLinesCH2(fLine, findTR, offset_SVG, elementToDrag, radiusOfCentralPoint, polygons)
				}
			}

			findX.innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToDrag.style.width.replace(/\D+/g,""))/2)) + "px";
			findY.innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2)) + "px";
			findR.innerHTML = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
		}
		else if(p == 1){
			var fixLine = null;
			for(var i = 0; i < findedLines.length; i++){
				if(findedLines[i].getAttribute("lengthLine")){
					fixLine = findedLines[i];
				}
			}
			var lineLength = Number(fixLine.getAttribute("lengthLine"));
			var xfix = 0;
			var yfix = 0;
			if(fixLine.getAttribute("ch") == "1"){
				xfix = Number(fixLine.getAttribute("x2"))+offset_SVG.left;
				yfix = Number(fixLine.getAttribute("y2"))+offset_SVG.top;
			}
			else{
				xfix = Number(fixLine.getAttribute("x1"))+offset_SVG.left;
				yfix = Number(fixLine.getAttribute("y1"))+offset_SVG.top;
			}

			if(!e) e = window.event;

			var center = {};
			center.x = xfix; 
			center.y = yfix;
			var point = {};
			point.x = (e.clientX - deltaX) + parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2); 
			point.y = (e.clientY - deltaY) + parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
			var angle = get_angle(center, point);
			
			var radius = lineLength;
			var angleOffset = -90;
			var deg2rad = Math.PI/180;
			var rad2deg = 180/Math.PI;
			var angle2 = angle + angleOffset;
			var radangle = angle2*deg2rad;
			var left = radius*Math.cos(radangle) + xfix - parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
			var top = radius*Math.sin(radangle) + yfix - parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);

			elementToDrag.style.left = parseInt(left) + "px";
			elementToDrag.style.top = parseInt(top) + "px";

			for(var i = 0; i < findedLines.length; i++){
				var fLine = findedLines[i];
				var x1 = Number(fLine.getAttribute("x1"))-radiusOfCentralPoint+offset_SVG.left;
				var y1 = Number(fLine.getAttribute("y1"))-radiusOfCentralPoint+offset_SVG.top;
				var x2 = Number(fLine.getAttribute("x2"))-radiusOfCentralPoint+offset_SVG.left;
				var y2 = Number(fLine.getAttribute("y2"))-radiusOfCentralPoint+offset_SVG.top;
				if(fLine.getAttribute("ch") == "1"){
					changePolyAndLinesCH1(fLine, findTR, offset_SVG, elementToDrag, radiusOfCentralPoint, polygons);
				}
				else if(fLine.getAttribute("ch") == "2"){
					findPolyAndLinesCH2(fLine, findTR, offset_SVG, elementToDrag, radiusOfCentralPoint, polygons)
				}
			}

			findX.innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToDrag.style.width.replace(/\D+/g,""))/2)) + "px";
			findY.innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2)) + "px";
			findR.innerHTML = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
		}
		else{}
	}

	if(document.addEventListener){
		document.addEventListener("mousemove", moveHandler, true);
		document.addEventListener("mouseup", upHandler, true);
	}
	
	if(event.stopPropagation) event.stopPropagation();
	else event.cancelBubble = true;

	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;

	function moveHandler(e){
		dragG(elementToDrag,e);
		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	}

	function upHandler(e){
		if(!e) e = window.event;
		document.removeEventListener("mouseup", upHandler, true);
		document.removeEventListener("mousemove", moveHandler, true);

		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	}
}

function findPointsOfTangent(line, radiusOfCentralPoint, radiusOfSecondPoint, xOfCentralPoint, yOfCentralPoint, xOfSecondPoint, yOfSecondPoint){
	var lengthOfLine = getLineLength(line);
	var lengthOfCathetusFirstTriangle = Math.sqrt(lengthOfLine*lengthOfLine - radiusOfCentralPoint*radiusOfCentralPoint);
	var lengthOfCathetusSecondTriangle = Math.sqrt(lengthOfLine*lengthOfLine - radiusOfSecondPoint*radiusOfSecondPoint);
	var ya, yb, xa, xb, ya2, yb2, xa2, xb2;
    var center = {};
    center.x = xOfCentralPoint;
    center.y = yOfCentralPoint;
    var point = {};
    point.x = xOfSecondPoint;
    point.y = yOfSecondPoint;
	var e3 = center.x - point.x;
	var c = center.y - point.y;
    var q = (lengthOfCathetusFirstTriangle*lengthOfCathetusFirstTriangle - radiusOfCentralPoint*radiusOfCentralPoint + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
    var A = c*c + e3*e3; 
    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - radiusOfCentralPoint*radiusOfCentralPoint*e3*e3;
    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
    xa = (q - ya*c)/e3;
    xb = (q - yb*c)/e3;
    
	var e2 = point.x - center.x;
	var c2 = point.y - center.y;
    var q2 = (lengthOfCathetusSecondTriangle*lengthOfCathetusSecondTriangle - radiusOfSecondPoint*radiusOfSecondPoint + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
    var A2 = c2*c2 + e2*e2; 
    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - radiusOfSecondPoint*radiusOfSecondPoint*e2*e2;
    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
    xa2 = (q2 - ya2*c2)/e2;
    xb2 = (q2 - yb2*c2)/e2;
    var resultArray = new Array(xa, xb, ya, yb, xa2, xb2, ya2, yb2);
    return resultArray;
}

function changePolyAndLinesCH1(line, tableTR, offset_SVG, elementToDrag, radiusOfCentralPoint, polygons){
	for(var u = 0; u < tableTR.length; u++){
		var td = tableTR[u].getElementsByTagName('td');
		if(parseInt(Number(line.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(line.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(line.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(line.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
			td[0].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+radiusOfCentralPoint);
			td[1].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+radiusOfCentralPoint);
			break;
		}
	}

	var x_center = Number(line.getAttribute("x1")) + offset_SVG.left;
	var y_center = Number(line.getAttribute("y1")) + offset_SVG.top;
	var x_of_second_point = Number(line.getAttribute("x2")) + offset_SVG.left;
	var y_of_second_point = Number(line.getAttribute("y2")) + offset_SVG.top;

	var points = document.getElementsByClassName("movedElement");
	var findedPoint;
	for(var o = 0; o < points.length; o++){
		if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
			findedPoint = points[o];
			break;
		}
	}
	var radiusOfSecondPoint = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

	var pointsOfTangent = findPointsOfTangent(line, radiusOfCentralPoint, radiusOfSecondPoint, x_center, y_center, x_of_second_point, y_of_second_point);
   					   	
    var allOptions = allOptionsOfCoordinates(pointsOfTangent, offset_SVG);

    var finded_poly = null;
    for(var i = 0; i < polygons.length; i++){
    	for(var j = 0; j < allOptions.length; j++){
    		if(String(polygons[i].getAttribute("points")) == allOptions[j]){
    			finded_poly = polygons[i];
    			break;
    		}
    	}
    }

    line.setAttribute("x1", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+radiusOfCentralPoint-offset_SVG.left));
	line.setAttribute("y1", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+radiusOfCentralPoint-offset_SVG.top));

	var x_changed_of_the_first_point = Number(line.getAttribute("x1")) + offset_SVG.left;
	var y_changed_of_the_first_point = Number(line.getAttribute("y1")) + offset_SVG.top;

	var pointsOfTangent = findPointsOfTangent(line, radiusOfCentralPoint, radiusOfSecondPoint, x_changed_of_the_first_point, y_changed_of_the_first_point, x_of_second_point, y_of_second_point);
	
	finded_poly.setAttribute("points", parseInt(pointsOfTangent[0]-offset_SVG.left) + "," + parseInt(pointsOfTangent[2]-offset_SVG.top) + " " + parseInt(pointsOfTangent[4]-offset_SVG.left) + "," + parseInt(pointsOfTangent[6]-offset_SVG.top) + " " + parseInt(pointsOfTangent[5]-offset_SVG.left) + "," + parseInt(pointsOfTangent[7]-offset_SVG.top) + " " + parseInt(pointsOfTangent[1]-offset_SVG.left) + "," + parseInt(pointsOfTangent[3]-offset_SVG.top));
}

function findPolyAndLinesCH2(line, tableTR, offset_SVG, elementToDrag, radiusOfCentralPoint, polygons){
	for(var u = 0; u < tableTR.length; u++){
		var td = tableTR[u].getElementsByTagName('td');
		if(parseInt(Number(line.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(line.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(line.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(line.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
			td[2].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+radiusOfCentralPoint);
			td[3].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+radiusOfCentralPoint);
		}
	}

	var x_center = Number(line.getAttribute("x2")) + offset_SVG.left;
	var y_center = Number(line.getAttribute("y2")) + offset_SVG.top;
	var x_of_second_point = Number(line.getAttribute("x1")) + offset_SVG.left;
	var y_of_second_point = Number(line.getAttribute("y1")) + offset_SVG.top;

	var points = document.getElementsByClassName("movedElement");
	var findedPoint;
	for(var o = 0; o < points.length; o++){
		if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
			findedPoint = points[o];
			break;
		}
	}
	var radiusOfSecondPoint = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

    var pointsOfTangent = findPointsOfTangent(line, radiusOfCentralPoint, radiusOfSecondPoint, x_center, y_center, x_of_second_point, y_of_second_point);

    var allOptions = allOptionsOfCoordinates(pointsOfTangent, offset_SVG);

    var finded_poly = null;
    for(var i = 0; i < polygons.length; i++){
    	for(var j = 0; j < allOptions.length; j++){
    		if(String(polygons[i].getAttribute("points")) == allOptions[j]){
    			finded_poly = polygons[i];
    			break;
    		}
    	}
    }

    line.setAttribute("x2", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+radiusOfCentralPoint-offset_SVG.left));
	line.setAttribute("y2", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+radiusOfCentralPoint-offset_SVG.top));

	var x_changed_of_the_first_point = Number(line.getAttribute("x2")) + offset_SVG.left;
	var y_changed_of_the_first_point = Number(line.getAttribute("y2")) + offset_SVG.top;

    var pointsOfTangent = findPointsOfTangent(line, radiusOfCentralPoint, radiusOfSecondPoint, x_changed_of_the_first_point, y_changed_of_the_first_point, x_of_second_point, y_of_second_point);
	
	finded_poly.setAttribute("points", parseInt(pointsOfTangent[0]-offset_SVG.left) + "," + parseInt(pointsOfTangent[2]-offset_SVG.top) + " " + parseInt(pointsOfTangent[4]-offset_SVG.left) + "," + parseInt(pointsOfTangent[6]-offset_SVG.top) + " " + parseInt(pointsOfTangent[5]-offset_SVG.left) + "," + parseInt(pointsOfTangent[7]-offset_SVG.top) + " " + parseInt(pointsOfTangent[1]-offset_SVG.left) + "," + parseInt(pointsOfTangent[3]-offset_SVG.top));	
}

function allOptionsOfCoordinates(pointsOfTangent, offset_SVG){
	var coordinates1 = String(String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top));
   	var coordinates2 = String(String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top));
   	var coordinates3 = String(String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top));
   	var coordinates4 = String(String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top));
   	var coordinates5 = String(String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top));
   	var coordinates6 = String(String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top));
   	var coordinates7 = String(String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top));
   	var coordinates8 = String(String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top));
   	var coordinates9 = String(String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top));
   	var coordinates10 = String(String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top));
   	var coordinates11 = String(String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top));
   	var coordinates12 = String(String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top));
   	var coordinates13 = String(String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top));
   	var coordinates14 = String(String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top));
   	var coordinates15 = String(String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top));
   	var coordinates16 = String(String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top));
   	var coordinates17 = String(String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top));
   	var coordinates18 = String(String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top));
   	var coordinates19 = String(String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top));
    var coordinates20 = String(String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top));
   	var coordinates21 = String(String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top));
    var coordinates22 = String(String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top));
    var coordinates23 = String(String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top));
    var coordinates24 = String(String(parseInt(pointsOfTangent[1])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[3])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[5])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[7])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[4])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[6])-offset_SVG.top) + " " + String(parseInt(pointsOfTangent[0])-offset_SVG.left) + "," + String(parseInt(pointsOfTangent[2])-offset_SVG.top));
    var resultArray = new Array(coordinates1, coordinates2, coordinates3, coordinates4, coordinates5, coordinates6, coordinates7, coordinates8, coordinates9, coordinates10, coordinates11, coordinates12, coordinates13, coordinates14, coordinates15, coordinates16, coordinates17, coordinates18, coordinates19, coordinates20, coordinates21, coordinates22, coordinates23, coordinates24);
    return resultArray;
}
