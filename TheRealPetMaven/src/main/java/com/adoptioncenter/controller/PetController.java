package com.adoptioncenter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import com.adoptioncenter.ExoticAnimal;
import com.adoptioncenter.ExoticPetAdapter;
import com.adoptioncenter.Pet;
import com.adoptioncenter.Shelter;
import com.adoptioncenter.view.PetView;
import com.adoptioncenter.PetAgeComparator;
import com.adoptioncenter.PetSpeciesComparator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
    				String name = JOptionPane.showInputDialog(view, "Enter pet name: ");
    				if(name == null || name.trim().isEmpty()) {
    					JOptionPane.showMessageDialog(view, "Name Cannont be empty.");
    					break;
    				}
    				
    				String ageStr = JOptionPane.showInputDialog(view, "Enter Pet age: ");
    				int age;
    				try {
    					age = Integer.parseInt(ageStr);
    				} catch (NumberFormatException ex) {
    					JOptionPane.showMessageDialog(view, "Invalid age.");
    					break;
    				}
    				
    				String[] options = {"Dog", "Cat", "Rabbit", "Exotic"};
    				String species = (String) JOptionPane.showInputDialog(view, "Select species:", "Species", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    				
    				if(species == null) {
    					break;
    				}
    				
    				Pet newPet;
    				switch(species) {
    					case "Dog":
    						newPet = new Dog(name, age, species);
    						break;
    					case "Cat":
    						newPet = new Cat(name, age, species);
    						break;
    					case "Rabbit":
    						newPet = new Rabbit(name, age, species);
    						break;
    					case "Exotic":
    						ExoticAnimal exoticanimal = new ExoticAnimal(name, age, species);
    						newPet = new ExoticPetAdapter(exoticanimal);
    						break;
    					default:
    						JOptionPane.showMessageDialog(view, "Unknown species.");
    						return;
    						
    				}
    				
    				shelter.addPet(newPet);
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
    				if(selectedPet != null) {
    					StringBuilder details = new StringBuilder();
    					String adoptedStatus;
    					if(selectedPet.isAdopted()) {
    						adoptedStatus = "Yes";
    					} else {
    						adoptedStatus = "No";
    					}
    					
    					details.append("Name: ").append(selectedPet.getName()).append("\n");
    					details.append("Age: ").append(selectedPet.getAge()).append("\n");
    					details.append("Spcies: ").append(selectedPet.getSpecies()).append("\n");
    					details.append("Adopted: ").append(adoptedStatus);
    				}
    				break;
    			case "Save":
    				Gson gson = new GsonBuilder().setPrettyPrinting().create();
    				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    				String filename = timestamp + "_pets.json";
    				
    				try(FileWriter writer = new FileWriter(filename)){
    					gson.toJson(shelter.getPets(), writer);
    					JOptionPane.showMessageDialog(view, "Saved at " + filename);
    				} catch (IOException ex) {
    					JOptionPane.showMessageDialog(view, "Error saving: " + ex.getMessage());
    				}
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
