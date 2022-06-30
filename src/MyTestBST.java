//Class MyTestBST

import java.util.ArrayList;
import java.util.Scanner;


public class MyTestBST {
    public static void main(String[] args) {
        boolean isTestRunning = true;

        BST testBST = null; //create a raw type tree since we don't know the type of tree right now, and we need to declare this array now.

        //this block will force the user to enter 0 before we even run the loop.
        printMenu();
        forceUserToEnter0(); //this method will force the user to enter 0 and will keep looping until they do.
        char type = getTreeDataType(); //this method will get the type of the tree from the user.

        //assign the tree the correct type based on what the user inputted.
        if(type == 'i'){
            testBST = new BST<Integer>();
        }else if(type == 's'){
            testBST  = new BST<String>();
        }else{
            System.out.println("ERROR! INVALID TREE TYPE"); //this line should never execute ass the getTreeDataType should only return i or s.
        }


        if(testBST != null){//check to make sure that the tree is not null.

            do{//do-while loop to go through the normal cases.

                printMenu(); //print the menu on every iteration
                int userMenuChoice = getValidateUserMenuInput(); //get the user menu choice and input validate it (make sure that the user selects 0-10)

                if((userMenuChoice >= 1 && userMenuChoice <=3) || userMenuChoice == 5){ //if the user chooses options 0-3 or 5, then we have to special case the insert, delete and search methods.
                    if(type == 's'){//CASE 1 the current tree type is a String.
                        switch (userMenuChoice){
                            case 1:
                                System.out.println("Testing method Insert Data Element (Option 1): ");
                                System.out.print("Please enter a string to insert: ");
                                String string = getDataElementString(); //gets the string and stores it.
                                System.out.print("Before inserting "+string+" (Inorder):\t");

                                testBST.inorder();
                                System.out.println();

                                testBST.insert(string); //inserts specified string.

                                System.out.print("After inserting "+string+ " (Inorder):\t");
                                testBST.inorder();
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Testing method Delete Data Element (Option 2): ");
                                System.out.print("Please enter a string to search for and delete: ");
                                String stringToDelete = getDataElementString(); //gets a string and stores it.
                                System.out.print("Before deleting "+stringToDelete+" (Inorder):\t");
                                testBST.inorder();
                                System.out.println();

                                testBST.delete(stringToDelete); //deletes specified string

                                System.out.print("After deleting "+stringToDelete+ " (Inorder):\t");
                                testBST.inorder();
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Testing method Search for Data Element (Option 3): ");
                                System.out.print("Please enter a string to search for in the tree: ");
                                String stringToSearchFor = getDataElementString();
                                System.out.println("Search for "+stringToSearchFor+"?\t" +testBST.search(stringToSearchFor));
                                break;
                            case  5:
                                System.out.println("Testing method Path from Root to Data Element (Option 5): ");
                                System.out.print("Please enter a string to get the path for: ");
                                ArrayList<BST.TreeNode<String>> path = testBST.path(getDataElementString()); //find path to specified string.
                                for(int i=0;path != null && i < path.size();i++){ //print out that path
                                    System.out.print(path.get(i).element+ " ");
                                }
                                System.out.println();
                                break;
                        }
                    }else{//CASE 2 the current tree type is an Integer.
                        switch (userMenuChoice){
                            case 1:
                                System.out.println("Testing method Insert Data Element (Option 1): ");
                                System.out.print("Please enter an integer to add to the tree: ");
                                Integer num = getDataElementInt("Please enter an integer to add to the tree: ");
                                System.out.print("Before inserting "+num+" (Inorder):\t");
                                testBST.inorder();
                                System.out.println();

                                testBST.insert(num); //insert specified integer

                                System.out.print("After inserting "+num+ " (Inorder):\t");
                                testBST.inorder();
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Testing method Delete Data Element (Option 2): ");
                                System.out.print("Please enter an integer to search for and delete from the tree: ");
                                Integer numToDelete = getDataElementInt("Please enter an integer to search for and delete from the tree: ");
                                System.out.print("Before deleting "+numToDelete+" (Inorder):\t");
                                testBST.inorder();
                                System.out.println();

                                testBST.delete(numToDelete); //delete specified integer

                                System.out.print("After deleting "+numToDelete+ " (Inorder):\t");
                                testBST.inorder();
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Testing method Search for Data Element (Option 3): ");
                                System.out.print("Please enter an integer to search for in the tree: ");
                                Integer numToSearchFor = getDataElementInt("Please enter an integer to search for in the tree: ");
                                System.out.println("Search for "+numToSearchFor+"?\t" +testBST.search(numToSearchFor)); //search for specified integer
                                break;
                            case 5:
                                System.out.println("Testing method Path from Root to Data Element (Option 5): ");
                                System.out.print("Please enter an integer to get the path for: ");
                                ArrayList<BST.TreeNode<Integer>> path = testBST.path(getDataElementInt("Please enter an integer to get the path for: ")); //get the path for specified integer node
                                for(int i=0;path != null && i < path.size();i++){ //print the path we got.
                                    System.out.print(path.get(i).element+ " ");
                                }
                                System.out.println();
                                break;
                        }
                    }
                }else{//if it's not menu option 1,2,3 or 5 then it does not matter if it is a string or an integer.
                    switch (userMenuChoice){
                        case 0: //the user wants to change the tree type.
                            System.out.println("Testing method Enter Tree Data Type (Option 0): ");
                            System.out.println("Be aware that this will delete the old tree and create a new one on top of it.");
                            type = getTreeDataType(); //this will get the type the user wants to change to.
                            if(type == 's'){
                                testBST = new BST<String>(); //create a new tree with the specified type.
                            }else if(type == 'i'){
                                testBST = new BST<Integer>(); //create a new tree with the specified type.
                            }else{
                                System.out.println("ERROR! INVALID TREE TYPE"); //this line should never execute as the getTreeDataType should only return i or s.
                            }
                            break;
                        case 4:
                            System.out.println("Testing method Print Tree Size (Option 4): ");
                            System.out.println("Tree size:\t"+testBST.getSize()); //get the tree size
                            break;
                        case 6:
                            System.out.println("Testing method Check if Empty Tree (Option 6): ");
                            System.out.println("Is empty tree?\t"+testBST.isEmpty()); //get if the tree is empty
                            break;
                        case 7:
                            System.out.println("Testing method Print Preorder Traversal (Option 7): ");
                            System.out.print("Preorder:\t");
                            testBST.preorder(); //print the preorder
                            System.out.println();
                            break;
                        case 8:
                            System.out.println("Testing method Print Inorder Traversal (Option 8): ");
                            System.out.print("Inorder:\t");
                            testBST.inorder(); //print the inorder
                            System.out.println();
                            break;
                        case 9:
                            System.out.println("Testing method Print Postorder Traversal (Option 9): ");
                            System.out.print("Postorder:\t");
                            testBST.postorder(); //print the postorder
                            System.out.println();
                            break;
                        case 10:
                            System.out.println("Terminating program, thank you.");
                            isTestRunning = false;
                            break;
                    }
                }

            }while (isTestRunning); //sentinel loop that will continue to run the menu until terminated.
        }

    }

    //Prints the menu for the MyTestBST class
    private static void printMenu(){
        System.out.println("\n----------------MAIN MENU---------------");
        System.out.println("0.\tEnter Tree Data Type (integer or string)");
        System.out.println("1.\tInsert Data Element");
        System.out.println("2.\tDelete Data Element");
        System.out.println("3.\tSearch for Data Element");
        System.out.println("4.\tPrint Tree Size");
        System.out.println("5.\tPath from Root to Data Element");
        System.out.println("6.\tCheck if Empty Tree");
        System.out.println("7.\tPrint Preorder Traversal");
        System.out.println("8.\tPrint Inorder Traversal");
        System.out.println("9.\tPrint Postorder Traversal");
        System.out.println("10.\tExit Program\n");
    }

    /**
     * This method gets and validates user input. This method should be called every time the menu is called to get an input
     * from the user regrading their choice on the menu.
     */
    private static void forceUserToEnter0(){
        boolean testPassed = false;
        int userInputInteger;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter option number: ");
            try{
                userInputInteger = Integer.parseInt(sc.nextLine());
                if(userInputInteger==0){ //unless the user presses 0, it will keep prompting the user.
                    testPassed = true;
                }else{
                    System.out.println("You must first enter a tree data type! (Select option 0)");
                    printMenu();
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter an Integer.");
            }
        }while(!testPassed);
    }

    /**
     * This method gets and validates user input. This method should be called every time the menu is called to get an input
     * from the user regrading their choice on the menu.
     */
    private static int getValidateUserMenuInput(){
        boolean testPassed = false;
        int userInputInteger = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter option number: ");
            try{
                userInputInteger = Integer.parseInt(sc.nextLine());
                if(userInputInteger>=0 && userInputInteger <= 10){ //if the number is actually a valid menu option, return that number.
                    testPassed = true;
                }else{
                    System.out.println("Please enter a number between 0-10.");
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter an Integer.");
            }
        }while(!testPassed);
        return userInputInteger;
    }

    //This method will get the tree data type and set the generic tree to that type.
    //this method will return a 'i' for integer type and 's' for string.
    private static char getTreeDataType(){
        boolean testPassed = false;
        String userInput;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter tree data type (integer or string): ");
            userInput = sc.nextLine().trim();
            if(userInput.equalsIgnoreCase("integer")){ //if the user picks an integer or boolean return, else keep asking.
                return 'i';
            }else if(userInput.equalsIgnoreCase("string")){
                return 's';
            }else{
                System.out.println("Please choose between integer and string!");
            }
        }while(!testPassed);
        throw new IllegalStateException("Illegal state in getTreeDataType"); //if somehow the  user got out of the while loop.
    }

    //This method will get an input for the user and will check it to ensure it is of type node before returning it back.
    //This method will be called to get data nodes for integer trees.
    private static Integer getDataElementInt(String prompt){
        Scanner sc = new Scanner(System.in);
        boolean isTestPassed = false;
        do{
            try{
                return Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Please enter an integer.");
                System.out.print(prompt);
            }
        }while(!isTestPassed);
        throw new IllegalStateException("Illegal state in getDataElement()");
    }

    //This method will get an input for strings and return it back.
    //This method will be called to get data nodes for string trees.
    private static String getDataElementString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
