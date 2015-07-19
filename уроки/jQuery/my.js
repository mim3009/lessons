(function ($) {
	$.fn.myExt = function (options) {
		options = $.extend({
			widthLine: "1px", //толщина рамки
			baseColor: "black", //цвет елемента над которым нет курсора
			hoverColor: "red" //цвет елемента на который наведен курсор
		}, options);
		var make = function(){
			$(this).css("border", options.widthLine + " solid " + options.baseColor);

			$(this).mouseenter(function () {
				$(this).css("border-color", options.hoverColor);
			});

			$(this).mouseleave(function () {
				$(this).css("border-color", options.baseColor);
			});
		}
		return this.each(make);
	}
})($);