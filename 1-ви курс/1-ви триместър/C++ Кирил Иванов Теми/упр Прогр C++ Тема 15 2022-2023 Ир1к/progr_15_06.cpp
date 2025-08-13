// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_06.cpp
#include <iostream>
using namespace std;

void setElms( int a[ ], int L, int minV, int maxV ) {
  // Записва в a случайни числа от [minV;maxV].
  if( ! a ) return; // защита от некоректна стойност на a
  if( maxV < minV ) // защита от некоректни minV и maxV
  {
    int temp = minV;
    minV = maxV;
    maxV = temp;
  }
  for( int i = 0; i < L; ++i )
    a[i] = rand( ) % (maxV - minV + 1) + minV;
}

void writeArray( const int a[ ], int L ) {
  // Извежда масива.
  if( a ) // защита от некоректно a
  {
    for( int i = 0; i < L; ++i )
      cout << "  " << a[i];
    cout << endl;
  }
}

int countPairs( const int a[ ], int L ) {
  // Преброява двойките съседни елементи с еднаква четност.
  if( ! a || L < 1 ) // защита от некоректни стойности на a и L
    return 0;
  int number = 0;
  for( int i = 1; i < L; ++i )
    if( (a[i - 1] % 2 == 0) == (a[i] % 2 == 0) )
      ++number;
  return number;
}

void viewElements( const int a[ ], int L ) {
  // Извежда всички елементи, заедно с индексите им, които
  // имат два непосредствени, ненулеви съседа с различен знак.
  cout << "Елементи с ненулеви съседи с различен знак:\n";
  if( a ) // само при смислена стойност на a
    for( int i = 2; i < L; ++i )
      if( a[i - 2] * a[i] < 0 )
        cout << "    елемент: " << a[i - 1]
             << " ; индекс: " << i - 1 << endl;
  cout << "  (край на елементите)\n";
}

int main( ) {
  system("chcp 1251 > nul");
  srand((unsigned)time(NULL));
  const int Len = 15, Left = -10, Right = 5;
  int ar[Len];
  setElms(ar, Len, Left, Right);
  writeArray(ar, Len);
  cout << "Брой двойки съседни с еднаква четност: "
       << countPairs(ar, Len) << endl;
  viewElements(ar, Len);
}
