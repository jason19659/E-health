$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			nav : false,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
	
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
	$(function(){ var url = getPath() + "/api/medicinal/showTop5";
	var d;
	$("#flexiselDemo3").empty(); 
	$.getJSON(url,function(data) {
						d = data;
						var txt2;

						for (var i = 0; i < data.length; i++) {
							var divs = "<li><img src=\""+data[i].image+"\" class=\"img-responsive\" />\n";
							var title = "<div class=\"grid-flex\"> \n";
							var t0 = "<p>￥ "+data[i].price+" </p> \n";
							var t1 = "<div class=\"m_3\">\n";
							var t2 = "<a href=\""+getPath()+"/api/order/"+data[i].id+"\" class=\"link2\">加入购物车</a>\n";
							var t3 = "</div>\n";
							var t4 = "<div class=\"ticket\"></div>\n";
							var t5 = "</div></li>"
							var txt = divs + title + t0 + t1 + t2 + t3 + t4 + t5;
							$("#flexiselDemo3").append(txt);
						}

					});})
					
	 var url = getPath() + "/api/medicinal/showMost4";
	var d;
	$.getJSON(url,function(data) {
						d = data;
						var txt2;

						for (var i = 0; i < data.length; i++) {
						var txt = 
							"<div class=\"col-md-3 span_6\">"
							+"	<div class=\"box_inner\">"
							+"		<img src=\""+data[i].image+"\" class=\"img-responsive\" />"
							+"		<div class=\"sale-box\"></div>"
							+"		<div class=\"desc\">"
							+"			<h3>"+data[i].name+"</h3>"
							+"			<h4>￥ "+data[i].price+"</h4>"
							+"			<ul class=\"list2\">"
							+"				<li class=\"list2_left\"><span class=\"m_1\"><a href=\""+getPath()+"/api/order/"+data[i].id+"\" class=\"link\">加入购物车</a></span></li>"
							+"				<li class=\"list2_right\"><span class=\"m_2\"><a href=\""+getPath()+"/single.html?id="+data[i].id+"\" class=\"link1\">查看详情</a></span></li>"
							+"				<div class=\"clearfix\"></div>"
							+"			</ul>"
							+"		<div class=\"heart\"></div>"
							+"		</div>"
							+"	</div>"
							+"</div>"
							$(".grid_2").append(txt);
						}

					});