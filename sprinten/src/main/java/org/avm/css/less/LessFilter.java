package org.avm.css.less;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 *
 * @author Vlad Mihnea
 */
public class LessFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(LessFilter.class);

	private ServletContext servletContext;
	private String servletName;

	public void destroy() {
		// Do nothing
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		LOGGER.debug("[doFilter()]");
		if (servletRequest instanceof HttpServletRequest) {
			RequestDispatcher namedDispatcher = servletContext.getNamedDispatcher(servletName);
			namedDispatcher.forward(servletRequest, servletResponse);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.debug("[init()]");
		this.servletContext = filterConfig.getServletContext();
		this.servletName = filterConfig.getInitParameter("servletName");
		LOGGER.info("[init()][servletName=" + servletName + "]");
	}

}
