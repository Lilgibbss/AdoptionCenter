package com.adoptioncenter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import com.adoptioncenter.Pet;
import com.adoptioncenter.Shelter;
import com.adoptioncenter.view.PetView;
import com.adoptioncenter.PetAgeComparator;
import com.adoptioncenter.PetSpeciesComparator;

public class PetController {
	private Shelter<Pet> shelter;
	private PetView view;
	
	private class ButtonHandler implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		String command = e.getActionCommand();
    		Pet selectedPet = view.getSelectedPet();
    		
    		switch (command) {
    			case "Add":
    				
    				break;
    			case "Adopt":
    				if(selectedPet != null && !selectedPet.isAdopted()) {
    					selectedPet.adopt();
    				}
    				break;
    			case "Remmove":
    				if(selectedPet != null) {
    					shelter.removePet(selectedPet);
    				}
    				break;
    			case "View Details":
    				//TODO
    				break;
    			case "Save":
    				//TODO
    				break;		
    		}
    		refreshView();
    	}
    }
	
	public PetController(Shelter<Pet> shelter, PetView view) {
		this.shelter = shelter;
		this.view = view;
		
		view.addButtonListener(new ButtonHandler());
		view.addSortListener(new SortHandler());
		
		refreshView();
	}
	
	private void refreshView() {
		view.updatePetList(shelter.getPets());
	}
	
	private class SortHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String sortType = view.getSelectedSort();
			List<Pet> pets = shelter.getPets();
			
			switch (sortType) {
				case "Age":
					Collections.sort(pets, new PetAgeComparator());
					break;
				case "Species":
					Collections.sort(pets, new PetSpeciesComparator());
					break;
				default:
					Collections.sort(pets);
			}
			refreshView();
		}
	}
}
