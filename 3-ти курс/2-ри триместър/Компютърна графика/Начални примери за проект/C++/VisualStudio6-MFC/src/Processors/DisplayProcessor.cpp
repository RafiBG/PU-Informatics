// DisplayProcessor.cpp: implementation of the CDisplayProcessor class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "DisplayProcessor.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CDisplayProcessor::CDisplayProcessor()
{
	m_pModel = NULL;
}

CDisplayProcessor::~CDisplayProcessor()
{

}

//

/// ��������� ������ �������� �� ������ �� ������������� ����� pDC.
void CDisplayProcessor::ReDraw(CDC* pDC)
{
	Draw(pDC);
}

/// ������������.
/// ��������� �� ������ �������� � ������� � ��������� �� �������������� �� �����.
/// pDC - ���� �� �� ������� ��������������.
void CDisplayProcessor::Draw(CDC* pDC)
{
	for (int i = 0; i < GetModel()->GetShapesCount(); i++) {
		DrawShape(pDC, GetModel()->GetShape(i));
	}
}

/// ����������� ����� ������� �� �������������.
/// pDC - ���� �� �� ������� ��������������.
/// item - ������� �� �������������.
void CDisplayProcessor::DrawShape(CDC* pDC, CShape* shape)
{
	shape->SelfDraw(pDC);
}

/// ����� ������� ��������.
CDrawModel* CDisplayProcessor::GetModel()
{
	if (!m_pModel) m_pModel = (CDrawModel*) ((CFrameWnd*) AfxGetApp()->GetMainWnd())->GetActiveDocument();
	return m_pModel;
}

/// �������� ����������� �� ������ ������� �������� � �������� ��������.
void CDisplayProcessor::Invalidate()
{
	GetModel()->UpdateAllViews(NULL);
}
