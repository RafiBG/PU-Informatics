// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_02_demo.cpp
#include <iostream>
using namespace std;
void demo1(long a[5])
// дължината на масива е недостъпна САМО чрез параметъра a
{
    // параметърът a е от тип long *
    cout << "demo1: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // не може for(long elm : a)...
}
void demo2(long a[5000])
// дължината на масива е недостъпна САМО чрез параметъра a
{
    // параметърът a е от тип long *
    cout << "demo2: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // не може for(long elm : a)...
}
void demo3(long a[])
// дължината на масива е недостъпна САМО чрез параметъра a
{
    // параметърът a е от тип long *
    cout << "demo3: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // не може for(long elm : a)...
}
void demo4(long* a)
// дължината на масива е недостъпна САМО чрез параметъра a
{
    // параметърът a е от тип long *
    cout << "demo4: sizeof(a) -> " << sizeof(a) << endl
        << "       typeid(a).name() -> " << typeid(a).name()
        << endl;
    // не може for(long elm : a)...
}
void readArray(long a[], int L)
// това е правилно предаване на масива чрез параметри
{
    if (!a) { // функцията трябва да работи смислено при всяко a
        cout << "Няма елементи за въвеждане.\n";
        return;
    }
    cout << "Въведете " << L << " цели числа:\n";
    for (int i = 0; i < L; ++i) {
        cout << "  " << i + 1 << "-о число: ";
        cin >> a[i];
    }
}
void writeArray(const long a[], int L)
// това е правилно предаване на масива чрез параметри
{
    // const забранява промяната на елемент от масива
    // Това е удобно, когато заглавието на функцията се използва
    // като подсказка при писането на код.
    if (a) // функцията трябва да работи смислено при всякакво a
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
    // не може for(long elm : p)...
    cout << "typeid(ar).name() -> " << typeid(ar).name() << endl;
    cout << "typeid(p).name() -> " << typeid(p).name() << endl;
    cout << "----- с фактически параметър ar ---\n";
    demo1(ar);
    demo2(ar);
    demo3(ar);
    demo4(ar);
    cout << "----- с фактически параметър p -----\n";
    demo1(p);
    demo2(p);
    demo3(p);
    demo4(p);
    cout << "------------------------------------\n";
    const int arLen = sizeof(ar) / sizeof(ar[0]);
    readArray(ar, arLen);
    writeArray(ar, arLen);
}