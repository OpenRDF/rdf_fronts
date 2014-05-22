<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

		<div id="bottom">
			<div id="bottom-inner">
				<div class="global-bottom-left">
					<ul class="bottom-ul">
						<li class="bottom-li-title">关于RDF</li>
						<li class="bottom-li-sub"><a href="http://www.w3.org/TR/2014/NOTE-rdf11-primer-20140225/">RDF简介</a></li>
						<li class="bottom-li-sub"><a href="http://wiki.dbpedia.org/Lookup">dbpedia接口</a></li>
						<li class="bottom-li-sub"><a href="http://pro.europeana.eu/api%E2%80%8E">europeana API</a></li>
					</ul>
				</div>
				<div class="global-bottom-left">
					<ul class="bottom-ul">
						<li class="bottom-li-title">使用技术</li>
						<li class="bottom-li-sub"><a href="http://www.w3.org/standards/semanticweb/">SEMANTIC WEB</a></li>
						<li class="bottom-li-sub"><a href="http://www.w3.org/TR/rdf-sparql-query/">SparQL技术</a></li>
						<li class="bottom-li-sub"><a href="http://baike.baidu.com/subview/16184/5909255.htm#viewPageContent">SSH框架技术</a></li>
						<li class="bottom-li-sub"><a href="http://baike.baidu.com/view/584868.htm">DES加密技术</a></li>
						<li class="bottom-li-sub"><a href="http://baike.baidu.com/subview/18179/6392359.htm">CAS简介</a></li>
					</ul>
				</div>
				<div class="global-bottom-left">
					<ul class="bottom-ul">
						<li class="bottom-li-title">课程知识库系统</li>
						<li class="bottom-li-sub"><a href="<%=basePath%>home">首页</a></li>
						<li class="bottom-li-sub"><a href="<%=basePath%>register">注册</a></li>
						<li class="bottom-li-sub"><a href="${rdf_cas_href }/login?service=<%=java.net.URLEncoder.encode(basePath) %>home">登录</a></li>
						<li class="bottom-li-sub"><a href="<%=basePath%>protocal">使用协议</a></li>
					</ul>
				</div>
				<div class="global-bottom-left">
					<ul class="bottom-ul">
						<li class="bottom-li-title">本系统源码托管地址</li>
						<li class="bottom-li-sub"><a href="https://github.com/OpenRDF/rdf_fronts">前台源码</a></li>
						<li class="bottom-li-sub"><a href="https://github.com/OpenRDF/rdf_backend">后台源码</a></li>
						<li class="bottom-li-sub"><a href="https://github.com/OpenRDF/rdf_cas">中央认证系统</a></li>
					</ul>
				</div>
			</div>
			<div id="bottom-base">
				<div id="bottom-base-inner">
					<div class="copyright">
						<p>
							<a href="#" style="margin-left:420px;">关于本站</a> <a href="#">法律声明</a>
							<a href="#">友情链接</a>
						</p>
						<p class="big">© 2014 www.166801.com 版权所有</p>
		
					</div>
				</div>
			</div>
		</div>
