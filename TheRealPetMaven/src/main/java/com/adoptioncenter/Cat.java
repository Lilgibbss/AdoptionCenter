package com.adoptioncenter;

public class Cat extends Pet {
	public Cat(int id, String name, int age, String species) {
		super(name, age, species, id, "Cat");
	}
	public Cat() {
		super();
		setType("Cat");
	}

}

