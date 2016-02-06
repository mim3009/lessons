function drawLine(){

	function checkingMinusForSVG(a, b){
		var res = a - b;
		if(res < 0){
			return a+10;
		}
		else{
			return b+10;
		}
	}

	function checkingMinusforLineOne(a, b){
		var res = a - b;
		if(res < 0){
			return Math.abs(a - b);
		}
		else{
			return 0;
		}
	}

	function checkingMinusforLineTwo(a, b){
		var res = a - b;
		if(res < 0){
			return 0;
		}
		else{
			return Math.abs(a - b);
		}
	}

	var elements = document.getElementsByClassName('lines');
	while(elements.length){
		document.body.removeChild(elements[0]);
	}

	var el = document.getElementsByClassName('movedElement');
	for(var i = 0; i < el.length; i++){
		
		var x1 = null;
		var x2 = null;
		var y1 = null;
		var y2 = null;

		if(i == el.length-1){
			x1 = parseInt(el[i].style.left.replace(/\D+/g,""));
			y1 = parseInt(el[i].style.top.replace(/\D+/g,""));
			x2 = parseInt(el[0].style.left.replace(/\D+/g,""));
			y2 = parseInt(el[0].style.top.replace(/\D+/g,""));
		}
		else{
			x1 = parseInt(el[i].style.left.replace(/\D+/g,""));
			y1 = parseInt(el[i].style.top.replace(/\D+/g,""));
			x2 = parseInt(el[i+1].style.left.replace(/\D+/g,""));
			y2 = parseInt(el[i+1].style.top.replace(/\D+/g,""));
		}
		
		var svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
		svg.setAttribute("class", "lines");
		svg.setAttribute("height", Math.abs(y2-y1));
		svg.setAttribute("width", Math.abs(x2-x1));
		svg.setAttribute("style", "position:absolute; left:" + checkingMinusForSVG(x2, x1) + "px; top:" + checkingMinusForSVG(y2, y1) + "px");

		var line = document.createElementNS('http://www.w3.org/2000/svg', 'line');
		line.setAttribute("x1", checkingMinusforLineOne(x2, x1));
		line.setAttribute("y1", checkingMinusforLineOne(y2, y1));
		line.setAttribute("x2", checkingMinusforLineTwo(x2, x1));
		line.setAttribute("y2", checkingMinusforLineTwo(y2, y1));
		line.setAttribute("style", "stroke: rgb(255,0,0); stroke-width: 3");
		
		svg.appendChild(line); 
		document.body.appendChild(svg);
	}
}
