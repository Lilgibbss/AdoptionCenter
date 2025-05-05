package com.adoptioncenter.main;

import javax.swing.SwingUtilities;

import com.adoptioncenter.ExoticPetLoader;
import com.adoptioncenter.Pet;
import com.adoptioncenter.Shelter;
import com.adoptioncenter.controller.PetController;
import com.adoptioncenter.view.PetView;
import com.adoptioncenter.PetLoader;

import java.util.List;

public class Main {
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            Shelter<Pet> shelter = new Shelter<>();

	            // Load pets from JSON
	            List<Pet> loadedPets = PetLoader.loadPets();
	            loadedPets.forEach(shelter::addPet);

	            // Load exotic pets from JSON
	            List<Pet> loadedExotics = ExoticPetLoader.loadExotics();
	            loadedExotics.forEach(shelter::addPet);

	            PetView view = new PetView();
	            new PetController(shelter, view);
	            view.setVisible(true);
	        });
	    }

}
