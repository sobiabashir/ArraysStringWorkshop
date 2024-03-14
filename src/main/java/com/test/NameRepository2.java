package com.test;
import java.util.Arrays;

public class NameRepository2 {

    public static String[] names = {"sobia bashir","sadia rasheed","hafsa rasheed"};
   public static String[] findByFirstName(final String firstName) {
        int count = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length > 0 && parts[0].equalsIgnoreCase(firstName)) {
                count++;
            }
        }
        String[] matches = new String[count];
        count = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length > 0 && parts[0].equalsIgnoreCase(firstName)) {
                matches[count++] = name;
            }
        }
        return Arrays.copyOf(matches, count);
    }


    public static String[] findByLastName(final String lastName) {
        int count = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length > 1 && parts[1].equalsIgnoreCase(lastName)) {
                count++;
            }
        }
        String[] matches = new String[count];
        count = 0;
        for (String name : names) {
            String[] parts = name.split("\\s+");
            if (parts.length > 1 && parts[1].equalsIgnoreCase(lastName)) {
                matches[count++] = name;
            }
        }
        return Arrays.copyOf(matches, count);
    }


    public static boolean update(final String original, final String updatedName) {
        // Check if the original name exists in the array
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                // Check if the updatedName already exists in the array
                boolean updatedNameExists = false;
                for (String name : names) {
                    if (name.equals(updatedName)) {
                        updatedNameExists = true;
                        break;
                    }
                }
                // If the updatedName already exists and it's different from the original name, return false
                if (updatedNameExists && !original.equals(updatedName)) {
                    return false;
                }
                // Update the name
                names[i] = updatedName;
                return true;
            }
        }
        // Name wasn't found
        return false;
    }

    public static boolean remove(final String fullName) {
        int indexToRemove = -1;
        // Find the index of the name to remove
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            // Create a new array with one less element
            String[] updatedNames = new String[names.length - 1];
            // Copy elements before the index to keep
            System.arraycopy(names, 0, updatedNames, 0, indexToRemove);
            /* Copy elements after the index to keep */
            if (names.length - (indexToRemove + 1) >= 0) {
                System.arraycopy(names, indexToRemove + 1, updatedNames, indexToRemove + 1 - 1, names.length - (indexToRemove + 1));
            }
            names = updatedNames; // Update the reference to the new array
            return true;
        }
        return false; // Name wasn't found
    }

}



