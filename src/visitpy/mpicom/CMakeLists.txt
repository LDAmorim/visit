# Copyright (c) Lawrence Livermore National Security, LLC and other VisIt
# Project developers.  See the top-level LICENSE file for dates and other
# details.  No copyright assignment is required to contribute to VisIt.

#****************************************************************************
# Modifications:
#  Cyrus Harrison, Wed Mar 10 11:06:40 PST 2010 
#  Use CMAKE_LIBRARY_OUTPUT_DIRECTORY instead of LIBRARY_OUTPUT_DIRECTORY.
#
#  Cyrus Harrison,Thu Apr  5 09:14:27 PDT 2012
#  Use new python module creation setup.
#
#  Kathleen Biagas, Thu Jun 21 11:32:12 PST 2012 
#  Change how parallel flags are handled on windows. 
#
#  Kathleen Biagas, Thu Sep 27 11:35:34 PDT 2018
#  Change PYTHON_LIBRARIES to PYTHON_LIBRARY for consistency throughout visit.
#
#****************************************************************************

SET(MPICOM_PY_SOURCES py_src/__init__.py
                      py_src/mpistub.py)

# if we have a parallel build - create the mpicom python C module.
IF(VISIT_PARALLEL)
    SET(MPICOM_SOURCES
        src/mpicom.C
        src/Buffer.C)

    INCLUDE_DIRECTORIES(${CMAKE_CURRENT_SOURCE_DIR}/src/
                        ${PYTHON_INCLUDE_PATH})

    LINK_DIRECTORIES(${LIBRARY_OUTPUT_DIRECTORY})


    # Create the mpicom
    PYTHON_ADD_HYBRID_MODULE(mpicom
                             site-packages
                             setup.py
                             "${MPICOM_PY_SOURCES}"
                             ${MPICOM_SOURCES})

    SET_TARGET_PROPERTIES(mpicom PROPERTIES COMPILE_FLAGS "-fno-strict-aliasing")

    IF(UNIX)
        IF(VISIT_PARALLEL_CXXFLAGS)
            SET(PAR_COMPILE_FLAGS "-fno-strict-aliasing")
            FOREACH (X ${VISIT_PARALLEL_CXXFLAGS})
                SET(PAR_COMPILE_FLAGS "${PAR_COMPILE_FLAGS} ${X}")
            ENDFOREACH (X ${VISIT_PARALLEL_CXXFLAGS})
            SET_TARGET_PROPERTIES(mpicom PROPERTIES
                                  COMPILE_FLAGS ${PAR_COMPILE_FLAGS})
        ENDIF(VISIT_PARALLEL_CXXFLAGS)
        IF(VISIT_PARALLEL_LINKER_FLAGS)
            SET(PAR_LINK_FLAGS "")
            FOREACH (X ${VISIT_PARALLEL_LINKER_FLAGS})
                SET(PAR_LINK_FLAGS "${PAR_LINK_FLAGS} ${X}")
            ENDFOREACH (X ${VISIT_PARALLEL_LINKER_FLAGS})
            SET_TARGET_PROPERTIES(mpicom PROPERTIES
                              LINK_FLAGS ${PAR_LINK_FLAGS})
        ENDIF(VISIT_PARALLEL_LINKER_FLAGS)
    ELSE(UNIX)
        ADD_TARGET_INCLUDE(mpicom ${VISIT_PARALLEL_INCLUDE})
        ADD_TARGET_DEFINITIONS(mpicom ${VISIT_PARALLEL_DEFS})
    ENDIF(UNIX)

    TARGET_LINK_LIBRARIES(mpicom
                          ${PYTHON_LIBRARY}
                          ${VISIT_PARALLEL_LIBS})

ELSE(VISIT_PARALLEL)
    # we still need to build the module w/ the mpi stub
    PYTHON_ADD_DISTUTILS_SETUP(mpicom_py_setup
                               site-packages
                               setup.py
                               ${MPICOM_PY_SOURCES})
# add to main target?
ENDIF(VISIT_PARALLEL)

