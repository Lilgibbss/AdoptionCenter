package com.adoptioncenter;

/**
 * Represents an exotic animal provided by a third-party system.
 * This class is not directly compatible with the main Pet class and requires adaptation.
 */
public class ExoticAnimal {
    private String uniqueId;       // Unique identifier for the exotic animal
    private String animalName;     // Name of the exotic animal
    private String category;       // Category (e.g., Bird, Reptile)
    private String subSpecies;     // Specific species or sub-type
    private int yearsOld;          // Age of the animal
    private boolean available;     // Availability status for adoption

    /**
     * Constructs a new ExoticAnimal with the given attributes.
     *
     * @param uniqueId   Unique identifier
     * @param animalName Name of the animal
     * @param category   Broad category (e.g., Mammal, Reptile)
     * @param subSpecies Specific species or type
     * @param yearsOld   Age in years
     */
    public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
        this.uniqueId = uniqueId;
        this.animalName = animalName;
        this.category = category;
        this.subSpecies = subSpecies;
        this.yearsOld = yearsOld;
        this.available = true;
    }

    /** @return the unique identifier of the exotic animal */
    public String getUniqueId() {
        return uniqueId;
    }

    /** @return the name of the animal */
    public String getAnimalName() {
        return animalName;
    }

    /** @return the broad category of the animal (e.g., Bird, Mammal) */
    public String getCategory() {
        return category;
    }

    /** @return the sub-species or specific type */
    public String getSubSpecies() {
        return subSpecies;
    }

    /** @return the age of the animal in years */
    public int getYearsOld() {
        return yearsOld;
    }

    /** @return true if the animal is available for adoption, false otherwise */
    public boolean isAvailable() {
        return available;
    }

    /** @param uniqueId sets the unique identifier */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /** @param animalName sets the name of the animal */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    /** @param category sets the broad category of the animal */
    public void setCategory(String category) {
        this.category = category;
    }

    /** @param subSpecies sets the specific species or type */
    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }

    /** @param yearsOld sets the age of the animal in years */
    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    /** @param available sets the adoption availability of the animal */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}

