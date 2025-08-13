// DisplayProcessor.h: interface for the CDisplayProcessor class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_DISPLAYPROCESSOR_H__5AB577E2_02A9_468D_822D_32A4A946669A__INCLUDED_)
#define AFX_DISPLAYPROCESSOR_H__5AB577E2_02A9_468D_822D_32A4A946669A__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "../Model/DrawModel.h"
#include "../Model/Shape.h"

/// Класът, който ще бъде използван при управляване на дисплейната система.
class CDisplayProcessor  
{
private:
	/// Текущ документ. Съдържа списък с всички елементи формиращи изображението и др.
	CDrawModel* m_pModel;

public:
	CDisplayProcessor();
	virtual ~CDisplayProcessor();

	/// Прерисува всички елементи на модела на изображението върху pDC.
	virtual void ReDraw(CDC* pDC);
	/// Визуализация.
	virtual void Draw(CDC* pDC);
	/// Визуализира даден елемент от изображението.
	virtual void DrawShape(CDC* pDC, CShape* shape);

	/// Връща текущия документ.
	CDrawModel* GetModel();
	/// Инициира прерисуване на всички изгледи свързани с активния документ.
	void Invalidate();
};

#endif // !defined(AFX_DISPLAYPROCESSOR_H__5AB577E2_02A9_468D_822D_32A4A946669A__INCLUDED_)
