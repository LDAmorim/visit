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

package llnl.visit.operators;

import llnl.visit.AttributeSubject;
import llnl.visit.CommunicationBuffer;
import llnl.visit.Plugin;
import java.util.Vector;
import java.lang.Integer;
import java.lang.Double;

// ****************************************************************************
// Class: ThresholdAttributes
//
// Purpose:
//    This class contains attributes for the threshold operator.
//
// Notes:      Autogenerated by xml2java.
//
// Programmer: xml2java
// Creation:   Mon Sep 24 11:17:55 PDT 2007
//
// Modifications:
//   
// ****************************************************************************

public class ThresholdAttributes extends AttributeSubject implements Plugin
{
    // Enum values
    public final static int OUTPUTMESHTYPE_INPUTZONES = 0;
    public final static int OUTPUTMESHTYPE_POINTMESH = 1;

    public final static int ZONEPORTION_ENTIREZONE = 0;
    public final static int ZONEPORTION_PARTOFZONE = 1;


    public ThresholdAttributes()
    {
        super(7);

        outputMeshType = 0;
        listedVarNames = new Vector();
        listedVarNames.addElement(new String("default"));
        zonePortions = new Vector();
        lowerBounds = new Vector();
        upperBounds = new Vector();
        defaultVarName = new String("default");
        defaultVarIsScalar = false;
    }

    public ThresholdAttributes(ThresholdAttributes obj)
    {
        super(7);

        int i;

        outputMeshType = obj.outputMeshType;
        listedVarNames = new Vector(obj.listedVarNames.size());
        for(i = 0; i < obj.listedVarNames.size(); ++i)
            listedVarNames.addElement(new String((String)obj.listedVarNames.elementAt(i)));

        zonePortions = new Vector();
        for(i = 0; i < obj.zonePortions.size(); ++i)
        {
            Integer iv = (Integer)obj.zonePortions.elementAt(i);
            zonePortions.addElement(new Integer(iv.intValue()));
        }
        lowerBounds = new Vector(obj.lowerBounds.size());
        for(i = 0; i < obj.lowerBounds.size(); ++i)
        {
            Double dv = (Double)obj.lowerBounds.elementAt(i);
            lowerBounds.addElement(new Double(dv.doubleValue()));
        }

        upperBounds = new Vector(obj.upperBounds.size());
        for(i = 0; i < obj.upperBounds.size(); ++i)
        {
            Double dv = (Double)obj.upperBounds.elementAt(i);
            upperBounds.addElement(new Double(dv.doubleValue()));
        }

        defaultVarName = new String(obj.defaultVarName);
        defaultVarIsScalar = obj.defaultVarIsScalar;

        SelectAll();
    }

    public boolean equals(ThresholdAttributes obj)
    {
        int i;

        // Create the return value
        return ((outputMeshType == obj.outputMeshType) &&
                (listedVarNames == obj.listedVarNames) &&
                (zonePortions == obj.zonePortions) &&
                (lowerBounds == obj.lowerBounds) &&
                (upperBounds == obj.upperBounds) &&
                (defaultVarName == obj.defaultVarName) &&
                (defaultVarIsScalar == obj.defaultVarIsScalar));
    }

    public String GetName() { return "Threshold"; }
    public String GetVersion() { return "1.0"; }

    // Property setting methods
    public void SetOutputMeshType(int outputMeshType_)
    {
        outputMeshType = outputMeshType_;
        Select(0);
    }

    public void SetListedVarNames(Vector listedVarNames_)
    {
        listedVarNames = listedVarNames_;
        Select(1);
    }

    public void SetZonePortions(Vector zonePortions_)
    {
        zonePortions = zonePortions_;
        Select(2);
    }

    public void SetLowerBounds(Vector lowerBounds_)
    {
        lowerBounds = lowerBounds_;
        Select(3);
    }

    public void SetUpperBounds(Vector upperBounds_)
    {
        upperBounds = upperBounds_;
        Select(4);
    }

    public void SetDefaultVarName(String defaultVarName_)
    {
        defaultVarName = defaultVarName_;
        Select(5);
    }

    public void SetDefaultVarIsScalar(boolean defaultVarIsScalar_)
    {
        defaultVarIsScalar = defaultVarIsScalar_;
        Select(6);
    }

    // Property getting methods
    public int     GetOutputMeshType() { return outputMeshType; }
    public Vector  GetListedVarNames() { return listedVarNames; }
    public Vector  GetZonePortions() { return zonePortions; }
    public Vector  GetLowerBounds() { return lowerBounds; }
    public Vector  GetUpperBounds() { return upperBounds; }
    public String  GetDefaultVarName() { return defaultVarName; }
    public boolean GetDefaultVarIsScalar() { return defaultVarIsScalar; }

    // Write and read methods.
    public void WriteAtts(CommunicationBuffer buf)
    {
        if(WriteSelect(0, buf))
            buf.WriteInt(outputMeshType);
        if(WriteSelect(1, buf))
            buf.WriteStringVector(listedVarNames);
        if(WriteSelect(2, buf))
            buf.WriteIntVector(zonePortions);
        if(WriteSelect(3, buf))
            buf.WriteDoubleVector(lowerBounds);
        if(WriteSelect(4, buf))
            buf.WriteDoubleVector(upperBounds);
        if(WriteSelect(5, buf))
            buf.WriteString(defaultVarName);
        if(WriteSelect(6, buf))
            buf.WriteBool(defaultVarIsScalar);
    }

    public void ReadAtts(int n, CommunicationBuffer buf)
    {
        for(int i = 0; i < n; ++i)
        {
            int index = (int)buf.ReadByte();
            switch(index)
            {
            case 0:
                SetOutputMeshType(buf.ReadInt());
                break;
            case 1:
                SetListedVarNames(buf.ReadStringVector());
                break;
            case 2:
                SetZonePortions(buf.ReadIntVector());
                break;
            case 3:
                SetLowerBounds(buf.ReadDoubleVector());
                break;
            case 4:
                SetUpperBounds(buf.ReadDoubleVector());
                break;
            case 5:
                SetDefaultVarName(buf.ReadString());
                break;
            case 6:
                SetDefaultVarIsScalar(buf.ReadBool());
                break;
            }
        }
    }


    // Attributes
    private int     outputMeshType;
    private Vector  listedVarNames; // vector of String objects
    private Vector  zonePortions; // vector of Integer objects
    private Vector  lowerBounds; // vector of Double objects
    private Vector  upperBounds; // vector of Double objects
    private String  defaultVarName;
    private boolean defaultVarIsScalar;
}

