/**
 * Copyright (c) Jadar, 2013
 * Developer Capes API by Jadar
 * 
 * version 1.3.1
 */
package net.lomeli.diving.core.capes;

public class DeveloperCapesUser
{

    private final String username;
    private final String group;

    DeveloperCapesUser(String parUsername, String parGroup)
    {
        username = parUsername;
        group = parGroup;

    }

    public String getUsername()
    {
        return username;
    }

    public String getGroup()
    {
        return group;
    }
}