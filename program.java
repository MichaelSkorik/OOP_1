package create_java.create3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class program {

        public static List<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> criteria) {
                List<Laptop> filteredLaptops = new ArrayList<>();

                for (Laptop laptop : laptops) {
                        boolean meetsCriteria = true;

                        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
                                String criterion = entry.getKey();

                                switch (criterion) {
                                        case "RAM":
                                                meetsCriteria &= laptop.getRam() >= (int) entry.getValue();
                                                break;
                                        case "StorageCapacity":
                                                meetsCriteria &= laptop.getStorageCapacity() >= (int) entry.getValue();
                                                break;
                                        case "OperatingSystem":
                                                meetsCriteria &= laptop.getOperatingSystem().equals(entry.getValue());
                                                break;
                                        case "Color":
                                                meetsCriteria &= laptop.getColor().equals(entry.getValue());
                                                break;
                                        // Add other criteria as needed
                                }
                        }

                        if (meetsCriteria) {
                                filteredLaptops.add(laptop);
                        }
                }

                return filteredLaptops;
        }

        public static void main(String[] args) {

                Set<Laptop> laptops = new HashSet<>();
                laptops.add(new Laptop("Model1", 8, 512, "Windows", "Gray"));
                laptops.add(new Laptop("Model2", 16, 1024, "MacOS", "Silver"));
                laptops.add(new Laptop("Model3", 8, 256, "Linux", "Black"));
                laptops.add(new Laptop("Model4", 16, 1024, "Windows", "Silver"));
                laptops.add(new Laptop("Model5", 32, 512, "Linux", "White"));

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number corresponding to the desired criterion:");
                System.out.println("1 - RAM\n2 - Storage Capacity\n3 - Operating System\n4 - Color");
                int criterion = scanner.nextInt();

                Map<String, Object> filterCriteria = new HashMap<>();

                switch (criterion) {
                        case 1:
                                System.out.println("Enter the minimum RAM value:");
                                int minRam = scanner.nextInt();
                                filterCriteria.put("RAM", minRam);
                                break;
                        case 2:
                                System.out.println("Enter the minimum storage capacity value:");
                                int minStorageCapacity = scanner.nextInt();
                                filterCriteria.put("StorageCapacity", minStorageCapacity);
                                break;
                        case 3:
                                System.out.println("Enter the operating system:");
                                String operatingSystem = scanner.next();
                                filterCriteria.put("OperatingSystem", operatingSystem);
                                break;
                        case 4:
                                System.out.println("Enter the color:");
                                String color = scanner.next();
                                filterCriteria.put("Color", color);
                                break;
                        default:
                                System.out.println("Invalid input.");
                                scanner.close();
                                return;
                }
                List<Laptop> result = filterLaptops(laptops, filterCriteria);

                if (result.isEmpty()) {
                        System.out.println("No laptops meet the specified criteria.");
                } else {
                        System.out.println("Laptops that meet the specified criteria:");
                        for (Laptop laptop : result) {
                                System.out.println(laptop.getModel());
                        }
                }
                
        }

}
