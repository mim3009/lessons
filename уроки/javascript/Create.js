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
		div.style.background = "rgba(128, 128, 128, 0.29)";
		//div.style.background = "gray";
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
				line.setAttribute("style", "stroke: red; stroke-width: 3");

				line.oncontextmenu = changeColorLine;

				svg[0].appendChild(line);

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
				console.log("angle = " + angle);
				if(angle == 90 || angle == 270){
					polygon.setAttribute("points", parseInt(Number(x1+rad1-svg[0].offsetLeft)) + "," + parseInt(Number(y1+rad1+rad1-svg[0].offsetTop-1)) + " " + parseInt(Number(x1+rad1-svg[0].offsetLeft)) + "," + parseInt(Number(y1+rad1-rad1-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2-svg[0].offsetLeft)) + "," + parseInt(Number(y2+rad2-rad2-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2-svg[0].offsetLeft)) + "," + parseInt(Number(y2+rad2+rad2-svg[0].offsetTop-1)));
				}
				else if(angle == 0 || angle == 180){
					polygon.setAttribute("points", parseInt(Number(x1+rad1-rad1-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1-svg[0].offsetTop)) + " " + parseInt(Number(x1+rad1+rad1-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1-svg[0].offsetTop)) + " " + parseInt(Number(x2+rad2+rad2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2-svg[0].offsetTop)) + " " + parseInt(Number(x2+rad2-rad2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2-svg[0].offsetTop)));
				}
				/*if((angle == 90 || angle == 270) || (angle >= 45 && angle < 135) || (angle >= 225 && angle < 315)){
					polygon.setAttribute("points", parseInt(Number(x1+rad1-svg[0].offsetLeft)) + "," + parseInt(Number(y1+rad1+rad1-svg[0].offsetTop-1)) + " " + parseInt(Number(x1+rad1-svg[0].offsetLeft)) + "," + parseInt(Number(y1+rad1-rad1-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2-svg[0].offsetLeft)) + "," + parseInt(Number(y2+rad2-rad2-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2-svg[0].offsetLeft)) + "," + parseInt(Number(y2+rad2+rad2-svg[0].offsetTop-1)));
				}
				else if((angle == 0 || angle == 180) || (angle >= 135 && angle < 225) || (angle >= 315 && angle < 45)){
					polygon.setAttribute("points", parseInt(Number(x1+rad1-rad1-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1-svg[0].offsetTop)) + " " + parseInt(Number(x1+rad1+rad1-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1-svg[0].offsetTop)) + " " + parseInt(Number(x2+rad2+rad2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2-svg[0].offsetTop)) + " " + parseInt(Number(x2+rad2-rad2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2-svg[0].offsetTop)));
				}

				*/
				else if(angle > 90 && angle < 180){
					var angle2 = 180-Number(angle);
					var angle3 = 180-(90+angle2);
					var a = Math.abs((rad1*Math.sin(angle3))/Math.sin(90));
					var c = Math.sqrt(Math.abs(rad1*rad1 - a*a));
					var a1 = Math.abs((rad1*Math.sin(angle2))/Math.sin(90));
					var c1 = Math.sqrt(Math.abs(rad1*rad1 - a*a));
					var a2 = Math.abs((rad2*Math.sin(angle2))/Math.sin(90));
					var c2 = Math.sqrt(Math.abs(rad2*rad2 - a2*a2));
					var a3 = Math.abs((rad2*Math.sin(angle3))/Math.sin(90));
					var c3 = Math.sqrt(Math.abs(rad2*rad2 - a2*a2));
					var raz = Math.abs(rad1-c);
					var raz2 = Math.abs(rad2-c2);
					polygon.setAttribute("points", parseInt(Number(x1+rad1+c-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1-a-svg[0].offsetTop-1)) + " " + parseInt(Number(x1+rad1-c1-svg[0].offsetLeft-1)) + "," + parseInt(Number(y1+rad1+a-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2-c2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2+a2-svg[0].offsetTop-1)) + " " + parseInt(Number(x2+rad2+c2-svg[0].offsetLeft-1)) + "," + parseInt(Number(y2+rad2-a2-svg[0].offsetTop-1)));
					console.log("a = " + a + " c = " + c + " a2 = " + a2 + " c2 = " + c2 + " raz = " + raz);
				}

				polygon.setAttribute("style", "fill: #FFECAD; stroke: purple; stroke-width: 1;");
				svg[0].appendChild(polygon);
			}
		}
		document.removeEventListener("mouseup", upHandl, true);
		document.removeEventListener("mousemove", moveHandl, true);

		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;	
	}
}

function changeColorLine(e){
	e = e || window.event;
	e.preventDefault ? e.preventDefault() : e.returnValue = false;
	var el = e.target || e.srcElement;
	if(el.style.stroke == "red"){
		el.style.stroke = "white";
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
