package com.adoptioncenter;

/**
 * Represents a Rabbit pet in the adoption center.
 * Extends the Pet class with default species set to "Rabbit".
 */
public class Rabbit extends Pet {

    /**
     * Constructs a Rabbit with the given id, name, age, and species.
     * 
     * @param id      The unique identifier for the rabbit
     * @param name    The name of the rabbit
     * @param age     The age of the rabbit
     * @param species The breed or species detail of the rabbit
     */
    public Rabbit(int id, String name, int age, String species) {
        super(name, age, species, id, "Cat"); // Consider correcting the last argument if this is a typo
    }

    /**
     * Default constructor that initializes a Rabbit with type set to "Rabbit".
     */
    public Rabbit() {
        super();
        setType("Rabbit");
    }
}

