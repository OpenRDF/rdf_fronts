<%@ page language="java" import="java.util.*, org.jasig.cas.client.authentication.AttributePrincipal" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="./js/jquery/jquery.js"></script>
</head>

<body class="user-style ms-windows">
	<!-- body -->
	<div class="profile">
		<!-- topbar -->
		<jsp:include page="pagepart/search_result_top.jsp" />
		<!-- container -->
		<div id="container">
			<div id="container-inner-result">
				<div style="width: 620px;">
					<s:if test='%{resultMessage eq "success" }'>
						<div style="margin: 10px 40px;">
							<c:forEach items="${conceptList }" var="concept">
								<p>
									<span style="float: left; width: auto;">词条：${concept.cnName }</span> <span style="width: 20px; float: left; font-style: italic;">&nbsp;</span> <span
										style="font-style: italic; width: auto; float: left; margin-right: 100px;"> <a class="store" href='javascript:sotre("${concept.enName }");' style="display: block; width: auto;">(收藏该词条)</a></span>
								</p>
								<p>英文名称：${concept.enName }</p>
								<p>词条概念/定义：</p>
								<p>${concept.source }</p>
								<p>创建时间：${concept.bday }</p>
								<hr>
							</c:forEach>
							<p style="font-size: 14px; color: red">注意：以上结果仅供参考。</p>
						</div>
					</s:if>
					<s:else>
						<div style="height: 150px; text-align: center; margin-top: 20px;">${resultMessage }</div>
					</s:else>



				</div>





			</div>
		</div>
		<!-- bottom -->
		<jsp:include page="pagepart/bottom.jsp"></jsp:include>
	</div>
</body>
</html>
<script type="text/javascript">
	function sotre(keyword){
		$.ajax({
		    type: 'get',
		    url: "storeAction?keyword=" + keyword ,
		    data:{}, 
		    success: function(date){alert(date);},
		    error: function(){alert("ajax 失败!");}
		});
  }
</script>