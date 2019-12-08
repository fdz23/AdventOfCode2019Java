package javatest.AdventOfCode2019Java.Day6;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javatest.AdventOfCode2019Java.Day6.SpaceObject;

public class Day6 {
    public static void main(String[] args){
        try 
        {
            String path = "javatest/AdventOfCode2019Java/Day6/puzzle6.txt";
            List<String> stringList = Files.readAllLines(Paths.get(path));
            String start = "YOU";
            String target = "SAN";

            List<SpaceObject> objectList = getObjectList(stringList);
            List<SpaceObject> updatedList = orderParents(objectList, stringList);

            int resultPart1 = getOrbitCount(updatedList);
            int resultPart2 = getShortestPath(start, target, updatedList);

            System.out.println("The first result is : " + resultPart1);
            System.out.println("The second result is : " + resultPart2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int getShortestPath(String start, String target, List<SpaceObject> updatedList)
    {
        int result = 0;
        List<SpaceObject> startPathToCOM = new ArrayList();
        List<SpaceObject> targetPathToCOM = new ArrayList();
        SpaceObject objectToCompare = new SpaceObject("LUL");

        for (SpaceObject object : updatedList)
        {
            if (object.getName().equals(start))
            {
                startPathToCOM = object.getListToCOM();
            }
            if (object.getName().equals(target))
            {
                targetPathToCOM = object.getListToCOM();
            }
        }

        outerloop:
        for (SpaceObject object : startPathToCOM)
        {
            for (SpaceObject object2 : targetPathToCOM)
            {
                if (object.getParent() != null && object2.getParent() != null)
                {
                    if (object.getParent().equals(object2.getParent()))
                    {
                        objectToCompare = object.getParent();
                        break outerloop;
                    }
                }
            }
        }

        for (SpaceObject object : startPathToCOM)
        {
            result++;
            if (object.getParent().equals(objectToCompare))
            {
                break;
            }
        }

        for (SpaceObject object : targetPathToCOM)
        {
            result++;
            if (object.getParent().equals(objectToCompare))
            {
                break;
            }
        }

        return result;
    }

    public static int getOrbitCount(List<SpaceObject> updatedList)
    {
        int result = 0;

        for (SpaceObject object : updatedList)
        {
            result += object.getOrbitCount();
        }

        return result;
    }

    public static List<SpaceObject> orderParents(List<SpaceObject> objectList, List<String> stringList)
    {
        for (String line : stringList)
        {
            String[] lineSplit = line.split("\\)");

            String parentName = lineSplit[0];
            String childName = lineSplit[1];

            for (SpaceObject object : objectList)
            {
                if (object.getName().equals(childName))
                {
                    for (SpaceObject object2 : objectList)
                    {
                        if (object2.getName().equals(parentName))
                        {
                            object.setParent(object2);
                        }
                    }
                }
            }
        }

        return objectList;
    }

    public static List<SpaceObject> getObjectList(List<String> stringList)
    {
        List<SpaceObject> objectList = new ArrayList();

        for (String line : stringList)
        {
            String[] lineSplit = line.split("\\)");

            String parentName = lineSplit[0];
            String childName = lineSplit[1];

            int aux = 0;
            int aux2 = 0;

            if (objectList.isEmpty())
            {
                objectList.add(new SpaceObject(parentName));
                objectList.add(new SpaceObject(childName));
            }

            for (SpaceObject object : objectList)
            {
                if (object.getName().equals(parentName))
                {
                    aux++;
                }

                if (object.getName().equals(childName))
                {
                    aux2++;
                }
            }

            if (aux == 0)
            {
                objectList.add(new SpaceObject(parentName));
            }
            if (aux2 == 0)
            {
                objectList.add(new SpaceObject(childName));
            }
        }

        return objectList;
    }
}