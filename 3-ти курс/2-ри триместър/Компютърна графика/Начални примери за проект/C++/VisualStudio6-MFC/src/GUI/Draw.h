// Draw.h : main header file for the DRAW application
//

#if !defined(AFX_DRAW_H__307B601B_631F_48EF_A807_23D8D6B6BE70__INCLUDED_)
#define AFX_DRAW_H__307B601B_631F_48EF_A807_23D8D6B6BE70__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CDrawApp:
// See Draw.cpp for the implementation of this class
//

/// ���� � �������� ����� �� ����������.
class CDrawApp : public CWinApp
{
public:
	CDrawApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDrawApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CDrawApp)
	afx_msg void OnAppAbout();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DRAW_H__307B601B_631F_48EF_A807_23D8D6B6BE70__INCLUDED_)
