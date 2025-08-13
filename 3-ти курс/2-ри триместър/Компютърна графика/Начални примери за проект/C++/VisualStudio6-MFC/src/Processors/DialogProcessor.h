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

/// Класът, който ще бъде използван при управляване на диалога.
class CDialogProcessor : public CDisplayProcessor  
{
public:
	/// Избран елемент.
	CShape* Selection;
	/// Дали в момента диалога е в състояние на "влачене" на избрания елемент.
	BOOL IsDragging;
	/// Последна позиция на мишката при "влачене".
	/// Използва се за определяне на вектора на транслация.
	CPoint LastLocation;

	CDialogProcessor();
	virtual ~CDialogProcessor();

	/// Добавя примитив - правоъгълник на произволно място върху клиентската област.
	void AddRandomRectangle();
	/// Проверява дали дадена точка е в елемента.
	CShape* ContainsPoint(CPoint point);
	/// Транслация на избраният елемент.
	void TranslateTo(CPoint p);
};

#endif // !defined(AFX_DIALOGPROCESSOR_H__9290F4AC_1042_4D95_B0CB_8C537F923F62__INCLUDED_)
