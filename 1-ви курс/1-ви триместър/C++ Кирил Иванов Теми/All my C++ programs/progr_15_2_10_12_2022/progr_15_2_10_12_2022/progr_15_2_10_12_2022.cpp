// ������������ � ����� C++ �� �, �������, ����� ����
// ���� 15. ��������� �� ��������� ������ ��� �������
// ���� progr_15_02_demo.cpp
#include <iostream>
using namespace std;
void demo1(long a[5])
// ��������� �� ������ � ���������� ���� ���� ���������� a
{
    // ����������� a � �� ��� long *
    cout << "demo1: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // �� ���� for(long elm : a)...
}
void demo2(long a[5000])
// ��������� �� ������ � ���������� ���� ���� ���������� a
{
    // ����������� a � �� ��� long *
    cout << "demo2: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // �� ���� for(long elm : a)...
}
void demo3(long a[])
// ��������� �� ������ � ���������� ���� ���� ���������� a
{
    // ����������� a � �� ��� long *
    cout << "demo3: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // �� ���� for(long elm : a)...
}
void demo4(long* a)
// ��������� �� ������ � ���������� ���� ���� ���������� a
{
    // ����������� a � �� ��� long *
    cout << "demo4: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // �� ���� for(long elm : a)...
}
void readArray(long a[], int L)
// ���� � �������� ��������� �� ������ ���� ���������
{
    if (!a) { // ��������� ������ �� ������ �������� ��� ����� a
        cout << "���� �������� �� ���������.\n";
        return;
    }
    cout << "�������� " << L << " ���� �����:\n";
    for (int i = 0; i < L; ++i) {
        cout << "  " << i + 1 << "-� �����: ";
        cin >> a[i];
    }
}
void writeArray(const long a[], int L)
// ���� � �������� ��������� �� ������ ���� ���������
{
    // const ��������� ��������� �� ������� �� ������
    // ���� � ������, ������ ���������� �� ��������� �� ��������
    // ���� ��������� ��� �������� �� ���.
    if (a) // ��������� ������ �� ������ �������� ��� �������� a
    {
        for (int i = 0; i < L; ++i) cout << a[i] << "  ";
        cout << endl;
    }
}
int main() {
    system("chcp 1251 > nul");
    long ar[] = { 11L, 22L, 33L, 44L, 55L };
    long* p = ar;
    for (long elm : ar) cout << "  " << elm;
    cout << endl;
    // �� ���� for(long elm : p)...
    cout << "typeid(ar).name() -> " << typeid(ar).name() << endl;
    cout << "typeid(p).name() -> " << typeid(p).name() << endl;
    cout << "----- � ���������� ��������� ar ---\n";
    demo1(ar);
    demo2(ar);
    demo3(ar);
    demo4(ar);
    cout << "----- � ���������� ��������� p -----\n";
    demo1(p);
    demo2(p);
    demo3(p);
    demo4(p);
    cout << "------------------------------------\n";
    const int arLen = sizeof(ar) / sizeof(ar[0]);
    readArray(ar, arLen);
    writeArray(ar, arLen);
}