package com.adoptioncenter.main;

import javax.swing.SwingUtilities;

import com.adoptioncenter.Pet;
import com.adoptioncenter.Shelter;
import com.adoptioncenter.controller.PetController;
import com.adoptioncenter.view.PetView;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Shelter<Pet> shelter = new Shelter<>();
			PetView view = new PetView();
			new PetController(shelter, view);
			view.setVisible(true);
		});
	}

}
