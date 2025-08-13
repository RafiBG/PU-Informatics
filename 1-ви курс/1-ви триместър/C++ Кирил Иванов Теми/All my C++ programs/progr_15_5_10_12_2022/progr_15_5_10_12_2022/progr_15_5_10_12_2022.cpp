// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_05.cpp
#include <iostream>
using namespace std;
#include <ctime>

void setElms(int a[], int L, int minV, int maxV) {
    // Записва в a случайни числа от [minV;maxV].
    if (!a) return; // защита от некоректна стойност на a
    if (maxV < minV) // защита от некоректни minV и maxV
    {
        int temp = minV;
        minV = maxV;
        maxV = temp;
    }
    for (int i = 0; i < L; ++i)
        a[i] = rand() % (maxV - minV + 1) + minV;
}

void writeArray(const int a[], int L) {
    // Извежда масива.
    // const защитава масива от случайни промени
    if (a) // защита от некоректно a
    {
        for (int i = 0; i < L; ++i)
            cout << "  " << a[i];
        cout << endl;
    }
}

void indices(const int a[], int L, int value,
    int& first, int& Last)
{
    // Записва във first и Last или индексите на първия и последния
    // елементи на масива със стойност value, или минус единици.
    // const е написано заради добрия стил на програмиране
    if (!a) // защита от некоректно a
    {
        first = Last = -1;
        return;
    }
    first = 0;
    while (first < L && a[first] != value)
        ++first;
    if (first >= L) // >=L, защото тук е възможно L<0
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
    cout << "Въведете търсена стойност: ";
    cin >> sVal;
    indices(ar, Len, sVal, first, Last);
    if (-1 == first) cout << "  Няма такъв елемент.\n";
    else cout << "  Индекс на първи такъв елемент: " << first
        << "\n  Индекс на последен такъв елемент: " << Last
        << endl;
}