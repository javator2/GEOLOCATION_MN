package com.sda.MapyGoogle;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=";
        String ApiKey = "&key=AIzaSyB76-rDrOkOr8xfXXoTj7NEeevzergovws";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj lokalizację: ");
        String localization = scanner.nextLine();

        GoogleService googleService = new GoogleService(url, localization, ApiKey);

        String mapUrl = "http://maps.googleapis.com/maps/api/staticmap?center=" + Place.getLan() + "," + Place.getLng() + "&size=400x400&zoom=16";
        // System.out.println(url.toString());
        File file = new File("plik.png");
        deleteFile(file);
        try (InputStream input = new URL(mapUrl).openStream()) {
            Files.copy(input, Paths.get(file.getName()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(googleService.toString());

    }


    private static void deleteFile(File file) {
        if (file.delete()) {
            System.out.println("Skasowano plik tymczasowy: " + file.getName());
        } else {
            System.out.println("Operacja kasowania pliku tymczasowego nie powiodla sie.");
        }
    }
}
