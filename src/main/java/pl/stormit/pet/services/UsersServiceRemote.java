package pl.stormit.pet.services;

import pl.stormit.pet.model.User;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UsersServiceRemote {

	List<User> findAll();
}
