var Geometry = {};

if(window.screenLeft === undefined){
	Geometry.getWindowX = function(){ return window.screenLeft; };
	Geometry.getWindowY = function(){ return window.screenTop; };
}
else if(window.screenX){
	Geometry.getWindowX = function(){ return window.screenX; };
	Geometry.getWindowY = function(){ return window.screenY; };
}

if(window.innerWidth){
	Geometry.getViewportWidth = function(){ return window.innerWidth; };
	Geometry.getViewportHeight = function(){ return window.innerHeight; };
	Geometry.getHorizontalScroll = function(){ return window.pageXOffset; };
	Geometry.getVerticalScroll = function(){ return window.pageYOffset; };
}
else if(document.documentElement && document.documentElement.clientWidth){
	Geometry.getViewportWidth = function(){ return document.documentElement.clientWidth; };
	Geometry.getViewportHeight = function(){ return document.documentElement.clientHeight; };
	Geometry.getHorizontalScroll = function(){ return document.documentElement.scrollLeft; };
	Geometry.getVerticalScroll = function(){ return document.documentElement.scrollTop; };
}

if(document.documentElement && document.documentElement.scrollWidth){
	Geometry.getDocumentWidth = function(){ return document.documentElement.scrollWidth; };
	Geometry.getDocumentHeight = function(){ return document.documentElement.scrollHeight; };
}
else if(document.body.scrollWidth){
	Geometry.getDocumentWidth = function(){ return document.body.scrollWidth; };
	Geometry.getDocumentHeight = function(){ return document.body.scrollHeight; };
}