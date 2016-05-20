window.onload = function(){
	var table2 = document.getElementById("table2");
	table2.style.display = "none";
}

function addCreate(){	
	document.addEventListener('click', creatingPoints, false);
}

function removeCreate(){
	document.removeEventListener('click', creatingPoints, false);
}

function addMove(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = function(e){
			drag(this, e);
		}
	}
}

function removeMove(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = null;
	}
}

function addMoveLines(){
	var elements = document.getElementsByTagName('line');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = function(e){
			dragLine(this, e);
		}
	}
}

function removeMoveLines(){
	var elements = document.getElementsByTagName('line');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = null;
	}
}

function addContext(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].oncontextmenu = changeColour;
	}
}

function removeContext(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].oncontextmenu = null;
	}
}

function addContextLine(){
	var elements = document.getElementsByTagName('line');
	for(var i = 0; i < elements.length; i++){
		elements[i].oncontextmenu = changeColorLine;
	}
}

function removeContextLine(){
	var elements = document.getElementsByTagName('line');
	for(var i = 0; i < elements.length; i++){
		elements[i].oncontextmenu = null;
	}
}

function addTransform(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = function(e){
			changeRadius(this, e);
		}
	}
}

function removeTransform(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = null;
	}
}

function addDraw(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = function(e){
			drawLine(this, e);
		}
	}
}

function tableWithParametersShow(){
	var table1 = document.getElementById("table1");
	var table2 = document.getElementById("table2");
	table1.style.display = "block";
	table2.style.display = "none";
}

function inputsShow(){
	var table1 = document.getElementById("table1");
	var table2 = document.getElementById("table2");
	table2.style.display = "block";
	table1.style.display = "none";
}

function removeDraw(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = null;
	}
}

function calculate(){
	var elements = document.getElementsByClassName('movedElement');
	var allMass = 0;
	for(var i = 0; i < elements.length; i++){
		if(elements[i].style.background == "red"){
			allMass += Number(elements[i].getAttribute("mass").replace(/\D+/g,""));
		}
	}
	alert(allMass);
}

function creatingPoints(e){
	var element = e.target || e.srcElement;
	if(element == '[object SVGSVGElement]'){
		var div = document.createElement("div");
		div.className = "movedElement";
		//div.style.background = "rgba(128, 128, 128, 0.29)";
		div.style.background = "gray";
		div.style.left = (e.pageX - 10) + "px";
		div.style.top = (e.pageY - 10) + "px";
		div.style.position = "absolute";
		div.style.height = "20px"; 
		div.style.width = "20px";
		div.style.borderRadius = "100%";
		div.style.zIndex = "1";
		div.setAttribute("mass", "10kg");
		
		div.onmousedown = function(e){
			drag(this, e);
		}
		
		div.oncontextmenu = changeColour;

		document.body.appendChild(div);

		var table = document.getElementById("pointsTable");
		var row = table.insertRow(table.rows.length);
		var cell0 = row.insertCell(0);
		var cell1 = row.insertCell(1);
		var cell2 = row.insertCell(2);
		var cell3 = row.insertCell(3);
		var cell4 = row.insertCell(4);
		cell0.innerHTML = Number(div.style.left.replace(/\D+/g,"")) + Number(div.style.width.replace(/\D+/g,""))/2 + "px";
		cell1.innerHTML = Number(div.style.top.replace(/\D+/g,"")) + Number(div.style.height.replace(/\D+/g,""))/2 + "px";
		cell2.innerHTML = div.style.background;
		cell3.innerHTML = Number(div.style.height.replace(/\D+/g,""))/2;
		cell4.innerHTML = div.getAttribute("mass");
		row.style.background = div.style.background; 
	}
	
}

function changeColour(e){
	e = e || window.event;
	e.preventDefault ? e.preventDefault() : e.returnValue = false;
	var el = e.target || e.srcElement;
	if(el.style.background == "gray"){
		el.style.background = "red";
		var tr = document.getElementById("pointsTable").getElementsByTagName('tr');
		for(var i = 0; i < tr.length; i++){
			var td = tr[i].getElementsByTagName('td');
			for(var j = 0; j < td.length; j++){
				if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(el.style.left.replace(/\D+/g,"")) + Number(el.style.width.replace(/\D+/g,""))/2) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(el.style.top.replace(/\D+/g,"")) + Number(el.style.height.replace(/\D+/g,""))/2)){
					td[2].innerHTML = el.style.background;
					tr[i].style.background = el.style.background;
				}
			}
		}
	}
	else if(el.style.background == "red"){
		var allPoints = document.getElementsByClassName("movedElement");
		var isGreenPointAlreadyExists = 0;
		for(var i = 0; i < allPoints.length; i++)
			if(allPoints[i].style.background == "green") isGreenPointAlreadyExists = 1;
		if(isGreenPointAlreadyExists == 0){
			el.style.background = "green";
			var tr = document.getElementById("pointsTable").getElementsByTagName('tr');
			for(var i = 0; i < tr.length; i++){
				var td = tr[i].getElementsByTagName('td');
				for(var j = 0; j < td.length; j++){
					if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(el.style.left.replace(/\D+/g,"")) + Number(el.style.width.replace(/\D+/g,""))/2) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(el.style.top.replace(/\D+/g,"")) + Number(el.style.height.replace(/\D+/g,""))/2)){
						td[2].innerHTML = el.style.background;
						tr[i].style.background = el.style.background;
					}
				}
			}
		}
	}
	else{
		var table = document.getElementById("pointsTable");
		var tr = document.getElementById("pointsTable").getElementsByTagName('tr');
		for(var i = 0; i < tr.length; i++){
			var td = tr[i].getElementsByTagName('td');
			for(var j = 0; j < td.length; j++){
				if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(el.style.left.replace(/\D+/g,"")) + Number(el.style.width.replace(/\D+/g,""))/2) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(el.style.top.replace(/\D+/g,"")) + Number(el.style.height.replace(/\D+/g,""))/2)){
					table.deleteRow(i);
					break;
				}
			}
		}

		var polygons = document.getElementsByTagName("polygon");
		var radiusOfCentralPoint = parseInt(Number(el.style.height.replace(/\D+/g,""))/2);
		var svg = document.getElementsByTagName("svg");
		var offset_SVG = svg[0].getBoundingClientRect();
		var lines = document.getElementsByTagName("line");
		var findedLines = new Array();
		var j = 0;
		for(var i = 0; i < lines.length; i++){
			if(lines[i].getAttribute("x1") == (Number(el.style.left.replace(/\D+/g,""))-offset_SVG.left+radiusOfCentralPoint) && lines[i].getAttribute("y1") == (Number(el.style.top.replace(/\D+/g,""))-offset_SVG.top+radiusOfCentralPoint)){
				findedLines[j] = lines[i];
				findedLines[j].setAttribute("ch", "1");
				j++;
			}
			if(lines[i].getAttribute("x2") == (Number(el.style.left.replace(/\D+/g,""))-offset_SVG.left+radiusOfCentralPoint) && lines[i].getAttribute("y2") == (Number(el.style.top.replace(/\D+/g,""))-offset_SVG.top+radiusOfCentralPoint)){
				findedLines[j] = lines[i];
				findedLines[j].setAttribute("ch", "2");
				j++;
			}
		}

		for(var i = 0; i < findedLines.length; i++){
			var table = document.getElementById("linesTable");
			var tr = document.getElementById("linesTable").getElementsByTagName('tr');
			for(var j = 0; j < tr.length; j++){
				var td = tr[j].getElementsByTagName('td');
				if(parseInt(Number(findedLines[i].getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
					table.deleteRow(j);
					break;
				}
			}

			if(findedLines[i].getAttribute("ch") == "1"){
				var x_of_second_point = Number(findedLines[i].getAttribute("x2")) + offset_SVG.left;
				var y_of_second_point = Number(findedLines[i].getAttribute("y2")) + offset_SVG.top;
				var points = document.getElementsByClassName("movedElement");
				var findedPoint;
				for(var o = 0; o < points.length; o++){
					if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
						findedPoint = points[o];
						break;
					}
				}
				var radiusOfSecondPoint = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

				var pointsOfTangent = findPointsOfTangent(findedLines[i], radiusOfCentralPoint, radiusOfSecondPoint, Number(el.style.left.replace(/\D+/g,"")) + parseInt(Number(el.style.height.replace(/\D+/g,""))/2), Number(el.style.top.replace(/\D+/g,"")) + parseInt(Number(el.style.height.replace(/\D+/g,""))/2), x_of_second_point, y_of_second_point);
   					   	
			    var allOptions = allOptionsOfCoordinates(pointsOfTangent, offset_SVG);

			    for(var k = 0; k < polygons.length; k++){
			    	for(var t = 0; t < allOptions.length; t++){
			    		if(String(polygons[k].getAttribute("points")) == allOptions[t]){
			    			svg[0].removeChild(polygons[k]);
			    			break;
			    		}
			    	}
			    }
			}
			else if(findedLines[i].getAttribute("ch") == "2"){
				var x_of_second_point = Number(findedLines[i].getAttribute("x1")) + offset_SVG.left;
				var y_of_second_point = Number(findedLines[i].getAttribute("y1")) + offset_SVG.top;
				var points = document.getElementsByClassName("movedElement");
				var findedPoint;
				for(var o = 0; o < points.length; o++){
					if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
						findedPoint = points[o];
						break;
					}
				}
				var radiusOfSecondPoint = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

			    var pointsOfTangent = findPointsOfTangent(findedLines[i], radiusOfCentralPoint, radiusOfSecondPoint, Number(el.style.left.replace(/\D+/g,"")) + parseInt(Number(el.style.height.replace(/\D+/g,""))/2), Number(el.style.top.replace(/\D+/g,"")) + parseInt(Number(el.style.height.replace(/\D+/g,""))/2), x_of_second_point, y_of_second_point);
   					   	
			   	var allOptions = allOptionsOfCoordinates(pointsOfTangent, offset_SVG);

			    for(var k = 0; k < polygons.length; k++){
			    	for(var t = 0; t < allOptions.length; t++){
			    		if(String(polygons[k].getAttribute("points")) == allOptions[t]){
			    			svg[0].removeChild(polygons[k]);
			    			break;
			    		}
			    	}
			    }
			}

			svg[0].removeChild(findedLines[i]);
		}
	
		document.body.removeChild(el);
	}
	e.stopPropagation();
}

function changeRadius(elementToChange, event){
	var tr = document.getElementById("pointsTable").getElementsByTagName('tr');
	var findX = null;
	var findY = null;
	var findR = null;
	var findM = null;
	for(var i = 0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName('td');
		for(var j = 0; j < td.length; j++){
			if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToChange.style.left.replace(/\D+/g,"")) + Number(elementToChange.style.width.replace(/\D+/g,""))/2) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToChange.style.top.replace(/\D+/g,"")) + Number(elementToChange.style.height.replace(/\D+/g,""))/2)){
				findX = td[0];
				findY = td[1];
				findR = td[3];
				findM = td[4];
				break;
			}
		}
	}
	var radius = parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
	var startY = event.clientY;
	var spY = Number(elementToChange.style.top.replace(/\D+/g,"")) + radius;
	var spX = Number(elementToChange.style.left.replace(/\D+/g,"")) + radius;
	document.addEventListener("mousemove", moveH, true);
	document.addEventListener("mouseup", upH, true);

	if(event.stopPropagation) event.stopPropagation();
	else event.cancelBubble = true;

	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;

	function change(e){
		if(e.clientY < startY){
			var res = radius - Math.abs(startY - e.clientY);
		}
		else{
			var res = radius + Math.abs(startY - e.clientY);
		}
		if(res < 5){
			res = 5;
		}
		if(res > 100){
			res = 100;
		}
		return res + "px";
	}

	function moveH(e){
		if(!e) e = window.event;

		var radiusOfCentralPointStart = parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
		var svg = document.getElementsByTagName("svg");
		var offset_SVG = svg[0].getBoundingClientRect();
		var lines = document.getElementsByTagName("line");
		var findedLines = new Array();
		var j = 0;
		for(var i = 0; i < lines.length; i++){
			if(lines[i].getAttribute("x1") == (parseInt(Number(elementToChange.style.left.replace(/\D+/g,"")))-offset_SVG.left+radiusOfCentralPointStart) && lines[i].getAttribute("y1") == (parseInt(Number(elementToChange.style.top.replace(/\D+/g,"")))-offset_SVG.top+radiusOfCentralPointStart)){
				findedLines[j] = lines[i];
				findedLines[j].setAttribute("ch", "1");
				j++;
			}
			if(lines[i].getAttribute("x2") == (parseInt(Number(elementToChange.style.left.replace(/\D+/g,"")))-offset_SVG.left+radiusOfCentralPointStart) && lines[i].getAttribute("y2") == (parseInt(Number(elementToChange.style.top.replace(/\D+/g,"")))-offset_SVG.top+radiusOfCentralPointStart)){
				findedLines[j] = lines[i];
				findedLines[j].setAttribute("ch", "2");
				j++;
			}
		}

		elementToChange.style.height = change(e);
		elementToChange.style.width = change(e);

		var radius2 = parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
		var epY = Number(elementToChange.style.top.replace(/\D+/g,"")) + radius2;
		var epX = Number(elementToChange.style.left.replace(/\D+/g,"")) + radius2;
		if(epY > spY){
			var cY = parseInt(Math.abs(spY - epY));
			var cX = parseInt(Math.abs(spX - epX));
			elementToChange.style.top = Number(elementToChange.style.top.replace(/\D+/g,"")) - cY + "px";
			elementToChange.style.left = Number(elementToChange.style.left.replace(/\D+/g,"")) - cX + "px";
		}
		else{
			var cY = parseInt(Math.abs(spY - epY));
			var cX = parseInt(Math.abs(spX - epX));
			elementToChange.style.top = Number(elementToChange.style.top.replace(/\D+/g,"")) + cY + "px";
			elementToChange.style.left = Number(elementToChange.style.left.replace(/\D+/g,"")) + cX + "px";
		}
		findX.innerHTML = parseInt(Number(elementToChange.style.left.replace(/\D+/g,"")) + Number(elementToChange.style.width.replace(/\D+/g,""))/2) + "px";
		findY.innerHTML = parseInt(Number(elementToChange.style.top.replace(/\D+/g,"")) + Number(elementToChange.style.height.replace(/\D+/g,""))/2) + "px";
		findR.innerHTML = parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
		findM.innerHTML = parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2) + "kg";

		var polygons = document.getElementsByTagName("polygon");
		var radiusOfCentralPoint = parseInt(Number(elementToChange.style.width.replace(/\D+/g,""))/2);
		for(var i = 0; i < findedLines.length; i++){
			if(findedLines[i].getAttribute("ch") == "1"){
				var x_of_second_point = Number(findedLines[i].getAttribute("x2")) + offset_SVG.left;
				var y_of_second_point = Number(findedLines[i].getAttribute("y2")) + offset_SVG.top;
				var points = document.getElementsByClassName("movedElement");
				var findedPoint;
				for(var o = 0; o < points.length; o++){
					if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
						findedPoint = points[o];
						break;
					}
				}
				var radiusOfSecondPoint = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

				var pointsOfTangent = findPointsOfTangent(findedLines[i], radiusOfCentralPointStart, radiusOfSecondPoint, Number(elementToChange.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), Number(elementToChange.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), x_of_second_point, y_of_second_point);
   					 
				var allOptions = allOptionsOfCoordinates(pointsOfTangent, offset_SVG);

			    var finded_poly = null;
			    for(var k = 0; k < polygons.length; k++){
			    	for(var t = 0; t < allOptions.length; t++){
			    		if(String(polygons[k].getAttribute("points")) == allOptions[t]){
			    			finded_poly = polygons[k];
			    			break;
			    		}
			    	}
			    }

				var pointsOfTangent = findPointsOfTangent(findedLines[i], radiusOfCentralPoint, radiusOfSecondPoint, Number(elementToChange.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), Number(elementToChange.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), x_of_second_point, y_of_second_point);
	
				finded_poly.setAttribute("points", parseInt(pointsOfTangent[0]-offset_SVG.left) + "," + parseInt(pointsOfTangent[2]-offset_SVG.top) + " " + parseInt(pointsOfTangent[4]-offset_SVG.left) + "," + parseInt(pointsOfTangent[6]-offset_SVG.top) + " " + parseInt(pointsOfTangent[5]-offset_SVG.left) + "," + parseInt(pointsOfTangent[7]-offset_SVG.top) + " " + parseInt(pointsOfTangent[1]-offset_SVG.left) + "," + parseInt(pointsOfTangent[3]-offset_SVG.top));
			}
			else if(findedLines[i].getAttribute("ch") == "2"){
				var x_of_second_point = Number(findedLines[i].getAttribute("x1")) + offset_SVG.left;
				var y_of_second_point = Number(findedLines[i].getAttribute("y1")) + offset_SVG.top;
				var points = document.getElementsByClassName("movedElement");
				var findedPoint;
				for(var o = 0; o < points.length; o++){
					if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
						findedPoint = points[o];
						break;
					}
				}
				var radiusOfSecondPoint = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

			    var pointsOfTangent = findPointsOfTangent(findedLines[i], radiusOfCentralPointStart, radiusOfSecondPoint, Number(elementToChange.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), Number(elementToChange.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), x_of_second_point, y_of_second_point);
   					   	
			   	var allOptions = allOptionsOfCoordinates(pointsOfTangent, offset_SVG);

			    var finded_poly = null;
			    for(var k = 0; k < polygons.length; k++){
			    	for(var t = 0; t < allOptions.length; t++){
			    		if(String(polygons[k].getAttribute("points")) == allOptions[t]){
			    			finded_poly = polygons[k];
			    			break;
			    		}
			    	}
			    }

				var pointsOfTangent = findPointsOfTangent(findedLines[i], radiusOfCentralPoint, radiusOfSecondPoint, Number(elementToChange.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), Number(elementToChange.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2), x_of_second_point, y_of_second_point);
	
				finded_poly.setAttribute("points", parseInt(pointsOfTangent[0]-offset_SVG.left) + "," + parseInt(pointsOfTangent[2]-offset_SVG.top) + " " + parseInt(pointsOfTangent[4]-offset_SVG.left) + "," + parseInt(pointsOfTangent[6]-offset_SVG.top) + " " + parseInt(pointsOfTangent[5]-offset_SVG.left) + "," + parseInt(pointsOfTangent[7]-offset_SVG.top) + " " + parseInt(pointsOfTangent[1]-offset_SVG.left) + "," + parseInt(pointsOfTangent[3]-offset_SVG.top));
			}
		}
		
		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	}

	function upH(e){
		if(!e) e = window.event;
		document.removeEventListener("mouseup", upH, true);
		document.removeEventListener("mousemove", moveH, true);
		
		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;	
	}
}

function get_angle(center, point){ 
	var x = point.x - center.x; 
	var y = point.y - center.y; 
	if(x==0) return (y>0) ? 180 : 0; 
	var a = Math.atan(y/x)*180/Math.PI; 
	a = (x > 0) ? a+90 : a+270; 
	return a;
}

function drawLine(el, event){
	var x1 = Number(el.style.left.replace(/\D+/g,""));
	var y1 = Number(el.style.top.replace(/\D+/g,""));
	var radiusOfCentralPoint = parseInt(Number(el.style.height.replace(/\D+/g,""))/2);

	document.addEventListener("mousemove", moveHandl, true);
	document.addEventListener("mouseup", upHandl, true);

	if(event.stopPropagation) event.stopPropagation();
	else event.cancelBubble = true;

	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;

	function moveHandl(e){
		if(!e) e = window.event;
		
		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	}

	function upHandl(e){
		if(!e) e = window.event;
		var element = e.target || e.srcElement;
		if(element == '[object HTMLDivElement]' && element != el){
			var x2 = Number(element.style.left.replace(/\D+/g,""));
			var y2 = Number(element.style.top.replace(/\D+/g,""));
			var radiusOfSecondPoint = parseInt(Number(element.style.height.replace(/\D+/g,""))/2);
			var svg = document.getElementsByTagName("svg");
			var offset_SVG = svg[0].getBoundingClientRect();
			var lines = document.getElementsByTagName("line");
			var flag = 0;
			for(var i = 0; i < lines.length; i++){
				if((lines[i].getAttribute("x1") == (x1-offset_SVG.left+radiusOfCentralPoint) && lines[i].getAttribute("y1") == (y1-offset_SVG.top+radiusOfCentralPoint) && lines[i].getAttribute("x2") == (x2-offset_SVG.left+radiusOfSecondPoint) && lines[i].getAttribute("y2") == (y2-offset_SVG.top+radiusOfSecondPoint)) || (lines[i].getAttribute("x1") == (x2-offset_SVG.left+radiusOfSecondPoint) && lines[i].getAttribute("y1") == (y2-offset_SVG.top+radiusOfSecondPoint) && lines[i].getAttribute("x2") == (x1-offset_SVG.left+radiusOfCentralPoint) && lines[i].getAttribute("y2") == (y1-offset_SVG.top+radiusOfCentralPoint))){
					flag = 1;
				}
			}
			if(flag == 0){
				var line = document.createElementNS('http://www.w3.org/2000/svg', 'line');
				line.setAttribute("x1", x1+radiusOfCentralPoint-offset_SVG.left);
				line.setAttribute("y1", y1+radiusOfCentralPoint-offset_SVG.top);
				line.setAttribute("x2", x2+radiusOfSecondPoint-offset_SVG.left);
				line.setAttribute("y2", y2+radiusOfSecondPoint-offset_SVG.top);
				line.setAttribute("style", "stroke: red; stroke-width: 3; z-index: 1;");

				line.oncontextmenu = changeColorLine;
				line.onmousedown = function(e){
					//dragLine(this, e);
				}

				var table = document.getElementById("linesTable");
				var row = table.insertRow(table.rows.length);
				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);
				var cell3 = row.insertCell(3);
				var cell4 = row.insertCell(4);
				cell0.innerHTML = x1+radiusOfCentralPoint;
				cell1.innerHTML = y1+radiusOfCentralPoint;
				cell2.innerHTML = x2+radiusOfSecondPoint;
				cell3.innerHTML = y2+radiusOfSecondPoint;
				cell4.innerHTML = line.style.stroke;
				row.style.background = line.style.stroke;

				var polygon = document.createElementNS('http://www.w3.org/2000/svg', 'polygon');
				
				var pointsOfTangent = findPointsOfTangent(line, radiusOfCentralPoint, radiusOfSecondPoint, parseInt(Number(x1+radiusOfCentralPoint-offset_SVG.left)), parseInt(Number(y1+radiusOfCentralPoint-offset_SVG.top)), parseInt(Number(x2+radiusOfSecondPoint-offset_SVG.left)), parseInt(Number(y2+radiusOfSecondPoint-offset_SVG.top)));
	
				polygon.setAttribute("points", parseInt(pointsOfTangent[0]) + "," + parseInt(pointsOfTangent[2]) + " " + parseInt(pointsOfTangent[4]) + "," + parseInt(pointsOfTangent[6]) + " " + parseInt(pointsOfTangent[5]) + "," + parseInt(pointsOfTangent[7]) + " " + parseInt(pointsOfTangent[1]) + "," + parseInt(pointsOfTangent[3]));

				polygon.setAttribute("style", "fill: #FFECAD; stroke: purple; stroke-width: 1;");
				svg[0].appendChild(polygon);
				svg[0].appendChild(line);
			}
		}
		document.removeEventListener("mouseup", upHandl, true);
		document.removeEventListener("mousemove", moveHandl, true);

		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;	
	}
}

function getLineLength(line){
	var x1 = line.getAttribute("x1");
	var y1 = line.getAttribute("y1");
	var x2 = line.getAttribute("x2");
	var y2 = line.getAttribute("y2");
	var res = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
	return res;
}

function changeColorLine(e){
	e = e || window.event;
	e.preventDefault ? e.preventDefault() : e.returnValue = false;
	var el = e.target || e.srcElement;
	if(el.style.stroke == "red"){
		el.style.stroke = "white";
		var len = getLineLength(el);
		el.setAttribute("lengthLine", len);
		var svg = document.getElementsByTagName("svg");
		var offset_SVG = svg[0].getBoundingClientRect();
		var tr = document.getElementById("linesTable").getElementsByTagName('tr');
		for(var i = 0; i < tr.length; i++){
			var td = tr[i].getElementsByTagName('td');
			for(var j = 0; j < td.length; j++){
				if(parseInt(Number(el.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
					td[4].innerHTML = el.style.stroke;
					tr[i].style.background = el.style.stroke;
					break;
				}
			}
		}
	}
	else if(el.style.stroke == "white"){
		var svg = document.getElementsByTagName("svg");
		var offset_SVG = svg[0].getBoundingClientRect();
		var table = document.getElementById("linesTable");
		var tr = document.getElementById("linesTable").getElementsByTagName('tr');
		for(var i = 0; i < tr.length; i++){
			var td = tr[i].getElementsByTagName('td');
			for(var j = 0; j < td.length; j++){
				if(parseInt(Number(el.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
					table.deleteRow(i);
					break;
				}
			}
		}

		var x_center = Number(el.getAttribute("x1")) + offset_SVG.left;
		var y_center = Number(el.getAttribute("y1")) + offset_SVG.top;
		var x_of_second_point = Number(el.getAttribute("x2")) + offset_SVG.left;
		var y_of_second_point = Number(el.getAttribute("y2")) + offset_SVG.top;
		var points = document.getElementsByClassName("movedElement");
		var findedPoint_1;
		var findedPoint_2;
		
		for(var i = 0; i < points.length; i++){
			if(Number(points[i].style.left.replace(/\D+/g,""))+parseInt(Number(points[i].style.width.replace(/\D+/g,""))/2) == parseInt(x_center) && Number(points[i].style.top.replace(/\D+/g,""))+parseInt(Number(points[i].style.height.replace(/\D+/g,""))/2) == parseInt(y_center)){
				findedPoint_1 = points[i];
			}
		}
		for(var i = 0; i < points.length; i++){
			if(Number(points[i].style.left.replace(/\D+/g,""))+parseInt(Number(points[i].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[i].style.top.replace(/\D+/g,""))+parseInt(Number(points[i].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
				findedPoint_2 = points[i];
			}
		}
		var radiusOfCentralPoint = parseInt(Number(findedPoint_1.style.width.replace(/\D+/g,""))/2);
		var radiusOfSecondPoint = parseInt(Number(findedPoint_2.style.width.replace(/\D+/g,""))/2);
	   	
	   	var pointsOfTangent = findPointsOfTangent(el, radiusOfCentralPoint, radiusOfSecondPoint, x_center, y_center, x_of_second_point, y_of_second_point);
   					   	
	   	var allOptions = allOptionsOfCoordinates(pointsOfTangent, offset_SVG);
	   	var polygons = document.getElementsByTagName("polygon");
	    for(var i = 0; i < polygons.length; i++){
	    	for(var j = 0; j < allOptions.length; j++){
	    		if(String(polygons[i].getAttribute("points")) == allOptions[j]){
	    			svg[0].removeChild(polygons[i]);
	    		}
	    	}
	    }

		svg[0].removeChild(el);
	}
	e.stopPropagation();
}
