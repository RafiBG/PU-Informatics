// Shape.h: interface for the CShape class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_SHAPE_H__9B5738A9_7DBF_44AA_A60B_5ACDC162F98D__INCLUDED_)
#define AFX_SHAPE_H__9B5738A9_7DBF_44AA_A60B_5ACDC162F98D__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/// ������� ���� �� �����������, ����� ������� ������ �������������� �� �����������.
class CShape
{
private:
	/// �������� ������������ �� ��������.
	CRect m_Rectangle;

	/// ���� �� ��������.
	COLORREF m_FillColor;
	/// �������� ���� �� ����������� �� ������� �� �������� �� ����������� �� ��������.
	CBrush *m_Brush;

public:
	CShape();
	CShape(CShape* srcShape);
	virtual ~CShape();

	/// ����������� ��������.
	virtual void SelfDraw(CDC* pDC);
	/// �������� ���� ����� point ���������� �� ��������.
	virtual BOOL Contains(CPoint point);
	/// ����� ���������� ������������ �� ��������.
	virtual CRect GetRectangle();
	/// ������� ���������� ������������ �� ��������. 
	virtual void SetRectangle(CRect rect);
	/// ����� ����� �� ��������.
	virtual COLORREF GetFillColor();
	/// ������� ����� �� ��������.
	virtual void SetFillColor(COLORREF fillColor);
	/// ����� ����� �� ��������� �� ��������. 
	virtual CBrush* GetBrush();
};

#endif // !defined(AFX_SHAPE_H__9B5738A9_7DBF_44AA_A60B_5ACDC162F98D__INCLUDED_)
