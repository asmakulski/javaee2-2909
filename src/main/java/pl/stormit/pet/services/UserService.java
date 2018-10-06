package pl.stormit.pet.services;

import pl.stormit.pet.model.User;
import pl.stormit.pet.repository.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserService implements UsersServiceLocal, UsersServiceRemote {

	private UserRepository userRepository;

	@Inject
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findBy(String username, String password) {
		return userRepository.findBy(username, password);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
