#include <iostream>
using namespace std;
int main()
{
    system("chcp 1251 > nul");
    int next, odd = 2, numEven = 0;    //������ 4.2.
    do {
        cout << "���� ����� (�� ���� - ��� �������� �������): ";
        cin >> next;
        if (next % 2 == 0) ++numEven;
        else if (2 == odd) odd = next;
    } while (next % 2 == 0 || next == odd);
    cout << "���� ��������� ����� " << numEven
        << "\n ��������� �������� �������: " << odd << ", " << next << endl;
}

