#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    /*��������� ��������, ����������� ���� 
    ������� ����� ����� ��� ������ �� ���� 
    �� ���� ���� (���� ������ �� ���� � 4 �����).

    1 ����� � ���������� �� ������������ �� 3 ��. �.
    ����. ������� �� ���������� ������ �� ���� ���� 
    �����, ��������� ����������� ���� �����.*/

    double paint_area;
    cout << "What is the area in square feet?  ";
    cin >> paint_area;
    int can_area = 300;
    int cans = ceil(paint_area / can_area);
    cout << "\n"; // ��������� �� �� ��������� ��������. ���� �� ���� � ��� ���.
    cout << "The number of cans of paint required is: " << cans;
    cout << "\n";
    return 0;
}

