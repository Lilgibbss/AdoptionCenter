package com.adoptioncenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class PetLoader {
    public static List<Pet> loadPets() {
        try (InputStream is = PetLoader.class.getResourceAsStream("/pets.json");
             InputStreamReader reader = new InputStreamReader(is)) {
             
            Type petListType = new TypeToken<List<Pet>>() {}.getType();
            return new Gson().fromJson(reader, petListType);
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}