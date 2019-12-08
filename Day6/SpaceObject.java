package javatest.AdventOfCode2019Java.Day6;

import java.util.ArrayList;
import java.util.List;

public class SpaceObject
{
    private SpaceObject parent;
    private String name;

    public SpaceObject(String name)
    {
        this.name = name;
    }

    public List<SpaceObject> getListToCOM()
    {
        List<SpaceObject> listToCOM = new ArrayList();
        SpaceObject parentObject = parent;

        while (parentObject != null)
        {
            listToCOM.add(parentObject);
            parentObject = parentObject.parent;
        }

        return listToCOM;
    }

    public int getOrbitCount()
    {
        int orbitCount = 0;
        SpaceObject parentObject = parent;

        while (parentObject != null)
        {
            orbitCount++;
            parentObject = parentObject.parent;
        }

        return orbitCount;
    }

    public String getName()
    {
        return name;
    }

    public SpaceObject getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(SpaceObject parent) {
        this.parent = parent;
    }
}