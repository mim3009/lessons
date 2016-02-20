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
	if(element == '[object HTMLHtmlElement]' || element == '[object SVGSVGElement]'){
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
	}
	
}

function changeColour(e){
	e = e || window.event;
	e.preventDefault ? e.preventDefault() : e.returnValue = false;
	var el = e.target || e.srcElement;
	if(el.style.background == "gray"){
		el.style.background = "red";
	}
	else if(el.style.background == "red"){
		el.style.background = "green";
	}
	else{
		document.body.removeChild(el);
		console.log("element was deleted");
	}
	e.stopPropagation();
}

function changeRadius(elementToChange, event){
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
	console.log("element downH =" + el);
	var x1 = Number(el.style.left.replace(/\D+/g,""));
	var y1 = Number(el.style.top.replace(/\D+/g,""));
	var rad1 = (Number(el.style.height.replace(/\D+/g,""))/2);
	console.log("x1 = " + x1);
	console.log("y1 = " + y1);
	console.log("rad1 = " + rad1)
	document.addEventListener("mousemove", moveHandl, true);
	document.addEventListener("mouseup", upHandl, true);

	if(event.stopPropagation) event.stopPropagation();
	else event.cancelBubble = true;

	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;

	function checkingMinusForSVG(a, b, r1, r2){
		var res = a - b;
		var resrad = r1 - r2;
		if(resrad == 0){
			if(res < 0){
				return a + (r1+r2)/2;
			}
			else{
				return b + (r1+r2)/2;
			}
		}
		else if(resrad > 0){
			if(res < 0){
				return a + (r1+r2)/2 - resrad/2;
			}
			else{
				return b + (r1+r2)/2 + resrad/2;
			}
		}
		else{
			if(res < 0){
				return a + (r1+r2)/2 - resrad/2;
			}
			else{
				return b + (r1+r2)/2 + resrad/2;
			}
		}
		
	}

	function checkingMinusforLineOne(a, b, r1, r2){
		var res = a - b;
		var resrad = r1 - r2;
		if(resrad == 0){
			if(res < 0){
				return Math.abs(a - b);
			}
			else{
				return 0;
			}
		}
		else if(resrad > 0){
			if(res < 0){
				return (Math.abs(a - b) + Math.abs(resrad));
			}
			else{
				return 0;
			}
		}
		else{
			if(res < 0){
				return (Math.abs(a - b) - Math.abs(resrad));
			}
			else{
				return 0;
			}
		}
	}

	function checkingMinusforLineTwo(a, b, r1, r2){
		var res = a - b;
		var resrad = r1 - r2;
		if(resrad == 0){
			if(res < 0){
				return 0;
			}
			else{
				return Math.abs(a - b);
			}
		}
		else if(resrad > 0){
			if(res < 0){
				return 0;
			}
			else{
				return (Math.abs(a - b) - Math.abs(resrad));
			}
		}
		else{
			if(res < 0){
				return 0;
			}
			else{
				return (Math.abs(a - b) + Math.abs(resrad));
			}
		}
	}

	function checkZero(a1, a2, rad1, rad2){
		if(Math.abs((a2+rad2)-(a1+rad1))>0){
			return Math.abs((a2+rad2)-(a1+rad1));
		}
		else{
			return 1;
		}
	}

	function moveHandl(e){
		if(!e) e = window.event;
		
		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	}

	function upHandl(e){
		var svgs = document.getElementsByClassName('svg');
		if(!e) e = window.event;
		var element = e.target || e.srcElement;
		console.log("element upH =" + element);
		if(element == '[object HTMLDivElement]' && element != el){
			var x2 = Number(element.style.left.replace(/\D+/g,""));
			var y2 = Number(element.style.top.replace(/\D+/g,""));
			var rad2 = (Number(element.style.height.replace(/\D+/g,""))/2);
			console.log("x2 = " + x2);
			console.log("y2 = " + y2);
			console.log("rad2 = " + rad2);

			var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
			svg.setAttribute("class", "svg");
			svg.setAttribute("style", "height: " + checkZero(y1, y2, rad1, rad2) + "; width: " + checkZero(x1, x2, rad1, rad2) + "; position: absolute; left:" + (checkingMinusForSVG(x2, x1, rad1, rad2)) + "px; top:" + (checkingMinusForSVG(y2, y1, rad1, rad2)) + "px");

			var flag = 0;
			for(var i = 0; i < svgs.length; i++){
				if(Number(svgs[i].style.left.replace(/\D+/g,"")) == Number(svg.style.left.replace(/\D+/g,"")) && Number(svgs[i].style.top.replace(/\D+/g,"")) == Number(svg.style.top.replace(/\D+/g,"")) && Number(svgs[i].style.height.replace(/\D+/g,"")) == Number(svg.style.height.replace(/\D+/g,"")) && Number(svgs[i].style.width.replace(/\D+/g,"")) == Number(svg.style.width.replace(/\D+/g,""))){
					flag = 1;
				}
			}

			if(flag == 0){
				var line = document.createElementNS('http://www.w3.org/2000/svg', 'line');
				line.setAttribute("class", "line");
				line.setAttribute("x1", checkingMinusforLineOne(x2, x1, rad1, rad2));
				line.setAttribute("y1", checkingMinusforLineOne(y2, y1, rad1, rad2));
				line.setAttribute("x2", checkingMinusforLineTwo(x2, x1, rad1, rad2));
				line.setAttribute("y2", checkingMinusforLineTwo(y2, y1, rad1, rad2));
				line.setAttribute("style", "stroke: rgb(255,0,0); stroke-width: 3");
				
				svg.appendChild(line); 
				document.body.appendChild(svg);
			}
		}

		document.removeEventListener("mouseup", upHandl, true);
		document.removeEventListener("mousemove", moveHandl, true);

		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;	
	}
}
