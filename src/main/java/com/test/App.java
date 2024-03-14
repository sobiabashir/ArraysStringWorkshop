package com.test;
import java.util.Arrays;
import java.util.Scanner;



public class App {
    public static void main(String[] args) {
        ////////////////////Part 1////////////////
        AddFormateNmae();

        ///////////part 2 and 3///////////
        AddNameToArray();
        SearchNameFromArray();

        //////////////////Part 3 and 4////////////
        SearchNameFromFirstNmae();
        SearchNameFromLastNmae();
        UpdateName();
        RemovedName();
    }

    public static void AddFormateNmae()
    {
        String[] formatOfNames = NameFormatter.formatName("sobia bashir");
        for(String formatOfName:formatOfNames)
            System.out.print(formatOfName);
    }
    public  static void AddNameToArray()
    {
        System.out.println();
        String nameToAdd="sobia asim";
        boolean added = NameRepository.add("Sobia Asim");
        if (added) {
            System.out.println("Name added successfully: " +nameToAdd );
        } else {
            System.out.println("Name already exists or is invalid: " + nameToAdd);
        }
    }

    public static void SearchNameFromArray()
    {
        String foundName = NameRepository.find("SOBIA ASIM");
        if (foundName != null) {
            System.out.println("Name found: " + foundName);
        } else {
            System.out.println("Name not found: " );
        }
    }

    public  static void SearchNameFromLastNmae()
    {
        String[] namesByLastName = NameRepository2.findByLastName("rasheed");
        for(String name:namesByLastName) {
            System.out.println(name);
        }
    }
    public  static void SearchNameFromFirstNmae()
    {
        String[] namesByFirstName = NameRepository2.findByFirstName("sadia");
        for(String name:namesByFirstName) {
            System.out.println(name);
        }
    }
    public static void UpdateName()
    {
        String name1="sobia bashir";
        String replaceName="SOBIA BASHIR";
        boolean Isupdated = NameRepository2.update("sadia rasheed","SADIA RASHeed");
        // Check if the name was successfully updated or not
        if (Isupdated) {
            System.out.println("Name updated successfully from '" + name1 + "' to '" + replaceName + "'.");
            for(String name:NameRepository2.names)
                System.out.println(name);
        } else {
            System.out.println("Failed to update name. Either the original name was not found or the updated name already exists.");
        }
    }
    public static void RemovedName()
    {
        boolean removed = NameRepository2.remove(" ");

// Check if the name was removed or not
        if (removed) {
            System.out.println("Name");
        } else {
            System.out.println("Failed to remove name");
        }

    }
}
