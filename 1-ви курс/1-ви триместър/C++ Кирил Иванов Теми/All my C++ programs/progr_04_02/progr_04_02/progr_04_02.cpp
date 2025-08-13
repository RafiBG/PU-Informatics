#include <iostream>
using namespace std;
int main()
{
    system("chcp 1251 > nul");
    int next, odd = 2, numEven = 0;    //Задача 4.2.
    do {
        cout << "Цяло число (за край - две разлимни нечетни): ";
        cin >> next;
        if (next % 2 == 0) ++numEven;
        else if (2 == odd) odd = next;
    } while (next % 2 == 0 || next == odd);
    cout << "Брой прочетени четни " << numEven
        << "\n Прочетени различни нечетни: " << odd << ", " << next << endl;
}

