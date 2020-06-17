<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Droppable - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  #body{
  	width: 1200px;
  }
  #clothing{
  	width:500px;
  	float:left;
  }
  	#clothing>h2{
  		border-radius: 5px;
  		padding: 2px 2px 2px 10px;
  	}
  	
  #cart{
		width:500px;
		
		margin: 0px 10px;
		float:left;
	}	
	
	#cart>h2{
  		border-radius: 5px;
  		padding: 2px 2px 2px 10px;
  	}
  	#cart>div{
  		  	}
	
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	$('#catalog').accordion({
		heightStyle : 'content'
	});
    $('#catalog li').draggable({
    	helper:'clone',
    	appentdTo:'#cart'
    });//draggalbe
    $('#cart>div').droppable({
    	drop:function(event,ui){
    		$(this).find('.placeholder').remove();
    		var uidrag = ui.draggable.text();
    		$(this).find('ol').append('<li>'+uidrag+'</li>');
    	}
    });//draggalbe
  });//ready
  </script>
</head>
<body>
	<div id="clothing" >
		<h2 class="ui-widget-header">카 탈 로 그 </h2>
		<!-- 드래그하는 대상들 -->
		<div id="catalog">
			<h2><a href="#">상의류</a></h2>
			<div>
				<ul>
					<li>티셔츠</li>
					<li>남방</li>
					<li>가디건</li>
					<li>점퍼</li>
				</ul>
			</div>
			
			<h2><a href="#">하의류</a></h2>
			<div>
				<ul>
					<li>바지</li>
					<li>반바지</li>
					<li>치마</li>
				</ul>
			</div>
			
			<h2><a href="#">엑세서리</a></h2>
			<div>
				<ul>
					<li>귀고리</li>
					<li>목걸이</li>
					<li>반지</li>
					<li>팔찌</li>
					<li>발찌</li>
				</ul>
			</div>
			
		</div>
	</div>
	
	<!-- drop할 영역 -->
	<div id="cart">
		<h2 class="ui-widget-header">Shopping Cart</h2>
		<div class="ui-widget-content">
			<ol>
				<li class="placeholder">Dropping Here</li>
			</ol>
		</div>
	</div>
</body>
</html>