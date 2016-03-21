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

function removeDraw(){
	var elements = document.getElementsByClassName('movedElement');
	for(var i = 0; i < elements.length; i++){
		elements[i].onmousedown = null;
	}
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

		var rad1 = parseInt(Number(el.style.height.replace(/\D+/g,""))/2);
		var svg = document.getElementsByTagName("svg");
		var lines = document.getElementsByTagName("line");
		var findedLines = new Array();
		var j = 0;
		for(var i = 0; i < lines.length; i++){
			if(lines[i].getAttribute("x1") == (Number(el.style.left.replace(/\D+/g,""))-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y1") == (Number(el.style.top.replace(/\D+/g,""))-svg[0].offsetTop+rad1)){
				findedLines[j] = lines[i];
				findedLines[j].setAttribute("ch", "1");
				j++;
			}
			if(lines[i].getAttribute("x2") == (Number(el.style.left.replace(/\D+/g,""))-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y2") == (Number(el.style.top.replace(/\D+/g,""))-svg[0].offsetTop+rad1)){
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
				for(var k = 0; k < td.length; k++){
					if(parseInt(Number(findedLines[i].getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
						table.deleteRow(j);
						break;
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

		var rad1 = parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
		var svg = document.getElementsByTagName("svg");
		var lines = document.getElementsByTagName("line");
		var findedLines = new Array();
		var j = 0;
		for(var i = 0; i < lines.length; i++){
			if(lines[i].getAttribute("x1") == (parseInt(Number(elementToChange.style.left.replace(/\D+/g,"")))-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y1") == (parseInt(Number(elementToChange.style.top.replace(/\D+/g,"")))-svg[0].offsetTop+rad1)){
				findedLines[j] = lines[i];
				findedLines[j].setAttribute("ch", "1");
				j++;
			}
			if(lines[i].getAttribute("x2") == (parseInt(Number(elementToChange.style.left.replace(/\D+/g,"")))-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y2") == (parseInt(Number(elementToChange.style.top.replace(/\D+/g,"")))-svg[0].offsetTop+rad1)){
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
		var finded_polygons = new Array();
		var b = 0;
		for(var i = 0; i < findedLines.length; i++){
			if(findedLines[i].getAttribute("ch") == "1"){
				var x_of_second_point = Number(findedLines[i].getAttribute("x2")) + svg[0].offsetLeft;
				var y_of_second_point = Number(findedLines[i].getAttribute("y2")) + svg[0].offsetTop;
				var points = document.getElementsByClassName("movedElement");
				var findedPoint;
				for(var o = 0; o < points.length; o++){
					if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
						findedPoint = points[o];
						break;
					}
				}
				var rad2 = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

				var len = getLineLength(findedLines[i]);
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
			    center.x = Number(elementToChange.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
			    center.y = Number(elementToChange.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
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
			   	
			   	var coordinates1 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates2 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates3 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates4 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates5 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates6 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates7 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates8 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates9 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates10 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates11 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates12 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates13 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates14 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates15 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates16 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates17 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates18 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates19 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			    var coordinates20 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates21 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			    var coordinates22 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			    var coordinates23 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			    var coordinates24 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   
			    for(var t = 0; t < polygons.length; t++){
			    	if(String(polygons[t].getAttribute("points")) == coordinates1 || String(polygons[t].getAttribute("points")) == coordinates2 || String(polygons[t].getAttribute("points")) == coordinates3 || String(polygons[t].getAttribute("points")) == coordinates4 || String(polygons[t].getAttribute("points")) == coordinates5 || String(polygons[t].getAttribute("points")) == coordinates6 || String(polygons[t].getAttribute("points")) == coordinates7 || String(polygons[t].getAttribute("points")) == coordinates8 || String(polygons[t].getAttribute("points")) == coordinates9 || String(polygons[t].getAttribute("points")) == coordinates10 || String(polygons[t].getAttribute("points")) == coordinates11 || String(polygons[t].getAttribute("points")) == coordinates12 || String(polygons[t].getAttribute("points")) == coordinates13 || String(polygons[t].getAttribute("points")) == coordinates14 || String(polygons[t].getAttribute("points")) == coordinates15 || String(polygons[t].getAttribute("points")) == coordinates16 || String(polygons[t].getAttribute("points")) == coordinates17 || String(polygons[t].getAttribute("points")) == coordinates18 || String(polygons[t].getAttribute("points")) == coordinates19 || String(polygons[t].getAttribute("points")) == coordinates20 || String(polygons[t].getAttribute("points")) == coordinates21 || String(polygons[t].getAttribute("points")) == coordinates22 || String(polygons[t].getAttribute("points")) == coordinates23 || String(polygons[t].getAttribute("points")) == coordinates24){
			    		finded_polygons[b] = polygons[t];
			    		b++;
			    	}
			    }

			}
			else if(findedLines[i].getAttribute("ch") == "2"){
				var x_of_second_point = Number(findedLines[i].getAttribute("x1")) + svg[0].offsetLeft;
				var y_of_second_point = Number(findedLines[i].getAttribute("y1")) + svg[0].offsetTop;
				var points = document.getElementsByClassName("movedElement");
				var findedPoint;
				for(var o = 0; o < points.length; o++){
					if(Number(points[o].style.left.replace(/\D+/g,""))+parseInt(Number(points[o].style.width.replace(/\D+/g,""))/2) == parseInt(x_of_second_point) && Number(points[o].style.top.replace(/\D+/g,""))+parseInt(Number(points[o].style.height.replace(/\D+/g,""))/2) == parseInt(y_of_second_point)){
						findedPoint = points[o];
						break;
					}
				}
				var rad2 = parseInt(Number(findedPoint.style.width.replace(/\D+/g,""))/2);

				var len = getLineLength(findedLines[i]);
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
			    center.x = Number(elementToChange.style.left.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
			    center.y = Number(elementToChange.style.top.replace(/\D+/g,"")) + parseInt(Number(elementToChange.style.height.replace(/\D+/g,""))/2);
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
			   	
			   	var coordinates1 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates2 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates3 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates4 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates5 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates6 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates7 = String(String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates8 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates9 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates10 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates11 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			   	var coordinates12 = String(String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates13 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates14 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates15 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop));
			   	var coordinates16 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates17 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates18 = String(String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   	var coordinates19 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			    var coordinates20 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			   	var coordinates21 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop));
			    var coordinates22 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			    var coordinates23 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop));
			    var coordinates24 = String(String(parseInt(xb)-svg[0].offsetLeft) + "," + String(parseInt(yb)-svg[0].offsetTop) + " " + String(parseInt(xb2)-svg[0].offsetLeft) + "," + String(parseInt(yb2)-svg[0].offsetTop) + " " + String(parseInt(xa2)-svg[0].offsetLeft) + "," + String(parseInt(ya2)-svg[0].offsetTop) + " " + String(parseInt(xa)-svg[0].offsetLeft) + "," + String(parseInt(ya)-svg[0].offsetTop));
			   
			    for(var t = 0; t < polygons.length; t++){
			    	if(String(polygons[t].getAttribute("points")) == coordinates1 || String(polygons[t].getAttribute("points")) == coordinates2 || String(polygons[t].getAttribute("points")) == coordinates3 || String(polygons[t].getAttribute("points")) == coordinates4 || String(polygons[t].getAttribute("points")) == coordinates5 || String(polygons[t].getAttribute("points")) == coordinates6 || String(polygons[t].getAttribute("points")) == coordinates7 || String(polygons[t].getAttribute("points")) == coordinates8 || String(polygons[t].getAttribute("points")) == coordinates9 || String(polygons[t].getAttribute("points")) == coordinates10 || String(polygons[t].getAttribute("points")) == coordinates11 || String(polygons[t].getAttribute("points")) == coordinates12 || String(polygons[t].getAttribute("points")) == coordinates13 || String(polygons[t].getAttribute("points")) == coordinates14 || String(polygons[t].getAttribute("points")) == coordinates15 || String(polygons[t].getAttribute("points")) == coordinates16 || String(polygons[t].getAttribute("points")) == coordinates17 || String(polygons[t].getAttribute("points")) == coordinates18 || String(polygons[t].getAttribute("points")) == coordinates19 || String(polygons[t].getAttribute("points")) == coordinates20 || String(polygons[t].getAttribute("points")) == coordinates21 || String(polygons[t].getAttribute("points")) == coordinates22 || String(polygons[t].getAttribute("points")) == coordinates23 || String(polygons[t].getAttribute("points")) == coordinates24){
			    		finded_polygons[b] = polygons[t];
			    		b++;
			    	}
			    }
			}
		}

		console.log(finded_polygons);

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
	var rad1 = parseInt(Number(el.style.height.replace(/\D+/g,""))/2);

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
			var rad2 = parseInt(Number(element.style.height.replace(/\D+/g,""))/2);
			var svg = document.getElementsByTagName("svg");
			var lines = document.getElementsByTagName("line");
			var flag = 0;
			for(var i = 0; i < lines.length; i++){
				if((lines[i].getAttribute("x1") == (x1-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y1") == (y1-svg[0].offsetTop+rad1) && lines[i].getAttribute("x2") == (x2-svg[0].offsetLeft+rad2) && lines[i].getAttribute("y2") == (y2-svg[0].offsetTop+rad2)) || (lines[i].getAttribute("x1") == (x2-svg[0].offsetLeft+rad2) && lines[i].getAttribute("y1") == (y2-svg[0].offsetTop+rad2) && lines[i].getAttribute("x2") == (x1-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y2") == (y1-svg[0].offsetTop+rad1))){
					flag = 1;
				}
			}
			if(flag == 0){
				var line = document.createElementNS('http://www.w3.org/2000/svg', 'line');
				line.setAttribute("x1", x1+rad1-svg[0].offsetLeft);
				line.setAttribute("y1", y1+rad1-svg[0].offsetTop);
				line.setAttribute("x2", x2+rad2-svg[0].offsetLeft);
				line.setAttribute("y2", y2+rad2-svg[0].offsetTop);
				line.setAttribute("style", "stroke: red; stroke-width: 3; z-index: 1;");

				line.oncontextmenu = changeColorLine;
				line.onmousedown = function(e){
					dragLine(this, e);
				}

				var table = document.getElementById("linesTable");
				var row = table.insertRow(table.rows.length);
				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);
				var cell3 = row.insertCell(3);
				var cell4 = row.insertCell(4);
				cell0.innerHTML = x1+rad1;
				cell1.innerHTML = y1+rad1;
				cell2.innerHTML = x2+rad2;
				cell3.innerHTML = y2+rad2;
				cell4.innerHTML = line.style.stroke;
				row.style.background = line.style.stroke;

				var polygon = document.createElementNS('http://www.w3.org/2000/svg', 'polygon');
				var center = {};
				center.x = parseInt(Number(x1+rad1-svg[0].offsetLeft)); 
				center.y = parseInt(Number(y1+rad1-svg[0].offsetTop));
				var point = {};
				point.x = parseInt(Number(x2+rad2-svg[0].offsetLeft)); 
				point.y =  parseInt(Number(y2+rad2-svg[0].offsetTop));
				var angle = get_angle(center, point);
				if(angle == 90 || angle == 270){
					polygon.setAttribute("points", parseInt(Number(x1+rad1-svg[0].offsetLeft)) + "," + parseInt(Number(y1+rad1+rad1-svg[0].offsetTop-1)) + " " + parseInt(Number(x1+rad1-svg[0].offsetLeft)) + "," + parseInt(Number(y1+rad1-rad1-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2-svg[0].offsetLeft)) + "," + parseInt(Number(y2+rad2-rad2-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2-svg[0].offsetLeft)) + "," + parseInt(Number(y2+rad2+rad2-svg[0].offsetTop-1)));
				}
				else if(angle == 0 || angle == 180){
					polygon.setAttribute("points", parseInt(Number(x1+rad1-rad1-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1-svg[0].offsetTop)) + " " + parseInt(Number(x1+rad1+rad1-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1-svg[0].offsetTop)) + " " + parseInt(Number(x2+rad2+rad2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2-svg[0].offsetTop)) + " " + parseInt(Number(x2+rad2-rad2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2-svg[0].offsetTop)));
				}
				else{
					var len = getLineLength(line);
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
					if(len > rad1){
						var e = center.x - point.x;
						var c = center.y - point.y;
					    var q = (l*l - rad1*rad1 + center.y*center.y - point.y*point.y + center.x*center.x - point.x*point.x)/2;
					    var A = c*c + e*e; 
					    var B = (center.x*e*c - c*q - center.y*e*e)*2;
					    var C = center.x*center.x*e*e - 2*center.x*e*q + q*q + center.y*center.y*e*e - rad1*rad1*e*e;
					    ya = (Math.sqrt(B*B - 4*A*C) - B) / (2*A);
					    yb = (-Math.sqrt(B*B - 4*A*C) - B) / (2*A);
					    xa = (q - ya*c)/e;
					    xb = (q - yb*c)/e;
					    console.log("2 " + xa + " " + ya + " " + xb + " " + yb);


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
					    console.log("2 " + xa2 + " " + ya2 + " " + xb2 + " " + yb2);
					}
					else if(len == rad1){
						console.log("1 " + point.x + " " + point.y);
					}
					else if(len < rad1){
						console.log("can`t find");
					}
					polygon.setAttribute("points", parseInt(xa) + "," + parseInt(ya) + " " + parseInt(xa2) + "," + parseInt(ya2) + " " + parseInt(xb2) + "," + parseInt(yb2) + " " + parseInt(xb) + "," + parseInt(yb));
				}

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
		var tr = document.getElementById("linesTable").getElementsByTagName('tr');
		for(var i = 0; i < tr.length; i++){
			var td = tr[i].getElementsByTagName('td');
			for(var j = 0; j < td.length; j++){
				if(parseInt(Number(el.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
					td[4].innerHTML = el.style.stroke;
					tr[i].style.background = el.style.stroke;
					break;
				}
			}
		}
	}
	else if(el.style.stroke == "white"){
		var svg = document.getElementsByTagName("svg");
		var table = document.getElementById("linesTable");
		var tr = document.getElementById("linesTable").getElementsByTagName('tr');
		for(var i = 0; i < tr.length; i++){
			var td = tr[i].getElementsByTagName('td');
			for(var j = 0; j < td.length; j++){
				if(parseInt(Number(el.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(el.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
					table.deleteRow(i);
					break;
				}
			}
		}
		svg[0].removeChild(el);
	}
	e.stopPropagation();
}
