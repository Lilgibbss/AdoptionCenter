package com.adoptioncenter;

public class ExoticAnimal {
    private String uniqueId;      
    private String animalName;    
    private String category;       
    private String subSpecies;    
    private int yearsOld;         
    private boolean available;

    public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
        this.uniqueId = uniqueId;
        this.animalName = animalName;
        this.category = category;
        this.subSpecies = subSpecies;
        this.yearsOld = yearsOld;
        this.available = true;
    }

	public String getUniqueId() {
		return uniqueId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public String getCategory() {
		return category;
	}

	public String getSubSpecies() {
		return subSpecies;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
    
}
