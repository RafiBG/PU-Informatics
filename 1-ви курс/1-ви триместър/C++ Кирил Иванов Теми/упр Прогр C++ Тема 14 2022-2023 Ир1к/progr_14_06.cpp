// Програмиране с езика C++ за И, редовно, първи курс
// Тема 14. Въведение във функции.
//          Параметри от примитивен тип и от тип указател към
//          или псевдоним на примитивна стойност
// Файл progr_14_06.cpp
#include <iostream>
using namespace std;
double average( double n1, double n2, double n3, double & sum ) {
  sum = n1 + n2 + n3;
  return sum / 3;
}
int main( ) {
  system("chcp 1251 > nul");
  double x, y, z, sum = 0.0;
  // инициализирането на sum е необходимо само в MS Visual Studio
  cout << "Три числа: ";
  cin >> x >> y >> z;
  cout << "Средно аритметично: " << average(x, y, z, sum) << endl
       << "Сума: " << sum << endl;
}
