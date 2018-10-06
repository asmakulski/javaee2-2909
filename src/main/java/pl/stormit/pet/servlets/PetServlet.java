package pl.stormit.pet.servlets;

import pl.stormit.pet.model.Pet;
import pl.stormit.pet.model.PetType;
import pl.stormit.pet.repository.PetRepository;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/pets")
public class PetServlet extends HttpServlet {

	private PetRepository petRepository;

	@Inject
	public PetServlet(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		writer.println("Pets");

		List<Pet> pets = petRepository.getPets();
		for(Pet pet : pets){
			writer.println(pet);
		}

//		petRepository.getPets().forEach(writer::println);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		PetType type = PetType.valueOf(req.getParameter("type"));

		Pet pet = new Pet(name, age, type);
		petRepository.add(pet);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		PetType type = PetType.valueOf(req.getParameter("type"));

		Pet pet = new Pet(name, age, type);
		petRepository.update(pet);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getMethod();
//		System.out.println(method);
		if("PATCH".equalsIgnoreCase(method)){
			doPatch(req, resp);
		} else {
			super.service(req, resp);
		}
	}

	private void doPatch(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		Integer age = Integer.valueOf(req.getParameter("age"));
		Pet pet = petRepository.getPet(name);

		if(age!=null){
			pet.setAge(age);
		}

		petRepository.update(pet);
	}
}
