// Програмиране с езика C++ за И, редовно, първи курс
// Тема 11. Указатели и псевдоними
// Файл progr_11_09_demo.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  int ar[] = { 11, 22, 33, 44, 55 };
  const int arLen = sizeof(ar) / sizeof(ar[0]);
  int * p = ar;
  for(int i = 0; i < arLen; ++i) cout << "  " << *(p + i);
  cout << endl;
  p = ar + arLen - 1;
  for(int i = 0; i < arLen; ++i) cout << "  " << *(p - i);
  cout << endl;
  p = ar + 3;
  for(int i = -3; i < arLen - 3; ++i) cout << "  " << *(p + i);
  cout << "\n  --------\n";
  for(p = ar; p - ar < arLen; ++p) cout << "  " << *p;
  cout << endl;
  for(p = ar + arLen - 1; p >= ar; --p) cout << "  " << *p;
  cout << endl;
  for(p = ar; p - ar < arLen;  p += 2) cout << "  " << *p;
  cout << "  (само с четни индекси)\n";
  for(p = ar; p - ar < arLen; ++p)
    cout << *p << " има индекс " << p - ar << endl;
}
