// DrawModel.h : interface of the CDrawModel class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_DRAWMODEL_H__D9A62DCE_93BF_4865_BA11_AD3AE3916227__INCLUDED_)
#define AFX_DRAWMODEL_H__D9A62DCE_93BF_4865_BA11_AD3AE3916227__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "afxtempl.h"
#include "Shape.h"

/// Максимален брой елементи на изображението.
/// За да няма ограничение на броя елементи трябва да се смени масива
/// със динамична стриктура от данни.
#define MAX_SHAPES 1000

///
class CDrawModel : public CDocument
{
protected:
	/// Списък с всички елементи формиращи изображението.
	CShape* m_Shapes[MAX_SHAPES];
	/// Брой на елементите формиращи изображението.
	int m_ShapesCount;

protected: // create from serialization only
	CDrawModel();
	DECLARE_DYNCREATE(CDrawModel)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CDrawModel)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CDrawModel();

	/// Връща броя на елементите формиращи изображението.
	int GetShapesCount();
	/// Връща елемент от изображението с индекс i.
	CShape* GetShape(int i);
	/// Добавя елемент към изображението.
	void AddShape(CShape* shape);

// Generated message map functions
	//{{AFX_MSG(CDrawModel)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_DRAWMODEL_H__D9A62DCE_93BF_4865_BA11_AD3AE3916227__INCLUDED_)
