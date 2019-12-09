package javatest.AdventOfCode2019Java.Day7;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javatest.AdventOfCode2019Java.Day7.Day5_2;

public class Day7part2
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
            int output = 0;
            int[] iterators = new int[5];
            int[] signToHalt = new int[1];
            signToHalt[0] = 0;
            
            for (int i = 0; i < intCodeList.length; i++)
            {
                intCodeList[i] = (Integer.parseInt(dataSplit[i]));
            }

            permute(5, new int[]{ 5, 6, 7, 8, 9}, intCodeList, output, iterators, signToHalt);

            Collections.sort(results);

            System.out.println("Part 2 result = " + results.get(results.size() - 1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void permute(int n, int[] elements, int[] intCodeList, int output, int[] iteratorsA, int[] signToHalt) throws Exception 
    {
        int[] intCodeList1 = intCodeList.clone();
        int[] intCodeList2 = intCodeList.clone();
        int[] intCodeList3 = intCodeList.clone();
        int[] intCodeList4 = intCodeList.clone();
        int[] intCodeList5 = intCodeList.clone();
        int[] iterators = iteratorsA.clone();
        signToHalt[0] = 0;

        if (n == 1) 
        {
            permuteArray(elements, intCodeList1, intCodeList2, intCodeList3, intCodeList4, intCodeList5, output, iterators, signToHalt);
        } 
        else 
        {
            for (int i = 0; i < n-1; i++) 
            {
                permute(n - 1, elements, intCodeList, output, iterators, signToHalt);

                if(n % 2 == 0) 
                {
                    swap(elements, i, n-1);
                } 
                else 
                {
                    swap(elements, 0, n-1);
                }
            }

            permute(n - 1, elements, intCodeList, output, iterators, signToHalt);
        }
    }
    private static void swap(int[] input, int a, int b) 
    {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    private static void permuteArray(int[] input, int[] intCodeList1, int[] intCodeList2, int[] intCodeList3, int[] intCodeList4, int[] intCodeList5, int output, int[] iterators, int[] signToHalt) throws Exception 
    {

        output = Day5_2.runIntCode(intCodeList1, input[0], output, iterators, 0, 0, signToHalt);
        output = Day5_2.runIntCode(intCodeList2, input[1], output, iterators, 1, 0, signToHalt);
        output = Day5_2.runIntCode(intCodeList3, input[2], output, iterators, 2, 0, signToHalt);
        output = Day5_2.runIntCode(intCodeList4, input[3], output, iterators, 3, 0, signToHalt);
        output = Day5_2.runIntCode(intCodeList5, input[4], output, iterators, 4, 0, signToHalt);
        
        while (signToHalt[0] == 0)
        {
            output = Day5_2.runIntCode(intCodeList1, output, output, iterators, 0, 3, signToHalt);
            output = Day5_2.runIntCode(intCodeList2, output, output, iterators, 1, 3, signToHalt);
            output = Day5_2.runIntCode(intCodeList3, output, output, iterators, 2, 3, signToHalt);
            output = Day5_2.runIntCode(intCodeList4, output, output, iterators, 3, 3, signToHalt);
            output = Day5_2.runIntCode(intCodeList5, output, output, iterators, 4, 3, signToHalt);
        }

        results.add(output);
    }
}