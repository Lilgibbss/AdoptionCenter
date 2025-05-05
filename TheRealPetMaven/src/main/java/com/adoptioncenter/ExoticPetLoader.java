package com.adoptioncenter;

import com.google.gson.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExoticPetLoader {
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
            e.printStackTrace();
        }

        return pets;
    }
}
