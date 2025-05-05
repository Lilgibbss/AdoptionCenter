package com.adoptioncenter;

/**
 * Adapter class that allowed ExoticAnimal to be used as Pet
 */

public class ExoticPetAdapter extends Pet {
	private ExoticAnimal exoticAnimal;
	
	/**
	 * Creates the adapter wrapping the given ExoticAnimal
	 * @param exoticAnimal the animal to adapt/wrap
	 */
	public ExoticPetAdapter(ExoticAnimal exoticAnimal) {
		super(exoticAnimal.getName(), exoticAnimal.getAge(), exoticAnimal.getType());
		this.exoticAnimal = exoticAnimal;
	}
	
	/**
	 * returns the adoption status of exotic animal
	 * 
	 * @return true is animal is adopted
	 */
	@Override
	public boolean isAdopted() {
		return !exoticAnimal.isAvalible();
	}
	
	/**
	 * marks animal as adopted
	 */
	
	@Override
	public void adopt() {
		exoticAnimal.adopted();
	}
}
