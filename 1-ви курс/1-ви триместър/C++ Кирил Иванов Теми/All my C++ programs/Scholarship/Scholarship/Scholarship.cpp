#include <iostream>
using namespace std;
int main()
{
    setlocale(LC_ALL, "bg");
    double mark = 5.4;  // ���� �������  ���������� ����� : 2201261077
    if (mark >= 5.5)    // ��� �� ������ �� ������� �������� �� ���� ��� ?
    {
        cout << "��� ���������." << endl;
    }
    else
    {
        cout << "���� ���������" << endl;
    }
}