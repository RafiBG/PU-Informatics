// Програмиране с езика C++ за И, редовно, първи курс
// Тема 14. Въведение във функции.
//          Параметри от примитивен тип и от тип указател към
//          или псевдоним на примитивна стойност
// Файл progr_14_04.cpp
#include <iostream>
using namespace std;
#include <iomanip>
long readNumMinMax( long minValue, long maxValue ) {
  long num;
  if( minValue > maxValue ) {
    // функцията трябва да работи смислено
    // с параметрите от всяко възможно извикване
    num = minValue;
    minValue = maxValue;
    maxValue = num;
  }
  do {
    cout << "Въведете цяло число от " << minValue << " до "
         << maxValue << ": ";
    cin >> num;
  } while( num < minValue || num > maxValue );
  return num;
}
void printRomb( char ch, long num ) {
  if( num < 3 || 21 < num ) {
    cout << ch << endl;
    return;
  }
  for( int min = -num / 2, first = -min, second = 0;
       first >= min;
       --first, second += first >= 0 ? 2 : -2 )
  {
    cout << setw(1 + abs(first)) << ch;
    if( second ) cout << setw(second) << ch;
    cout << endl;
  }
}
int main( ) {
  system("chcp 1251 > nul");
  const long Left = 1, Right = 30;
  printRomb( '&', readNumMinMax(Left, Right) );

}
