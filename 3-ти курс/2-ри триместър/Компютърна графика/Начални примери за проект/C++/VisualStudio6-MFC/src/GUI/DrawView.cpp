// DrawView.cpp : implementation of the CDrawView class
//

#include "stdafx.h"
#include "Draw.h"
#include "DrawView.h"
#include "MainFrm.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CDrawView

IMPLEMENT_DYNCREATE(CDrawView, CScrollView)

BEGIN_MESSAGE_MAP(CDrawView, CScrollView)
	//{{AFX_MSG_MAP(CDrawView)
	ON_WM_LBUTTONDOWN()
	ON_WM_LBUTTONUP()
	ON_WM_MOUSEMOVE()
	ON_COMMAND(ID_TOOL_RECT, OnToolRect)
	ON_COMMAND(ID_TOOL_PICKUP, OnToolPickup)
	ON_WM_ERASEBKGND()
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CDrawView construction/destruction

CDrawView::CDrawView()
{
	// TODO: add construction code here

	/// ����������� �������� �������� � ������� - �������� ������������� �� ������.
	DialogProcessor = new CDialogProcessor();
	/// ����������� �� ��������� � ������� �� � ������� ������������.
	m_IsPickup = false;
}

CDrawView::~CDrawView()
{
	/// ����������� ����������� �������� ��������.
	delete DialogProcessor;
}

BOOL CDrawView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CScrollView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CDrawView drawing

/// ���������, ����� �� ��������, �� �� �� �������������� ��� ��������� �� ������.
void CDrawView::OnDraw(CDC* pDC)
{
	CMemDC MemDC(pDC);

	DialogProcessor->ReDraw(MemDC);
}

void CDrawView::OnInitialUpdate()
{
	CScrollView::OnInitialUpdate();

	CSize sizeTotal;
	// TODO: calculate the total size of this view
	sizeTotal.cx = sizeTotal.cy = 1000;
	SetScrollSizes(MM_TEXT, sizeTotal);
}

//

/// ������� ������������� ����� � ������ ������� �� ������� ��������.
void CDrawView::SetStatusText(LPCTSTR text)
{
	((CMainFrame*) ((CFrameWnd*) AfxGetApp()->GetMainWnd()))->SetStatusText(text);
}

/////////////////////////////////////////////////////////////////////////////
// CDrawView message handlers

/// �����, ����� ������� �� ���������� ����� ������������ ��� ���������� �������.
/// ������� �� ������� � ������������ �� �������, � ����� �������������.
void CDrawView::OnToolRect() 
{
	DialogProcessor->AddRandomRectangle();
	SetStatusText("�������� ��������: �������� �� ������������");
	DialogProcessor->Invalidate();
}

/// �����, ����� ������ � �������� �� ������� � ������ ���������� � ��������� �������.
void CDrawView::OnToolPickup() 
{
	m_IsPickup = !m_IsPickup;
}

/// ���������� �� ������������ ��� ����������� �� ����� �� ������� � �������� (� ������� ���) ���� �� �
/// �������� ����� �������. ��� � ���� �� ��� �� ��������� ���� ���������� � ������� ������ �� "�������".
/// ������� �� ������� � ������������ �� �������, � ����� �������������.
/// ������������ �� �������� � �����������, ��� ����� �� ������ "���-������" ������� �� ������.
void CDrawView::OnLButtonDown(UINT nFlags, CPoint point)
{
	if (m_IsPickup) {
		CPoint sp = CDrawView::GetScrollPosition();
		point += sp;

		DialogProcessor->Selection = DialogProcessor->ContainsPoint(point);
		if (DialogProcessor->Selection) {
			SetStatusText("�������� ��������: �������� �� ��������");
			DialogProcessor->IsDragging = true;
			DialogProcessor->LastLocation = point;
			DialogProcessor->Invalidate();
			SetCapture();
		}
	}
	
	CScrollView::OnLButtonDown(nFlags, point);
}

/// ���������� �� ������������� �� �������.
/// ��� ��� � ���� �� "�������", �� �������� ������� �� ���������.
void CDrawView::OnMouseMove(UINT nFlags, CPoint point) 
{
	if (DialogProcessor->IsDragging) {
		CPoint sp = CDrawView::GetScrollPosition();
		point += sp;

		SetStatusText("�������� ��������: �������");
		DialogProcessor->TranslateTo(point);
		DialogProcessor->Invalidate();
	}
	
	CScrollView::OnMouseMove(nFlags, point);
}

/// ���������� �� ����������� �� ������ �� �������.
/// �������� �� ����� "�������".
void CDrawView::OnLButtonUp(UINT nFlags, CPoint point) 
{
	DialogProcessor->IsDragging = false;
	ReleaseCapture();
	
	CScrollView::OnLButtonUp(nFlags, point);
}

/// ���������� �� ����������� � ����� ���� �� ����� ������.
/// ����� � �� �� �������� ������������ ��� �����������.
BOOL CDrawView::OnEraseBkgnd(CDC* pDC) 
{
	return FALSE;
}
