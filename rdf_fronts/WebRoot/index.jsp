<%@ page language="java" import="java.util.*, org.jasig.cas.client.authentication.AttributePrincipal" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<title>知识库系统 -- 首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css" rel="stylesheet" href="./css/main.css" media="screen" charset="utf-8">
</head>

<body class="user-style ms-windows">
	<!-- body -->
	<div class="profile">
		<!-- topbar -->
		<jsp:include page="pagepart/top.jsp" />
		<!-- container -->
		<div id="container">
			<div id="container-inner">
				<div class="container-logo"></div>


				<div class="search-div">
					<form action="search" method="get">
						<input type="text" name="keywords" id="keyword" maxlength="100" style="width:474px; height:32px;" autocomplete="off">
						<input type="submit" value="搜索" id="search-button" class="btn">
					</form>
				</div>





			</div>
		</div>
		<!-- bottom -->
		<jsp:include page="pagepart/bottom.jsp"></jsp:include>
	</div>
</body>
</html>
