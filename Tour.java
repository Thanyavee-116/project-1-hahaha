import java.io.*;
import java.util.*;

public abstract class Tour {
    static String path = "/Users/aimily/Desktop/project-1-hahaha/tours.txt";

    public static void readTours() {

        try {
            Scanner file = new Scanner(new File(path));

            boolean groupHeaderPrinted = false;
            boolean holidayHeaderPrinted = false;

            System.out.println("Read from " + path);

            while (file.hasNextLine()) {

                String line = file.nextLine().trim();

                if (line.isEmpty() || line.startsWith("#"))
                    continue;

                String[] data = line.split(",");

                String code = data[0].trim();

                // ================= GROUP TOUR =================
                if (code.startsWith("GT")) {

                    if (!groupHeaderPrinted) {
                        System.out.println("Group Tours: price per person");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.printf("%-6s %15s %15s %15s %18s\n",
                                "Code", "15-20 persons", "21-30 persons", ">=31 persons", "Single Supplement");
                        System.out.println("-------------------------------------------------------------------------");
                        groupHeaderPrinted = true;
                    }

                    int rate1 = Integer.parseInt(data[1].trim());
                    int rate2 = Integer.parseInt(data[2].trim());
                    int rate3 = Integer.parseInt(data[3].trim());
                    int supplement = Integer.parseInt(data[4].trim());

                    System.out.printf("%-6s %,15d %,15d %,15d %,18d\n",
                            code, rate1, rate2, rate3, supplement);
                }

                // ================= HOLIDAY PACKAGE =================
                else if (code.startsWith("HP")) {

                    if (!holidayHeaderPrinted) {
                        System.out.println("\nHoliday Packages: price per person");
                        System.out.println("------------------------------------------------");
                        System.out.printf("%-6s %20s %20s\n",
                                "Code", "1 person(single)", "2 persons(Double)");
                        System.out.println("------------------------------------------------");
                        holidayHeaderPrinted = true;
                    }

                    int rate1 = Integer.parseInt(data[1].trim());
                    int rate2 = Integer.parseInt(data[2].trim());

                    System.out.printf("%-6s %,20d %,20d\n",
                            code, rate1, rate2);
                }
            }

            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}

class HolidayPackage extends Tour {

}

class GroupTour extends Tour {

}



