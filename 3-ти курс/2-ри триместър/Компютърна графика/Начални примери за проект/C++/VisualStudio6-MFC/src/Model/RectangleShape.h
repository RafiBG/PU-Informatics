// RectangleShape.h: interface for the CRectangleShape class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_RECTANGLESHAPE_H__F147BF6C_9D22_434C_BE32_B0F5DF033501__INCLUDED_)
#define AFX_RECTANGLESHAPE_H__F147BF6C_9D22_434C_BE32_B0F5DF033501__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "Shape.h"

/// ������ ������������ � ������� ��������, ����� � ��������� �� ������� Shape.
class CRectangleShape : public CShape  
{
public:
	CRectangleShape();
	CRectangleShape(CRect srcRect);
	virtual ~CRectangleShape();
	
	virtual void SelfDraw(CDC* pDC);
	/// �������� �� ������������� �� ����� point ��� �������������.
	virtual BOOL Contains(CPoint point);

};

#endif // !defined(AFX_RECTANGLESHAPE_H__F147BF6C_9D22_434C_BE32_B0F5DF033501__INCLUDED_)
