package com.adoptioncenter;

import java.util.ArrayList;
import java.util.List;

public class Shelter<T extends Pet> {
	private List<T> pets;
	
	public Shelter() {
		this.pets = new ArrayList<>();
	}
	
	public void addPet(T pet) {
		pets.add(pet);
	}
	
	public void removePet(T pet) {
		pets.remove(pet);
	}
	
	public List<T> getPets(){
		return pets;
	}
	
	public T getPetByName(String name) {
		for(T pet : pets) {
			if(pet.getName().equalsIgnoreCase(name)) {
				return pet;
			}
		}
		return null;
	}
	
	public void clearAll() {
		pets.clear();
	}
}

