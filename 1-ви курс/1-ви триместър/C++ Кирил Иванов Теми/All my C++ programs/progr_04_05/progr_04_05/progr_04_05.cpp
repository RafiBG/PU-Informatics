#include <iostream>
using namespace std;
int main()
{
    double next, max;
    int numMax = 0;
    do {
        cout << "�����(0 �� ����): ";
        cin >> next;
        if (next)
            if (0 == numMax || max < next)      //������ 4.5.
            {
                max = next;
                numMax = 1;
            }
            else if (max == next) ++numMax;
    } while (next);
    cout << "Ma������: " << max << "\n ���� ����������: " << numMax << endl;
    else cout << "���� �����,�������� �� ����. \n";
}
