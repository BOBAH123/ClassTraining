package com.company;

import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Home home = new Home();
        DatabaseHandler dbHandler = new DatabaseHandler();

        home.input();
        dbHandler.signUpUser(home);

        ResultSet result = dbHandler.getInfo(home);*//*
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        System.out.print("Choose owner's name: ");
        in = new Scanner(System.in);
        Home newHome = new Home();

        newHome.setOwnerName(in.nextLine());
        System.out.print(newHome.getOwnerName());*/
        dialog();
    }

    public static void dialog() {
        Home home = new Home();
        DatabaseHandler dbHandler = new DatabaseHandler();
        boolean exit = true;
        while (exit){
            System.out.print("1. Add User.\n2. Find by Owner's name.\n3. Delete user by name.\n0. To Exit.\n Press 1, 2, 3 or 0: ");
            Scanner in = new Scanner(System.in);
            switch (in.nextLine()) {
                case "1":
                    home.input();
                    dbHandler.signUpUser(home);
                    break;
                case "2":
                    System.out.print("\nChoose owner's name: ");
                    in = new Scanner(System.in);
                    //Home newHome = new Home();
                    home.setOwnerName(in.nextLine());
                    ResultSet result = dbHandler.getInfo(home);
                    break;
                case "3":
                    System.out.print("\nChoose owner's name: ");
                    in = new Scanner(System.in);
                    home.setOwnerName(in.nextLine());
                    dbHandler.deleteUser(home);
                    break;
                case "0":
                    exit = false;
                    System.out.print("Goodbye!");
                    break;
                default:
                    System.out.print("Error.");
                    break;
            }
            System.out.println();
        }
    }
}
