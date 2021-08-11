// import scanner class
import java.io.IOException;
import java.util.Scanner;

public class Poised {
    // main method
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);
        System.out.println("Lets build");

        // get details about architect and store details in variables
        System.out.print("Enter the architect's name and surname: ");
        String architectName = input.nextLine();
        System.out.print("Enter the architect's telephone number: ");
        String architectNumber = input.nextLine();
        System.out.print("Enter the architect's email address: ");
        String architectEmail = input.nextLine();
        System.out.print("Enter the architect's physical address ");
        String architectAddress = input.nextLine();

        // get details about contractor and store details in variables
        System.out.print("Enter the contractor's name and surname ");
        String contractorName = input.nextLine();
        System.out.print("Enter the contractor's telephone number: ");
        String contractorNumber = input.nextLine();
        System.out.print("Enter the contractor's email address: ");
        String contractorEmail = input.nextLine();
        System.out.print("Enter the contractor's physical address: ");
        String contractorAddress = input.nextLine();

        // get details about customer and store details in variables
        System.out.print("Enter the customer's name and surname: ");
        // empty string
        String customerName = "";
        // while loop until try block is executed
        // ensures both name and surname of customer is entered
        while (true) {
            // try split the string entered to see if it consists of two names then break out of loop
            try {
                customerName = input.nextLine();
                String[] nameArr = customerName.split(" ");
                String surname = nameArr[1];
                break;
            }
            // catch if fails and print out error message
            catch (Exception e) {
                System.out.print("Invalid - enter the customer's NAME and SURNAME: ");
            }
        }
        System.out.print("Enter the customer's telephone number: ");
        String customerNumber = input.nextLine();
        System.out.print("Enter the customer's email address: ");
        String customerEmail = input.nextLine();
        System.out.print("Enter the customer's physical address: ");
        String customerAddress = input.nextLine();

        // create architect, contractor and customer objects
        Person architect = new Person(architectName, architectNumber, architectEmail, architectAddress);
        Person contractor = new Person(contractorName, contractorNumber, contractorEmail, contractorAddress);
        Person customer = new Person(customerName, customerNumber, customerEmail, customerAddress);

        // get details about project and store in variables
        System.out.print("Enter the project number: ");
        // set projectNumber to zero
        int projectNumber = 0;
        // while loop until try block is executed
        // ensures an integer is entered
        while (true) {
            // try get an integer and break out of while loop
            try {
                projectNumber = input.nextInt();
                break;
            }
            // catch if integer is not entered and output message
            catch (Exception e) {
                input.nextLine();   // skip empty line entered by user
                System.out.print("Invalid input - enter the project number again: ");
            }
        }
        input.nextLine();   // skip empty line entered by user
        System.out.print("Enter the project name: ");
        String projectName = input.nextLine();
        System.out.print("What type of building is being designed? E.g. House, apartment block or store, etc.: ");
        String buildingType = input.nextLine();
        System.out.print("Enter the physical address for the project: ");
        String projectAddress = input.nextLine();

        System.out.print("Enter the ERF number: ");
        // set erfNumber to zero
        int erfNumber = 0;
        // while loop until try block is executed
        // ensures an integer is entered
        while (true) {
            // try get an integer and break out of while loop
            try {
                erfNumber = input.nextInt();
                break;
            }
            // catch if integer is not entered and output message
            catch (Exception e) {
                input.nextLine();   // skip empty line entered by user
                System.out.print("Invalid input - enter the project number again: ");
            }
        }

        System.out.print("Enter the total fee being charged for the project: ");
        // set projectFee to zero
        double projectFee = 0;
        // while loop until try block is executed
        // ensures a double is entered
        while (true) {
            // try get a double and break out of while loop
            try {
                projectFee = input.nextDouble();
                break;
            }
            // catch if double is not entered and output message
            catch (Exception e) {
                input.nextLine();   // skip empty line entered by user
                System.out.print("Invalid input - enter the total fee being charged for the project again: ");
            }
        }
        System.out.print("Enter total amount paid to date: ");
        // set amountPaid to zero
        double amountPaid = 0;
        // while loop until try block is executed
        // ensures a double is entered
        while (true) {
            // try get a double and break out of while loop
            try {
                amountPaid = input.nextDouble();
                break;
            }
            // catch if double is not entered and output message
            catch (Exception e) {
                input.nextLine();   // skip empty line entered by user
                System.out.print("Invalid input - enter the total amount paid to date again: ");
            }
        }
        input.nextLine(); // skip empty line entered by user
        System.out.print("Enter the deadline for the project: ");
        String deadline = input.nextLine(); // change deadline type to date?

        // create a project object
        Project project = new Project(projectNumber, projectName, buildingType, projectAddress, erfNumber,
                projectFee, amountPaid, deadline, architect, contractor, customer, false, "");

        // Output instruction and get choice to change/update details
        System.out.print("Enter 'x' to change/update details or any other key to skip: ");
        String choice = input.nextLine();
        // if user chooses to change/update details
        if (choice.equalsIgnoreCase("x")) {
            // while user does not exit loop over menu
            while (true) {
                // output options
                System.out.println("""
                        Enter 1 to change the due date of the project
                        Enter 2 to change the total amount of the fee paid to date
                        Enter 3 to update a contractor’s contact details
                        Enter 0 to exit out of change/update section""");
                // get option type
                int type = input.nextInt();

                // if - else chain executing code depending on option type chosen

                // if type is 1 output instruction, get new due date and set new deadline for project
                if (type == 1) {
                    System.out.print("Enter a new due date for the project: ");
                    String newDate = input.next();
                    project.setDeadline(newDate);
                }

                // if type is 2 output instruction, get new amount and set new total amount for project
                else if (type == 2) {
                    System.out.print("Enter the total amount of the fee paid to date: ");
                    double newAmount = input.nextDouble();
                    project.setTotalAmount(newAmount);
                }

                // if type is 3
                else if (type == 3) {
                    // output instruction
                    System.out.println("""
                            Enter 1 to update a contractor's email address
                            Enter 2 to update a contractor's telephone number
                            Enter 3 to update both""");
                    // get update choice
                    int update = input.nextInt();

                    // if choice is 1, output message, get new email and set new email for contractor
                    if (update == 1) {
                        System.out.print("Enter an updated contractor's email address: ");
                        String newEmail = input.next();
                        contractor.setEmail(newEmail);
                    }

                    // if choice is 2, output message, get new number and set new number for contractor
                    else if (update == 2) {
                        System.out.print("Enter an updated contractor's telephone number: ");
                        String newNumber = input.next();
                        contractor.setNumber(newNumber);
                    }

                    // if choice is 3, execute both if and else if blocks above
                    else if (update == 3) {
                        System.out.print("Enter an updated contractor's email address: ");
                        String newEmail = input.next();
                        contractor.setEmail(newEmail);
                        System.out.print("Enter an updated contractor's telephone number: ");
                        String newNumber = input.next();
                        contractor.setNumber(newNumber);
                    }
                }
                // break out of loop
                else if (type == 0)
                    break;
                else
                    System.out.println("Invalid choice");
            }
        }

        // output message and get input to finalize project or not
        System.out.print("Enter 'f' to finalize the project or enter any other key to skip: ");
        String finalizeChoice = input.nextLine();
        // if user chooses to finalize project
        // finalize the project by calling finalizeProject from the Project class
        if (finalizeChoice.equalsIgnoreCase("f")) {
            project.finalizeProject();
            // get current date and set it as the completion date using the setCompletionDate method
            String completionDate = "Today's Date"; // Was told to keep date in string format by lecturer
            project.setCompletionDate(completionDate);
            // check if project is paid for in full.
            // If true output message else output invoice by calling the invoice method in the Project class
            if (project.totalPaid == project.totalDue) {
                System.out.println("Paid in full");
            } else {
                System.out.println(project.invoice());
            }
        }
    }
}
