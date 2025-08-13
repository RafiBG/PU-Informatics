// ������������ � ����� C++ �� �, �������, ����� ����
// ���� 15. ��������� �� ��������� ������ ��� �������
// ���� progr_15_05.cpp
#include <iostream>
using namespace std;
#include <ctime>

void setElms(int a[], int L, int minV, int maxV) {
    // ������� � a �������� ����� �� [minV;maxV].
    if (!a) return; // ������ �� ���������� �������� �� a
    if (maxV < minV) // ������ �� ���������� minV � maxV
    {
        int temp = minV;
        minV = maxV;
        maxV = temp;
    }
    for (int i = 0; i < L; ++i)
        a[i] = rand() % (maxV - minV + 1) + minV;
}

void writeArray(const int a[], int L) {
    // ������� ������.
    // const �������� ������ �� �������� �������
    if (a) // ������ �� ���������� a
    {
        for (int i = 0; i < L; ++i)
            cout << "  " << a[i];
        cout << endl;
    }
}

void indices(const int a[], int L, int value,
    int& first, int& Last)
{
    // ������� ��� first � Last ��� ��������� �� ������ � ���������
    // �������� �� ������ ��� �������� value, ��� ����� �������.
    // const � �������� ������ ������ ���� �� ������������
    if (!a) // ������ �� ���������� a
    {
        first = Last = -1;
        return;
    }
    first = 0;
    while (first < L && a[first] != value)
        ++first;
    if (first >= L) // >=L, ������ ��� � �������� L<0
        first = Last = -1;
    else {
        Last = L - 1;
        while (a[Last] != value)
            --Last;
    }
}

int main() {
    system("chcp 1251 > nul");
    srand((unsigned)time(NULL));
    const int Len = 10, Left = -5, Right = 3;
    int ar[Len];
    setElms(ar, Len, Left, Right);
    writeArray(ar, Len);
    int sVal, first, Last;
    cout << "�������� ������� ��������: ";
    cin >> sVal;
    indices(ar, Len, sVal, first, Last);
    if (-1 == first) cout << "  ���� ����� �������.\n";
    else cout << "  ������ �� ����� ����� �������: " << first
        << "\n  ������ �� �������� ����� �������: " << Last
        << endl;
}