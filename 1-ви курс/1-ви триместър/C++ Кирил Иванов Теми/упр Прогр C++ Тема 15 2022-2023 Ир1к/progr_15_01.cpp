// Програмиране с езика C++ за И, редовно, първи курс
// Тема 15. Предаване на едномерни масиви към функции
// Файл progr_15_01.cpp
#include <iostream>
using namespace std;
void changeMinMax(double *p1, double *p2, double *p3) {
  double *p = p1;
  if (*p1 > *p2) p1 = p2;
  if (*p1 > *p3) p1 = p3;
  if (*p3 < *p) p3 = p;
  if (*p3 < *p2) p3 = p2;
  double temp = *p1;
  *p1 = *p3;
  *p3 = temp;
}
void changeMinMax(double &r1, double &r2, double &r3) {
  double &min = r1 < r2 ? r1 < r3 ? r1 : r3
                        : r2 < r3 ? r2 : r3,
         &max = r1 > r2 ? r1 > r3 ? r1 : r3
                        : r2 > r3 ? r2 : r3;
  double temp = min;
  min = max;
  max = temp;
}
int main() {
  system("chcp 1251 > nul");
  double x, y, z;
  cout << "Три числа: ";
  cin >> x >> y >> z;
  cout << "x -> " << x << " ; y -> " << y << " ; z -> " << z
       << endl;
  changeMinMax(&x, &y, &z);
  cout << "x -> " << x << " ; y -> " << y << " ; z -> " << z
         << endl;
  changeMinMax(x, y, z);
  cout << "x -> " << x << " ; y -> " << y << " ; z -> " << z
       << endl;
}


