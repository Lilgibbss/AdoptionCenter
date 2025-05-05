package com.adoptioncenter;

public abstract class Pet implements Comparable<Pet> {
    private int id;
	private String name;
    private String species;
    private int age;
    private String type;
    private Boolean adopted;
    

    public Pet(String name, int age, String species, int id, String type) {
    	this.id = id;
    	this.name = name;
    	this.age = age;
    	this.species = species;
    	this.adopted = false;
    	this.type = type;
    }

    public Pet() {} 


	
	public int getId() {
		return id;
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

	public String getType() {
		return type;
	}

	public Boolean isAdopted() {
		return adopted;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAdopted(Boolean adopted) {
		this.adopted = adopted;
	}
	
	public void adopt() {
		this.adopted = true;
	}

	@Override
	public int compareTo(Pet other) {
		return this.name.compareToIgnoreCase(other.name);
	}

}