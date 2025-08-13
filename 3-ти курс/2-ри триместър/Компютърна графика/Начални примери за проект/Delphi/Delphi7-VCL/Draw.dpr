program Draw;

uses
  Forms,
  MainFormU in 'src\GUI\MainFormU.pas' {MainForm},
  ShapesU in 'src\Model\ShapesU.pas',
  RectangleShapeU in 'src\Model\RectangleShapeU.pas',
  DisplayProcessorU in 'src\Processors\DisplayProcessorU.pas',
  DialogProcessorU in 'src\Processors\DialogProcessorU.pas';

{$R *.res}

/// ������ ����� �� ����������.
/// ������� ������ ���������� � �������� �����.
begin
  Application.Initialize;
  Application.Title := 'Draw';
  Application.CreateForm(TMainForm, MainForm);
  Application.Run;
end.
