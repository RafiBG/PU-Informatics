# Microsoft Developer Studio Project File - Name="Draw" - Package Owner=<4>
# Microsoft Developer Studio Generated Build File, Format Version 6.00
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Application" 0x0101

CFG=Draw - Win32 Debug
!MESSAGE This is not a valid makefile. To build this project using NMAKE,
!MESSAGE use the Export Makefile command and run
!MESSAGE 
!MESSAGE NMAKE /f "Draw.mak".
!MESSAGE 
!MESSAGE You can specify a configuration when running NMAKE
!MESSAGE by defining the macro CFG on the command line. For example:
!MESSAGE 
!MESSAGE NMAKE /f "Draw.mak" CFG="Draw - Win32 Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "Draw - Win32 Release" (based on "Win32 (x86) Application")
!MESSAGE "Draw - Win32 Debug" (based on "Win32 (x86) Application")
!MESSAGE 

# Begin Project
# PROP AllowPerConfigDependencies 0
# PROP Scc_ProjName ""
# PROP Scc_LocalPath ""
CPP=cl.exe
MTL=midl.exe
RSC=rc.exe

!IF  "$(CFG)" == "Draw - Win32 Release"

# PROP BASE Use_MFC 5
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir "bin/Release"
# PROP BASE Intermediate_Dir "obj/Release"
# PROP BASE Target_Dir ""
# PROP Use_MFC 5
# PROP Use_Debug_Libraries 0
# PROP Output_Dir "bin/Release"
# PROP Intermediate_Dir "obj/Release"
# PROP Ignore_Export_Lib 0
# PROP Target_Dir ""
# ADD BASE CPP /nologo /MT /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_WINDOWS" /Yu"stdafx.h" /FD /c
# ADD CPP /nologo /MT /W3 /GX /O2 /Ob2 /D "WIN32" /D "NDEBUG" /D "_WINDOWS" /D "_MBCS" /Yu"stdafx.h" /FD /c
# ADD BASE MTL /nologo /D "NDEBUG" /mktyplib203 /win32
# ADD MTL /nologo /D "NDEBUG" /mktyplib203 /win32
# ADD BASE RSC /l 0x402 /d "NDEBUG"
# ADD RSC /l 0x402 /d "NDEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo /o"obj/Release/Draw.bsc"
LINK32=link.exe
# ADD BASE LINK32 /nologo /subsystem:windows /machine:I386
# ADD LINK32 /nologo /subsystem:windows /machine:I386
# SUBTRACT LINK32 /pdb:none

!ELSEIF  "$(CFG)" == "Draw - Win32 Debug"

# PROP BASE Use_MFC 5
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir "bin/Debug"
# PROP BASE Intermediate_Dir "obj/Debug"
# PROP BASE Target_Dir ""
# PROP Use_MFC 5
# PROP Use_Debug_Libraries 1
# PROP Output_Dir "bin/Debug"
# PROP Intermediate_Dir "obj/Debug"
# PROP Ignore_Export_Lib 0
# PROP Target_Dir ""
# ADD BASE CPP /nologo /MTd /W3 /Gm /GX /ZI /Od /D "WIN32" /D "_DEBUG" /D "_WINDOWS" /Yu"stdafx.h" /FD /GZ /c
# ADD CPP /nologo /MTd /W3 /Gm /GX /ZI /Od /D "WIN32" /D "_DEBUG" /D "_WINDOWS" /D "_MBCS" /FR /Yu"stdafx.h" /FD /GZ /c
# ADD BASE MTL /nologo /D "_DEBUG" /mktyplib203 /win32
# ADD MTL /nologo /D "_DEBUG" /mktyplib203 /win32
# SUBTRACT MTL /Oicf
# ADD BASE RSC /l 0x402 /d "_DEBUG"
# ADD RSC /l 0x402 /d "_DEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo /o"obj/Debug/Draw.bsc"
LINK32=link.exe
# ADD BASE LINK32 /nologo /subsystem:windows /debug /machine:I386 /pdbtype:sept
# ADD LINK32 /nologo /subsystem:windows /debug /machine:I386 /pdbtype:sept

!ENDIF 

# Begin Target

# Name "Draw - Win32 Release"
# Name "Draw - Win32 Debug"
# Begin Group "Source Files"

# PROP Default_Filter "cpp;c;cxx;rc;def;r;odl;idl;hpj;bat"
# Begin Source File

SOURCE=.\src\Processors\DialogProcessor.cpp
# End Source File
# Begin Source File

SOURCE=.\src\Processors\DisplayProcessor.cpp
# End Source File
# Begin Source File

SOURCE=.\src\GUI\Draw.cpp
# End Source File
# Begin Source File

SOURCE=.\src\GUI\Draw.rc
# End Source File
# Begin Source File

SOURCE=.\src\Model\DrawModel.cpp
# End Source File
# Begin Source File

SOURCE=.\src\GUI\DrawView.cpp
# End Source File
# Begin Source File

SOURCE=.\src\GUI\MainFrm.cpp
# End Source File
# Begin Source File

SOURCE=.\src\Model\RectangleShape.cpp
# End Source File
# Begin Source File

SOURCE=.\src\Model\Shape.cpp
# End Source File
# Begin Source File

SOURCE=.\src\StdAfx.cpp
# ADD CPP /Yc"stdafx.h"
# End Source File
# End Group
# Begin Group "Header Files"

# PROP Default_Filter "h;hpp;hxx;hm;inl"
# Begin Source File

SOURCE=.\src\Processors\DialogProcessor.h
# End Source File
# Begin Source File

SOURCE=.\src\Processors\DisplayProcessor.h
# End Source File
# Begin Source File

SOURCE=.\src\GUI\Draw.h
# End Source File
# Begin Source File

SOURCE=.\src\Model\DrawModel.h
# End Source File
# Begin Source File

SOURCE=.\src\GUI\DrawView.h
# End Source File
# Begin Source File

SOURCE=.\src\GUI\MainFrm.h
# End Source File
# Begin Source File

SOURCE=.\src\GUI\MemDC.h
# End Source File
# Begin Source File

SOURCE=.\src\Model\RectangleShape.h
# End Source File
# Begin Source File

SOURCE=.\src\GUI\Resource.h
# End Source File
# Begin Source File

SOURCE=.\src\Model\Shape.h
# End Source File
# Begin Source File

SOURCE=.\src\StdAfx.h
# End Source File
# End Group
# Begin Group "Resource Files"

# PROP Default_Filter "ico;cur;bmp;dlg;rc2;rct;bin;rgs;gif;jpg;jpeg;jpe"
# Begin Source File

SOURCE=.\res\Draw.ico
# End Source File
# Begin Source File

SOURCE=.\src\GUI\res\Draw.ico
# End Source File
# Begin Source File

SOURCE=.\res\Draw.rc2
# End Source File
# Begin Source File

SOURCE=.\res\DrawModel.ico
# End Source File
# Begin Source File

SOURCE=.\src\GUI\res\DrawModel.ico
# End Source File
# Begin Source File

SOURCE=.\res\Toolbar.bmp
# End Source File
# Begin Source File

SOURCE=.\src\GUI\res\Toolbar.bmp
# End Source File
# End Group
# Begin Source File

SOURCE=.\ReadMe.txt
# End Source File
# End Target
# End Project
