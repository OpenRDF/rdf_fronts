<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

	<div id="head">
		<div id="head-inner">
			<div class="head-inner-left">
				<ul>
					<li class="logo"><a href="$RDF_CAS_HREF"
						style="display: block; height: 50px; width: 200px; padding-top: 25px;">
							<img src="images/logo_reg.png" alt="logo" />
					</a></li>
					<i></i>
					<li class="info">注册账号</li>
				</ul>
			</div>
			<div class="head-inner-right">
				<span>我已注册，现在就</span>
				<button class="login-btn" id="login_btn">登录</button>
			</div>
		</div>
	</div>