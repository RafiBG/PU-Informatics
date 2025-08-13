// RectangleShape.cpp: implementation of the CRectangleShape class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "RectangleShape.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CRectangleShape::CRectangleShape()
{

}

CRectangleShape::CRectangleShape(CRect srcRect)
{
	SetRectangle(srcRect);
	SetFillColor(0xFFFFFF);
}

CRectangleShape::~CRectangleShape()
{

}

//

/// Частта, визуализираща конкретния примитив.
void CRectangleShape::SelfDraw(CDC *pDC)
{
	CShape::SelfDraw(pDC);

	pDC->FillRect(GetRectangle(), GetBrush());
	pDC->SelectStockObject(BLACK_PEN);
	pDC->SelectStockObject(NULL_BRUSH);
	pDC->Rectangle(GetRectangle());
}

/// Проверка за принадлежност на точка point към правоъгълника.
/// В случая на правоъгълник този метод може да не бъде пренаписван, защото
/// Реализацията съвпада с тази на абстрактния клас Shape, който проверява
/// дали точката е в обхващащия правоъгълник на елемента (а той съвпада с
/// елемента в този случай).
BOOL CRectangleShape::Contains(CPoint point)
{
	if (CShape::Contains(point)) {
		// Проверка дали е в обекта само, ако точката е в обхващащия правоъгълник.
		// В случая на правоъгълник - директно връщаме true
		return true;
	}
	else {
		// Ако не е в обхващащия правоъгълник, то неможе да е в обекта и => false
		return false;
	}
}
