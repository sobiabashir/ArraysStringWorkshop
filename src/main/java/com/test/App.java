package com.test;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        NameStyle stringObj =new NameStyle();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the full name in the following pattern first_name  last_name : ");
        String fullName = scanner.nextLine();
        String formattedName = Arrays.toString(stringObj.formatName(fullName));
        System.out.println("Formatted name: " + formattedName);

    }
}
