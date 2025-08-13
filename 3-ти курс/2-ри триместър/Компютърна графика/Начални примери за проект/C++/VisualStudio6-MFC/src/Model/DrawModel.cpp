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
	/// ������������ ���� ���� ���� ������� � �������������.
	m_ShapesCount = 0;
}

CDrawModel::~CDrawModel()
{
	/// �������� � ����������� ������� �� ������ �������� �� �������������.
	for (int i = 0; i < m_ShapesCount; i++) delete m_Shapes[i];
}

BOOL CDrawModel::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	/// ��������������� �� ���������.
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

/// ����� ���� �� ���������� ��������� �������������.
int CDrawModel::GetShapesCount()
{
	return m_ShapesCount;
}

/// ����� ������� �� ������������� � ������ i.
CShape* CDrawModel::GetShape(int i)
{
	return m_Shapes[i];
}

/// ������ ������� ��� �������������.
void CDrawModel::AddShape(CShape* shape)
{
	if (m_ShapesCount > MAX_SHAPES-1) {
		MessageBox(0, "������ �� �� ������� ������ ��������", "��������!!!", MB_ICONSTOP);
		return;
	}

	m_Shapes[m_ShapesCount++] = shape;
}
