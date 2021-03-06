// Copyright (c) Lawrence Livermore National Security, LLC and other VisIt
// Project developers.  See the top-level LICENSE file for dates and other
// details.  No copyright assignment is required to contribute to VisIt.

// ****************************************************************************
//  File: SliceEnginePluginInfo.C
// ****************************************************************************

#include <SlicePluginInfo.h>
#include <avtSliceFilter.h>

VISIT_OPERATOR_PLUGIN_ENTRY_EV(Slice,Engine)

// ****************************************************************************
//  Method: SliceEnginePluginInfo::AllocAvtPluginFilter
//
//  Purpose:
//    Return a pointer to a newly allocated avtPluginFilter.
//
//  Returns:    A pointer to the newly allocated avtPluginFilter.
//
//  Programmer: generated by xml2info
//  Creation:   omitted
//
// ****************************************************************************

avtPluginFilter *
SliceEnginePluginInfo::AllocAvtPluginFilter()
{
    return new avtSliceFilter;
}
