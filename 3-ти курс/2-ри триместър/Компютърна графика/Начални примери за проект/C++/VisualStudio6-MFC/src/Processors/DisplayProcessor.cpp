// DisplayProcessor.cpp: implementation of the CDisplayProcessor class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "DisplayProcessor.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CDisplayProcessor::CDisplayProcessor()
{
	m_pModel = NULL;
}

CDisplayProcessor::~CDisplayProcessor()
{

}

//

/// Прерисува всички елементи на модела на изображението върху pDC.
void CDisplayProcessor::ReDraw(CDC* pDC)
{
	Draw(pDC);
}

/// Визуализация.
/// Обхождане на всички елементи в списъка и извикване на визуализиращия им метод.
/// pDC - Къде да се извърши визуализацията.
void CDisplayProcessor::Draw(CDC* pDC)
{
	for (int i = 0; i < GetModel()->GetShapesCount(); i++) {
		DrawShape(pDC, GetModel()->GetShape(i));
	}
}

/// Визуализира даден елемент от изображението.
/// pDC - Къде да се извърши визуализацията.
/// item - Елемент за визуализиране.
void CDisplayProcessor::DrawShape(CDC* pDC, CShape* shape)
{
	shape->SelfDraw(pDC);
}

/// Връща текущия документ.
CDrawModel* CDisplayProcessor::GetModel()
{
	if (!m_pModel) m_pModel = (CDrawModel*) ((CFrameWnd*) AfxGetApp()->GetMainWnd())->GetActiveDocument();
	return m_pModel;
}

/// Инициира прерисуване на всички изгледи свързани с активния документ.
void CDisplayProcessor::Invalidate()
{
	GetModel()->UpdateAllViews(NULL);
}
