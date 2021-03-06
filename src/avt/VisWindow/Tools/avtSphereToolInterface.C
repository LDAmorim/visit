// Copyright (c) Lawrence Livermore National Security, LLC and other VisIt
// Project developers.  See the top-level LICENSE file for dates and other
// details.  No copyright assignment is required to contribute to VisIt.

#include <avtSphereToolInterface.h>
#include <SphereAttributes.h>

avtSphereToolInterface::avtSphereToolInterface(const VisWindow *v) :
    avtToolInterface(v)
{
    atts = new SphereAttributes;
}

avtSphereToolInterface::~avtSphereToolInterface()
{
    // nothing
}

void
avtSphereToolInterface::SetOrigin(double x, double y, double z)
{
    SphereAttributes *p = (SphereAttributes *)atts;
    double d[3] = {x, y, z};
    p->SetOrigin(d);
}

void
avtSphereToolInterface::SetRadius(const double radius)
{
    SphereAttributes *p = (SphereAttributes *)atts;
    p->SetRadius(radius);
}

const double *
avtSphereToolInterface::GetOrigin() const
{
    SphereAttributes *p = (SphereAttributes *)atts;
    return p->GetOrigin();
}

double
avtSphereToolInterface::GetRadius() const
{
    SphereAttributes *p = (SphereAttributes *)atts;
    return p->GetRadius();
}
