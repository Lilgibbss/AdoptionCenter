package com.adoptioncenter;

import java.util.Comparator;

/**
 * Comparator for comparing two Pet objects based on their species.
 * This is used to sort pets alphabetically by species name (case-insensitive).
 */
public class PetSpeciesComparator implements Comparator<Pet> {

    /**
     * Compares two pets by their species in a case-insensitive manner.
     *
     * @param p1 The first pet to compare
     * @param p2 The second pet to compare
     * @return A negative integer, zero, or a positive integer as the first species
     *         is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Pet p1, Pet p2) {
        return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
    }
}
