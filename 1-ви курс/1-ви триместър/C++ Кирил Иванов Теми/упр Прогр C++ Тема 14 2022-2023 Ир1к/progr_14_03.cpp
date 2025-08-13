// Програмиране с езика C++ за И, редовно, първи курс
// Тема 14. Въведение във функции.
//          Параметри от примитивен тип и от тип указател към
//          или псевдоним на примитивна стойност
// Файл progr_14_03.cpp
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
void printTriangle( char ch, long width ) {
  if( width < 2 || 15 < width ) {
    cout << ch << endl;
    return;
  }
  char oldCh = cout.fill(ch);
  for( int w = 1; w <= width; ++w )
    cout << setw(w) << ch << endl;
  cout.fill(oldCh);
}
int main( ) {
  system("chcp 1251 > nul");
  const long Left = 1, Right = 30;
  printTriangle('|', readNumMinMax(Left, Right));

}
