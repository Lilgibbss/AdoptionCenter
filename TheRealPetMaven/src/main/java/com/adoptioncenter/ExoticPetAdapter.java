package com.adoptioncenter;

public class ExoticPetAdapter extends Pet {
	private ExoticAnimal exoticAnimal;
	
	public ExoticPetAdapter(ExoticAnimal exoticAnimal) {
		super(exoticAnimal.getName(), exoticAnimal.getAge(), exoticAnimal.getType());
		this.exoticAnimal = exoticAnimal;
	}
	
	@Override
	public boolean isAdopted() {
		return !exoticAnimal.isAvalible();
	}
	
	@Override
	public void adopt() {
		exoticAnimal.adopted();
	}
}
