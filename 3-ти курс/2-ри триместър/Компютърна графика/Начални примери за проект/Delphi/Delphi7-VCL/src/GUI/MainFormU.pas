unit MainFormU;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ExtCtrls, ComCtrls, Menus, Buttons, ToolWin,
  DialogProcessorU, ShapesU;

type
  /// Върху главната форма е поставен PaintBox, върху който се осъществява визуализацията
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
    /// Агрегирания диалогов процесор във формата улеснява манипулацията на модела.
    DialogProcessor : TDialogProcessor;

    // Буфер зяа двойното буфериране
    B: TBitmap;

  public
    { Public declarations }
	/// Прихванато Windows съобщение с цел предотврятяване изчистването на фона на прозореца,
	/// с което се предотвратява премигването при визуализация.
    procedure OnVMPaint(var Param: TWMEraseBkgnd); message WM_ERASEBKGND;
  end;

var
  MainForm: TMainForm;

implementation

{$R *.dfm}

/// При създаване на формата се създава и диалоговият процесор.
procedure TMainForm.FormCreate(Sender: TObject);
begin
  DialogProcessor := TDialogProcessor.Create;
  B := TBitmap.Create;
end;

/// Изход от програмата. Затваря главната форма, а с това и програмата.
procedure TMainForm.Exit1Click(Sender: TObject);
begin
  Close;
end;

/// Събитието, което се прихваща, за да се превизуализира при изменяне на модела.
procedure TMainForm.ViewPortPaint(Sender: TObject);
begin
  // Двойно буфериране чрез междинен битмап B
  B.Width := ClientWidth;
  B.Height := ClientHeight;
  B.Canvas.Brush.Color := clWhite;
  B.Canvas.FillRect(ClientRect);
  // Визуализация в B
  DialogProcessor.ReDraw(Sender, B.Canvas);
  // Копиране на изображението от B на екрана
  ViewPort.Canvas.Draw(0, 0, B);
end;

/// Бутон, който поставя на произволно място правоъгълник със зададените размери.
/// Променя се лентата със състоянието и се инвалидира PaintBox-а.
procedure TMainForm.DrawRectangleSpeedButtonClick(Sender: TObject);
begin
  DialogProcessor.AddRandomRectangle;

  StatusBar1.Panels.Items[0].Text := 'Последно действие: Рисуване на правоъгълник';

  ViewPort.Invalidate;
end;

/// Прихващане на координатите при натискането на бутон на мишката и проверка (в обратен ред) дали не е
/// щракнато върху елемент. Ако е така то той се отбелязва като селектиран и започва процес на "влачене".
/// Промяна на статуса и инвалидиране на контрола, в който визуализираме.
/// Реализацията се диалогът с потребителя, при който се избира "най-горния" елемент от екрана.
procedure TMainForm.ViewPortMouseDown(Sender: TObject;
  Button: TMouseButton; Shift: TShiftState; X, Y: Integer);
begin
  if PickUpSpeedButton.Down then
    begin
      DialogProcessor.Selection := DialogProcessor.ContainsPoint(Point(X,Y));
      if DialogProcessor.Selection <> nil then
        begin
          StatusBar1.Panels[0].Text := 'Последно действие: Селекция на примитив';
          DialogProcessor.IsDragging := True;
          DialogProcessor.LastLocation := Point(X, Y);
          ViewPort.Invalidate;
        end;
    end;
end;

/// Прихващане на преместването на мишката.
/// Ако сме в режм на "влачене", то избрания елемент се транслира.
procedure TMainForm.ViewPortMouseMove(Sender: TObject; Shift: TShiftState; X, Y: Integer);
begin
  if DialogProcessor.IsDragging then
    begin
      if DialogProcessor.Selection <> nil then StatusBar1.Panels[0].Text := 'Последно действие: Влачене';
      DialogProcessor.TranslateTo(Point(X, Y));
      ViewPort.Invalidate;
    end;
end;

/// Прихващане на отпускането на бутона на мишката.
/// Излизаме от режим "влачене".
procedure TMainForm.ViewPortMouseUp(Sender: TObject; Button: TMouseButton;
  Shift: TShiftState; X, Y: Integer);
begin
  DialogProcessor.IsDragging := false;
end;

/// Прихванато Windows съобщение с цел предотврятяване изчистването на фона на прозореца,
/// с което се предотвратява премигването при визуализация.
procedure TMainForm.OnVMPaint(var Param: TWMEraseBkgnd);
begin
  Param.Result := 1;
end;

end.
