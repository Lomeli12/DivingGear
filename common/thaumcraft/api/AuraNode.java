package thaumcraft.api;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuraNode implements Serializable
{
    // key
    public int key;

    // aura
    public short level;
    public short baseLevel;
    public ObjectTags flux = new ObjectTags();
    public EnumNodeType type;

    // location
    public int dimension;
    public double xPos;
    public double yPos;
    public double zPos;
    public boolean locked;

    public AuraNode(int key, short lvl, EnumNodeType type, int dim, int x,
            int y, int z)
    {
        this.key = key;
        level = lvl;
        baseLevel = lvl;
        this.type = type;
        dimension = dim;
        xPos = x + .5d;
        yPos = y + .5d;
        zPos = z + .5d;
    }

    public AuraNode()
    {
    }

}
