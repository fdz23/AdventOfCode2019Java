package javatest.AdventOfCode2019Java.Day8;

public class Layer
{
    private int[][] image = new int[25][6];

    public Layer(int[][] image)
    {
        this.image = image;
    }

    public void compareLayers(Layer layer)
    {
        int[][] layerImage = layer.getImage();

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 25; j++)
            {
                if (layerImage[j][i] == 0 && image[j][i] == 2)
                {
                    image[j][i] = 0;
                }
                if (layerImage[j][i] == 1 && image[j][i] == 2)
                {
                    image[j][i] = 1;
                }
            }
        }
    }

    public int[][] getImage()
    {
        return image;
    }

    public void printLayer()
    {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 25; j++)
            {
                System.out.print(image[j][i] + " ");
            }
            System.out.println();
        }
    }

    public int getNumberOfZeros()
    {
        int zeroCounter = 0;

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 25; j++)
            {
                if (image[j][i] == 0)
                {
                    zeroCounter++;
                }
            }
        }

        return zeroCounter;
    }

    public int getNumberOfOnes()
    {
        int oneCounter = 0;

        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if (image[i][j] == 1)
                {
                    oneCounter++;
                }
            }
        }

        return oneCounter;
    }

    public int getNumberOfTwos()
    {
        int twoCounter = 0;

        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if (image[i][j] == 2)
                {
                    twoCounter++;
                }
            }
        }

        return twoCounter;
    }

    public int[][] deepCopy(int[][] matrix) 
    {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }
}