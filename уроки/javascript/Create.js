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
		div.style.background = "gray";
		div.style.left = (e.pageX - 10) + "px";
		div.style.top = (e.pageY - 10) + "px";
		div.style.position = "absolute";
		div.style.height = "20px"; 
		div.style.width = "20px";
		div.style.borderRadius = "100%";
		div.style.zIndex = "1";
		
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
		cell0.innerHTML = Number(div.style.left.replace(/\D+/g,"")) + Number(div.style.width.replace(/\D+/g,""))/2 + "px";
		cell1.innerHTML = Number(div.style.top.replace(/\D+/g,"")) + Number(div.style.height.replace(/\D+/g,""))/2 + "px";
		cell2.innerHTML = div.style.background;
		cell3.innerHTML = Number(div.style.height.replace(/\D+/g,""))/2;
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
	for(var i = 0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName('td');
		for(var j = 0; j < td.length; j++){
			if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToChange.style.left.replace(/\D+/g,"")) + Number(elementToChange.style.width.replace(/\D+/g,""))/2) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToChange.style.top.replace(/\D+/g,"")) + Number(elementToChange.style.height.replace(/\D+/g,""))/2)){
				findX = td[0];
				findY = td[1];
				findR = td[3];
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
				line.setAttribute("style", "stroke: rgb(255,0,0); stroke-width: 3");
				svg[0].appendChild(line);

				var table = document.getElementById("linesTable");
				var row = table.insertRow(table.rows.length);
				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);
				var cell3 = row.insertCell(3);
				cell0.innerHTML = x1+rad1;
				cell1.innerHTML = y1+rad1;
				cell2.innerHTML = x2+rad2;
				cell3.innerHTML = y2+rad2;
			}
		}
		document.removeEventListener("mouseup", upHandl, true);
		document.removeEventListener("mousemove", moveHandl, true);

		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;	
	}
}
