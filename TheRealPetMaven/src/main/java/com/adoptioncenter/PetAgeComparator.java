package com.adoptioncenter;

import java.util.Comparator;

/**
 * Comparator class to compare pets by age
 * allows sorting by age
 */
public class PetAgeComparator implements Comparator<Pet> {
	
	/**
	 * @param p1 first pet
	 * @param p2 second pet
	 * 
	 * @return a negative integer, zero, or a positive integer as the
     *         first Pet's age is less than, equal to, or greater than
     *         the second Pet's age
	 */
	@Override
	public int compare(Pet p1, Pet p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
}
