// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_03.cpp
#include <iostream>
using namespace std;
#include <ctime>
// 1.а)
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
// 1.б)
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
// 1.в)
int maxElm(const int a[], int L) {
    // Намира максимума в масива.
      // думата const следва добрия стил на програмиране
    if (!a || L < 1) // защита от некоректни стойности на a и L
        return 0; // връща фиктивна стойност
    int max = a[0];
    for (int i = 1; i < L; ++i)
        if (a[i] > max)
            max = a[i];
    return max;
}
// 1.г)
int countOddPos(const int a[], int L) {
    // Преброява нечетните положителни елементи.
    int num = 0;
    if (a) // за да стартира цикълът само с коректно a
        for (int i = 0; i < L; ++i)
            if (a[i] > 0 && a[i] % 2)
                ++num;
    return num;
}
// 1.д)
double average(const int a[], int L) {
    // Изчислява средното аритметично на всички елементи.
    double sum = 0.0;
    if (!a || L < 1) // при неправилни стойности на a и L
        return sum; // връща фиктивна стойност
    for (int i = 0; i < L; ++i)
        sum += a[i];
    return sum / L; // това е дробно делене заради типа на sum
}
// 1.е)
void invertOdd(int a[], int L) {
    // Променя знака на нечетните елементи.
    if (a) // само при смислена стойност на a
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
    cout << "Максимум: " << maxElm(ar, Len) << endl;
    cout << "Брой нечетни положителни: " << countOddPos(ar, Len)
        << endl;
    cout << "Средно аритметично: " << average(ar, Len) << endl;
    invertOdd(ar, Len);
    writeArray(ar, Len);
}