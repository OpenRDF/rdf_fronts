<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- topbar -->
<div id="topbar">
	<div id="global-top">
		<div class="global-top-middle">
			<div class="global-top-middle-left">
				<ul class="topbar-left">
					<li class="local-search"><a href="<%=basePath%>home">搜本站</a></li>
					<i></i>
					<li class="advance-search"><a href="<%=basePath%>dbpedia">高级搜索</a></li>
				</ul>
			</div>
			<div class="global-top-middle-right">
				<ul class="topbar-right">
					<li class="login"><a href='<s:property value="rdf_cas_href"/>/login?service=<%=java.net.URLEncoder.encode(basePath)%>home'>登录</a></li>
					<i></i>
					<li class="register"><a href="register">注册</a></li>
					<i></i>
					<li class="find-password"><a href="findpassword.html">找回密码?</a></li>
				</ul>
			</div>
		</div>
		<div class="search-div-result">
			<div class="search-div-result-logo"></div>
			<div class="search-div-result-input">
				<form action="advance" method="get">
					<input type="text" name="keywords" value="${keywords }" id="keyword" maxlength="100" style="width:474px; height:32px;" autocomplete="off"> <input type="submit" value="搜索" id="search-button" class="btn">
				</form>
			</div>
		</div>
	</div>
</div>
