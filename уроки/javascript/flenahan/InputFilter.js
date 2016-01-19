(function(){
	
	if(window.addEventListener) window.addEventListener("load", init, false);
	else if(window.attachEvent) window.attachEvent("onload", init);

	function init(){
		var inputtags = document.getElementsByTagName("input");
		for(var i = 0; i < inputtags.length; i++){
			var tag = inputtags[i];
			if(tag.type != "text") continue;
			var allowed = tag.getAttribute("allowed");
			if(!allowed) continue;
			if(tag.addEventListener) tag.addEventListener("keypress", filter, false);
			else tag.onkeypress = filter;
		}
	}

	function filter(event){
		var e = event || window.event;
		var code = e.charCode || e.keyCode;
		if(e.charCode == 0) return true;
		if(e.ctrlKey || e.altKey) return true;
		if(code < 32) return true;
		var allowed = this.getAttribute("allowed");
		var messageElement = null;
		var messageid = this.getAttribute("messageid");
		if(messageid) messageElement = document.getElementById(messageid);
		var c = String.fromCharCode(code);

		if(allowed.indexOf(c) != -1){
			if(messageElement) messageElement.style.visibility = "hidden";
			return true;
		}
		else{
			if(messageElement) messageElement.style.visibility = "visible";
			if(e.preventDefault) e.preventDefault();
			if(e.returnValue) e.returnValue = false;
			return false;
		}
	}

})();