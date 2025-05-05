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
		super(exoticAnimal.getAnimalName(),exoticAnimal.getYearsOld(),exoticAnimal.getSubSpecies(),0,"Exotic");		
		this.exoticAnimal = exoticAnimal;
	}
	
	/**
	 * returns the adoption status of exotic animal
	 * 
	 * @return true is animal is adopted
	 */
	@Override
	public Boolean isAdopted() {
		return !exoticAnimal.isAvailable();
	}
	
	/**
	 * marks animal as adopted
	 */
	
	@Override
	public void adopt(){
		exoticAnimal.isAvailable();
		this.setAdopted(true);
		
	}
	
	public ExoticAnimal getExoticAnimal() {
		return exoticAnimal;
	}
}
