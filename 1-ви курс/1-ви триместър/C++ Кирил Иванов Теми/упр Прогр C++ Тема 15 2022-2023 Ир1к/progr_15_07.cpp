// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_07.cpp
#include <iostream>
using namespace std;

// точка 1
void readArray( long a[ ], int L )
  // Въвежда масива и контролира,
  // че най-много два елемента могат да са равни.
{
  if( ! a || L < 1 )
    // функцията трябва да работи смислено за всякакви параметри
  {
    cout << "Няма масив за въвеждане.\n";
    return;
  }
  cout << "Въведете масив от " << L
       << " числа (до 2 равни елемента):\n";
  for( int i = 0, num; i < L; ++i )
    do {
      cout << "  " << i + 1 << "-о число: ";
      cin >> a[i];
      for( int j = num = 0; j <= i; ++j )
        if( a[i] == a[j] )
          ++num;
    } while( num > 2 );
}

// точка 2
void matches( const long a1[ ], int L1, const long a2[], int L2 )
  // Извежда без повторения общите елементи на a1 и a2.
{
  if( ! a1 || L1 < 1 || ! a2 || L2 < 1 ) {
    cout << "Няма масиви за търсене на общи елементи.\n";
    return;
  }
  cout << "Общи елементи: ";
  for(int i = 0, f; i < L1; ++i) {
    for( f = 0; f < i && a1[f] != a1[i]; ++f );
    if( f < i ) continue; // когато a1[i] вече се е срещал в a1
    for( f = 0; f < L2 && a2[f] != a1[i]; ++f );
    if( f < L2 ) cout << " " << a1[i];
  }
  cout << endl;
}

// точка 3
int main( ) {
  system("chcp 1251 > nul");
  const int Len1 = 5, Len2 = 7;
  long ar1[Len1], ar2[Len2];
  readArray(ar1, Len1);
  readArray(ar2, Len2);
  matches(ar1, Len1, ar2, Len2);
}
