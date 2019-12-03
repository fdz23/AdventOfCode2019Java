import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {

    public static int[] runIntcode(int[] numbers) throws Exception {
        int[] numbersHere = numbers.clone();
        int i = 0;

        while(i < numbersHere.length) {
            if(numbersHere[i] == 1) {
                numbersHere[numbersHere[i + 3]] = numbersHere[numbersHere[i + 1]] + numbersHere[numbersHere[i + 2]];
                i += 4;
            }
            else if(numbersHere[i] == 2) {
                numbersHere[numbersHere[i + 3]] = numbersHere[numbersHere[i + 1]] * numbersHere[numbersHere[i + 2]];
                i += 4;
            }
            else if(numbersHere[i] == 99) {
                return numbersHere;
            }
            else {
                System.out.println("Something went wrong!");
                return numbersHere;
            }
        }

        return numbersHere;
    }

    public static void main(String[] args) {
        try {
            String path = "Day2/puzzle2.txt";
            List<String> line = Files.readAllLines(Paths.get(path));
            String[] stringNumbers = line.get(0).split(",");
            int[] numbers = new int[stringNumbers.length];
            
            for(int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }

            for(int i = 0; i < 100; i++) {
                for(int j = 0; j < 100; j++) {
                    numbers[1] = i;
                    numbers[2] = j;

                    int[] newNumbers = runIntcode(numbers);
                    if(newNumbers[0] != 19690720) {
                        if(i == 12 && j == 2) {
                            System.out.println("The answer to the first puzzle is : " + newNumbers[0]);
                        }
                        newNumbers = numbers;
                    }
                    else {
                        throw new Exception("The answer to the second puzzle is : " + (100 * i + j));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
