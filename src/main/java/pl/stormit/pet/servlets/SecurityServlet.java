package pl.stormit.pet.servlets;

import pl.stormit.pet.model.User;
import pl.stormit.pet.repository.UserRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class SecurityServlet extends HttpServlet {

	private UserRepository userRepository;

	@Inject
	public SecurityServlet(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Optional<User> user = userRepository.findBy(username, password);
		req.getSession(true).setAttribute("logged",
				user.isPresent());

		if(user.isPresent()){
			resp.sendRedirect("pets");

		} else {
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			resp.getWriter();
		}
	}
}
