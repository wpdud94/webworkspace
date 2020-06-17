<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Accordion - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <!-- bs는 jquery 다음으로... jquery를 쓰기 때문... -->
  <script>
  $( function() {
	//1. 아코디언
	var icons = {
      header: "ui-icon-circle-arrow-e",
      activeHeader: "ui-icon-circle-arrow-s"
    };
    $( "#accordion" ).accordion({
    	heightStyle: "content",
    	icons : icons
    });//accordion
    //2. section2에 데이터 넣기
    $('#accordion h3').click(function() {
		//alert($(this).text());
		var text = $(this).text();
		if(text=="IT Education Subject"){
    		$.ajax({
    			type : 'post',
    			url : 'front.do',
    			data : 'command=subject',
    				
    			success:function(data){
    				$('#subject').html(data);	/* result.jsp의 body부분.! */
    			}
    		})//ajax
		}else if(text=='Assoication Global IT Company'){
			$.ajax({
				type:'post',
				url:'front.do',
				data:'command=company',
				
				success : function(data) {
					$('#itcom').html(data);
				}//callback
			});//ajax
		}//elseif
	});//click_accordion h3
	
	//3. 
	$('#createSection').click(function() {
		var footerContent="<h3>How to Get</h3><div><p>서울 서초동 459 엔코아 아카데미 남부터미널 777</p></div>";
		//동적으로 accordion 만들기... 보통은 동적으로 생성할 때 지우고 다시 만듦
		$('#accordion').append(footerContent).accordion('destroy').accordion({
			heightStyle: "content",
	    	icons : icons
		});
		$(this).remove(); // 붙임과 동시에 더 만들지 않도록 버튼 삭제
	});//click_createSection
  } );//ready
  </script>
</head>
<body>
 
<div id="accordion">
  <h3>Encore Academy Introduction</h3>
  <div>
  	<p>
  	플레이 데이터의 새로운 교육 프로그램을 소개합니다.<br/>
  	아래의 섹션에서 이수할 교육과목을 확인하시기 바랍니다.
  	<p>
  </div>
  
  <h3>IT Education Subject</h3>
  <div id="subject">
   
  </div>
  
  <h3>Assoication Global IT Company</h3>
  <div id="itcom">
  
  </div>
</div>
 <hr>
 <input type="button" value="Create Section Addction" id="createSection">
 
</body>
</html>