package pl.stormit.pet.model;

import pl.stormit.pet.model.PetType;

public class Pet {
	private String name;
	private int age;
	private PetType type;

	public Pet() {
	}

	public Pet(String name, int age, PetType type) {
		this();
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public PetType getType() {
		return type;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pet{" +
				"name='" + name + '\'' +
				", age=" + age +
				", type=" + type +
				'}';
	}
}
