package com.openrdf.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;

import com.openrdf.utils.properties.URLPropertiesUtils;

public class CasInfo2Session implements Filter {

	private String enCoding;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request2, ServletResponse response2,
			FilterChain filterChain) throws IOException, ServletException {
		// 参数转换，因为我们已经它肯定是Http协议的请求。
		HttpServletRequest request = (HttpServletRequest) request2;
		HttpServletResponse response = (HttpServletResponse) response2;
		// 设置request和response使用的编码均为UTF-8。
		request.setCharacterEncoding(enCoding);
		response.setCharacterEncoding(enCoding);
		response.setContentType("text/html;charset=UTF-8");
		// 获取session
		HttpSession session = request.getSession();
		// 当获取不到项目信息时，初始化session中的项目信息
		if (session.getAttribute("RDF_BACKEND_HREF") == null
				|| session.getAttribute("RDF_FRONTS_HREF") == null
				|| session.getAttribute("RDF_CAS_HREF") == null) {
			session.setAttribute("RDF_BACKEND_HREF", URLPropertiesUtils
					.getPropertiesUrl(URLPropertiesUtils.RDF_BACKEND_HREF));
			session.setAttribute("RDF_FRONTS_HREF", URLPropertiesUtils
					.getPropertiesUrl(URLPropertiesUtils.RDF_FRONTS_HREF));
			session.setAttribute("RDF_CAS_HREF", URLPropertiesUtils
					.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF));
		}

		// 当获取不到用户名等信息时，初始化session中的用户信息
		AttributePrincipal principal = (AttributePrincipal) request
				.getUserPrincipal();
		if (principal != null) {
			if (session.getAttribute("emailAuthentication") == null
					|| session.getAttribute("userId") == null
					|| session.getAttribute("userName") == null
					|| session.getAttribute("userEmail") == null
					|| session.getAttribute("userQQ") == null) {
				// 获取值CAS中的值
				Map<String, Object> attributes = principal.getAttributes();
				String userId = (String) attributes.get("userId");
				String userName = (String) attributes.get("userName");
				String userEmail = (String) attributes.get("userEmail");
				String userQQ = (String) attributes.get("userQQ");
				String emailAuthentication = (String) attributes
						.get("emailAuthentication");

				session.setAttribute("userId", userId);
				session.setAttribute("userName", userName);
				session.setAttribute("userEmail", userEmail);
				session.setAttribute("userQQ", userQQ);
				session.setAttribute("emailAuthentication", emailAuthentication);
			}
		}
		// 设置完成后，交回给服务器。
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fileConfig) throws ServletException {
		enCoding = fileConfig.getInitParameter("enCoding");
	}

}
