function log(category, message, object){

	if(log.options[category + "Disabled"]) return;

	var id = category + "_log";
	var c = document.getElementById(id);

	if(!c && log.options[category + "Enabled"]){
		c = document.createElement("div");
		c.id = id;
		c.className = "log";
		document.body.appendChild(c);
	}

	if(!c) return;

	if(log.options.timestamp) message = new Date() + ": " + (message?message:"");

	var entry = document.createElement("div");
	entry.className = category + "_message";

	if(message){
		entry.appendChild(document.createTextNode(message));
	}

	if(object && typeof object == "object"){
		entry.appendChild(log.makeTable(object, 0));
	}

	c.appendChild(entry); 
}

log.makeTable = function(object, level){
	if(level > log.options.maxRecursion) return document.createTextNode(object.toString());
	var table = document.createElement("table");
	table.border = 1;
	var header = document.createElement("tr");
	var headerName = document.createElement("th");
	var headerType = document.createElement("th");
	var headerValue = document.createElement("th");
	headerName.appendChild(document.createTextNode("Имя"));
	headerType.appendChild(document.createTextNode("Тип"));
	headerValue.appendChild(document.createTextNode("Значение"));
	header.appendChild(headerName);
	header.appendChild(headerType);
	header.appendChild(headerValue);
	table.appendChild(header);

	var names = [];
	for(var name in object){
		names.push(name);
	}
	names.sort();

	for(var i = 0; i < names.length; i++){
		var name, value, type;
		name = names[i];

		try{
			value = object[name];
			type = typeof value;
		}catch(e){
			value = "<Неизвестное значение";
			type = "Не известен";
		};

		if(log.options.filter && !log.options.filter(name, value)) continue;
		if(type == "function") value = "{/*исходные тексты не выводятся*/}";

		var row = document.createElement("tr");
		row.vAlign = "top";
		var rowName = document.createElement("td");
		var rowType = document.createElement("td");
		var rowValue = document.createElement("td");

		rowName.appendChild(document.createTextNode(name));
		rowType.appendChild(document.createTextNode(type));

		if(type == "object") rowValue.appendChild(log.makeTable(value, level+1));
		else rowValue.appendChild(document.createTextNode(value));

		row.appendChild(rowName);
		row.appendChild(rowType);
		row.appendChild(rowValue);

		table.appendChild(row);
	}
	return table;
}

log.options = {};

log.debug = function(message, object){
	log("debug", message, object);
};

log.warn = function(message, object){
	log("warning", message, object);
};

//function alert(msg){
//	log("alert", msg);
//}