package com.test;
import java.util.Arrays;
public class NameRepository {
    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    }

    public static void setNames(String[] newNames) {
        names = Arrays.copyOf(newNames, newNames.length);
    }

    public static void clear() {
        names = new String[0];
    }
    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }

    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
        return null;
    }
    public static boolean add(final String fullName) {
        String foundFulName=find(fullName);
        if(foundFulName!=null)
        {
            return false;
        }
        // Check if the fullName already exists in the array
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return false;
            }
        }
        String[] updatedNames = Arrays.copyOf(names, names.length + 1);
        updatedNames[updatedNames.length - 1] = fullName;
        names = updatedNames; // Update the reference to the new array

        return true;
    }





}
