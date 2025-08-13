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

/// ������, ������������� ���������� ��������.
void CRectangleShape::SelfDraw(CDC *pDC)
{
	CShape::SelfDraw(pDC);

	pDC->FillRect(GetRectangle(), GetBrush());
	pDC->SelectStockObject(BLACK_PEN);
	pDC->SelectStockObject(NULL_BRUSH);
	pDC->Rectangle(GetRectangle());
}

/// �������� �� ������������� �� ����� point ��� �������������.
/// � ������ �� ������������ ���� ����� ���� �� �� ���� �����������, ������
/// ������������ ������� � ���� �� ����������� ���� Shape, ����� ���������
/// ���� ������� � � ���������� ������������ �� �������� (� ��� ������� �
/// �������� � ���� ������).
BOOL CRectangleShape::Contains(CPoint point)
{
	if (CShape::Contains(point)) {
		// �������� ���� � � ������ ����, ��� ������� � � ���������� ������������.
		// � ������ �� ������������ - �������� ������� true
		return true;
	}
	else {
		// ��� �� � � ���������� ������������, �� ������ �� � � ������ � => false
		return false;
	}
}
