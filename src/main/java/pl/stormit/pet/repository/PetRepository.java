package pl.stormit.pet.repository;

import pl.stormit.pet.model.Pet;
import pl.stormit.pet.model.PetType;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PetRepository {
	private List<Pet> pets;

	@PostConstruct
	public void init() {
		pets = new ArrayList<>();
		pets.add(new Pet("Garfield", 3, PetType.CAT));
		pets.add(new Pet("Scooby Doo", 12, PetType.DOG));
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void add(Pet pet) {
		pets.add(pet);
	}

	public void remove(final String name) {
		pets.removeIf(pet -> pet.getName().equals(name));
	}

	public void update(Pet pet) {
		for (Pet p : pets) {
			if (pet.getName().equals(p.getName())) {
				p.setAge(pet.getAge());
				p.setType(pet.getType());
			}
		}
	}

	public Pet getPet(String name) {
		return pets.stream().filter(p -> p.getName().equalsIgnoreCase(name))
				.findAny().get();
	}
}
