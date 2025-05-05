package com.adoptioncenter;

import java.util.Comparator;

/**
 * Class to compare pet names
 * allows for sorting by name
 */
public class PetNameComparator implements Comparator<Pet> {
   /**
    * @param p1 animal to compare
    * @param p2 animal to compare to p1
    * 
    * @return a number to indicate p1 is great or less or == p2
    */
	@Override
    public int compare(Pet p1, Pet p2) {
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}
