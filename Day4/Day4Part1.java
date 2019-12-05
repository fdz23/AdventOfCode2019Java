package javatest.AdventOfCode2019Java.Day4;

public class Day4Part1
{
    private static int rangeMin = 136818;
    private static int rangeMax = 685979;
    public static void main(String[] args)
    {
        int[] combinations = generateCombinations();
        int amountOfValidCombinations = 0;

        for (int i = 0; i < combinations.length; i++)
        {
            int[] number = new int[6];
            String numberNow = Integer.toString(combinations[i]);
            for (int j = 0; j < 6; j++)
            {
                number[j] = numberNow.charAt(j);
            }

            if (isNumberValid(number))
            {
                amountOfValidCombinations++;
            }
        }

        System.out.println("Solution for part 1 : " + amountOfValidCombinations);
    }

    public static boolean isNumberValid(int[] number)
    {
        int doubleCheck = 0;

        for (int i = 5; i > 0; i--)
        {
            if (number[i] < number[i - 1])
            {
                return false;
            }
        }

        for (int i = 0; i < number.length; i++)
        {
            if (number[0] == number[i] && 0 != i) {
                doubleCheck++;
            }
            if (number[1] == number[i] && 1 != i) {
                doubleCheck++;
            }
            if (number[2] == number[i] && 2 != i) {
                doubleCheck++;
            }
            if (number[3] == number[i] && 3 != i) {
                doubleCheck++;
            }
            if (number[4] == number[i] && 4 != i) {
                doubleCheck++;
            }
            if (number[5] == number[i] && 5 != i) {
                doubleCheck++;
            }
        }

        if(doubleCheck < 1)
        {
            return false;
        }

        return true;
    }

    public static int[] generateCombinations()
    {
        int[] allCombinations = new int[rangeMax - rangeMin + 1];

        for (int i = 0; i < allCombinations.length; i++)
        {
            allCombinations[i] = rangeMin + i;
        }

        return allCombinations;
    }
}