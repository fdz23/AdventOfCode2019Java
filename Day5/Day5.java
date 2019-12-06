package javatest.AdventOfCode2019Java.Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Day5 {
    public static void main(String[] args) throws IOException
    {
        try
        {
            String path = "javatest/AdventOfCode2019Java/Day5/puzzle5.txt";
            String data = Files.readAllLines(Paths.get(path)).get(0);
            //String data = "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9";

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
        
        for (int i = 0; i < intCodeList.length; i++)
        {
            intCodeList[i] = (Integer.parseInt(dataSplit[i]));
        }

        runIntCode(intCodeList);
    }

    public static void runIntCode(int[] intCodeList) throws Exception
    {
        for (int i = 0; i < intCodeList.length; )
        {
            //System.out.print(intCodeList[i]);
            //System.out.println("[" + i + "]");
            int[] instructions = getInstructions(intCodeList[i]);
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
                        firstParameter = intCodeList[intCodeList[i + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[i + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[i + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[i + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    intCodeList[intCodeList[i + 3]] = firstParameter + secondParameter;
                    //System.out.println("position " + intCodeList[i + 3] + " receives " + intCodeList[intCodeList[i + 3]]);

                    i += 4;

                    break;
                case 2 :
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[i + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[i + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[i + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[i + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    intCodeList[intCodeList[i + 3]] = firstParameter * secondParameter;
                    //System.out.println("position " + intCodeList[i + 3] + " receives " + intCodeList[intCodeList[i + 3]]);

                    i += 4;

                    break;
                    
                case 3:
                    Scanner read = new Scanner(System.in);
                    System.out.println("Type the input : ");
                    int input = read.nextInt();

                    intCodeList[intCodeList[i + 1]] = input;

                    i += 2;

                    break;
                case 4:
                    int output = intCodeList[intCodeList[i + 1]];

                    System.out.println("Output is : " + output + ".");

                    i += 2;

                    break;
                case 5:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[i + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[i + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[i + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[i + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter != 0)
                    {
                        i = secondParameter;
                    }
                    else i += 3;

                    break;
                case 6:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[i + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[i + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[i + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[i + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter == 0)
                    {
                        i = secondParameter;
                    }
                    else i += 3;

                    break;
                case 7:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[i + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[i + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[i + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[i + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter < secondParameter)
                    {
                        intCodeList[intCodeList[i + 3]] = 1;
                    }
                    else
                    {
                        intCodeList[intCodeList[i + 3]] = 0;
                    }
                    
                    i += 4;

                    break;
                case 8:
                    if (mode1 == 0)
                    {
                        firstParameter = intCodeList[intCodeList[i + 1]];
                        //System.out.println("firstParameter receives " + intCodeList[intCodeList[i + 1]] + " from position" + intCodeList[i + 1]);
                    }
                    else 
                    {
                        firstParameter = intCodeList[i + 1];
                        //System.out.println("firstParameter receives " + intCodeList[i + 1] + " from position" + (i + 1));
                    }
                    if (mode2 == 0)
                    {
                        secondParameter = intCodeList[intCodeList[i + 2]];
                        //System.out.println("secondParameter receives " + intCodeList[intCodeList[i + 2]] + " from position" + intCodeList[i + 2]);
                    }
                    else 
                    {
                        secondParameter = intCodeList[i + 2];
                        //System.out.println("secondParameter receives " + intCodeList[i + 2] + " from position" + (i + 2));
                    }
                    if (firstParameter == secondParameter)
                    {
                        intCodeList[intCodeList[i + 3]] = 1;
                    }
                    else
                    {
                        intCodeList[intCodeList[i + 3]] = 0;
                    }

                    i += 4;

                    break;
                case 99:
                    throw new Exception("System halt!");
                default:
                    throw new Exception("Error! number entered : " + opCode + " isn't 1, 2, 3, 4, 5, 6, 7, 8 or 99!");
            }
        }
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