package pl.stormit.pet.services;

import pl.stormit.pet.model.User;

import javax.ejb.Local;
import java.util.Optional;

@Local
public interface UsersServiceLocal {

	Optional<User> findBy(String username, String password);
}
