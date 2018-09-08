package cn.wzb.ssm.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CORSFilter
 */
@WebFilter("/*")
public class CORSFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CORSFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
     HttpServletRequest request=(HttpServletRequest)req;
     HttpServletResponse response=(HttpServletResponse)resp;
     response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
	 response.setHeader("Access-Control-Allow-Credentials", "true");
	 response.setHeader("Access-Control-Allow-Headers", 
			 "Accept,Accept-Encoding,Accept-Language,Connection,Content-Length,Content-Type, Cookie,Host,Origin,Referer,User-Agent, Authorization,X-Requested-With,OsType");
	 response.setHeader("Access-Control-Allow-Methods", "POST,GET, HEAD,PUT, DELETE, TRACE, OPTIONS");
    if("OPTIONS".equalsIgnoreCase(request.getMethod())){
    	response.getOutputStream().close();
    }else{
		chain.doFilter(req, resp);
		}
  //  System.out.println("filter");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
