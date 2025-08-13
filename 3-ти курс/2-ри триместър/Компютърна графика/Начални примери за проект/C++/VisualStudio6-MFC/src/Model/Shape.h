// Shape.h: interface for the CShape class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_SHAPE_H__9B5738A9_7DBF_44AA_A60B_5ACDC162F98D__INCLUDED_)
#define AFX_SHAPE_H__9B5738A9_7DBF_44AA_A60B_5ACDC162F98D__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/// Базовия клас на примитивите, който съдържа общите характеристики на примитивите.
class CShape
{
private:
	/// Обхващащ правоъгълник на елемента.
	CRect m_Rectangle;

	/// Цвят на елемента.
	COLORREF m_FillColor;
	/// Помощтно поле за съхраняване на четката за рисуване на запълването на елемента.
	CBrush *m_Brush;

public:
	CShape();
	CShape(CShape* srcShape);
	virtual ~CShape();

	/// Визуализира елемента.
	virtual void SelfDraw(CDC* pDC);
	/// Проверка дали точка point принадлежи на елемента.
	virtual BOOL Contains(CPoint point);
	/// Връща обхващащия правоъгълник на елемента.
	virtual CRect GetRectangle();
	/// Променя обхващащия правоъгълник на елемента. 
	virtual void SetRectangle(CRect rect);
	/// Връща цвета на елемента.
	virtual COLORREF GetFillColor();
	/// Променя цвета на елемента.
	virtual void SetFillColor(COLORREF fillColor);
	/// Връща четка за запълване на елемента. 
	virtual CBrush* GetBrush();
};

#endif // !defined(AFX_SHAPE_H__9B5738A9_7DBF_44AA_A60B_5ACDC162F98D__INCLUDED_)
