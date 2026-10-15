import java.util.ArrayList;
import java.util.Scanner;

// Parent class - co4:Inheritance
class WasteCollection 
{
    String[] areaNames;
    String[] wasteTypes;
    double[] wasteAmounts;
    int count;

    WasteCollection(int size) 
    {
        areaNames=new String[size];
        wasteTypes=new String[size];
        wasteAmounts=new double[size];
        count=0;
    }

    // Method to add area details
    void addArea(String name, String type, double amount)
    {
        if (count < areaNames.length) 
            {
            areaNames[count]=name;
            wasteTypes[count]=type;
            wasteAmounts[count]=amount;
            count++;
            System.out.println("Area details added successfully");
        } else {
            System.out.println("Area limit reached");
        }
    }

    // Method overloading - co3
    double calculateTotalWaste() 
    {
        double total=0;

        for (int i=0;i < count;i++)
             {
            total += wasteAmounts[i];
        }

        return total;
    }

    double calculateTotalWaste(double extraWaste)
    {
        return calculateTotalWaste()+extraWaste;
    }

    // Display all areas-co3
    void displayAreas() 
    {
        if (count == 0) 
            {
            System.out.println("No area details available");
            return;
        }

        System.out.println("\n--- Waste Collection Report ---");

        for (int i=0;i<count;i++) 
            {
            System.out.println(
                (i + 1) + ". Area: " + areaNames[i]
                + " | Waste Type: " + wasteTypes[i]
                + " | Waste: " + wasteAmounts[i] + " kg"
            );
        }

        System.out.println(
            "Total Waste: " + calculateTotalWaste() + " kg"
        );
    }
}

// Child class - Inheritance-co4
class PriorityCollection extends WasteCollection
{

    PriorityCollection(int size) {
        super(size);
    }

    // Identify priority areas
    void findPriorityAreas() 
    {
        if (count == 0) 
            {
            System.out.println("Please add area details first.");
            return;
        }

        System.out.println("\n--- Priority Collection Areas ---");
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (wasteAmounts[i] >= 100) {
                System.out.println(
                    areaNames[i] + " - HIGH PRIORITY ("
                    + wasteAmounts[i] + " kg)"
                );
                found=true;
            } else if (wasteAmounts[i]>=50) 
                {
                System.out.println(
                    areaNames[i] + " - MEDIUM PRIORITY ("
                    + wasteAmounts[i]+ " kg)"
                );
                found=true;
            }
        }

        if (!found) 
            {
            System.out.println(
                "No medium or high priority areas."
            );
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityCollection collection =
            new PriorityCollection(10);

        // co6: ArrayList
        ArrayList<String> registeredAreas = new ArrayList<>();

        int choice = 0;

        do {
            System.out.println(
                "\n------ MUNICIPAL WASTE COLLECTION OPTIMIZER ------"
            );
            System.out.println("1. Add Area Waste Details");
            System.out.println("2. Display All Areas");
            System.out.println("3. Calculate Total Waste");
            System.out.println("4. Find Priority Areas");
            System.out.println("5. Calculate Total with Extra Waste");
            System.out.println("6. Display Registered Area Names");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                // switch case -co2
                switch (choice) {

                    case 1:
                        System.out.print("Enter area name: ");
                        String name = sc.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println(
                                "Area name cannot be empty"
                            );
                            break;
                        }

                        System.out.print(
                            "Enter waste type (Wet/Dry/Plastic): "
                        );
                        String type = sc.nextLine().trim();

                        System.out.print(
                            "Enter waste quantity in kg: "
                        );
                        double amount =
                            Double.parseDouble(sc.nextLine());

                        if (amount<0) 
                            {
                            System.out.println(
                                "Waste quantity cannot be negative"
                            );
                        } else {
                            int oldCount=collection.count;

                            collection.addArea(name,type,amount);

                            if (collection.count>oldCount)
                                 {
                                registeredAreas.add(name);
                            }
                        }
                        break;

                    case 2:
                        collection.displayAreas();
                        break;

                    case 3:
                        System.out.println(
                            "Total Waste: "
                            + collection.calculateTotalWaste()
                            + " kg"
                        );
                        break;

                    case 4:
                        collection.findPriorityAreas();
                        break;

                    case 5:
                        System.out.print(
                            "Enter additional waste in kg: "
                        );
                        double extra =
                            Double.parseDouble(sc.nextLine());

                        if (extra < 0) {
                            System.out.println(
                                "Extra waste cannot be negative."
                            );
                        } else {
                            System.out.println(
                                "Total including extra waste: "
                                + collection.calculateTotalWaste(extra)
                                + " kg"
                            );
                        }
                        break;

                    case 6:
                        System.out.println(
                            "\n--- Registered Area Names ---"
                        );

                        if (registeredAreas.isEmpty()) {
                            System.out.println(
                                "No areas registered yet."
                            );
                        } else {
                            for (String area : registeredAreas) {
                                System.out.println(area);
                            }
                        }
                        break;

                    case 7:
                        System.out.println(
                            "Thank you for using the Waste Optimizer!"
                        );
                        break;

                    default:
                        System.out.println(
                            "Invalid choice.Please try again."
                        );
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input Please enter a valid number."
                );
            }

        } while(choice != 7);

        sc.close();
    }
}
