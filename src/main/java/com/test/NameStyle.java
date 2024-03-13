package com.test;


public class NameStyle {

    public String[] formatName(String fullName) {


        String[] names = new String[2]; // Array to store first name and last name

        // Find the index of the first whitespace
        int indexForSpace = findSpace(fullName);
        // Extract first name and last name using substring
        names[0] = fullName.substring(0, indexForSpace); // First name
        names[1] = fullName.substring(indexForSpace + 1); // Last name
        if(names[1].isEmpty())
        {
            System.out.println("Please enter last name also");
            return null;
        }
        return names;

    }
    private static int findSpace(String fullName) {
        for (int i = 0; i < fullName.length(); i++)
        {
            if (fullName.charAt(i) == ' ' )
               return i;
        }
      return -1;
    }
}



