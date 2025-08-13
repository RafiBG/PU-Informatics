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

/// Визуализира елемента.
/// pDC - Къде да бъде визуализиран елемента.
void CShape::SelfDraw(CDC *pDC)
{
	//
}

/// Проверка дали точка point принадлежи на елемента.
/// point - Точка.
/// Връща true, ако точката принадлежи на елемента и
/// false, ако не пренадлежи.
BOOL CShape::Contains(CPoint point)
{
	return GetRectangle().PtInRect(point);
}

/// Връща обхващащия правоъгълник на елемента.
CRect CShape::GetRectangle()
{
	return m_Rectangle;
}

/// Променя обхващащия правоъгълник на елемента. 
void CShape::SetRectangle(CRect rect)
{
	m_Rectangle = rect;
}

/// Връща цвета на елемента.
COLORREF CShape::GetFillColor()
{
	return m_FillColor;
}

/// Променя цвета на елемента.
void CShape::SetFillColor(COLORREF fillColor)
{
	m_FillColor = fillColor;
	if (!m_Brush) delete m_Brush;
	m_Brush = new CBrush(fillColor);
}

/// Връща четка за запълване на елемента. 
CBrush* CShape::GetBrush()
{
	return m_Brush;
}
