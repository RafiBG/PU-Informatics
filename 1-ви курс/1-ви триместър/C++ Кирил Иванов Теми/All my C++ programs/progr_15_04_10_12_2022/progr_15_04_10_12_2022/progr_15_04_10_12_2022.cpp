// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_04.cpp
#include <iostream>
using namespace std;

// 1.а)
void readArray(long a[], int L, long minV, long maxV) {
    // Въвежда масива
    // и контролира елементите да бъдат от minV до maxV.
    if (!a || L < 1)
        // функцията трябва да работи смислено за всяко a
    {
        cout << "Няма масив за въвеждане.\n";
        return;
    }
    if (minV > maxV) {
        // за избягване на безкраен цикъл в do...while по-надолу
        long temp = minV;
        minV = maxV;
        maxV = temp;
    }
    cout << "Въвеждане на масив от " << L << " цели числа:\n";
    // цикъл по елементите на масива е възможен само чрез индекси;
    // невъзможен е цикъл for(... : a) ...
    for (int i = 0; i < L; ++i)
        do {
            cout << "  " << i + 1 << "-о число (от " << minV << " до "
                << maxV << "): ";
            cin >> a[i];
        } while (a[i] < minV || maxV < a[i]);
}

// 1.б)
long getMin(const long a[], int L)
// Намира минималната стойност на елемент от масива.
// const забранява всяка промяна на масива
{
    if (!a || L < 1)
        // функцията трябва да работи смислено за всякакви a и L
        return LONG_MIN; // връща фиктивна стойност
    long min = a[0];
    for (int i = 1; i < L; ++i)
        if (min > a[i])
            min = a[i];
    return min;
}

// 1.в)
long getAndCountMin(const long a[], int L, int& number)
// Едновременно връща минималната стойност на елемент
// и записва в number броя на минималните елементи.
  // const забранява всяка промяна на масива
{
    if (!a || L < 1)
        // функцията трябва да работи смислено за всякакви a и L
    {
        number = 0;
        return LONG_MIN; // връща фиктивна стойност
    }
    long min = a[0];
    number = 1;
    for (int i = 1; i < L; ++i)
        if (min == a[i]) ++number;
        else if (min > a[i]) {
            min = a[i];
            number = 1;
        }
    return min; // number е получила стойността си още в цикъла
}

// 1.г)
int countOdd(const long a[], int L)
// Намира броя на нечетните елементи в масива.
// const за да няма дори и случайна проманя на масива
{
    int num = 0;
    if (a) // функцията трябва да работи смислено за всяко a
        for (int i = 0; i < L; ++i)
            if (a[i] % 2)
                ++num;
    return num;
}

// 1.д)
double average(const long a[], int L)
// Изчислява средното аритметично на всички елементи в масива.
// const осигурява добрия стил на работа с масив
{
    if (!a || L < 1)
        // функцията трябва да работи смислено с всякакви параметри;
        // L се контролира заради командата return по-надолу
        return 0.0; // връща фиктивна стойност
    long long sum = 0LL;
    // long long защото сумата може да е над обхвата на типа long
  // може също double sum, но с цели числа се изчислява по-бързо
    for (int i = 0; i < L; ++i)
        sum += a[i];
    return sum / (double)L; // тук искаме L!=0 за смислен резултат
    // преобразуването към double осигурява дробно делене
}

// 1.е) с една връщана стойност
long getMaxNeg(const long a[], int L)
// Търси максималния отрицателен елемент в масива.
// const гарантира, че масивът ще бъде същия след изпълнението
{
    long max = 1; // резултат, когато няма отрицателен елемент
    if (!a) // функцията трябва да работи смислено за всяко a
        return max; // стойността 1 означава, че няма отрицателни
    for (int i = 0; i < L; ++i)
        if (a[i] < 0 && (1 == max || max < a[i]))
            max = a[i];
    return max;
}

// 1.е) с две връщани стойности
bool getMaxNeg(const long a[], int L, long& max)
// Връща true, точно когато има отрицателен елемент в масива,
// и записва в max максималния отрицателен елемент от масива.
  // const прави невъзможна промяната на масива
  // Името на функцията е същото, както на предходната,
  // но наборите от параметри на двете функции са несъвместими.
{
    max = 1; // 1 означава, че няма намерен отрицателен елемент
    if (a) // функцията трябва да работи смислено за всяко a
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
    cout << "Минимум: " << getMin(ar, Len) << endl;
    int numMin = 0;
    cout << "Минимум: " << getAndCountMin(ar, Len, numMin) << endl
        << "Брой минимални: " << numMin << endl;
    cout << "Брой на нечетните: " << countOdd(ar, Len) << endl;
    cout << "Средно аритметично: " << average(ar, Len) << endl;
    long maxNeg = getMaxNeg(ar, Len);
    if (maxNeg >= 0.0)
        cout << "Няма отрицателни елементи.\n";
    else
        cout << "Максимален отрицателен елемент: " << maxNeg << endl;

    if (getMaxNeg(ar, Len, maxNeg))
        cout << "Максимален отрицателен елемент: " << maxNeg << endl;
    else
        cout << "Няма отрицателни елементи.\n";
}