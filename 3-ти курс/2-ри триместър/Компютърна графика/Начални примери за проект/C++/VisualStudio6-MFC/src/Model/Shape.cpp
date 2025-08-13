// Shape.cpp: implementation of the CShape class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "Shape.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CShape::CShape()
{
	m_Rectangle = new CRect(0,0,100,200);
	m_FillColor = 0xFFFFFF;
	m_Brush = new CBrush(m_FillColor);
}

CShape::CShape(CShape* srcShape)
{
	m_Rectangle = srcShape->m_Rectangle;
	m_FillColor = srcShape->m_FillColor;
	m_Brush = new CBrush(m_FillColor);
}

CShape::~CShape()
{
	delete m_Rectangle;
	delete m_Brush;
}

//

/// ����������� ��������.
/// pDC - ���� �� ���� ������������ ��������.
void CShape::SelfDraw(CDC *pDC)
{
	//
}

/// �������� ���� ����� point ���������� �� ��������.
/// point - �����.
/// ����� true, ��� ������� ���������� �� �������� �
/// false, ��� �� ����������.
BOOL CShape::Contains(CPoint point)
{
	return GetRectangle().PtInRect(point);
}

/// ����� ���������� ������������ �� ��������.
CRect CShape::GetRectangle()
{
	return m_Rectangle;
}

/// ������� ���������� ������������ �� ��������. 
void CShape::SetRectangle(CRect rect)
{
	m_Rectangle = rect;
}

/// ����� ����� �� ��������.
COLORREF CShape::GetFillColor()
{
	return m_FillColor;
}

/// ������� ����� �� ��������.
void CShape::SetFillColor(COLORREF fillColor)
{
	m_FillColor = fillColor;
	if (!m_Brush) delete m_Brush;
	m_Brush = new CBrush(fillColor);
}

/// ����� ����� �� ��������� �� ��������. 
CBrush* CShape::GetBrush()
{
	return m_Brush;
}
