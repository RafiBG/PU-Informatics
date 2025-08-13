// DrawView.h : interface of the CDrawView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_DRAWVIEW_H__637E86BA_552A_46DC_B5A7_B12F9D68E154__INCLUDED_)
#define AFX_DRAWVIEW_H__637E86BA_552A_46DC_B5A7_B12F9D68E154__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "../Processors/DialogProcessor.h"

/// Клас с основния изглед на програмата.
/// Върху този изглед се извършва визуализацията.
class CDrawView : public CScrollView
{
protected: // create from serialization only
	CDrawView();
	DECLARE_DYNCREATE(CDrawView)

// Attributes
public:
	/// Агрегирания диалогов процесор в изгледа - улеснява манипулацията на модела.
	CDialogProcessor *DialogProcessor;

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDrawView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual void OnInitialUpdate(); // called first time after construct
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CDrawView();

	/// Показва информационен текст в Статус линията на главния прозорец.
	void SetStatusText(LPCTSTR text);

protected:
	/// Флаг дали инструмента за посочване и влачене е активен.
	BOOL m_IsPickup;

// Generated message map functions
protected:
	//{{AFX_MSG(CDrawView)
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg void OnLButtonUp(UINT nFlags, CPoint point);
	afx_msg void OnMouseMove(UINT nFlags, CPoint point);
	afx_msg void OnToolRect();
	afx_msg void OnToolPickup();
	afx_msg BOOL OnEraseBkgnd(CDC* pDC);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DRAWVIEW_H__637E86BA_552A_46DC_B5A7_B12F9D68E154__INCLUDED_)
