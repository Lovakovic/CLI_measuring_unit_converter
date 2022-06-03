package main;

import userInterface.WelcomeScreenController;

public class Main {

    public static void main(String[] args) {

        /*
        * Here is the start of my Java program, really exciting, I know!
        *
        * This project will be about creating a simple CLI program which
        * will convert different types of measuring units.
        *
        * */

        WelcomeScreenController welcomeScreen = new WelcomeScreenController();
        welcomeScreen.display();
    }
}
