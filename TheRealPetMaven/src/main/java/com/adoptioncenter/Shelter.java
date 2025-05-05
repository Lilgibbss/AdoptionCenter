package com.adoptioncenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Shelter class that holds a collection of pets available for adoption.
 * 
 * @param <T> A type that extends the Pet class
 */
public class Shelter<T extends Pet> {
    private List<T> pets;

    /**
     * Constructs an empty Shelter.
     */
    public Shelter() {
        this.pets = new ArrayList<>();
    }

    /**
     * Adds a pet to the shelter.
     * 
     * @param pet The pet to be added
     */
    public void addPet(T pet) {
        pets.add(pet);
    }

    /**
     * Removes a pet from the shelter.
     * 
     * @param pet The pet to be removed
     */
    public void removePet(T pet) {
        pets.remove(pet);
    }

    /**
     * Returns a list of all pets in the shelter.
     * 
     * @return List of pets
     */
    public List<T> getPets() {
        return pets;
    }

    /**
     * Retrieves a pet by its name (case-insensitive).
     * 
     * @param name The name of the pet
     * @return The pet with the given name, or null if not found
     */
    public T getPetByName(String name) {
        for (T pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return pet;
            }
        }
        return null;
    }

    /**
     * Removes all pets from the shelter.
     */
    public void clearAll() {
        pets.clear();
    }
}

