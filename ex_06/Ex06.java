// File: ex_06/Ex06.java
package ex_06;

import java.util.*;

public class Ex06 {
    public static void myCreateContinent(String continent, HashMap<String, HashMap<String, HashMap<String, String>>> worldMap) {
        worldMap.putIfAbsent(continent, new HashMap<>());
    }

    public static void myCreateCountry(String country, String continent, HashMap<String, HashMap<String, HashMap<String, String>>> worldMap) {
        if (!worldMap.containsKey(continent)) {
            System.out.println("Continent not found");
            return;
        }
        worldMap.get(continent).putIfAbsent(country, new HashMap<>());
    }

    public static void myCreateCity(String city, String postalCode, String country, String continent, HashMap<String, HashMap<String, HashMap<String, String>>> worldMap) {
        if (!worldMap.containsKey(continent)) {
            System.out.println("Continent not found");
            return;
        }
        if (!worldMap.get(continent).containsKey(country)) {
            System.out.println("Country not found");
            return;
        }
        worldMap.get(continent).get(country).put(city, postalCode);
    }

    public static Set<String> myGetCountriesOfContinent(String continent, HashMap<String, HashMap<String, HashMap<String, String>>> worldMap) {
        if (!worldMap.containsKey(continent)) {
            System.out.println("Continent not found");
            return null;
        }
        return worldMap.get(continent).keySet();
    }

    public static Set<String> myGetCitiesOfCountry(String country, String continent, HashMap<String, HashMap<String, HashMap<String, String>>> worldMap) {
        if (!worldMap.containsKey(continent)) {
            System.out.println("Continent not found");
            return null;
        }
        if (!worldMap.get(continent).containsKey(country)) {
            System.out.println("Country not found");
            return null;
        }
        return worldMap.get(continent).get(country).keySet();
    }

    public static String myGetCityPostalCode(String city, String country, String continent, HashMap<String, HashMap<String, HashMap<String, String>>> worldMap) {
        if (!worldMap.containsKey(continent)) {
            System.out.println("Continent not found");
            return null;
        }
        if (!worldMap.get(continent).containsKey(country)) {
            System.out.println("Country not found");
            return null;
        }
        if (!worldMap.get(continent).get(country).containsKey(city)) {
            System.out.println("City not found");
            return null;
        }
        return worldMap.get(continent).get(country).get(city);
    }

    public static void main(String[] args) {
        HashMap<String, HashMap<String, HashMap<String, String>>> map = new HashMap<>();
        myCreateContinent("Europe", map);
        myCreateCountry("France", "Europe", map);
        myCreateCity("Marseille", "13000", "France", "Europe", map);
        System.out.println(map);
    }
}
