package com.adoptioncenter;

public abstract class Pet implements Comparable<Pet> {
    private String name;
    private String species;
    private int age;
    private Boolean adopted;
    

    public Pet(String name, int age, String species) {
    	this.name = name;
    	this.age = age;
    	this.species = species;
    	this.adopted = false;
    }


	public String getName() {
		return name;
	}


	public String getSpecies() {
		return species;
	}


	public int getAge() {
		return age;
	}


	public boolean isAdopted() {
		return adopted;
	}
	
	public void adopt() {
		adopted = true;
	}
	
	@Override
	public int compareTo(Pet other) {
		return this.name.compareToIgnoreCase(other.name);
	}

}