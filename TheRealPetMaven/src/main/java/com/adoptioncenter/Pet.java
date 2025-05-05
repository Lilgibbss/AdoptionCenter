package com.adoptioncenter;

/**
 * Abstract base class representing a generic Pet.
 * Includes common attributes such as id, name, species, type, age, and adoption status.
 * Implements Comparable to allow sorting by name.
 */
public abstract class Pet implements Comparable<Pet> {
    private int id;
    private String name;
    private String species;
    private int age;
    private String type;
    private Boolean adopted;

    /**
     * Constructs a Pet with the specified details.
     *
     * @param name    The name of the pet
     * @param age     The age of the pet
     * @param species The species or breed of the pet
     * @param id      The unique identifier for the pet
     * @param type    The general type of the pet (e.g., Dog, Cat)
     */
    public Pet(String name, int age, String species, int id, String type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.species = species;
        this.adopted = false;
        this.type = type;
    }

    /**
     * Default constructor for Pet.
     * Used primarily by subclasses or deserialization tools like Gson.
     */
    public Pet() {
    }

    /**
     * Gets the unique identifier of the pet.
     *
     * @return The pet's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the pet.
     *
     * @return The pet's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the species or breed of the pet.
     *
     * @return The pet's species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the age of the pet.
     *
     * @return The pet's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the type of the pet (e.g., Dog, Cat).
     *
     * @return The pet's type
     */
    public String getType() {
        return type;
    }

    /**
     * Checks whether the pet has been adopted.
     *
     * @return true if adopted, false otherwise
     */
    public Boolean isAdopted() {
        return adopted;
    }

    /**
     * Sets the pet's ID.
     *
     * @param id The ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the pet's name.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the pet's species.
     *
     * @param species The species to set
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets the pet's age.
     *
     * @param age The age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the pet's type.
     *
     * @param type The type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the adoption status of the pet.
     *
     * @param adopted true if adopted, false otherwise
     */
    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    /**
     * Marks the pet as adopted.
     */
    public void adopt() {
        this.adopted = true;
    }

    /**
     * Compares this pet to another pet by name (case-insensitive).
     *
     * @param other The other pet to compare to
     * @return A negative, zero, or positive integer as this name is less than, equal to,
     *         or greater than the other name
     */
    @Override
    public int compareTo(Pet other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
