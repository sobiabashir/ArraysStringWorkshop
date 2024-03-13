package com.test;
import java.util.Scanner;

import static com.test.NameRepository.findAll;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        // Reading names from the user
        System.out.print("Enter names separated by commas: ");
        String namesListOFUser = scanner.nextLine();

        // Splitting the input string into an array of names
        String[] initialNames = namesListOFUser.split(",");

        // Trim each name to remove leading and trailing whitespaces
        for (int i = 0; i < initialNames.length; i++)
        {
            initialNames[i] = initialNames[i].trim();
        }

        NameRepository.setNames(initialNames);

        System.out.println("Number of names: " + NameRepository.getSize());

        /*System.out.println("All names:");
        String[] allNames = NameRepository.findAll();
        for (int i = 0; i < allNames.length; i++) {
            System.out.println(allNames[i]);
        }*/
        disply();

        // Getting name to find from the user
        System.out.print("Enter a name to find: ");
        String nameToFind = scanner.nextLine();
        String foundName = NameRepository.find(nameToFind);
        if (foundName != null) {
            System.out.println("Name found: " + foundName);
        } else {
            System.out.println("Name not found: " + nameToFind);
        }

        // Getting name to add from the user
        System.out.print("Enter a name to add: ");
        String nameToAdd = scanner.nextLine();
        boolean added = NameRepository.add(nameToAdd);
        if (added) {
            System.out.println("Name added successfully: " + nameToAdd);
            System.out.println("After adding list is below:");
            disply();
        } else {
            System.out.println("Name already exists: " + nameToAdd);
            System.out.println("After removing list is below:");
            disply();
        }

        NameRepository.clear();
        System.out.println("After clearing, number of names: " + NameRepository.getSize());



    }
    public static void disply()
    {
        System.out.println("All names:");
        String[] allNames = NameRepository.findAll();
        for (int i = 0; i < allNames.length; i++) {
            System.out.println(allNames[i]);
        }
    }

}
