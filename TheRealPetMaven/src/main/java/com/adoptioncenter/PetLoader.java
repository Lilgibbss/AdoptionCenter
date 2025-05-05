package com.adoptioncenter;

import com.adoptioncenter.Dog;
import com.adoptioncenter.Cat;
import com.adoptioncenter.Rabbit;
import com.google.gson.*;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class responsible for loading pet data from a JSON file.
 * Supports loading dogs, cats, and rabbits defined in "pets.json" from resources.
 */
public class PetLoader {

    /**
     * Loads a list of pets from the "pets.json" file located in the src/main/resources directory.
     * Parses the JSON array and constructs appropriate Pet objects (Dog, Cat, Rabbit).
     * Skips entries with unrecognized types.
     *
     * @return A list of Pet objects parsed from the JSON file
     */
    public static List<Pet> loadPets() {
        List<Pet> pets = new ArrayList<>();

        try (InputStream is = PetLoader.class.getResourceAsStream("/pets.json");
             InputStreamReader reader = new InputStreamReader(is)) {

            JsonElement root = JsonParser.parseReader(reader);
            JsonArray jsonArray = root.getAsJsonArray();
            Gson gson = new Gson();

            for (JsonElement elem : jsonArray) {
                JsonObject obj = elem.getAsJsonObject();
                int id = obj.get("id").getAsInt();
                String name = obj.get("name").getAsString();
                String type = obj.get("type").getAsString();
                String species = obj.get("species").getAsString();
                int age = obj.get("age").getAsInt();
                boolean adopted = obj.get("adopted").getAsBoolean();

                Pet pet;

                switch (type) {
                    case "Dog":
                        pet = new Dog(id, name, age, species);
                        break;
                    case "Cat":
                        pet = new Cat(id, name, age, species);
                        break;
                    case "Rabbit":
                        pet = new Rabbit(id, name, age, species);
                        break;
                    default:
                        continue; // skip unknown types
                }

                if (adopted) {
                    pet.adopt();
                }

                pets.add(pet);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider logging this instead in production
        }

        return pets;
    }
}
