package com.adoptioncenter;

public class Rabbit extends Pet {
	public Rabbit(int id, String name, int age, String species) {
		super(name, age, species, id, "Cat");
	}
	public Rabbit() {
		super();
		setType("Rabbit");
	}

}
