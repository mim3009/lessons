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

	var rad1 = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
	var svg = document.getElementsByTagName("svg");
	var offset_SVG = svg[0].getBoundingClientRect();
	var lines = document.getElementsByTagName("line");
	var findedLines = new Array();
	var j = 0;
	for(var i = 0; i < lines.length; i++){
		if(lines[i].getAttribute("x1") == (x-offset_SVG.left+rad1) && lines[i].getAttribute("y1") == (y-offset_SVG.top+rad1)){
			findedLines[j] = lines[i];
			findedLines[j].setAttribute("ch", "1");
			j++;
		}
		if(lines[i].getAttribute("x2") == (x-offset_SVG.left+rad1) && lines[i].getAttribute("y2") == (y-offset_SVG.top+rad1)){
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
				var x1 = Number(fLine.getAttribute("x1"))-rad1+offset_SVG.left;
				var y1 = Number(fLine.getAttribute("y1"))-rad1+offset_SVG.top;
				var x2 = Number(fLine.getAttribute("x2"))-rad1+offset_SVG.left;
				var y2 = Number(fLine.getAttribute("y2"))-rad1+offset_SVG.top;
				if(fLine.getAttribute("ch") == "1"){

					for(var u = 0; u < findTR.length; u++){
						var td = findTR[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[0].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
							td[1].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
							break;
						}
					}

					var x_center = Number(fLine.getAttribute("x1")) + offset_SVG.left;
					var y_center = Number(fLine.getAttribute("y1")) + offset_SVG.top;
					var x_of_second_point = Number(fLine.getAttribute("x2")) + offset_SVG.left;
					var y_of_second_point = Number(fLine.getAttribute("y2")) + offset_SVG.top;

					var points = document.getElementsByClassName("movedElement");
					var findedPoint;
					for(var o = 0; o < points.length; o++){
						if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
							findedPoint = points[o];
							break;
						}
					}
					var rad2 = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_center;
				    center.y = y_center;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;
				    
					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;
				   	
				   	var coordinates1 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates2 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates3 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates4 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates5 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates6 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates7 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates8 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates9 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates10 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates11 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates12 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates13 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates14 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates15 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates16 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates17 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates18 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates19 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates20 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates21 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates22 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				    var coordinates23 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				    var coordinates24 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   
				    var finded_poly = null;
				    for(var t = 0; t < polygons.length; t++){
				    	if(String(polygons[t].getAttribute("points")) == coordinates1 || String(polygons[t].getAttribute("points")) == coordinates2 || String(polygons[t].getAttribute("points")) == coordinates3 || String(polygons[t].getAttribute("points")) == coordinates4 || String(polygons[t].getAttribute("points")) == coordinates5 || String(polygons[t].getAttribute("points")) == coordinates6 || String(polygons[t].getAttribute("points")) == coordinates7 || String(polygons[t].getAttribute("points")) == coordinates8 || String(polygons[t].getAttribute("points")) == coordinates9 || String(polygons[t].getAttribute("points")) == coordinates10 || String(polygons[t].getAttribute("points")) == coordinates11 || String(polygons[t].getAttribute("points")) == coordinates12 || String(polygons[t].getAttribute("points")) == coordinates13 || String(polygons[t].getAttribute("points")) == coordinates14 || String(polygons[t].getAttribute("points")) == coordinates15 || String(polygons[t].getAttribute("points")) == coordinates16 || String(polygons[t].getAttribute("points")) == coordinates17 || String(polygons[t].getAttribute("points")) == coordinates18 || String(polygons[t].getAttribute("points")) == coordinates19 || String(polygons[t].getAttribute("points")) == coordinates20 || String(polygons[t].getAttribute("points")) == coordinates21 || String(polygons[t].getAttribute("points")) == coordinates22 || String(polygons[t].getAttribute("points")) == coordinates23 || String(polygons[t].getAttribute("points")) == coordinates24){
				    		finded_poly = polygons[t];
				    		break;
				    	}
				    }

				    fLine.setAttribute("x1", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-offset_SVG.left));
					fLine.setAttribute("y1", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-offset_SVG.top));

					var x_changed_of_the_first_point = Number(fLine.getAttribute("x1")) + offset_SVG.left;
					var y_changed_of_the_first_point = Number(fLine.getAttribute("y1")) + offset_SVG.top;

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_changed_of_the_first_point;
				    center.y = y_changed_of_the_first_point;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;

					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;

					finded_poly.setAttribute("points", parseInt(xa-offset_SVG.left) + "," + parseInt(ya-offset_SVG.top) + " " + parseInt(xa2-offset_SVG.left) + "," + parseInt(ya2-offset_SVG.top) + " " + parseInt(xb2-offset_SVG.left) + "," + parseInt(yb2-offset_SVG.top) + " " + parseInt(xb-offset_SVG.left) + "," + parseInt(yb-offset_SVG.top));

				}
				else if(fLine.getAttribute("ch") == "2"){

					for(var u = 0; u < findTR.length; u++){
						var td = findTR[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[2].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
							td[3].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
							break;
						}
					}

					var x_center = Number(fLine.getAttribute("x2")) + offset_SVG.left;
					var y_center = Number(fLine.getAttribute("y2")) + offset_SVG.top;
					var x_of_second_point = Number(fLine.getAttribute("x1")) + offset_SVG.left;
					var y_of_second_point = Number(fLine.getAttribute("y1")) + offset_SVG.top;

					var points = document.getElementsByClassName("movedElement");
					var findedPoint;
					for(var o = 0; o < points.length; o++){
						if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
							findedPoint = points[o];
							break;
						}
					}
					var rad2 = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_center;
				    center.y = y_center;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;
				    
					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;
				   	
				   	var coordinates1 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates2 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates3 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates4 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates5 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates6 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates7 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates8 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates9 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates10 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates11 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates12 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates13 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates14 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates15 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates16 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates17 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates18 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates19 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates20 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates21 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates22 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				    var coordinates23 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				    var coordinates24 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   
				    var finded_poly = null;
				    for(var t = 0; t < polygons.length; t++){
				    	if(String(polygons[t].getAttribute("points")) == coordinates1 || String(polygons[t].getAttribute("points")) == coordinates2 || String(polygons[t].getAttribute("points")) == coordinates3 || String(polygons[t].getAttribute("points")) == coordinates4 || String(polygons[t].getAttribute("points")) == coordinates5 || String(polygons[t].getAttribute("points")) == coordinates6 || String(polygons[t].getAttribute("points")) == coordinates7 || String(polygons[t].getAttribute("points")) == coordinates8 || String(polygons[t].getAttribute("points")) == coordinates9 || String(polygons[t].getAttribute("points")) == coordinates10 || String(polygons[t].getAttribute("points")) == coordinates11 || String(polygons[t].getAttribute("points")) == coordinates12 || String(polygons[t].getAttribute("points")) == coordinates13 || String(polygons[t].getAttribute("points")) == coordinates14 || String(polygons[t].getAttribute("points")) == coordinates15 || String(polygons[t].getAttribute("points")) == coordinates16 || String(polygons[t].getAttribute("points")) == coordinates17 || String(polygons[t].getAttribute("points")) == coordinates18 || String(polygons[t].getAttribute("points")) == coordinates19 || String(polygons[t].getAttribute("points")) == coordinates20 || String(polygons[t].getAttribute("points")) == coordinates21 || String(polygons[t].getAttribute("points")) == coordinates22 || String(polygons[t].getAttribute("points")) == coordinates23 || String(polygons[t].getAttribute("points")) == coordinates24){
				    		finded_poly = polygons[t];
				    		break;
				    	}
				    }

				    fLine.setAttribute("x2", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-offset_SVG.left));
					fLine.setAttribute("y2", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-offset_SVG.top));

					var x_changed_of_the_first_point = Number(fLine.getAttribute("x2")) + offset_SVG.left;
					var y_changed_of_the_first_point = Number(fLine.getAttribute("y2")) + offset_SVG.top;

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_changed_of_the_first_point;
				    center.y = y_changed_of_the_first_point;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;

					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;
					
					finded_poly.setAttribute("points", parseInt(xa-offset_SVG.left) + "," + parseInt(ya-offset_SVG.top) + " " + parseInt(xa2-offset_SVG.left) + "," + parseInt(ya2-offset_SVG.top) + " " + parseInt(xb2-offset_SVG.left) + "," + parseInt(yb2-offset_SVG.top) + " " + parseInt(xb-offset_SVG.left) + "," + parseInt(yb-offset_SVG.top));
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
				var x1 = Number(fLine.getAttribute("x1"))-rad1+offset_SVG.left;
				var y1 = Number(fLine.getAttribute("y1"))-rad1+offset_SVG.top;
				var x2 = Number(fLine.getAttribute("x2"))-rad1+offset_SVG.left;
				var y2 = Number(fLine.getAttribute("y2"))-rad1+offset_SVG.top;
				if(fLine.getAttribute("ch") == "1"){

					for(var u = 0; u < findTR.length; u++){
						var td = findTR[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[0].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
							td[1].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
						}
					}

					var x_center = Number(fLine.getAttribute("x1")) + offset_SVG.left;
					var y_center = Number(fLine.getAttribute("y1")) + offset_SVG.top;
					var x_of_second_point = Number(fLine.getAttribute("x2")) + offset_SVG.left;
					var y_of_second_point = Number(fLine.getAttribute("y2")) + offset_SVG.top;

					var points = document.getElementsByClassName("movedElement");
					var findedPoint;
					for(var o = 0; o < points.length; o++){
						if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
							findedPoint = points[o];
							break;
						}
					}
					var rad2 = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_center;
				    center.y = y_center;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;
				    
					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;
				   	
				   	var coordinates1 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates2 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates3 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates4 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates5 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates6 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates7 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates8 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates9 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates10 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates11 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates12 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates13 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates14 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates15 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates16 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates17 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates18 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates19 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates20 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates21 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates22 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				    var coordinates23 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				    var coordinates24 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   
				    var finded_poly = null;
				    for(var t = 0; t < polygons.length; t++){
				    	if(String(polygons[t].getAttribute("points")) == coordinates1 || String(polygons[t].getAttribute("points")) == coordinates2 || String(polygons[t].getAttribute("points")) == coordinates3 || String(polygons[t].getAttribute("points")) == coordinates4 || String(polygons[t].getAttribute("points")) == coordinates5 || String(polygons[t].getAttribute("points")) == coordinates6 || String(polygons[t].getAttribute("points")) == coordinates7 || String(polygons[t].getAttribute("points")) == coordinates8 || String(polygons[t].getAttribute("points")) == coordinates9 || String(polygons[t].getAttribute("points")) == coordinates10 || String(polygons[t].getAttribute("points")) == coordinates11 || String(polygons[t].getAttribute("points")) == coordinates12 || String(polygons[t].getAttribute("points")) == coordinates13 || String(polygons[t].getAttribute("points")) == coordinates14 || String(polygons[t].getAttribute("points")) == coordinates15 || String(polygons[t].getAttribute("points")) == coordinates16 || String(polygons[t].getAttribute("points")) == coordinates17 || String(polygons[t].getAttribute("points")) == coordinates18 || String(polygons[t].getAttribute("points")) == coordinates19 || String(polygons[t].getAttribute("points")) == coordinates20 || String(polygons[t].getAttribute("points")) == coordinates21 || String(polygons[t].getAttribute("points")) == coordinates22 || String(polygons[t].getAttribute("points")) == coordinates23 || String(polygons[t].getAttribute("points")) == coordinates24){
				    		finded_poly = polygons[t];
				    		break;
				    	}
				    }

				    fLine.setAttribute("x1", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-offset_SVG.left));
					fLine.setAttribute("y1", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-offset_SVG.top));

					var x_changed_of_the_first_point = Number(fLine.getAttribute("x1")) + offset_SVG.left;
					var y_changed_of_the_first_point = Number(fLine.getAttribute("y1")) + offset_SVG.top;

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_changed_of_the_first_point;
				    center.y = y_changed_of_the_first_point;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;

					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;

					finded_poly.setAttribute("points", parseInt(xa-offset_SVG.left) + "," + parseInt(ya-offset_SVG.top) + " " + parseInt(xa2-offset_SVG.left) + "," + parseInt(ya2-offset_SVG.top) + " " + parseInt(xb2-offset_SVG.left) + "," + parseInt(yb2-offset_SVG.top) + " " + parseInt(xb-offset_SVG.left) + "," + parseInt(yb-offset_SVG.top));
				}
				else if(fLine.getAttribute("ch") == "2"){

					for(var u = 0; u < findTR.length; u++){
						var td = findTR[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+offset_SVG.left) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+offset_SVG.top) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+offset_SVG.left) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+offset_SVG.top) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[2].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
							td[3].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
						}
					}

					var x_center = Number(fLine.getAttribute("x2")) + offset_SVG.left;
					var y_center = Number(fLine.getAttribute("y2")) + offset_SVG.top;
					var x_of_second_point = Number(fLine.getAttribute("x1")) + offset_SVG.left;
					var y_of_second_point = Number(fLine.getAttribute("y1")) + offset_SVG.top;

					var points = document.getElementsByClassName("movedElement");
					var findedPoint;
					for(var o = 0; o < points.length; o++){
						if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
							findedPoint = points[o];
							break;
						}
					}
					var rad2 = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_center;
				    center.y = y_center;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;
				    
					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;
				   	
				   	var coordinates1 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates2 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates3 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates4 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates5 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates6 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates7 = String(String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates8 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates9 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates10 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates11 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				   	var coordinates12 = String(String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates13 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates14 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates15 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top));
				   	var coordinates16 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates17 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates18 = String(String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   	var coordinates19 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates20 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				   	var coordinates21 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top));
				    var coordinates22 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				    var coordinates23 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top));
				    var coordinates24 = String(String(parseInt(xb)-offset_SVG.left) + "," + String(parseInt(yb)-offset_SVG.top) + " " + String(parseInt(xb2)-offset_SVG.left) + "," + String(parseInt(yb2)-offset_SVG.top) + " " + String(parseInt(xa2)-offset_SVG.left) + "," + String(parseInt(ya2)-offset_SVG.top) + " " + String(parseInt(xa)-offset_SVG.left) + "," + String(parseInt(ya)-offset_SVG.top));
				   
				    var finded_poly = null;
				    for(var t = 0; t < polygons.length; t++){
				    	if(String(polygons[t].getAttribute("points")) == coordinates1 || String(polygons[t].getAttribute("points")) == coordinates2 || String(polygons[t].getAttribute("points")) == coordinates3 || String(polygons[t].getAttribute("points")) == coordinates4 || String(polygons[t].getAttribute("points")) == coordinates5 || String(polygons[t].getAttribute("points")) == coordinates6 || String(polygons[t].getAttribute("points")) == coordinates7 || String(polygons[t].getAttribute("points")) == coordinates8 || String(polygons[t].getAttribute("points")) == coordinates9 || String(polygons[t].getAttribute("points")) == coordinates10 || String(polygons[t].getAttribute("points")) == coordinates11 || String(polygons[t].getAttribute("points")) == coordinates12 || String(polygons[t].getAttribute("points")) == coordinates13 || String(polygons[t].getAttribute("points")) == coordinates14 || String(polygons[t].getAttribute("points")) == coordinates15 || String(polygons[t].getAttribute("points")) == coordinates16 || String(polygons[t].getAttribute("points")) == coordinates17 || String(polygons[t].getAttribute("points")) == coordinates18 || String(polygons[t].getAttribute("points")) == coordinates19 || String(polygons[t].getAttribute("points")) == coordinates20 || String(polygons[t].getAttribute("points")) == coordinates21 || String(polygons[t].getAttribute("points")) == coordinates22 || String(polygons[t].getAttribute("points")) == coordinates23 || String(polygons[t].getAttribute("points")) == coordinates24){
				    		finded_poly = polygons[t];
				    		break;
				    	}
				    }

				    fLine.setAttribute("x2", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-offset_SVG.left));
					fLine.setAttribute("y2", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-offset_SVG.top));

					var x_changed_of_the_first_point = Number(fLine.getAttribute("x2")) + offset_SVG.left;
					var y_changed_of_the_first_point = Number(fLine.getAttribute("y2")) + offset_SVG.top;

					var len = getLineLength(fLine);
					var l = Math.sqrt(len*len - rad1*rad1);
					var l2 = Math.sqrt(len*len - rad2*rad2);
					var ya;
					var yb;
					var xa;
					var xb;
					var ya2;
				    var yb2;
				    var xa2;
				    var xb2;
				    var center = {};
				    center.x = x_changed_of_the_first_point;
				    center.y = y_changed_of_the_first_point;
				    var point = {};
				    point.x = x_of_second_point;
				    point.y = y_of_second_point;
					
					var e3 = center.x - point.x;
					var c = center.y - point.y;
				    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
				    var A = c*c + e3*e3; 
				    var B = (center.x*e3*c - c*q - center.y*e3*e3)*2;
				    var C = center.x*center.x*e3*e3 - 2*center.x*e3*q + q*q + center.y*center.y*e3*e3 - rad1*rad1*e3*e3;
				    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
				    xa = (q - ya*c)/e3;
				    xb = (q - yb*c)/e3;

					var e2 = point.x - center.x;
					var c2 = point.y - center.y;
				    var q2 = (l2*l2 - rad2*rad2 + point.y*point.y - center.y*center.y + point.x*point.x - center.x*center.x)/2;
				    var A2 = c2*c2 + e2*e2; 
				    var B2 = (point.x*e2*c2 - c2*q2 - point.y*e2*e2)*2;
				    var C2 = point.x*point.x*e2*e2 - 2*point.x*e2*q2 + q2*q2 + point.y*point.y*e2*e2 - rad2*rad2*e2*e2;
				    ya2 = (Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    yb2 = (-Math.sqrt(B2*B2 - 4*A2*C2) - B2) / (2*A2);
				    xa2 = (q2 - ya2*c2)/e2;
				    xb2 = (q2 - yb2*c2)/e2;
					
					finded_poly.setAttribute("points", parseInt(xa-offset_SVG.left) + "," + parseInt(ya-offset_SVG.top) + " " + parseInt(xa2-offset_SVG.left) + "," + parseInt(ya2-offset_SVG.top) + " " + parseInt(xb2-offset_SVG.left) + "," + parseInt(yb2-offset_SVG.top) + " " + parseInt(xb-offset_SVG.left) + "," + parseInt(yb-offset_SVG.top));	
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
