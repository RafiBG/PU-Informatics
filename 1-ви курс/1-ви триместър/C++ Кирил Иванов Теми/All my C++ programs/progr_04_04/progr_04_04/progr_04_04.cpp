#include <iostream>
using namespace std;
int main()
{
    system("chcp 1251 > nul");
    double next, max;
    int numMax = 0;
    do {
        cout << "����� (0 �� ����): ";
        cin >> next;
        if (0 == numMax || max < next)
        {
            max = next;                   //������ 4.4.
            numMax = 1;
        }
        else if (max == next) ++numMax;
    } while (next);
    cout << "��������: " << max << "\n ���� ��������� �� ���������: "
        << numMax << endl;
}
