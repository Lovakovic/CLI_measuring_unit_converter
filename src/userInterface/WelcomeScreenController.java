package userInterface;

import java.util.Scanner;

/**
 * Initial class for welcoming users
 */
public class WelcomeScreenController implements UI {

    private static final Scanner input = new Scanner(System.in);

    @Override
    public void display() {
        welcomeScreen();
        displayOptions();

        redirectToOtherScreen(chooseOption());
    }

    @Override
    public void exit() {
        System.out.println("Type Y to exit the program.");

        boolean exitConfirmed = input.nextLine().equalsIgnoreCase("y");

        if(exitConfirmed) {
            System.exit(0);
        }

        // else...
        welcomeScreen();
    }

    public void welcomeScreen() {
        System.out.println("Welcome to unit converter, please choose the type of units you'd like to convert:");
    }

    public void displayOptions() {

        System.out.println("[0] Exit");
        System.out.println("[1] Length");
        System.out.println("[2] Speed");
        System.out.println("[3] Temperature");
        System.out.println("[4] Volume");
        System.out.println("[5] Weight");

    }

    public int chooseOption() {
        int userInput;

        while(true) {

            userInput = input.nextInt();
            input.nextLine();

            if(0 <= userInput && userInput <= 5) {
                return userInput;
            }

            System.out.println("Invalid input, you have to enter a number within range.");
        }
    }

    public void redirectToOtherScreen(int optionChosen) {
        switch (optionChosen) {

            // user chose length
            case 1 -> redirectToLengthScreen();

            // user chose speed
            case 2 -> redirectToSpeedScreen();

            // user chose temperature
            case 3 -> redirectToTemperatureScreen();

            // user chose volume
            case 4 -> redirectToVolumeScreen();

            // user chose weight
            case 5 -> redirectToWeightScreen();

            // user chose to exit
            default -> exit();
        }
    }

    public void redirectToLengthScreen() {
        System.out.println("Redirecting to length conversion screen...\n");
        LengthScreenController lengthScreen = new LengthScreenController(input);
        lengthScreen.display();
    }

    public void redirectToSpeedScreen() {
        System.out.println("Redirecting to speed conversion screen... \n");
        SpeedScreenController speedScreen = new SpeedScreenController(input);
        speedScreen.display();
    }

    public void redirectToTemperatureScreen() {
        System.out.println("Redirecting to temperature conversion screen...\n");
        TemperatureScreenController temperatureScreen = new TemperatureScreenController(input);
        temperatureScreen.display();
    }

    public void redirectToVolumeScreen() {
        System.out.println("Redirecting to volume conversion screen...\n");
        VolumeScreenController volumeScreen = new VolumeScreenController(input);
        volumeScreen.display();
    }

    public void redirectToWeightScreen() {
        System.out.println("Redirecting to weight conversion screen...\n");
        WeightScreenController weightScreen = new WeightScreenController(input);
        weightScreen.display();
    }
}

