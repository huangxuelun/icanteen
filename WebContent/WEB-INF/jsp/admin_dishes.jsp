<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%String path = request.getContextPath(); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>beexbee</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- Le styles -->
<script type="text/javascript" src="<%=path%>/js/jquery-1.10.2.min.js" ></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/css/site.css">
<script type="text/javascript">
$(function() {
	$('#subm').on('click', function() {
		if($('#name').val() == '') {
			alert('菜名不能为空！');
			return false;
		}
		if($('#code').val() == '') {
			alert('编号不能为空！');
			return false;
		}
		if($('#price').val() == '') {
			alert('单价不能为空！');
			return false;
		}
		$('#stForm').submit();
	});
});
</script>
</head>
<body>

<header id="menu" class="flip">
	<div id="menu-background" style="top: 0px;"></div>
	<div class="nav-wrapper">
		<div class="container" role="navigation">
			<a class="brand" alt="Placemeter Logo" href="/">
				<span class="logo">beexbee</span>
			</a>
			<c:import url="nav.jsp"/>
			<nav class="secondary-nav">
			<a class="demo btn btn-primary" track-link-placement="Site header" track-link=""Create Account" CTA clicked" href="<%=path%>/index.html">返回首页</a>
			</nav>
		</div>
	</div>
</header>
<div style="margin-left: auto;margin-right: auto;top: 100px;width: 100%;margin-top: 100px;">
	<form id="stForm" action="addDishes.html" method="post">
	<div style="width: 300px;float: left;margin-left: 40px;">
		<div class="ic-title">菜品管理</div>
		<P class="ic-font">菜名：</P> 
		<input placeholder="" id="name" name="name" class="form-control input-lg ic-input" type="text">
		<P class="ic-font">编号：</P> 
		<input placeholder="" id="code" name="code" class="form-control input-lg ic-input" type="text">
		<P class="ic-font">单价：</P> 
		<input placeholder="" id="price" name="price" class="form-control input-lg ic-input" type="text">
		<P class="ic-font">卡路里：</P> 
		<input placeholder="" id="calorie" name="calorie" class="form-control input-lg ic-input" type="text">
		<button id="subm" type="button" class="btn btn-success ic-button">添  加</button> 
	</div>
	</form>
	<div style="width: 1400px;float: left;margin-left: 40px;">
		<div class="table-container">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>菜名</th>
							<th>编号</th>
							<th>单价</th>
							<th>卡路里</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dishes" items="${dishesList}" varStatus="stat">
							<tr>
								<td>${dishes.name}</td>
								<td>${dishes.code}</td>
								<td>${dishes.price}</td>
								<td>${dishes.calorie}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	</div>
</div>

<div class="col-sm-6" style="margin-top: 20px;padding-left: 5px;">
	
</div>
</body>
</html>