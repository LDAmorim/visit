// ***************************************************************************
//
// Copyright (c) 2000 - 2008, Lawrence Livermore National Security, LLC
// Produced at the Lawrence Livermore National Laboratory
// LLNL-CODE-400142
// All rights reserved.
//
// This file is  part of VisIt. For  details, see https://visit.llnl.gov/.  The
// full copyright notice is contained in the file COPYRIGHT located at the root
// of the VisIt distribution or at http://www.llnl.gov/visit/copyright.html.
//
// Redistribution  and  use  in  source  and  binary  forms,  with  or  without
// modification, are permitted provided that the following conditions are met:
//
//  - Redistributions of  source code must  retain the above  copyright notice,
//    this list of conditions and the disclaimer below.
//  - Redistributions in binary form must reproduce the above copyright notice,
//    this  list of  conditions  and  the  disclaimer (as noted below)  in  the
//    documentation and/or other materials provided with the distribution.
//  - Neither the name of  the LLNS/LLNL nor the names of  its contributors may
//    be used to endorse or promote products derived from this software without
//    specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT  HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR  IMPLIED WARRANTIES, INCLUDING,  BUT NOT  LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND  FITNESS FOR A PARTICULAR  PURPOSE
// ARE  DISCLAIMED. IN  NO EVENT  SHALL LAWRENCE  LIVERMORE NATIONAL  SECURITY,
// LLC, THE  U.S.  DEPARTMENT OF  ENERGY  OR  CONTRIBUTORS BE  LIABLE  FOR  ANY
// DIRECT,  INDIRECT,   INCIDENTAL,   SPECIAL,   EXEMPLARY,  OR   CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT  LIMITED TO, PROCUREMENT OF  SUBSTITUTE GOODS OR
// SERVICES; LOSS OF  USE, DATA, OR PROFITS; OR  BUSINESS INTERRUPTION) HOWEVER
// CAUSED  AND  ON  ANY  THEORY  OF  LIABILITY,  WHETHER  IN  CONTRACT,  STRICT
// LIABILITY, OR TORT  (INCLUDING NEGLIGENCE OR OTHERWISE)  ARISING IN ANY  WAY
// OUT OF THE  USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
// DAMAGE.
//
// ***************************************************************************

package llnl.visit;

import java.util.Vector;

// ****************************************************************************
// Class: ColorTableAttributes
//
// Purpose:
//    This class contains the list of colortables.
//
// Notes:      Autogenerated by xml2java.
//
// Programmer: xml2java
// Creation:   Wed Mar 14 17:54:46 PST 2007
//
// Modifications:
//   Brad Whitlock, Thu Dec 12 10:38:14 PDT 2002
//   This file has some methods that need to be added back in if the file is
//   ever regenerated.
//   
// ****************************************************************************

public class ColorTableAttributes extends AttributeSubject
{
    public ColorTableAttributes()
    {
        super(4);

        names = new Vector();
        colorTables = new Vector();
        activeContinuous = new String("hot");
        activeDiscrete = new String("levels");
    }

    public ColorTableAttributes(ColorTableAttributes obj)
    {
        super(4);

        int i;

        names = new Vector(obj.names.size());
        for(i = 0; i < obj.names.size(); ++i)
            names.addElement(new String((String)obj.names.elementAt(i)));

        // *** Copy the colorTables field ***
        colorTables = new Vector(obj.colorTables.size());
        for(i = 0; i < obj.colorTables.size(); ++i)
        {
            ColorControlPointList newObj = (ColorControlPointList)colorTables.elementAt(i);
            colorTables.addElement(new ColorControlPointList(newObj));
        }

        activeContinuous = new String(obj.activeContinuous);
        activeDiscrete = new String(obj.activeDiscrete);

        SelectAll();
    }

    public boolean equals(ColorTableAttributes obj)
    {
        int i;

        boolean colorTables_equal = (obj.colorTables.size() == colorTables.size());
        for(i = 0; (i < colorTables.size()) && colorTables_equal; ++i)
        {
            // Make references to ColorControlPointList from Object.
            ColorControlPointList colorTables1 = (ColorControlPointList)colorTables.elementAt(i);
            ColorControlPointList colorTables2 = (ColorControlPointList)obj.colorTables.elementAt(i);
            colorTables_equal = colorTables1.equals(colorTables2);
        }

        // Create the return value
        return ((names == obj.names) &&
                colorTables_equal &&
                (activeContinuous == obj.activeContinuous) &&
                (activeDiscrete == obj.activeDiscrete));
    }

    // Property setting methods
    public void SetNames(Vector names_)
    {
        names = names_;
        Select(0);
    }

    public void SetActiveContinuous(String activeContinuous_)
    {
        activeContinuous = activeContinuous_;
        Select(2);
    }

    public void SetActiveDiscrete(String activeDiscrete_)
    {
        activeDiscrete = activeDiscrete_;
        Select(3);
    }

    // Property getting methods
    public Vector GetNames() { return names; }
    public Vector GetColorTables() { return colorTables; }
    public String GetActiveContinuous() { return activeContinuous; }
    public String GetActiveDiscrete() { return activeDiscrete; }

    // Write and read methods.
    public void WriteAtts(CommunicationBuffer buf)
    {
        if(WriteSelect(0, buf))
            buf.WriteStringVector(names);
        if(WriteSelect(1, buf))
        {
            buf.WriteInt(colorTables.size());
            for(int i = 0; i < colorTables.size(); ++i)
            {
                ColorControlPointList tmp = (ColorControlPointList)colorTables.elementAt(i);
                tmp.Write(buf);
            }
        }
        if(WriteSelect(2, buf))
            buf.WriteString(activeContinuous);
        if(WriteSelect(3, buf))
            buf.WriteString(activeDiscrete);
    }

    public void ReadAtts(int n, CommunicationBuffer buf)
    {
        for(int i = 0; i < n; ++i)
        {
            int index = (int)buf.ReadByte();
            switch(index)
            {
            case 0:
                SetNames(buf.ReadStringVector());
                break;
            case 1:
                {
                    int len = buf.ReadInt();
                    colorTables.clear();
                    for(int j = 0; j < len; ++j)
                    {
                        ColorControlPointList tmp = new ColorControlPointList();
                        tmp.Read(buf);
                        colorTables.addElement(tmp);
                    }
                }
                Select(1);
                break;
            case 2:
                SetActiveContinuous(buf.ReadString());
                break;
            case 3:
                SetActiveDiscrete(buf.ReadString());
                break;
            }
        }
    }

    // Attributegroup convenience methods
    public void AddColorTables(ColorControlPointList obj)
    {
        colorTables.addElement(new ColorControlPointList(obj));
        Select(1);
    }

    public void ClearColorTables()
    {
        colorTables.clear();
        Select(1);
    }

    public void RemoveColorTables(int index)
    {
        if(index >= 0 && index < colorTables.size())
        {
            colorTables.remove(index);
            Select(1);
        }
    }

    public int GetNumColorTables()
    {
        return colorTables.size();
    }

    public ColorControlPointList GetColorTables(int i)
    {
        ColorControlPointList tmp = (ColorControlPointList)colorTables.elementAt(i);
        return tmp;
    }

 // Added methods
    public int GetColorTableIndex(String name)
    {
        int retval = -1;
        for(int i = 0; i < names.size(); ++i)
        {
            String n = (String)names.elementAt(i);
            if(n.equals(name))
            {
                retval = i;
                break;
            }
        }

        return retval;
    }

    public ColorControlPointList GetColorControlPoints(int index)
    {
        if(index >= 0 && index < colorTables.size())
            return (ColorControlPointList)colorTables.elementAt(index);
        else
            return null;
    }

    public ColorControlPointList GetColorControlPoints(String name)
    {
        int index = GetColorTableIndex(name);
        if(index >= 0 && index < colorTables.size())
            return (ColorControlPointList)colorTables.elementAt(index);
        else
            return null;
    }

    public ColorControlPointList GetActiveColorControlPoints()
    {
        int index = GetColorTableIndex(activeContinuous);
        if(index >= 0 && index < colorTables.size())
            return (ColorControlPointList)colorTables.elementAt(index);
        else
            return null;
    }

    public void AddColorTable(String name, ColorControlPointList cpts)
    {
        names.addElement(new String(name));
        Select(0);
        AddColorTables(cpts);
    }

    public void RemoveColorTable(String name)
    {
        int index = GetColorTableIndex(name);
        RemoveColorTable(index);
    }

    public void RemoveColorTable(int index)
    {
        if(index >= 0 && index < names.size())
        {
            String nameAt = (String)names.elementAt(index);
            boolean isActiveContinuous = nameAt.equals(activeContinuous);
            boolean isActiveDiscrete = nameAt.equals(activeDiscrete);

            // Remove the name from the vector.
            names.remove(index);
            Select(0);

            // Remove the color table from the vector.
            RemoveColorTables(index);

            // If it is the active color table that was removed, reset the
            // active color table to the first element.
            if(isActiveContinuous)
            {
                if(names.size() > 0)
                {
                    nameAt = (String)names.elementAt(0);
                    SetActiveContinuous(nameAt);
                }
                else
                    SetActiveContinuous("");
            }
            if(isActiveDiscrete)
            {
                if(names.size() > 0)
                {
                    nameAt = (String)names.elementAt(0);
                    SetActiveDiscrete(nameAt);
                }
                else
                    SetActiveDiscrete("");
            }
        }
    }

    // Attributes
    private Vector names; // vector of String objects
    private Vector colorTables; // vector of ColorControlPointList objects
    private String activeContinuous;
    private String activeDiscrete;
}

