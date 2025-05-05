package com.adoptioncenter;

/**
 * Represents a Cat in the adoption center.
 * Inherits from the abstract {@link Pet} class and specifies the type as "Cat".
 */
public class Cat extends Pet {

    /**
     * Constructs a Cat with the specified attributes.
     *
     * @param id       Unique identifier for the cat
     * @param name     Name of the cat
     * @param age      Age of the cat in years
     * @param species  Breed or species of the cat (e.g., Siamese, Persian)
     */
    public Cat(int id, String name, int age, String species) {
        super(name, age, species, id, "Cat");
    }

    /**
     * Default constructor for Cat.
     * Sets the type to "Cat". Useful for deserialization or manual configuration.
     */
    public Cat() {
        super();
        setType("Cat");
    }
}


