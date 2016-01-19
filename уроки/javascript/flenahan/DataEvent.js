var DataEvent = {};

DataEvent.send = function(target, datatype, data){
	if(typeof target == "string") target = document.getElementById(target);

	if(document.createElement){
		var e = document.createEvent("Events");
		e.initEvent("dataavailable", true, false);
	}
	else if(document.createEventObject){
		var e = document.createEventObject();
	}
	else return;

	e.datatype = datatype;
	e.data = data;

	if(target.dispatchEvent) target.dispatchEvent(e);
	else if(target.fireEvent) target.fireEvent("ondataavaiable", e);
};

DataEvent.receive = function(target, handler){
	if(typeof target == "string") target = document.getElementById(target);
	if(target.addEventListener) target.addEventListener("dataavailable", handler, false);
	else if(target.attachEvent) target.attachEvent("ondataavaiable", handler);
}