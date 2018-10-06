package pl.stormit.pet.repository;

import pl.stormit.pet.model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserRepository {

	private List<User> users;

	@PostConstruct
	public void init(){
		users = new ArrayList<>();
		users.add(new User("root", "r"));
		users.add(new User("admin", "a"));
	}


	public Optional<User> findBy(String username, String password) {
		return users.stream().filter(u -> u.getName().equals(username)
				&& u.getPassword().equals(password)).findAny();
	}

	public List<User> findAll(){
		return users;
	}
}
