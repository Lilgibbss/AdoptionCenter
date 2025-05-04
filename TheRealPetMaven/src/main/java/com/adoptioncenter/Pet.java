package com.adoptioncenter;

public class Pet {
	private String ID;
    private String name;
    private String species;
    private String subspecies;
    private int age;
    private Boolean adopted;
    

    // Constructors, Getters, Setters
    // Default constructor (for Gson)
    public Pet() {}

    // Full constructor
    public Pet(String ID, String name, String species, String subspecies, int age, Boolean adopted) {
        this.ID = ID;
        this.name = name;
        this.species = species;
        this.subspecies = subspecies;
        this.age = age;
        this.adopted = adopted;
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getAdopted() {
        return adopted;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    @Override
    public String toString() {
        return name + " (" + species + ", " + age + " yrs)";
    }
}