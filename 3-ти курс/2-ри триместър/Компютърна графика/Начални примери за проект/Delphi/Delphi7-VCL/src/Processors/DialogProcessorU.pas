unit DialogProcessorU;

interface

uses Graphics, Types, DisplayProcessorU, ShapesU;

type
  /// ������, ����� �� ���� ��������� ��� ����������� �� �������.
  TDialogProcessor = class(TDisplayProcessor)
  protected
    fSelection: TShapes;
    fIsDragging: Boolean;
    fLastLocation: TPoint;

    procedure SetSelection(const Value: TShapes);
    procedure SetIsDragging(const Value: Boolean);
    procedure SetLastLocation(const Value: TPoint);

  public
    /// ������ �������.
    property Selection: TShapes read FSelection write SetSelection;

    /// ���� � ������� ������� � � ��������� �� "�������" �� �������� �������.
    property IsDragging : Boolean read FIsDragging write SetIsDragging;

    /// �������� ������� �� ������� ��� "�������".
    /// �������� �� �� ���������� �� ������� �� ����������.
    property LastLocation: TPoint read FLastLocation write SetLastLocation;

    procedure AddRandomRectangle;
    function ContainsPoint(P : TPoint) : TShapes;
    procedure TranslateTo(P : TPoint);
  end;

implementation

uses
  Math, Classes,
  RectangleShapeU;

{ TDialogProcessor }

/// ������ �������� - ������������ �� ���������� ����� ����� ����������� ������
procedure TDialogProcessor.AddRandomRectangle;
var
  x,y : Integer;
  Rect1 : TRectangleShape;
  BoundingRect : TRect;
begin
  Randomize;
  x := RandomRange(100, 1000);
  y := RandomRange(100, 800);

  BoundingRect.TopLeft := Point(x, y);
  BoundingRect.BottomRight := Point(x + 100, y + 200);


  Rect1 := TRectangleShape.Create(BoundingRect);
  Rect1.FillColor := clWhite;

  ShapeList.Add(Rect1);

end;

/// ��������� ���� ������ ����� � � ��������.
/// ������� � ��� ������� �� �������������� � ��� �������� ��
/// "���-������" ������� �.�. ���� ����� ������� ��� �������.
/// P - ������� �����.
/// ����� �������� �� �������������, �� ����� ���������� �������� �����.
function TDialogProcessor.ContainsPoint(P : TPoint): TShapes;
var
  I : Integer;
begin
  for I := ShapeList.Count - 1 downto 0 do
    begin
      if (ShapeList.Items[i] as TShapes).Contains(P) then
        begin
          (ShapeList.Items[i] as TShapes).FillColor := clRed;
          Result := (ShapeList.Items[i] as TShapes);
          Exit;
        end;
    end;
    Result := nil;
end;

/// ���������� �� ��������� ������� �� ������ ��������� �� P.
/// P - ������ �� ����������.
procedure TDialogProcessor.TranslateTo(P: TPoint);
begin
  if Selection <> nil then
    begin
      Selection.Location := Point(Selection.Location.X + P.X - LastLocation.X, Selection.Location.Y + P.Y - LastLocation.Y);
      LastLocation := P;
    end;
end;

//

procedure TDialogProcessor.SetSelection(const Value: TShapes);
begin
  FSelection := Value;
end;

procedure TDialogProcessor.SetIsDragging(const Value: Boolean);
begin
  FIsDragging := Value;
end;

procedure TDialogProcessor.SetLastLocation(const Value: TPoint);
begin
  FLastLocation := Value;
end;

end.
