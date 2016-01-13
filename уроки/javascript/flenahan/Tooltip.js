function Tooltip(){
	this.tooltip = document.createElement("div");
	this.tooltip.stype.position = "absolute";
	this.tooltip.stype.visibility = "hidden";
	this.tooltip.className = "tooltipShadow";
	
	this.content = document.createElement("div");
	this.content.stype.position = "relative";
	this.content.className = "tooltipContent";

	this.tooltip.appendChild(this.content);
}

Tooltip.prototype.show = function(text, x, y){
	this.content.innerHTML = text;
	this.tooltip.stype.left = x + "px";
	this.tooltip.stype.top = y + "px";
	this.tooltip.stype.visibility = "visible";

	if(this.tooltip.parentNode != document.body) document.body.appendChild(this.tooltip);
};

Tooltip.prototype.hide = function(){
	this.tooltip.style.visibility = "hidden";
};