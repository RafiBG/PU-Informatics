// ������������ � ����� C++ �� �, �������, ����� ����
// ���� 15. ��������� �� ��������� ������ ��� �������
// ���� progr_15_03.cpp
#include <iostream>
using namespace std;
#include <ctime>
// 1.�)
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
// 1.�)
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
// 1.�)
int maxElm(const int a[], int L) {
    // ������ ��������� � ������.
      // ������ const ������ ������ ���� �� ������������
    if (!a || L < 1) // ������ �� ���������� ��������� �� a � L
        return 0; // ����� �������� ��������
    int max = a[0];
    for (int i = 1; i < L; ++i)
        if (a[i] > max)
            max = a[i];
    return max;
}
// 1.�)
int countOddPos(const int a[], int L) {
    // ��������� ��������� ����������� ��������.
    int num = 0;
    if (a) // �� �� �������� ������� ���� � �������� a
        for (int i = 0; i < L; ++i)
            if (a[i] > 0 && a[i] % 2)
                ++num;
    return num;
}
// 1.�)
double average(const int a[], int L) {
    // ��������� �������� ����������� �� ������ ��������.
    double sum = 0.0;
    if (!a || L < 1) // ��� ���������� ��������� �� a � L
        return sum; // ����� �������� ��������
    for (int i = 0; i < L; ++i)
        sum += a[i];
    return sum / L; // ���� � ������ ������ ������ ���� �� sum
}
// 1.�)
void invertOdd(int a[], int L) {
    // ������� ����� �� ��������� ��������.
    if (a) // ���� ��� �������� �������� �� a
        for (int i = 0; i < L; ++i)
            if (a[i] % 2) a[i] = -a[i];
}

int main() {
    system("chcp 1251 > nul");
    srand((unsigned)time(NULL));
    const int Len = 5, Left = -20, Right = 10;
    int ar[Len];
    setElms(ar, Len, Left, Right);
    writeArray(ar, Len);
    cout << "��������: " << maxElm(ar, Len) << endl;
    cout << "���� ������� �����������: " << countOddPos(ar, Len)
        << endl;
    cout << "������ �����������: " << average(ar, Len) << endl;
    invertOdd(ar, Len);
    writeArray(ar, Len);
}