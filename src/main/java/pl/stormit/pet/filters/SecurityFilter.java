package pl.stormit.pet.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/pets")
public class SecurityFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

		// if zalogowany
		HttpSession session = req.getSession();
		Object logged = req.getSession().getAttribute("logged");
		if (logged != null && (Boolean) logged) {
			// then wyświetl stronę
			chain.doFilter(req, res);
		} else {
			// else wyświetl błąd
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}

	}
}
