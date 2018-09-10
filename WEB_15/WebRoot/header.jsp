<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="zx.com.bean.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
		<c:if test="${empty user}">
			<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
		</c:if>
		<c:if test="${!empty user}">
			<li><a href="login.jsp">${user.username}</a></li>
			<li><a href="register.jsp">退出</a></li>
		</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="ProductListServlet">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
					<li><a href="#">电脑办公</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search" onkeyup="jier(this)" id="hehe">
					</div>
					<div style="position: absolute;height: 200px;z-index:1000;width: 179px;background: #fff" id="aa">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<script type="text/javascript">
					function jier(obj){
						var wudi=obj.value;
						$.ajax({
							url:"ProductHeadServlet",
							type:"POST",
							data:{"name":wudi},
							success:function(data){
								var content="";
								for(var i=0;i<data.length;i++){
									content+="<div>"+data[i]+"</div>";
								}
								$("#aa").html(content);
							},
							dataType:"json"
						});
					}
				</script>
			</div>
		</div>
	</nav>
</div>