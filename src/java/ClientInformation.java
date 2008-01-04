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
// Class: ClientInformation
//
// Purpose:
//    This class contains the attributes that describe the client
//
// Notes:      Autogenerated by xml2java.
//
// Programmer: xml2java
// Creation:   Wed Mar 14 17:54:42 PST 2007
//
// Modifications:
//   
// ****************************************************************************

public class ClientInformation extends AttributeSubject
{
    public ClientInformation()
    {
        super(3);

        clientName = new String("");
        methodNames = new Vector();
        methodPrototypes = new Vector();
    }

    public ClientInformation(ClientInformation obj)
    {
        super(3);

        int i;

        clientName = new String(obj.clientName);
        methodNames = new Vector(obj.methodNames.size());
        for(i = 0; i < obj.methodNames.size(); ++i)
            methodNames.addElement(new String((String)obj.methodNames.elementAt(i)));

        methodPrototypes = new Vector(obj.methodPrototypes.size());
        for(i = 0; i < obj.methodPrototypes.size(); ++i)
            methodPrototypes.addElement(new String((String)obj.methodPrototypes.elementAt(i)));


        SelectAll();
    }

    public boolean equals(ClientInformation obj)
    {
        int i;

        // Create the return value
        return ((clientName == obj.clientName) &&
                (methodNames == obj.methodNames) &&
                (methodPrototypes == obj.methodPrototypes));
    }

    // Property setting methods
    public void SetClientName(String clientName_)
    {
        clientName = clientName_;
        Select(0);
    }

    public void SetMethodNames(Vector methodNames_)
    {
        methodNames = methodNames_;
        Select(1);
    }

    public void SetMethodPrototypes(Vector methodPrototypes_)
    {
        methodPrototypes = methodPrototypes_;
        Select(2);
    }

    // Property getting methods
    public String GetClientName() { return clientName; }
    public Vector GetMethodNames() { return methodNames; }
    public Vector GetMethodPrototypes() { return methodPrototypes; }

    // Write and read methods.
    public void WriteAtts(CommunicationBuffer buf)
    {
        if(WriteSelect(0, buf))
            buf.WriteString(clientName);
        if(WriteSelect(1, buf))
            buf.WriteStringVector(methodNames);
        if(WriteSelect(2, buf))
            buf.WriteStringVector(methodPrototypes);
    }

    public void ReadAtts(int n, CommunicationBuffer buf)
    {
        for(int i = 0; i < n; ++i)
        {
            int index = (int)buf.ReadByte();
            switch(index)
            {
            case 0:
                SetClientName(buf.ReadString());
                break;
            case 1:
                SetMethodNames(buf.ReadStringVector());
                break;
            case 2:
                SetMethodPrototypes(buf.ReadStringVector());
                break;
            }
        }
    }


    // Attributes
    private String clientName;
    private Vector methodNames; // vector of String objects
    private Vector methodPrototypes; // vector of String objects
}

