package by.testing.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import by.testing.constants.*;

/**
 * Servlet Filter implementation class XssFilter
 */
@WebFilter("/XssFilter")
public class XssFilter implements Filter {

	ServletContext context;
    /**
     * Default constructor. 
     */
    public XssFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Xss filter working");
		context.log("Xss filter: working");
		Map<String, String[]> parameters = request.getParameterMap();
		Enumeration<String> parametersNames = request.getParameterNames();
		while (parametersNames.hasMoreElements())
		{
			String key = parametersNames.nextElement();
			String content = parameters.get(key)[0];
			context.log(content);
			if (content.matches(".*[%<>].*"))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(PageConstants.ERROR_PAGE);
				dispatcher.forward(request, response);
				System.out.println("Xss attack was prevented");
				context.log("Xss attcl was prvented");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
	}

}
