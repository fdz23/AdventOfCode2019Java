package javatest.AdventOfCode2019Java.Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Day5_2 {
    public static void main(String[] args) throws IOException
    {
        try
        {
            String path = "javatest/AdventOfCode2019Java/Day5/puzzle5.txt";
            String data = Files.readAllLines(Paths.get(path)).get(0);

            getDiagnostic(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void getDiagnostic(String data) throws Exception
    {
        String[] dataSplit = data.split(",");
        int[] intCodeList = new int[dataSplit.length];
        int input = 5;
        
        for (int i = 0; i < intCodeList.length; i++)
        {
            intCodeList[i] = (Integer.parseInt(dataSplit[i]));
        }

        //runIntCode(intCodeList, input);
    }

    public static int runIntCode(int[] intCodeList, int input1, int input2, int[] iterator, int amp, int inputOrder, int[] signToHalt) throws Exception
    {
        int output = 0;

        while (iterator[amp] < intCodeList.length)
        {
            boolean finish = false;

            if (finish == true) break;

            int[] instructions = getInstructions(intCodeList[iterator[amp]]);
            int opCode = instructions[4] + (instructions[3] * 10);
            int mode1 = instructions[2];
            int mode2 = instructions[1];
            int firstParameter = 0;
            int secondParameter = 0;

            switch (opCode)
            {
                case 1 :
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[iterator[amp] + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[iterator[amp] + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[iterator[amp] + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[iterator[amp] + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    intCodeList[intCodeList[iterator[amp] + 3]] = firstParameter + secondParameter;
                    //System.out.println("position " + intCodeList[i + 3] + " receives " + intCodeList[intCodeList[i + 3]]);

                    iterator[amp] += 4;

                    break;
                case 2 :
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[iterator[amp] + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[iterator[amp] + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[iterator[amp] + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[iterator[amp] + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    intCodeList[intCodeList[iterator[amp] + 3]] = firstParameter * secondParameter;
                    //System.out.println("position " + intCodeList[i + 3] + " receives " + intCodeList[intCodeList[i + 3]]);

                    iterator[amp] += 4;

                    break;
                    
                case 3:
                    if (inputOrder == 0)
                    {
                        inputOrder = 1;
                        intCodeList[intCodeList[iterator[amp] + 1]] = input1;
                    }
                    else if (inputOrder == 1)
                    {
                        inputOrder = 2;
                        intCodeList[intCodeList[iterator[amp] + 1]] = input2;
                    }
                    else if (inputOrder == 2)
                    {
                        return output;
                    }
                    else
                    {
                        intCodeList[intCodeList[iterator[amp] + 1]] = input1;
                        inputOrder = 2;
                    }

                    iterator[amp] += 2;

                    break;
                case 4:
                    output = intCodeList[intCodeList[iterator[amp] + 1]];

                    iterator[amp] += 2;

                    break;
                case 5:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[iterator[amp] + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[iterator[amp] + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[iterator[amp] + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[iterator[amp] + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter != 0)
                    {
                        iterator[amp] = secondParameter;
                    }
                    else iterator[amp] += 3;

                    break;
                case 6:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[iterator[amp] + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[iterator[amp] + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[iterator[amp] + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[iterator[amp] + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter == 0)
                    {
                        iterator[amp] = secondParameter;
                    }
                    else iterator[amp] += 3;

                    break;
                case 7:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[iterator[amp] + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[iterator[amp] + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[iterator[amp] + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[iterator[amp] + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter < secondParameter)
                    {
                        intCodeList[intCodeList[iterator[amp] + 3]] = 1;
                    }
                    else
                    {
                        intCodeList[intCodeList[iterator[amp] + 3]] = 0;
                    }
                    
                    iterator[amp] += 4;

                    break;
                case 8:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[iterator[amp] + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[iterator[amp] + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[iterator[amp] + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[iterator[amp] + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter == secondParameter)
                    {
                        intCodeList[intCodeList[iterator[amp] + 3]] = 1;
                    }
                    else
                    {
                        intCodeList[intCodeList[iterator[amp] + 3]] = 0;
                    }

                    iterator[amp] += 4;

                    break;
                case 99:
                    if (amp == 4)
                    {
                        signToHalt[0] = 1;
                        System.out.println("System halt!!! output : " + output);
                    }
                    return output;
                default:
                    throw new Exception("Error! number entered : " + opCode + " isn't 1, 2, 3, 4, 5, 6, 7, 8 or 99!");
            }
        }
        return output;
    }

    public static int[] getInstructions(int opCode)
    {
        String number = Integer.toString(opCode);
        int[] instructions = new int[5];
        int numberOfInstructions = number.toCharArray().length;

        //System.out.println("number : " + number);

        for (int i = 0; i < instructions.length; i++)
        {
            instructions[i] = 0;
            //System.out.println("instructions[" + i + "]" + instructions[i]);
        }

        int j = 4;
        int k = numberOfInstructions - 1;

        for (int i = 0; i < numberOfInstructions; i++)
        {
            instructions[j] = Character.getNumericValue(number.charAt(k));
            //System.out.println("instructions[" + j + "]" + instructions[j]);
            j--;
            k--;
        }

        for (int i = 0; i < instructions.length; i++)
        {
            //System.out.println("instructions[" + i + "]" + instructions[i]);
        }

        return instructions;
    }
}