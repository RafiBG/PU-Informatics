unit MainFormU;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ExtCtrls, ComCtrls, Menus, Buttons, ToolWin,
  DialogProcessorU, ShapesU;

type
  /// ����� �������� ����� � �������� PaintBox, ����� ����� �� ����������� ��������������
  TMainForm = class(TForm)
    MainMenu1: TMainMenu;
    File1: TMenuItem;
    Exit1: TMenuItem;
    Edit1: TMenuItem;
    Image1: TMenuItem;
    Help1: TMenuItem;
    About1: TMenuItem;
    StatusBar1: TStatusBar;
    SpeedBar: TToolBar;
    DrawRectangleSpeedButton: TSpeedButton;
    PickUpSpeedButton: TSpeedButton;
    ViewPort: TPaintBox;
    procedure Exit1Click(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure ViewPortPaint(Sender: TObject);
    procedure DrawRectangleSpeedButtonClick(Sender: TObject);
    procedure ViewPortMouseDown(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);
    procedure ViewPortMouseMove(Sender: TObject; Shift: TShiftState; X,
      Y: Integer);
    procedure ViewPortMouseUp(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);
  private
    /// ����������� �������� �������� ��� ������� �������� ������������� �� ������.
    DialogProcessor : TDialogProcessor;

    // ����� ��� �������� ����������
    B: TBitmap;

  public
    { Public declarations }
	/// ���������� Windows ��������� � ��� ��������������� ������������ �� ���� �� ���������,
	/// � ����� �� ������������� ������������ ��� ������������.
    procedure OnVMPaint(var Param: TWMEraseBkgnd); message WM_ERASEBKGND;
  end;

var
  MainForm: TMainForm;

implementation

{$R *.dfm}

/// ��� ��������� �� ������� �� ������� � ����������� ��������.
procedure TMainForm.FormCreate(Sender: TObject);
begin
  DialogProcessor := TDialogProcessor.Create;
  B := TBitmap.Create;
end;

/// ����� �� ����������. ������� �������� �����, � � ���� � ����������.
procedure TMainForm.Exit1Click(Sender: TObject);
begin
  Close;
end;

/// ���������, ����� �� ��������, �� �� �� �������������� ��� �������� �� ������.
procedure TMainForm.ViewPortPaint(Sender: TObject);
begin
  // ������ ���������� ���� �������� ������ B
  B.Width := ClientWidth;
  B.Height := ClientHeight;
  B.Canvas.Brush.Color := clWhite;
  B.Canvas.FillRect(ClientRect);
  // ������������ � B
  DialogProcessor.ReDraw(Sender, B.Canvas);
  // �������� �� ������������� �� B �� ������
  ViewPort.Canvas.Draw(0, 0, B);
end;

/// �����, ����� ������� �� ���������� ����� ������������ ��� ���������� �������.
/// ������� �� ������� ��� ����������� � �� ���������� PaintBox-�.
procedure TMainForm.DrawRectangleSpeedButtonClick(Sender: TObject);
begin
  DialogProcessor.AddRandomRectangle;

  StatusBar1.Panels.Items[0].Text := '�������� ��������: �������� �� ������������';

  ViewPort.Invalidate;
end;

/// ���������� �� ������������ ��� ����������� �� ����� �� ������� � �������� (� ������� ���) ���� �� �
/// �������� ����� �������. ��� � ���� �� ��� �� ��������� ���� ���������� � ������� ������ �� "�������".
/// ������� �� ������� � ������������ �� ��������, � ����� �������������.
/// ������������ �� �������� � �����������, ��� ����� �� ������ "���-������" ������� �� ������.
procedure TMainForm.ViewPortMouseDown(Sender: TObject;
  Button: TMouseButton; Shift: TShiftState; X, Y: Integer);
begin
  if PickUpSpeedButton.Down then
    begin
      DialogProcessor.Selection := DialogProcessor.ContainsPoint(Point(X,Y));
      if DialogProcessor.Selection <> nil then
        begin
          StatusBar1.Panels[0].Text := '�������� ��������: �������� �� ��������';
          DialogProcessor.IsDragging := True;
          DialogProcessor.LastLocation := Point(X, Y);
          ViewPort.Invalidate;
        end;
    end;
end;

/// ���������� �� ������������� �� �������.
/// ��� ��� � ���� �� "�������", �� �������� ������� �� ���������.
procedure TMainForm.ViewPortMouseMove(Sender: TObject; Shift: TShiftState; X, Y: Integer);
begin
  if DialogProcessor.IsDragging then
    begin
      if DialogProcessor.Selection <> nil then StatusBar1.Panels[0].Text := '�������� ��������: �������';
      DialogProcessor.TranslateTo(Point(X, Y));
      ViewPort.Invalidate;
    end;
end;

/// ���������� �� ����������� �� ������ �� �������.
/// �������� �� ����� "�������".
procedure TMainForm.ViewPortMouseUp(Sender: TObject; Button: TMouseButton;
  Shift: TShiftState; X, Y: Integer);
begin
  DialogProcessor.IsDragging := false;
end;

/// ���������� Windows ��������� � ��� ��������������� ������������ �� ���� �� ���������,
/// � ����� �� ������������� ������������ ��� ������������.
procedure TMainForm.OnVMPaint(var Param: TWMEraseBkgnd);
begin
  Param.Result := 1;
end;

end.
