#include <iostream>
using namespace std;
int main()
{
    double next, max;
    int numMax = 0;
    do {
        cout << "Число(0 за край): ";
        cin >> next;
        if (next)
            if (0 == numMax || max < next)      //Задача 4.5.
            {
                max = next;
                numMax = 1;
            }
            else if (max == next) ++numMax;
    } while (next);
    cout << "Maксимум: " << max << "\n Брой максимални: " << numMax << endl;
    else cout << "Няма числа,различни от нула. \n";
}
