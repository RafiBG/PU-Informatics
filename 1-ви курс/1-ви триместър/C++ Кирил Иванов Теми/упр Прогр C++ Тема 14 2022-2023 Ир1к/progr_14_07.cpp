// Програмиране с езика C++ за И, редовно, първи курс
// Тема 14. Въведение във функции.
//          Параметри от примитивен тип и от тип указател към
//          или псевдоним на примитивна стойност
// Файл progr_14_07.cpp
#include <iostream>
using namespace std;
int numMinMax( double & rMin, double * pMax ) {
  double next;
  int num = 0;
  rMin = *pMax = 0.0; // при отсъствие на ненулеви се връщат нули
  do {
    cout << "Въведете число (0 за край): ";
    cin >> next;
    if( 0.0 == rMin || 0.0 != next && rMin > next )
      rMin = next;
    if( 0.0 == *pMax || 0.0 != next && *pMax < next )
      *pMax = next;
    if( next )
      ++num;
  } while( next );
  return num;
}
int main( ) {
  system("chcp 1251 > nul");
  double min, max;
  int number = numMinMax(min, &max);
  cout << "Брой ненулеви числа: " << number << endl;
  if( number )
    cout << "Минимално ненулево число: " << min << endl
         << "Максимално ненулево число: " << max << endl;
}
