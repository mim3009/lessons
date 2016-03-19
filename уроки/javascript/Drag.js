function drag(elementToDrag, event){
	var distance = 0;
	var m = 0;
	var findX_of_element_i = new Array();
	var findY_of_element_i = new Array();
	var distance_for_another_points = new Array();
	for(var i = 0; i < 100; i++){
		distance_for_another_points[i] = 0;
	}
	var x_fixed_red_point;
	var y_fixed_red_point;
	var tr = document.getElementById("pointsTable").getElementsByTagName('tr');
	var findX = null;
	var findY = null;
	var findR = null;
	for(var i = 0; i < tr.length; i++){
		var td = tr[i].getElementsByTagName('td');
		for(var j = 0; j < td.length; j++){
			if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToDrag.style.left.replace(/\D+/g,"")) + Number(elementToDrag.style.width.replace(/\D+/g,""))/2) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(elementToDrag.style.top.replace(/\D+/g,"")) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2)){
				findX = td[0];
				findY = td[1];
				findR = td[3];
				break;
			}
		}
	}

	var startX = event.clientX;
	var startY = event.clientY;
	var origX = elementToDrag.offsetLeft;
	var origY = elementToDrag.offsetTop;
	var deltaX = startX - origX;
	var deltaY = startY - origY;

	var x = event.clientX - deltaX;
	var y = event.clientY - deltaY;

	var rad1 = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
	var svg = document.getElementsByTagName("svg");
	var lines = document.getElementsByTagName("line");
	var findedLines = new Array();
	var j = 0;
	for(var i = 0; i < lines.length; i++){
		if(lines[i].getAttribute("x1") == (x-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y1") == (y-svg[0].offsetTop+rad1)){
			findedLines[j] = lines[i];
			findedLines[j].setAttribute("ch", "1");
			j++;
		}
		if(lines[i].getAttribute("x2") == (x-svg[0].offsetLeft+rad1) && lines[i].getAttribute("y2") == (y-svg[0].offsetTop+rad1)){
			findedLines[j] = lines[i];
			findedLines[j].setAttribute("ch", "2");
			j++;
		}
	}

	var l = 0;
	var findTR = new Array();
	for(var i = 0; i < findedLines.length; i++){
		var table = document.getElementById("linesTable");
		var tr = document.getElementById("linesTable").getElementsByTagName('tr');
		for(var j = 0; j < tr.length; j++){
			var td = tr[j].getElementsByTagName('td');
			if(parseInt(Number(findedLines[i].getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(findedLines[i].getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
				findTR[l] = tr[j];
				l++;
			}
		}
	}

	function dragG(elementToDrag, e){
		var p = 0;
		for(var i = 0; i < findedLines.length; i++){
			if(findedLines[i].getAttribute("lengthLine")){
				p++;
			}
		}
		if(p == 0){
			if(!e) e = window.event;
			elementToDrag.style.left = (e.clientX - deltaX) + "px";
			elementToDrag.style.top = (e.clientY - deltaY) + "px";

			for(var i = 0; i < findedLines.length; i++){
				var fLine = findedLines[i];
				var x1 = Number(fLine.getAttribute("x1"))-rad1+svg[0].offsetLeft;
				var y1 = Number(fLine.getAttribute("y1"))-rad1+svg[0].offsetTop;
				var x2 = Number(fLine.getAttribute("x2"))-rad1+svg[0].offsetLeft;
				var y2 = Number(fLine.getAttribute("y2"))-rad1+svg[0].offsetTop;
				if(fLine.getAttribute("ch") == "1"){

					for(var u = 0; u < findTR.length; u++){
						var td = findTR[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[0].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
							td[1].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
							break;
						}
					}

					fLine.setAttribute("x1", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-svg[0].offsetLeft));
					fLine.setAttribute("y1", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-svg[0].offsetTop));
				}
				else if(fLine.getAttribute("ch") == "2"){

					for(var u = 0; u < findTR.length; u++){
						var td = findTR[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[2].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
							td[3].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
							break;
						}
					}

					fLine.setAttribute("x2", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-svg[0].offsetLeft));
					fLine.setAttribute("y2", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-svg[0].offsetTop));
				}
			}

			findX.innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,"")) + Number(elementToDrag.style.width.replace(/\D+/g,""))/2) + "px";
			findY.innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,"")) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2) + "px";
			findR.innerHTML = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
		}
		else if(p == 1){
			var fixLine = null;
			for(var i = 0; i < findedLines.length; i++){
				if(findedLines[i].getAttribute("lengthLine")){
					fixLine = findedLines[i];
				}
			}
			var lineLength = Number(fixLine.getAttribute("lengthLine"));
			var xfix = 0;
			var yfix = 0;
			if(fixLine.getAttribute("ch") == "1"){
				xfix = Number(fixLine.getAttribute("x2"))+svg[0].offsetLeft;
				yfix = Number(fixLine.getAttribute("y2"))+svg[0].offsetTop;
			}
			else{
				xfix = Number(fixLine.getAttribute("x1"))+svg[0].offsetLeft;
				yfix = Number(fixLine.getAttribute("y1"))+svg[0].offsetTop;
			}

			var second_fixed_point = null;
			var points = document.getElementsByClassName("movedElement");
			for(var i = 0; i < points.length; i++){
				if(Number(points[i].style.left.replace(/\D+/g,""))+(Number(points[i].style.width.replace(/\D+/g,""))/2) == xfix && Number(points[i].style.top.replace(/\D+/g,""))+(Number(points[i].style.height.replace(/\D+/g,""))/2) == yfix){
					second_fixed_point = points[i];
					break;
				}
			}

			if(second_fixed_point.style.background == "gray"){
				if(!e) e = window.event;

				var center = {};
				center.x = xfix; 
				center.y = yfix;
				var point = {};
				point.x = (e.clientX - deltaX) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2; 
				point.y = (e.clientY - deltaY) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2;
				var angle = get_angle(center, point);
				
				var radius = lineLength;
				var angleOffset = -90;
				var deg2rad = Math.PI/180;
				var rad2deg = 180/Math.PI;
				var angle2 = angle + angleOffset;
				var radangle = angle2*deg2rad;
				var left = radius*Math.cos(radangle) + xfix - Number(elementToDrag.style.height.replace(/\D+/g,""))/2;
				var top = radius*Math.sin(radangle) + yfix - Number(elementToDrag.style.height.replace(/\D+/g,""))/2;

				elementToDrag.style.left = parseInt(left) + "px";
				elementToDrag.style.top = parseInt(top) + "px";

				for(var i = 0; i < findedLines.length; i++){
					var fLine = findedLines[i];
					var x1 = Number(fLine.getAttribute("x1"))-rad1+svg[0].offsetLeft;
					var y1 = Number(fLine.getAttribute("y1"))-rad1+svg[0].offsetTop;
					var x2 = Number(fLine.getAttribute("x2"))-rad1+svg[0].offsetLeft;
					var y2 = Number(fLine.getAttribute("y2"))-rad1+svg[0].offsetTop;
					if(fLine.getAttribute("ch") == "1"){

						for(var u = 0; u < findTR.length; u++){
							var td = findTR[u].getElementsByTagName('td');
							if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
								td[0].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
								td[1].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
							}
						}

						fLine.setAttribute("x1", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-svg[0].offsetLeft));
						fLine.setAttribute("y1", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-svg[0].offsetTop));
					}
					else if(fLine.getAttribute("ch") == "2"){

						for(var u = 0; u < findTR.length; u++){
							var td = findTR[u].getElementsByTagName('td');
							if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
								td[2].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1);
								td[3].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1);
							}
						}

						fLine.setAttribute("x2", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+rad1-svg[0].offsetLeft));
						fLine.setAttribute("y2", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+rad1-svg[0].offsetTop));
					}
				}

				findX.innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,"")) + Number(elementToDrag.style.width.replace(/\D+/g,""))/2) + "px";
				findY.innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,"")) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2) + "px";
				findR.innerHTML = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
			}
			else if(second_fixed_point.style.background == "red"){
				red_point(second_fixed_point, fixLine, svg, e);
				console.log(fixLine);
				console.log("fLine");
				if(!e) e = window.event;

								var center2 = {};
								center2.x = x_fixed_red_point; 
								center2.y = y_fixed_red_point;
								var point2 = {};
								point2.x = (e.clientX - deltaX) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2; 
								point2.y = (e.clientY - deltaY) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2;
								var angle4 = get_angle(center2, point2);
								var point_x_of_dragged_element = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
								var point_y_of_dragged_element = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2);

								if(distance == 0){
									distance = Math.sqrt(Math.pow((x_fixed_red_point-point_x_of_dragged_element), 2) + Math.pow((y_fixed_red_point-point_y_of_dragged_element), 2));
								}
								//сделать так что бы первая тоже линия меняла координаты
								var radius2 = distance;
								var angleOffset = -90;
								var deg2rad = Math.PI/180;
								var rad2deg = 180/Math.PI;
								var angle5 = angle4 + angleOffset;
								var radangle2 = angle5*deg2rad;
								var left2 = radius2*Math.cos(radangle2) + x_fixed_red_point - Number(elementToDrag.style.height.replace(/\D+/g,""))/2;
								var top2 = radius2*Math.sin(radangle2) + y_fixed_red_point - Number(elementToDrag.style.height.replace(/\D+/g,""))/2;

								elementToDrag.style.left = parseInt(left2) + "px";
								elementToDrag.style.top = parseInt(top2) + "px";

								
									var fLine = fixLine;
									if(fLine.getAttribute("ch") == "1"){

										for(var u = 0; u < findTR.length; u++){
											var td = findTR[u].getElementsByTagName('td');
											if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
												td[0].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
												td[1].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
												td[2].innerHTML = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
												td[3].innerHTML = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
											}
										}

										fLine.setAttribute("x1", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2-svg[0].offsetLeft));
										fLine.setAttribute("y1", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2-svg[0].offsetTop));
										fLine.setAttribute("x2", parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetLeft));
										fLine.setAttribute("y2", parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetTop));
									}
									else if(fLine.getAttribute("ch") == "2"){

										for(var u = 0; u < findTR.length; u++){
											var td = findTR[u].getElementsByTagName('td');
											if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
												td[0].innerHTML = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
												td[1].innerHTML = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
												td[2].innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
												td[3].innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
											}
										}

										fLine.setAttribute("x1", parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetLeft));
										fLine.setAttribute("y1", parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetTop));
										fLine.setAttribute("x2", parseInt(Number(elementToDrag.style.left.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2-svg[0].offsetLeft));
										fLine.setAttribute("y2", parseInt(Number(elementToDrag.style.top.replace(/\D+/g,""))+Number(elementToDrag.style.height.replace(/\D+/g,""))/2-svg[0].offsetTop));
									}
								

								findX.innerHTML = parseInt(Number(elementToDrag.style.left.replace(/\D+/g,"")) + Number(elementToDrag.style.width.replace(/\D+/g,""))/2) + "px";
								findY.innerHTML = parseInt(Number(elementToDrag.style.top.replace(/\D+/g,"")) + Number(elementToDrag.style.height.replace(/\D+/g,""))/2) + "px";
								findR.innerHTML = parseInt(Number(elementToDrag.style.height.replace(/\D+/g,""))/2);
			}
		}
		else{}
		m = 0;
	}

	function red_point(second_fixed_point, fixLine, svg, e){
		var rad11 = parseInt(Number(second_fixed_point.style.height.replace(/\D+/g,""))/2);
		var findedLines2 = new Array();
		var j = 0;
		for(var i = 0; i < lines.length; i++){
			if((lines[i].getAttribute("x1") == fixLine.getAttribute("x1") && lines[i].getAttribute("y1") == fixLine.getAttribute("y1") && lines[i].getAttribute("x2") == fixLine.getAttribute("x2") && lines[i].getAttribute("y2") == fixLine.getAttribute("y2")) || (lines[i].getAttribute("x1") == fixLine.getAttribute("x2") && lines[i].getAttribute("y1") == fixLine.getAttribute("y2") && lines[i].getAttribute("x2") == fixLine.getAttribute("x1") && lines[i].getAttribute("y2") == fixLine.getAttribute("y1"))) continue;
			else if(lines[i].getAttribute("x1") == parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+rad11-svg[0].offsetLeft) && lines[i].getAttribute("y1") == parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+rad11-svg[0].offsetTop)){
				findedLines2[j] = lines[i];
				findedLines2[j].setAttribute("ch", "1");
				j++;
			}
			else if(lines[i].getAttribute("x2") == parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+rad11-svg[0].offsetLeft) && lines[i].getAttribute("y2") == parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+rad11-svg[0].offsetTop)){
				findedLines2[j] = lines[i];
				findedLines2[j].setAttribute("ch", "2");
				j++;
			}
		}
		var k = 0;
		var white_line = null;
		for(var i = 0; i < findedLines2.length; i++){
			if(findedLines2[i].style.stroke == "white"){
				white_line = findedLines2[i];
				k++;
			}
		}
		if(k == 0){
			x_fixed_red_point = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+rad11);
			y_fixed_red_point = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+rad11);
		}
		else if(k == 1){
			var white_line_x1 = white_line.getAttribute("x1");
			var white_line_y1 = white_line.getAttribute("y1");
			var white_line_x2 = white_line.getAttribute("x2");
			var white_line_y2 = white_line.getAttribute("y2");
			var x_second_point = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+rad11-svg[0].offsetLeft);
			var y_second_point = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+rad11-svg[0].offsetTop);
			var third_point_x = null;
			var third_point_y = null;

			if(white_line_x1 == x_second_point && white_line_y1 == y_second_point){
				third_point_x = white_line_x2;
				third_point_y = white_line_y2;
			}
			else if(white_line_x2 == x_second_point && white_line_y2 == y_second_point){
				third_point_x = white_line_x1;
				third_point_y = white_line_y1;
			}

			var third_point = null;
			var points22 = document.getElementsByClassName("movedElement");
			for(var i = 0; i < points22.length; i++){
				if(Number(points22[i].style.left.replace(/\D+/g,""))+(Number(points22[i].style.width.replace(/\D+/g,""))/2) == (Number(third_point_x) + Number(svg[0].offsetLeft)) && Number(points22[i].style.top.replace(/\D+/g,""))+(Number(points22[i].style.height.replace(/\D+/g,""))/2) == (Number(third_point_y) + Number(svg[0].offsetTop))){
					third_point = points22[i];
					break;
				}
			}

			//дописать действия на то что точка последняя будет серой
			if(third_point.style.background == "gray"){
				//red_point(third_point, white_line, svg, e);
			}
			else if(third_point.style.background == "red"){
				red_point(third_point, white_line, svg, e);
												console.log(x_fixed_red_point + "        " + y_fixed_red_point);
												console.log(second_fixed_point);
												console.log(third_point);
												console.log(white_line);
												console.log(m++);
												m++;
				var tr_of_second_point = document.getElementById("pointsTable").getElementsByTagName('tr');
				var findX_of_second_point = null;
				var findY_of_second_point = null;
				for(var i = 0; i < tr_of_second_point.length; i++){
					var td = tr_of_second_point[i].getElementsByTagName('td');
					for(var j = 0; j < td.length; j++){
						if(Number(td[0].innerHTML.replace(/\D+/g,"")) == parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,"")) + Number(second_fixed_point.style.width.replace(/\D+/g,""))/2) && Number(td[1].innerHTML.replace(/\D+/g,"")) == parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,"")) + Number(second_fixed_point.style.height.replace(/\D+/g,""))/2)){
							findX_of_second_point = td[0];
							findY_of_second_point = td[1];
							break;
						}
					}
				}

				var origX_of_second_fixed_point = second_fixed_point.offsetLeft;
				var origY_of_second_fixed_point = second_fixed_point.offsetTop;
				var deltaX_of_second_fixed_point = startX - origX_of_second_fixed_point;
				var deltaY_of_second_fixed_point = startY - origY_of_second_fixed_point;

				var center2 = {};
				center2.x = x_fixed_red_point; 
				center2.y = y_fixed_red_point;

				var point_of_second_point = {};
				point_of_second_point.x = (e.clientX - deltaX_of_second_fixed_point) + Number(second_fixed_point.style.height.replace(/\D+/g,""))/2; 
				point_of_second_point.y = (e.clientY - deltaY_of_second_fixed_point) + Number(second_fixed_point.style.height.replace(/\D+/g,""))/2;
				var angle6 = get_angle(center2, point_of_second_point);
				var point_x_of_second_point = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.height.replace(/\D+/g,""))/2);
				var point_y_of_second_point = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.height.replace(/\D+/g,""))/2);

				if(distance_for_another_points[m] == 0 || distance_for_another_points[m] === undefined){
					distance_for_another_points[m] = Math.sqrt(Math.pow((x_fixed_red_point-point_x_of_second_point), 2) + Math.pow((y_fixed_red_point-point_y_of_second_point), 2));
				}
				
				var radius_of_second_point = distance_for_another_points[m];
				var angleOffset = -90;
				var deg2rad = Math.PI/180;
				var rad2deg = 180/Math.PI;
				var angle7 = angle6 + angleOffset;
				var radangle2 = angle7*deg2rad;
				var left2 = radius_of_second_point*Math.cos(radangle2) + x_fixed_red_point - Number(second_fixed_point.style.height.replace(/\D+/g,""))/2;
				var top2 = radius_of_second_point*Math.sin(radangle2) + y_fixed_red_point - Number(second_fixed_point.style.height.replace(/\D+/g,""))/2;

				second_fixed_point.style.left = parseInt(left2) + "px";
				second_fixed_point.style.top = parseInt(top2) + "px";

				findX_of_second_point.innerHTML = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,"")) + Number(second_fixed_point.style.width.replace(/\D+/g,""))/2) + "px";
				findY_of_second_point.innerHTML = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,"")) + Number(second_fixed_point.style.height.replace(/\D+/g,""))/2) + "px";

				var l = 0;
				var findTR_for_white_line = null;
				var tr_of_lines_table = document.getElementById("linesTable").getElementsByTagName('tr');
				for(var j = 0; j < tr_of_lines_table.length; j++){
					var td = tr_of_lines_table[j].getElementsByTagName('td');
					if(parseInt(Number(white_line.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(white_line.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(white_line.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(white_line.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
						findTR_for_white_line = tr_of_lines_table[j];
						l++;
					}
				}

				var fLine = white_line;
				if(fLine.getAttribute("ch") == "1"){

					for(var u = 0; u < findTR_for_white_line.length; u++){
						var td = findTR_for_white_line[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[0].innerHTML = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
							td[1].innerHTML = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
							td[2].innerHTML = parseInt(Number(third_point.style.left.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2);
							td[3].innerHTML = parseInt(Number(third_point.style.top.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2);
						}
					}

					fLine.setAttribute("x1", parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetLeft));
					fLine.setAttribute("y1", parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetTop));
					fLine.setAttribute("x2", parseInt(Number(third_point.style.left.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetLeft));
					fLine.setAttribute("y2", parseInt(Number(third_point.style.top.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetTop));
				}
				else if(fLine.getAttribute("ch") == "2"){

					for(var u = 0; u < findTR_for_white_line.length; u++){
						var td = findTR_for_white_line[u].getElementsByTagName('td');
						if(parseInt(Number(fLine.getAttribute("x1"))+svg[0].offsetLeft) == Number(td[0].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y1"))+svg[0].offsetTop) == Number(td[1].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("x2"))+svg[0].offsetLeft) == Number(td[2].innerHTML.replace(/\D+/g,"")) && parseInt(Number(fLine.getAttribute("y2"))+svg[0].offsetTop) == Number(td[3].innerHTML.replace(/\D+/g,""))){
							td[0].innerHTML = parseInt(Number(third_point.style.left.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2);
							td[1].innerHTML = parseInt(Number(third_point.style.top.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2);
							td[2].innerHTML = parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
							td[3].innerHTML = parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2);
						}
					}

					fLine.setAttribute("x1", parseInt(Number(third_point.style.left.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetLeft));
					fLine.setAttribute("y1", parseInt(Number(third_point.style.top.replace(/\D+/g,""))+Number(third_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetTop));
					fLine.setAttribute("x2", parseInt(Number(second_fixed_point.style.left.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetLeft));
					fLine.setAttribute("y2", parseInt(Number(second_fixed_point.style.top.replace(/\D+/g,""))+Number(second_fixed_point.style.width.replace(/\D+/g,""))/2-svg[0].offsetTop));
				}
			}
		}
		else if(k > 1){

		}
	}

	if(document.addEventListener){
		document.addEventListener("mousemove", moveHandler, true);
		document.addEventListener("mouseup", upHandler, true);
	}
	
	if(event.stopPropagation) event.stopPropagation();
	else event.cancelBubble = true;

	if(event.preventDefault) event.preventDefault();
	else event.returnValue = false;

	function moveHandler(e){
		dragG(elementToDrag,e);
		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	}

	function upHandler(e){
		if(!e) e = window.event;
		document.removeEventListener("mouseup", upHandler, true);
		document.removeEventListener("mousemove", moveHandler, true);

		if(e.stopPropagation) e.stopPropagation();
		else e.cancelBubble = true;
	}
}
