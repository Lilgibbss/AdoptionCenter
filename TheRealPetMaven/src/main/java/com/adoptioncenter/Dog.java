package com.adoptioncenter;

public class Dog extends Pet {
	public Dog(int id, String name, int age, String species) {
		super(name, age, species, id, "Dog");
	}
	public Dog() {
		super();
		setType("Dog");
	}

}
