//Class RemoveDuplicates

import java.util.Scanner;


public class RemoveDuplicates {
    public static void main(String[] args) {
        boolean isTestRunning = true;
        String inputString = "";
        do{
            printMenu();
            int userInput = getValidateUserMenuInput(); //get the user input for the menu
            switch (userInput){
                case 1:
                    inputString = readInputString(); // read and store the user string.
                    break;
                case 2:
                    System.out.println("Original Text: ");
                    System.out.println(inputString+"\n");
                    printProcessedText(inputString); //process the user string by putting it all into a BST and removing it from the BST.
                    break;
                case 3:
                    System.out.println("Terminating program, thank you"); //terminate the program.
                    isTestRunning = false;
                    break;
            }
        }while (isTestRunning);
    }

    /**
     * This menu prints the menu for the user.
     */
    private static void printMenu(){
        System.out.println("------------------MAIN MENU---------------");
        System.out.println("1. Read input string");
        System.out.println("2. Remove duplicates and display outputs");
        System.out.println("3. Exit program");
    }

    /**
     * This method gets and validates user input. This method should be called every time the menu is called to get an input
     * from the user regrading their choice on the menu.
     */
    private static int getValidateUserMenuInput(){
        boolean testPassed = false;
        int userInputInteger = 0;
        Scanner sc = new Scanner(System.in);
        while(!testPassed){
            System.out.print("Enter option number: ");
            try{
                userInputInteger = Integer.parseInt(sc.nextLine());
                if(userInputInteger>=1 && userInputInteger <= 3){ //if the number is actually a valid menu option, return that number.
                    testPassed = true;
                }else{
                    System.out.println("Please enter a number between 1-3.");
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter an Integer.");
            }
        }
        return userInputInteger;
    }

    /**
     * This method will read input string and return it back.
     */
    private static String readInputString(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your input: ");
        return sc.nextLine();
    }

    /**
     * This method will print out the processed text as well as the label before it.
     */
    private static void printProcessedText(String inputString){
        System.out.println("Processed Text: ");
        removeDuplicates(inputString).inorder();
        System.out.println();
    }
    /**
     * This method should not be called as it is called from the helper method printProcessedText()
     * This method will put the input string into a BST and will return it.
     */
    private static BST<String> removeDuplicates(String inputString){
        String[] tokens = inputString.split("\\s+");
        BST<String> stringBST = new BST<>();
        for(String token : tokens) {
            stringBST.insert(token);
        }
        return stringBST;
    }
}
