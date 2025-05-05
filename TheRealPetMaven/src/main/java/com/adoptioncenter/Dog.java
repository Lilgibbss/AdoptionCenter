package com.adoptioncenter;

/**
 * Represents a Dog in the adoption center.
 * Extends the abstract {@link Pet} class and sets the type to "Dog".
 */
public class Dog extends Pet {

    /**
     * Constructs a Dog with the specified attributes.
     *
     * @param id       Unique identifier for the dog
     * @param name     Name of the dog
     * @param age      Age of the dog in years
     * @param species  Breed or species of the dog (e.g., Labrador, Bulldog)
     */
    public Dog(int id, String name, int age, String species) {
        super(name, age, species, id, "Dog");
    }

    /**
     * Default constructor for Dog.
     * Sets the type to "Dog". Typically used for deserialization or manual setup.
     */
    public Dog() {
        super();
        setType("Dog");
    }
}

