package javatest.AdventOfCode2019Java.Day7;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javatest.AdventOfCode2019Java.Day7.Day5_1;

public class Day7part1
{
    static private List<Integer> results = new ArrayList();
    public static void main(String[] args)
    {
        try
        {
            String path = "javatest/AdventOfCode2019Java/Day7/puzzle7.txt";
            String data = Files.readAllLines(Paths.get(path)).get(0);;
            String[] dataSplit = data.split(",");
            int[] intCodeList = new int[dataSplit.length];
            
            for (int i = 0; i < intCodeList.length; i++)
            {
                intCodeList[i] = (Integer.parseInt(dataSplit[i]));
            }

            permute(5, new int[]{ 0, 1, 2, 3, 4}, intCodeList);

            Collections.sort(results);

            System.out.println("Part 1 result = " + results.get(results.size() - 1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void permute(int n, int[] elements, int[] intCodeList) throws Exception 
    {
        if (n == 1) 
        {
            permuteArray(elements, intCodeList);
        } 
        else 
        {
            for (int i = 0; i < n-1; i++) 
            {
                permute(n - 1, elements, intCodeList);

                if(n % 2 == 0) 
                {
                    swap(elements, i, n-1);
                } 
                else 
                {
                    swap(elements, 0, n-1);
                }
            }

            permute(n - 1, elements, intCodeList);
        }
    }
    private static void swap(int[] input, int a, int b) 
    {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    private static void permuteArray(int[] input, int[] intCodeList) throws Exception 
    {
        int output = 0;

        for (int i = 0; i < input.length; i++)
        {
            output = Day5_1.runIntCode(intCodeList, input[i], output);

            results.add(output);
        }
    }
}