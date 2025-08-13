// Програмиране с езика C++ за И, редовно, първи курс
// Тема 14. Въведение във функции.
//          Параметри от примитивен тип и от тип указател към
//          или псевдоним на примитивна стойност
// Файл progr_14_05_demo.cpp
#include <iostream>
using namespace std;
void setUp(double & u, double & v, double & w) {
  double temp;
  if (u > v) { temp = u; u = v; v = temp; }
  if (u > w) { temp = u; u = w; w = temp; }
  if (v > w) { temp = v; v = w; w = temp; }
  //cout << "u  v  w    -->>    " << u << "  " << v << "  " << w << endl;
}
void setUp(double * u, double * v, double * w) {
  double temp;
  if (*u > *v) { temp = *u; *u = *v; *v = temp; }
  if (*u > *w) { temp = *u; *u = *w; *w = temp; }
  if (*v > *w) { temp = *v; *v = *w; *w = temp; }
}
int main() {
  system("chcp 1251 > nul");
  double x, y, z;
  cout << "Три числа: ";
  cin >> x >> y >> z;
  setUp(x, y, z);
  cout << x << " <= " << y << " <= " << z << endl;
  setUp(& z, & y, & x);
  cout << z << " <= " << y << " <= " << x << endl;
}
