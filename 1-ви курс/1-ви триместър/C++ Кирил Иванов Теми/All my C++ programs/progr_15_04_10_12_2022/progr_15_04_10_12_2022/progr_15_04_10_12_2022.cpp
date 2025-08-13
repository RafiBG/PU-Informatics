// ������������ � ����� C++ �� �, �������, ����� ����
// ���� 15. ��������� �� ��������� ������ ��� �������
// ���� progr_15_04.cpp
#include <iostream>
using namespace std;

// 1.�)
void readArray(long a[], int L, long minV, long maxV) {
    // ������� ������
    // � ���������� ���������� �� ����� �� minV �� maxV.
    if (!a || L < 1)
        // ��������� ������ �� ������ �������� �� ����� a
    {
        cout << "���� ����� �� ���������.\n";
        return;
    }
    if (minV > maxV) {
        // �� ��������� �� �������� ����� � do...while ��-������
        long temp = minV;
        minV = maxV;
        maxV = temp;
    }
    cout << "��������� �� ����� �� " << L << " ���� �����:\n";
    // ����� �� ���������� �� ������ � �������� ���� ���� �������;
    // ���������� � ����� for(... : a) ...
    for (int i = 0; i < L; ++i)
        do {
            cout << "  " << i + 1 << "-� ����� (�� " << minV << " �� "
                << maxV << "): ";
            cin >> a[i];
        } while (a[i] < minV || maxV < a[i]);
}

// 1.�)
long getMin(const long a[], int L)
// ������ ����������� �������� �� ������� �� ������.
// const ��������� ����� ������� �� ������
{
    if (!a || L < 1)
        // ��������� ������ �� ������ �������� �� �������� a � L
        return LONG_MIN; // ����� �������� ��������
    long min = a[0];
    for (int i = 1; i < L; ++i)
        if (min > a[i])
            min = a[i];
    return min;
}

// 1.�)
long getAndCountMin(const long a[], int L, int& number)
// ������������ ����� ����������� �������� �� �������
// � ������� � number ���� �� ����������� ��������.
  // const ��������� ����� ������� �� ������
{
    if (!a || L < 1)
        // ��������� ������ �� ������ �������� �� �������� a � L
    {
        number = 0;
        return LONG_MIN; // ����� �������� ��������
    }
    long min = a[0];
    number = 1;
    for (int i = 1; i < L; ++i)
        if (min == a[i]) ++number;
        else if (min > a[i]) {
            min = a[i];
            number = 1;
        }
    return min; // number � �������� ���������� �� ��� � ������
}

// 1.�)
int countOdd(const long a[], int L)
// ������ ���� �� ��������� �������� � ������.
// const �� �� ���� ���� � �������� ������� �� ������
{
    int num = 0;
    if (a) // ��������� ������ �� ������ �������� �� ����� a
        for (int i = 0; i < L; ++i)
            if (a[i] % 2)
                ++num;
    return num;
}

// 1.�)
double average(const long a[], int L)
// ��������� �������� ����������� �� ������ �������� � ������.
// const ��������� ������ ���� �� ������ � �����
{
    if (!a || L < 1)
        // ��������� ������ �� ������ �������� � �������� ���������;
        // L �� ���������� ������ ��������� return ��-������
        return 0.0; // ����� �������� ��������
    long long sum = 0LL;
    // long long ������ ������ ���� �� � ��� ������� �� ���� long
  // ���� ���� double sum, �� � ���� ����� �� ��������� ��-�����
    for (int i = 0; i < L; ++i)
        sum += a[i];
    return sum / (double)L; // ��� ������ L!=0 �� ������� ��������
    // ��������������� ��� double ��������� ������ ������
}

// 1.�) � ���� ������� ��������
long getMaxNeg(const long a[], int L)
// ����� ����������� ����������� ������� � ������.
// const ���������, �� ������� �� ���� ����� ���� ������������
{
    long max = 1; // ��������, ������ ���� ����������� �������
    if (!a) // ��������� ������ �� ������ �������� �� ����� a
        return max; // ���������� 1 ��������, �� ���� �����������
    for (int i = 0; i < L; ++i)
        if (a[i] < 0 && (1 == max || max < a[i]))
            max = a[i];
    return max;
}

// 1.�) � ��� ������� ���������
bool getMaxNeg(const long a[], int L, long& max)
// ����� true, ����� ������ ��� ����������� ������� � ������,
// � ������� � max ����������� ����������� ������� �� ������.
  // const ����� ���������� ��������� �� ������
  // ����� �� ��������� � ������, ����� �� �����������,
  // �� �������� �� ��������� �� ����� ������� �� ������������.
{
    max = 1; // 1 ��������, �� ���� ������� ����������� �������
    if (a) // ��������� ������ �� ������ �������� �� ����� a
        for (int i = 0; i < L; ++i)
            if (a[i] < 0 && (max >= 0.0 || max < a[i]))
                max = a[i];
    return max < 0;
}

int main() {
    system("chcp 1251 > nul");
    const int Len = 5;
    const long minValue = -100, maxValue = 50;
    long ar[Len];
    readArray(ar, Len, minValue, maxValue);
    cout << "�������: " << getMin(ar, Len) << endl;
    int numMin = 0;
    cout << "�������: " << getAndCountMin(ar, Len, numMin) << endl
        << "���� ���������: " << numMin << endl;
    cout << "���� �� ���������: " << countOdd(ar, Len) << endl;
    cout << "������ �����������: " << average(ar, Len) << endl;
    long maxNeg = getMaxNeg(ar, Len);
    if (maxNeg >= 0.0)
        cout << "���� ����������� ��������.\n";
    else
        cout << "���������� ����������� �������: " << maxNeg << endl;

    if (getMaxNeg(ar, Len, maxNeg))
        cout << "���������� ����������� �������: " << maxNeg << endl;
    else
        cout << "���� ����������� ��������.\n";
}