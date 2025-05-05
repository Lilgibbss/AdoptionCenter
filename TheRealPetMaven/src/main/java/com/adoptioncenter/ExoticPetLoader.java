package com.adoptioncenter;

import com.google.gson.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class responsible for loading exotic pet data from a JSON file.
 * This class adapts third-party ExoticAnimal objects into the Pet system using ExoticPetAdapter.
 */
public class ExoticPetLoader {

    /**
     * Loads exotic pets from the "exotic_animals.json" file located in the src/main/resources directory.
     * Converts ExoticAnimal objects into Pet-compatible ExoticPetAdapter instances.
     *
     * @return A list of adapted exotic pets as Pet objects
     */
    public static List<Pet> loadExotics() {
        List<Pet> pets = new ArrayList<>();

        try (InputStream is = ExoticPetLoader.class.getResourceAsStream("/exotic_animals.json");
             InputStreamReader reader = new InputStreamReader(is)) {

            Gson gson = new Gson();
            ExoticAnimal[] exotics = gson.fromJson(reader, ExoticAnimal[].class);

            for (ExoticAnimal exotic : exotics) {
                pets.add(new ExoticPetAdapter(exotic));
            }

        } catch (Exception e) {
            e.printStackTrace(); // In a production system, consider proper logging
        }

        return pets;
    }
}
