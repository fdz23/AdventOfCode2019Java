import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static int calculateFuel(int mass) {
        return (mass / 3) - 2;
    }

    public static int calculateTotalFuel(List<Integer> masses) {
        int totalFuel = 0;

        for (int mass : masses) {
            int fuel = calculateFuel(mass);
            totalFuel += fuel;
        }

        return totalFuel;
    }

    public static int calculateTotalFuelFuel(List<Integer> masses) {
        int totalFuel = 0;
        for (int mass : masses) {
            int fuel = calculateFuel(mass);
            while (fuel > 0) {
                totalFuel += fuel;
                fuel = calculateFuel(fuel);
            }
        }

        return totalFuel;
    }

    public static void main(String[] args) {
        try {
            String path = "Day1/puzzle1.txt";
            List<String> list = Files.readAllLines(Paths.get(path));
            List<Integer> masses = new ArrayList();

            for (String line : list) {
                int mass = Integer.parseInt(line);
                masses.add(mass);
            }

            int firstPart = calculateTotalFuel(masses);
            int secondPart = calculateTotalFuelFuel(masses);

            System.out.println(firstPart + " is the answer to the first puzzle.");
            System.out.println(secondPart + " is the answer to the second puzzle.");
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }

    }

}