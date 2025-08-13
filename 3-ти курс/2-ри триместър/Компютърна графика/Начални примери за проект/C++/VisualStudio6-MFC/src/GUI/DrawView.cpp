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

	/// Агрегирания диалогов процесор в изгледа - улеснява манипулацията на модела.
	DialogProcessor = new CDialogProcessor();
	/// Инструмента за посочване и влачене не е активен първоначално.
	m_IsPickup = false;
}

CDrawView::~CDrawView()
{
	/// Деструктира агрегирания диалогов процесор.
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

/// Събитието, което се прихваща, за да се превизуализира при изменение на модела.
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

/// Показва информационен текст в Статус линията на главния прозорец.
void CDrawView::SetStatusText(LPCTSTR text)
{
	((CMainFrame*) ((CFrameWnd*) AfxGetApp()->GetMainWnd()))->SetStatusText(text);
}

/////////////////////////////////////////////////////////////////////////////
// CDrawView message handlers

/// Бутон, който поставя на произволно място правоъгълник със зададените размери.
/// Промяна на статуса и инвалидиране на изгледа, в който визуализираме.
void CDrawView::OnToolRect() 
{
	DialogProcessor->AddRandomRectangle();
	SetStatusText("Последно действие: Рисуване на правоъгълник");
	DialogProcessor->Invalidate();
}

/// Бутон, който когато е натиснат се задържа и тогава указването и влаченето работят.
void CDrawView::OnToolPickup() 
{
	m_IsPickup = !m_IsPickup;
}

/// Прихващане на координатите при натискането на бутон на мишката и проверка (в обратен ред) дали не е
/// щракнато върху елемент. Ако е така то той се отбелязва като селектиран и започва процес на "влачене".
/// Промяна на статуса и инвалидиране на изгледа, в който визуализираме.
/// Реализацията се диалогът с потребителя, при който се избира "най-горния" елемент от екрана.
void CDrawView::OnLButtonDown(UINT nFlags, CPoint point)
{
	if (m_IsPickup) {
		CPoint sp = CDrawView::GetScrollPosition();
		point += sp;

		DialogProcessor->Selection = DialogProcessor->ContainsPoint(point);
		if (DialogProcessor->Selection) {
			SetStatusText("Последно действие: Селекция на примитив");
			DialogProcessor->IsDragging = true;
			DialogProcessor->LastLocation = point;
			DialogProcessor->Invalidate();
			SetCapture();
		}
	}
	
	CScrollView::OnLButtonDown(nFlags, point);
}

/// Прихващане на преместването на мишката.
/// Ако сме в режм на "влачене", то избрания елемент се транслира.
void CDrawView::OnMouseMove(UINT nFlags, CPoint point) 
{
	if (DialogProcessor->IsDragging) {
		CPoint sp = CDrawView::GetScrollPosition();
		point += sp;

		SetStatusText("Последно действие: Влачене");
		DialogProcessor->TranslateTo(point);
		DialogProcessor->Invalidate();
	}
	
	CScrollView::OnMouseMove(nFlags, point);
}

/// Прихващане на отпускането на бутона на мишката.
/// Излизаме от режим "влачене".
void CDrawView::OnLButtonUp(UINT nFlags, CPoint point) 
{
	DialogProcessor->IsDragging = false;
	ReleaseCapture();
	
	CScrollView::OnLButtonUp(nFlags, point);
}

/// Прихващане на изтриването с фонов цвят на целия изглед.
/// Целта е да се премахне примигването при изчертаване.
BOOL CDrawView::OnEraseBkgnd(CDC* pDC) 
{
	return FALSE;
}
