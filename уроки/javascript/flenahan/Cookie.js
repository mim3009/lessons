function Cookie(name){
	this.$name = name;
	var allcookies = document.cookie;
	if(allcookies == "") return;
	var cookies = allcookies.split(';');
	var cookie = null;
	for(var i = 0; i < cookies.length; i++){
		if(cookies[i].substring(0, name.length+1) == (name + "=")){
			cookie = cookies[i];
			break;
		}
	}
	if(cookie == null) return;
	var cookieval = cookie.substring(name.length+1);
	var a = cookieval.split('&');
	for(var i = 0; i < a.length; i++){
		a[i] = a[i].split(':');
	}
	for(var i = 0; i < a.length; i++){
		this[a[i][0]] = decodeURIComponent(a[i][1]);
	}
}

Cookie.prototype.store = function(dayToLive, path, domain, secure){
	var cookieval = "";
	for(var prop in this){
		if((prop.charAt(0) == '$') && ((typeof this[prop]) == 'function')) continue;
		if(cookieval != "") cookieval += '&';
		cookieval += prop + ":" + encodeURIComponent(this[prop]);
	}
	var cookie = this.$name + '=' + cookieval;
	if(dayToLive || dayToLive == 0){
		cookie += "; max-age=" + (dayToLive*24*60*60);
	}
	if(path) cookie += "; path=" + path;
	if(domain) cookie += "; domain=" + domain;
	if(secure) cookie += "; secure";
	document.cookie = cookie;
}

Cookie.prototype.remove = function(path, domain, secure){
	for(var prop in this){
		if(prop.charAt(0) != '$' && typeof this[prop] != 'function') delete this[prop];
	}
	this.store(0, path, domain, secure);
}

Cookie.enabled = function(){
	if(navigator.cookieEnabled != undefined) return navigator.cookieEnabled;
	if(Cookie.enabled.cache != undefined) return Cookie.enabled.cache;
	document.cookie = "testcookie=test; max-age=10000";
	var cookies = document.cookie;
	if(cookies.indexOf("testcookie=test") == -1){
		return Cookie.enabled.cache = false;
	}
	else{
		document.cookie = "testcookie=test; max-age=0";
		return Cookie.enabled.cache = true;
	}
}