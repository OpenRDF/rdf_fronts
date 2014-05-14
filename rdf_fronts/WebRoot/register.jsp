<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册 -- 知识库系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
<link rel="stylesheet" type="text/css" href="css/register.css">
<link type="text/css" rel="stylesheet" href="./css/main.css" media="screen" charset="utf-8">
</head>

<body class="user-style ms-windows">
	<!-- body -->
	<jsp:include page="pagepart/head_register.jsp"></jsp:include>
	<!-- nav -->
	<div id="nav">
		<div class="nav-2">
			<div class="mod-nav clearfix">
				<h1 class="page-type-notab"></h1>
			</div>
		</div>
	</div>
	<div id="content">
		<div id="content-inner">
			<div id="reg_content">
				<form action="users/register" autocomplete="off" id="reg-form" method="POST">
					<p id="errorWrapper">
						<span id="error" class="pass-generalError"></span>
					</p>
					<p id="account" class="pass-form-item" style="display:">
						<label id="accountLabel" class="pass-label pass-label-account">注册邮箱</label> 
						<s:textfield id="userLoginEmail" type="text" name="userLogin.userLoginEmail" cssClass="pass-text-input pass-text-input-account"
							autocomplete="off" placeholder="邮箱"> </s:textfield>
							<span id="account_clearbtn" class="pass-clearbtn pass-clearbtn-account" style="display:none;"></span> 
							<span id="accountError"
							class="pass-item-error pass-item-error-account" style="display: none;"></span> 
							<span id="accountSucc" class="pass-item-succ pass-item-succ-account" style="display: none;"></span>
					</p>
					<p id="password" class="pass-form-item pass-form-item-password" style="display:">
						<label class="pass-label pass-label-password">密码</label> 
						<s:textfield id="password" type="password" name="userLogin.password" cssClass="pass-text-input pass-text-input-password" autocomplete="off"
							placeholder="密码"> </s:textfield>
							<span id="password_clearbtn" class="pass-clearbtn pass-clearbtn-password" style="display:none;"></span> 
							<span id="passwordError"
							class="pass-item-error pass-item-error-password" style="display: none;"></span> 
							<span class="pwd-strength-detail" style="display: none;">请输入密码</span> 
							<span id="passwordSucc" class="pass-item-succ pass-item-succ-password" style="display:none;"></span>
					<div class="pwd-checklist-wrapper">
						<ul id="pwdChecklist" class="pwd-checklist">
							<li id="pwd_checklist_len" data-rule="len" class="pwd-checklist-item" style="display:none;">长度为6~14个字符</li>
							<li id="pwd_checklist_cha" data-rule="cha" class="pwd-checklist-item" style="display:none;">支持数字,大小写字母和标点符号</li>
							<li id="pwd_checklist_spa" data-rule="spa" class="pwd-checklist-item" style="display:none;">不允许有空格</li>
						</ul>
					</div>
					</p>
					<p id="password" class="pass-form-item pass-form-item-password" style="display:">
						<label class="pass-label pass-label-password">再次输入密码</label> 
						<s:textfield id="re_password" type="password" name="re_password" cssClass="pass-text-input pass-text-input-password"
							autocomplete="off" placeholder="重复密码"> </s:textfield>
							<span id="password_clearbtn" class="pass-clearbtn pass-clearbtn-password" style="display:none;"></span> 
							<span id="passwordError" class="pass-item-error pass-item-error-password" style="display: none;"></span> 
							<span class="pwd-strength-detail" style="display: none;">再次输入密码</span> 
							<span id="passwordSucc" class="pass-item-succ pass-item-succ-password" style="display:none;"></span>
					<div class="pwd-checklist-wrapper">
						<ul id="pwdChecklist" class="pwd-checklist">
							<li id="pwd_checklist_len" data-rule="len" class="pwd-checklist-item" style="display:none;">长度为6~14个字符</li>
							<li id="pwd_checklist_cha" data-rule="cha" class="pwd-checklist-item" style="display:none;">支持数字,大小写字母和标点符号</li>
							<li id="pwd_checklist_spa" data-rule="spa" class="pwd-checklist-item" style="display:none;">不允许有空格</li>
						</ul>
					</div>
					</p>
					<p id="isAgreeWrapper" class="pass-form-item pass-form-item-isAgree">
						<input name="isAgree" id="isAgree" type="checkbox" checked="checked" class="pass-checkbox-input pass-checkbox-isAgree" autocomplete="off"> <label style="float: left;">我已阅读并接受</label> <a
							target="_blank" href="http://***/protocal.html" style="float: left;">《知识库系统使用协议》</a>
					</p>
					<p id="submitWrapper" class="pass-form-item pass-form-item-submit">
						<input id="reg_submit" type="submit" value="注册" class="pass-button pass-button-submit" onclick= "javascript:document.form.submit()">
					</p>
				</form>
			</div>
			<div id="reg_center"></div>
			<div id="reg_others">
				<span>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;欢迎注册知识库系统，本系统采用RDF来标记Web资源，通过SPASQL查询资源。</p>
					<p>
						&nbsp;&nbsp;&nbsp;&nbsp;本系统提供两种检索模式：<br />&nbsp;&nbsp;&nbsp;&nbsp;1）搜索本站资源。<br />&nbsp;&nbsp;&nbsp;&nbsp;2）通过高级搜索检索其他站资源。
					</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;声明：本系统所有资源均来自互联网。如有侵权，请联系作者邮箱：a.b@hotmail.com。</p>
				</span>
			</div>
		</div>
	</div>

	<!-- bottom -->
	<jsp:include page="pagepart/bottom.jsp"></jsp:include>
</body>
</html>
