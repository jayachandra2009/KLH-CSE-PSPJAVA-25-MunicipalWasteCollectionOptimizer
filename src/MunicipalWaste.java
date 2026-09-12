import java.util.Scanner;

public class MunicipalWaste {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] waste = new int[3][3];

        int choice;
        int total;
        int capacity;
        double average;

        System.out.println("================================");
        System.out.println(" MUNICIPAL WASTE COLLECTION");
        System.out.println("       OPTIMISER");
        System.out.println("================================");

        // Taking input for 3 areas and 3 days
        System.out.println("\nEnter waste collected in kg:");

        for (int i = 0; i < 3; i++) {
            System.out.println("\nArea " + (i + 1));

            for (int j = 0; j < 3; j++) {
                System.out.print("Day " + (j + 1) + ": ");
                waste[i][j] = sc.nextInt();
            }
        }

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Display Waste Details");
            System.out.println("2. Calculate Total Waste");
            System.out.println("3. Calculate Average Waste");
            System.out.println("4. Check Truck Capacity");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nWaste Details:");

                    for (int i = 0; i < 3; i++) {

                        System.out.print("Area " + (i + 1) + ": ");

                        for (int j = 0; j < 3; j++) {
                            System.out.print(waste[i][j] + " kg  ");
                        }

                        System.out.println();
                    }

                    break;

                case 2:

                    total = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {

                            // Addition operator
                            total = total + waste[i][j];
                        }
                    }

                    System.out.println("Total Waste = "
                            + total + " kg");

                    break;

                case 3:

                    total = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            total = total + waste[i][j];
                        }
                    }

                    // Type casting
                    average = (double) total / 9;

                    System.out.printf("Average Waste = %.2f kg%n",
                            average);

                    break;

                case 4:

                    System.out.print("Enter truck capacity: ");
                    capacity = sc.nextInt();

                    total = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            total = total + waste[i][j];
                        }
                    }

                    // Relational operator
                    if (total <= capacity) {
                        System.out.println(
                                "Truck can collect all the waste.");
                    }
                    else {
                        System.out.println(
                                "Truck capacity is not enough.");

                        // Subtraction operator
                        System.out.println("Extra waste = "
                                + (total - capacity) + " kg");
                    }

                    break;

                case 5:

                    System.out.println("Thank you!");

                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
