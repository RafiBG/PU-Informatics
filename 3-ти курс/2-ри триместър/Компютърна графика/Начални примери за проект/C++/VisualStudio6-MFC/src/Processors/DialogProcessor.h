// DialogProcessor.h: interface for the CDialogProcessor class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_DIALOGPROCESSOR_H__9290F4AC_1042_4D95_B0CB_8C537F923F62__INCLUDED_)
#define AFX_DIALOGPROCESSOR_H__9290F4AC_1042_4D95_B0CB_8C537F923F62__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "DisplayProcessor.h"
#include "../Model/Shape.h"

/// ������, ����� �� ���� ��������� ��� ����������� �� �������.
class CDialogProcessor : public CDisplayProcessor  
{
public:
	/// ������ �������.
	CShape* Selection;
	/// ���� � ������� ������� � � ��������� �� "�������" �� �������� �������.
	BOOL IsDragging;
	/// �������� ������� �� ������� ��� "�������".
	/// �������� �� �� ���������� �� ������� �� ����������.
	CPoint LastLocation;

	CDialogProcessor();
	virtual ~CDialogProcessor();

	/// ������ �������� - ������������ �� ���������� ����� ����� ����������� ������.
	void AddRandomRectangle();
	/// ��������� ���� ������ ����� � � ��������.
	CShape* ContainsPoint(CPoint point);
	/// ���������� �� ��������� �������.
	void TranslateTo(CPoint p);
};

#endif // !defined(AFX_DIALOGPROCESSOR_H__9290F4AC_1042_4D95_B0CB_8C537F923F62__INCLUDED_)
