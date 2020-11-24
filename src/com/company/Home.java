package com.company;

import java.util.Scanner;

public class Home {
    private String type;
    private double sqware;
    private String adress;
    private int numberOfLivers;
    private String ownerName;

    public Home() {}

    public Home(String type, double sqware, String adress, int numberOfLivers, String ownerName) {
        this.type = type;
        this.sqware = sqware;
        this.adress = adress;
        this.numberOfLivers = numberOfLivers;
        this.ownerName = ownerName;
    }

    public void input() {
        System.out.print("Chooze type. Press 'F' if flat and 'H' if house: ");
        Scanner in = new Scanner(System.in);
        switch (in.nextLine()) {
            case "F":
                this.type = "Flat";
                break;
            case "f":
                this.type = "Flat";
                break;
            case "H":
                this.type = "House";
                break;
            case "h":
                this.type = "House";
                break;
            default:
                this.type = "-";
                break;
        }
        System.out.print("Input sqware of your " + this.type +": ");
        in = new Scanner(System.in);
        this.sqware = in.nextDouble();
        System.out.print("Input number of livers : ");
        in = new Scanner(System.in);
        this.numberOfLivers = in.nextInt();
        System.out.print("Input adress of your " + this.type +": ");
        in = new Scanner(System.in);
        this.adress = in.nextLine();
        System.out.print("Input owner's name: ");
        in = new Scanner(System.in);
        this.ownerName = in.nextLine();
    }

    public double getSqware() {
        return sqware;
    }

    public String getAdress() {
        return adress;
    }

    public int getNumberOfLivers() {
        return numberOfLivers;
    }

    public String getType() {
        return type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setNumberOfLivers(int numberOfLivers) {
        this.numberOfLivers = numberOfLivers;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setSqware(double sqware) {
        this.sqware = sqware;
    }

    public void setType(String type) {
        this.type = type;
    }
}
