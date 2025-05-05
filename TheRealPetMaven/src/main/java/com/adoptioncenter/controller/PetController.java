package com.adoptioncenter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import com.adoptioncenter.Cat;
import com.adoptioncenter.Dog;
import com.adoptioncenter.ExoticAnimal;
import com.adoptioncenter.ExoticPetAdapter;
import com.adoptioncenter.Pet;
import com.adoptioncenter.Shelter;
import com.adoptioncenter.view.PetView;
import com.adoptioncenter.PetAgeComparator;
import com.adoptioncenter.PetSpeciesComparator;
import com.adoptioncenter.Rabbit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PetController {
    private Shelter<Pet> shelter;
    private PetView view;

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

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            Pet selectedPet = view.getSelectedPet();

            switch (command) {
                case "Add":
                    String name = JOptionPane.showInputDialog(view, "Enter pet name: ");
                    if (name == null || name.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(view, "Name cannot be empty.");
                        break;
                    }

                    String ageStr = JOptionPane.showInputDialog(view, "Enter pet age: ");
                    int age;
                    try {
                        age = Integer.parseInt(ageStr);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(view, "Invalid age.");
                        break;
                    }

                    String[] options = {"Dog", "Cat", "Rabbit", "Exotic"};
                    String type = (String) JOptionPane.showInputDialog(view, "Select species:", "Species",
                            JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                    if (type == null) break;

                    Pet newPet;
                    int id = 0; // Static for now
                    String species;

                    switch (type) {
                        case "Dog":
                            species = JOptionPane.showInputDialog(view, "Enter breed (species):");
                            if (species == null || species.trim().isEmpty()) species = "Unknown";
                            newPet = new Dog(id, name, age, species);
                            break;
                        case "Cat":
                            species = JOptionPane.showInputDialog(view, "Enter breed (species):");
                            if (species == null || species.trim().isEmpty()) species = "Unknown";
                            newPet = new Cat(id, name, age, species);
                            break;
                        case "Rabbit":
                            species = JOptionPane.showInputDialog(view, "Enter breed (species):");
                            if (species == null || species.trim().isEmpty()) species = "Unknown";
                            newPet = new Rabbit(id, name, age, species);
                            break;
                        case "Exotic":
                            String uniqueId = JOptionPane.showInputDialog(view, "Enter exotic ID:");
                            String category = JOptionPane.showInputDialog(view, "Enter category (e.g., Bird, Reptile):");
                            String subSpecies = JOptionPane.showInputDialog(view, "Enter sub-species:");
                            if (uniqueId == null) uniqueId = "unknown";
                            if (category == null) category = "unknown";
                            if (subSpecies == null) subSpecies = "unknown";
                            ExoticAnimal exoticAnimal = new ExoticAnimal(uniqueId, name, category, subSpecies, age);
                            newPet = new ExoticPetAdapter(exoticAnimal);
                            break;
                        default:
                            JOptionPane.showMessageDialog(view, "Unknown type.");
                            return;
                    }

                    shelter.addPet(newPet);
                    break;

                case "Adopt":
                    if (selectedPet != null && !selectedPet.isAdopted()) {
                        selectedPet.adopt();
                        JOptionPane.showMessageDialog(view, selectedPet.getName() + " has been adopted.");
                    } else if (selectedPet != null) {
                        JOptionPane.showMessageDialog(view, "This pet is already adopted.");
                    }
                    break;

                case "Remove":
                    if (selectedPet != null) {
                        shelter.removePet(selectedPet);
                        JOptionPane.showMessageDialog(view, selectedPet.getName() + " has been removed.");
                    }
                    break;

                case "View Details":
                    if (selectedPet != null) {
                        StringBuilder details = new StringBuilder();
                        String adoptedStatus = selectedPet.isAdopted() ? "Yes" : "No";

                        details.append("Name: ").append(selectedPet.getName()).append("\n");
                        details.append("Age: ").append(selectedPet.getAge()).append("\n");
                        details.append("Species: ").append(selectedPet.getSpecies()).append("\n");
                        details.append("Adopted: ").append(adoptedStatus);

                        JOptionPane.showMessageDialog(view, details.toString(), "Pet Details", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "Save":
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    String filename = timestamp + "_pets.json";

                    try (FileWriter writer = new FileWriter(filename)) {
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

    private class SortHandler implements ActionListener {
        @Override
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
                    Collections.sort(pets); // sort by name using Comparable
            }

            refreshView();
        }
    }
}


