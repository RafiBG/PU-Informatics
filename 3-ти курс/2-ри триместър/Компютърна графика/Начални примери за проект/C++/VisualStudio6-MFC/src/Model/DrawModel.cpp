// DrawModel.cpp : implementation of the CDrawModel class
//

#include "stdafx.h"
#include "DrawModel.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CDrawModel

IMPLEMENT_DYNCREATE(CDrawModel, CDocument)

BEGIN_MESSAGE_MAP(CDrawModel, CDocument)
	//{{AFX_MSG_MAP(CDrawModel)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CDrawModel construction/destruction

CDrawModel::CDrawModel()
{
	/// Първоначално няма нито един елемент в изображението.
	m_ShapesCount = 0;
}

CDrawModel::~CDrawModel()
{
	/// Премахва и освибождава паметта на всички елементи от изображението.
	for (int i = 0; i < m_ShapesCount; i++) delete m_Shapes[i];
}

BOOL CDrawModel::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	/// Реинициализация на документа.
	//for (int i = 0; i < m_ShapesCount; i++) 
	//	delete m_Shapes[i];
	m_ShapesCount = 0;

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CDrawModel serialization

void CDrawModel::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: add storing code here
	}
	else
	{
		// TODO: add loading code here
	}
}

/////////////////////////////////////////////////////////////////////////////
// CDrawModel commands

/// Връща броя на елементите формиращи изображението.
int CDrawModel::GetShapesCount()
{
	return m_ShapesCount;
}

/// Връща елемент от изображението с индекс i.
CShape* CDrawModel::GetShape(int i)
{
	return m_Shapes[i];
}

/// Добавя елемент към изображението.
void CDrawModel::AddShape(CShape* shape)
{
	if (m_ShapesCount > MAX_SHAPES-1) {
		MessageBox(0, "Неможе да се добавят повече елементи", "Внимание!!!", MB_ICONSTOP);
		return;
	}

	m_Shapes[m_ShapesCount++] = shape;
}
