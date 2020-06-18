<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	refreshPage();
	$('#thead').on('click','#deleteCart', deleteStorage);
	$('#tcontent').on('click','#upBtn',plusCount);
	$('#tcontent').on('click','#downBtn',subCount);
});//ready

function refreshPage() {
	var html="";
	var num = 1;
	var totalPrice=0;
	
	for(var key in localStorage){
		//alert(key);
		if(key=='length') break;
		var data = localStorage.getItem(key).split(',');
		html+= '<tr><td>'+num+'</td>'
				+'<td><img src ='+data[0]+' width=150px height=150px></td>'
				+'<td>'+data[1]+'</td>'
				+'<td>'+data[2]+'</td>'
				+'<td><button value= '+key+' id=upBtn>'
						+'<img src=img/up.jpg width=10px height=10px>'
					+'</button><p>'+data[5]+'</p>'
					+'<button value= '+key+' id=downBtn>'
						+'<img src=img/down.jpg width=10px height=10px>'
					+'</button></td>'
				+'<td><input type=checkbox value='+data[3]+' id=checkbox></td></tr>;';
		totalPrice += parseInt(data[2])*parseInt(data[5]);
		$('#tcontent').html(html);
		$('tfoot span:eq(1)').html(totalPrice);
		num++;
	}//for
}//refreshPage()
	
function deleteStorage() {
	var arr = $('input[type=checkbox]:checked');
	arr.each(function(index, item) {
		var itemNumber = item.value;
		localStorage.removeItem(itemNumber);
	});//each
	refreshPage();
}//deleteStorage
function plusCount() {
	//alert($(this).val());
	for(var key in localStorage){
		//alert(key);
		if(key=='length') break;
		if(key==$(this).val()){
			var data = localStorage.getItem(key).split(',');
			data[5] = parseInt(data[5])+1;
			var str = data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5];
			localStorage.setItem(key,str);
		}
	}//for
	refreshPage();
}//pulsCount
function subCount() {
	//alert($(this).val());
	for(var key in localStorage){
		//alert(key);
		if(key=='length') break;
		if(key==$(this).val()){
			var data = localStorage.getItem(key).split(',');
			
			data[5] = parseInt(data[5])-1;
			if(data[5]<0)data[5]=0;
			
			var str = data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5];
			localStorage.setItem(key,str);
		}
	}//for
	refreshPage();
}//subCount
</script>
</head>
<body>
<div id="header">
	<h1>장바구니</h1>
</div>
<div id="wrap">
	<a href="itemList.do">쇼핑 계속하기</a>
	<table border="1">
		<thead>
			<tr id="thead">
				<th>번호</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>수량</th>
				<th><button id="deleteCart">삭제</button></th>
			</tr>
		<thead>
		<tbody id="tcontent">
		</tbody>
		<tfoot>
			<tr>
			<td colspan="6"><span>총 결제금액 : </span><span></span><span>원</span></td>
			</tr>
		</tfoot>
	</table>
</div>
<div id="footer">

</div>
</body>
</html>