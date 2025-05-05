package com.adoptioncenter.view;

import com.adoptioncenter.model.Pet;
import java.util.Comparator;

public class PetNameComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet p1, Pet p2) {
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}
