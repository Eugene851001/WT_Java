package by.testing.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter(filterName = "Filter", urlPatterns = {"/*"})
public class Filter implements javax.servlet.Filter {

	private ServletContext context;
	
    /**
     * Default constructor. 
     */
    public Filter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		req.getParameter("command");
		if (req.getParameter("locale") == null)
		{
			req.setAttribute("locale", "en");
		}
		String command = req.getParameter("command");
		if (command != null)
		{
			context.log("Filter: " + command);
		}
		else
		{
			context.log("Filter: no command");
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
