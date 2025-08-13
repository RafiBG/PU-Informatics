// Програмиране с езика C++ за И, редовно, първи курс
// Тема 14. Въведение във функции.
//          Параметри от примитивен тип и от тип указател към
//          или псевдоним на примитивна стойност
// Файл progr_14_01_demo.cpp
#include <iostream>
using namespace std;
#include <iomanip>

void demo1() {
  cout << "Начало на илюстрацията.\n";
}

string demo2() {
  return "Край на илюстрацията."s;
  // суфиксът s в края на низовия литерал означава,
  // че литералът е от тип string
}

const char demo3() {
  return '\n';
}

void printChar(char ch, int num) {
  // num > 0
  /* Условието num > 0 е пожелание за извикването на функцията,
   но дефиницията на функцията трябва да се застрахова,
   че ще работи смислено при всяко възможно извикване.
   */
  char chOld = cout.fill(ch);
  if (num < 1) num = 1;
  cout << setw(num) << ch << endl;
  cout.fill(chOld);
}

long sum3(long n1, long n2, long n3) {
  return n1 + n2 + n3;
}

int main() {
  system("chcp 1251 > nul");

  demo1();

  printChar('=', 20);

  long x, y, z;
  cout << "Три цели числа: ";
  cin >> x >> y >> z;

  printChar('=', 25);

  cout << "Сума: " << sum3(x, y, z) << endl;
  printChar('=', 30);
  
  // следва предварителна декларация
  // void viewSum3(long, long, long);
  void viewSum3(long param1, long param2, long param3);
  // Имената на параметри в предварителната декларация
  // се игнорират от транслатора, но се използват за подсказки.
  
  viewSum3(x, y, z);

  printChar('=', 35);

  cout << "typeid(demo1).name() -> " << typeid(demo1).name()
       << endl;
  cout << "typeid(demo2).name() -> " << typeid(demo2).name()
       << endl;
  cout << "typeid(sum3).name() -> " << typeid(sum3).name()
       << endl;
  cout << "typeid(viewSum3).name() -> "
       << typeid(viewSum3).name()
       << endl;

  printChar('=', 45);

  cout << demo2() << demo3();
}

void viewSum3(long u, long v, long w) {
  cout << u << " + " << v << " + " << w << " = " << sum3(u, v, w)
       << endl;
}
