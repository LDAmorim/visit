// Copyright (c) Lawrence Livermore National Security, LLC and other VisIt
// Project developers.  See the top-level LICENSE file for dates and other
// details.  No copyright assignment is required to contribute to VisIt.

// ************************************************************************* //
//  File: avtRemapFilter.h
// ************************************************************************* //

#ifndef AVT_Remap_FILTER_H
#define AVT_Remap_FILTER_H

#include <avtDatasetToDatasetFilter.h>
#include <avtPluginFilter.h>

#include <RemapAttributes.h>

#include <vtkDataSet.h>
#include <vtkRectilinearGrid.h>
#include <vtkDoubleArray.h>
#include <vtkImplicitBoolean.h>




// ****************************************************************************
//  Class: avtRemapFilter
//
//  Purpose:
//      A plugin operator for Remap.
//
//  Programmer: rusu1 -- generated by xml2avt
//  Creation:   Tue Oct 23 14:58:25 PST 2018
//
// ****************************************************************************

class avtRemapFilter : public avtDatasetToDatasetFilter,
                       public virtual avtPluginFilter
{
  public:
                         avtRemapFilter();
    virtual             ~avtRemapFilter();

    static avtFilter    *Create();

    virtual const char  *GetType(void)  { return "avtRemapFilter"; };
    virtual const char  *GetDescription(void)
                             { return "Remap"; };

    virtual void         SetAtts(const AttributeGroup*);
    virtual bool         Equivalent(const AttributeGroup*);

  protected:
    RemapAttributes     atts;

    virtual void        Execute(void);
    void                TraverseDomainTree(avtDataTree_p);
    void                ClipDomain(avtDataTree_p);
    
  private:
  
    // ------------------------ //
    // --- Helper Functions --- //
    // ------------------------ //
    vtkDoubleArray      *CalculateCellVolumes(vtkDataSet*, const char* name = "");
    void                GetBounds();
    void                CreateGrid(int, int, int, int, int, int, int, int, int);
    void                CreateGrid(int, int, int, int, int, int);
    vtkDataArray        *GetCoordinates(double, double, int, int, int);
    void                MakeClippingFunction(int, int);
    void                CleanClippingFunctions();
    
    
    // -------------------- //
    // --- Class Fields --- //
    // -------------------- //
    vtkRectilinearGrid* rg;
    double              rGridBounds[6];
    double              rCellVolume;
    vtkDoubleArray*     vars;
    bool                is3D;      
    std::vector<vtkImplicitBoolean*> funcsArrayX;
    std::vector<vtkImplicitBoolean*> funcsArrayY;
    std::vector<vtkImplicitBoolean*> funcsArrayZ;
  
};


#endif
