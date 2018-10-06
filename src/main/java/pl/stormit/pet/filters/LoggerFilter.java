package pl.stormit.pet.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = "/*")
public class LoggerFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println(req.getMethod()+", "+req.getRequestURI());

		System.out.println("Headers");
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			System.out.println(headerName +" => " + req.getHeader(headerName));
		}

		chain.doFilter(req, res);
	}
}
