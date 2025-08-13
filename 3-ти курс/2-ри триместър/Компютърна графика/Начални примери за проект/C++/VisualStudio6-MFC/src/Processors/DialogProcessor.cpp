// DialogProcessor.cpp: implementation of the CDialogProcessor class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "../Model/RectangleShape.h"
#include "DialogProcessor.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CDialogProcessor::CDialogProcessor()
{
	Selection = NULL;
	LastLocation = CPoint(0,0);
	IsDragging = false;
}

CDialogProcessor::~CDialogProcessor()
{

}

//

/// ������ �������� - ������������ �� ���������� ����� ����� ����������� ������.
void CDialogProcessor::AddRandomRectangle()
{
	int rx = 100 + rand()*900 / RAND_MAX; //100..1000
	int ry = 100 + rand()*500 / RAND_MAX; //100..600
	GetModel()->AddShape(new CRectangleShape(new CRect(rx,ry,rx+100,ry+200)));

	GetModel()->SetModifiedFlag();
}

/// ��������� ���� ������ ����� � � ��������.
/// ������� � ��� ������� �� �������������� � ��� �������� ��
/// "���-������" ������� �.�. ���� ����� ������� ��� �������.
/// point - ������� �����.
/// ����� �������� �� �������������, �� ����� ���������� �������� �����.
CShape* CDialogProcessor::ContainsPoint(CPoint point)
{
	for (int i = GetModel()->GetShapesCount() - 1; i >= 0; i--) {
		CShape* shape = GetModel()->GetShape(i);
		if (shape->Contains(point)) {
			shape->SetFillColor(0x0000FF);
			return shape;
		}	
	}
	return NULL;
}

/// ���������� �� ��������� ������� �� ������ ��������� �� p.
/// p - ������ �� ����������.
void CDialogProcessor::TranslateTo(CPoint p)
{
	if (Selection) {
		CRect r = Selection->GetRectangle();
		r.OffsetRect(p-LastLocation);
		Selection->SetRectangle(r);
		GetModel()->SetModifiedFlag();
		LastLocation = p;
	}
}
