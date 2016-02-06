document.addEventListener('click', function(e){
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
		div.style.borderRadius = "40px";
		div.style.zIndex = "1";
		
		div.onmousedown = function(e){
			drag(this, e);
		}
		
		div.oncontextmenu = function(e){
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
	    		drawLine();
	    		console.log("element was deleted");
	    	}
			e.stopPropagation();
		}

		document.body.appendChild(div);
		drawLine();
		console.log('page: ' + e.pageX + ',' + e.pageY, 'client: ' + e.clientX + ',' + e.clientY, 'screen: ' + e.screenX + ',' + e.screenY);
	}
	
}, false);
