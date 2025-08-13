// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_08.cpp
#include <iostream>
using namespace std;

// точка 1
void readArray( long a[ ], int L,
                const long dividers[ ], int Ld )
  // Въвежда масива a и контролира,
  // че всеки елемент ще се дели на поне едно число от dividers.
{
  // функцията трябва да работи смислено за всякакви параметри
  if( ! a || L < 1 ) {
    cout << "Няма масив за въвеждане.\n";
    return;
  }
  if( ! dividers || Ld < 1 ) {
    cout << "Няма масив от делители.\n";
    return;
  }
  int i = 0;
  while( i < Ld && 0 == dividers[i] )
    ++i;
  if( i == Ld ) {
    cout << "Няма ненулев делител.\n";
    return;
  }
  cout << "Въведете масив от " << L
       << " числа с поне по един делител:\n"
       << "  (допустими делители: ";
  for( i = 0; i < Ld; ++i )
    if( dividers[i] )
      cout << "  " << dividers[i];
  cout << ")\n";
  for( int num = 0; num < L; ++num )
    do {
      cout << "  " << num + 1 << "-о число: ";
      cin >> a[num];
      for( i = 0; i < Ld; ++i )
        if( dividers[i] && a[num] % dividers[i] == 0 )
          break;
    } while( i == Ld );
}

// точка 2
void writeArray( const long a[ ], int L ) {
  // Извежда масива.
  if( a && L > 0 )
  // функцията трябва да работи смислено за всяко a и L
  {
    for( int i = 0; i < L; ++i )
      cout << "  " << a[i];
    cout << endl;
  }
}

// точка 3
int main( ) {
  system("chcp 1251 > nul");
  const int Len = 10;
  long ar[Len], dividers[ ] = { 2, 3, 5, 7, 11, 13, 17, 19 };
  const int LenDividers = sizeof(dividers) / sizeof(dividers[0]);
  readArray(ar, Len, dividers, LenDividers);
  writeArray(ar, Len);
  for( long d : dividers ) {
    cout << "просто число " << d << " , дели:";
    for( long elm : ar )
      if( elm % d == 0 )
        cout << "  " << elm;
    cout << endl;
  }
}
