package javatest.AdventOfCode2019Java.Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javatest.AdventOfCode2019Java.Day8.*;

public class Day8 
{
    public static void main(String[] args) 
    {
        
        try 
        {
            String path = "javatest/AdventOfCode2019Java/Day8/puzzle8.txt";
            String data = Files.readAllLines(Paths.get(path)).get(0);
            int[][] inputImage = new int[25][6];
            int index = 0;
            List<Layer> layers = new ArrayList();
            int compare = Integer.MAX_VALUE;
            int indexOfLayerFewerZero = 0;
            int numberOfOnes = 0;
            int numberOfTwos = 0;
            int result = 0;

            while (index < data.length())
            {
                for (int j = 0; j < 6; j++)
                {
                    for (int i = 0; i < 25; i++)
                    {
                        inputImage[i][j] = Character.getNumericValue(data.charAt(index));
                        index++;
                    }
                }

                Layer newLayer = new Layer(deepCopy(inputImage));
                layers.add(newLayer);
            }

            for (Layer layer : layers) 
            {
                if (layer.getNumberOfZeros() < compare) 
                {
                    compare = layer.getNumberOfZeros();
                    indexOfLayerFewerZero = layers.indexOf(layer);
                }
            }

            numberOfOnes = layers.get(indexOfLayerFewerZero).getNumberOfOnes();
            numberOfTwos = layers.get(indexOfLayerFewerZero).getNumberOfTwos();

            result = numberOfOnes * numberOfTwos;

            System.out.println("Part 1 result : " + result);
            System.out.println("Part 2 result : ");
            transformLayersIntoImage(layers).printLayer();

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static Layer transformLayersIntoImage(List<Layer> layers)
    {
        Layer finalLayer = new Layer(deepCopy(layers.get(0).getImage()));

        for (Layer layer : layers)
        {
            finalLayer.compareLayers(layer);
        }

        return finalLayer;
    }

    public static int[][] deepCopy(int[][] matrix) 
    {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }
}