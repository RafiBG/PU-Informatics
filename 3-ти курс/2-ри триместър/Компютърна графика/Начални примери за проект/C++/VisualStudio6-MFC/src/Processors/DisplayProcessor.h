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

/// ������, ����� �� ���� ��������� ��� ����������� �� ����������� �������.
class CDisplayProcessor  
{
private:
	/// ����� ��������. ������� ������ � ������ �������� ��������� ������������� � ��.
	CDrawModel* m_pModel;

public:
	CDisplayProcessor();
	virtual ~CDisplayProcessor();

	/// ��������� ������ �������� �� ������ �� ������������� ����� pDC.
	virtual void ReDraw(CDC* pDC);
	/// ������������.
	virtual void Draw(CDC* pDC);
	/// ����������� ����� ������� �� �������������.
	virtual void DrawShape(CDC* pDC, CShape* shape);

	/// ����� ������� ��������.
	CDrawModel* GetModel();
	/// �������� ����������� �� ������ ������� �������� � �������� ��������.
	void Invalidate();
};

#endif // !defined(AFX_DISPLAYPROCESSOR_H__5AB577E2_02A9_468D_822D_32A4A946669A__INCLUDED_)
