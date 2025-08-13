// Програмиране с езика C++ за И, редовно, първи курс
// Тема 13. Двумерни масиви
// Файл progr_13_02_demo.cpp
#include <iostream>
using namespace std;
#include <iomanip>
const int rLen = 3, cLen = 4;
long ar1[rLen][cLen],
     ar2[rLen][cLen] = { {   1,   2,   3,   4 },
                         {  -1,  -2,  -3,  -4 },
                         { 111, 222, -33, -44 }
                       },
     ar3[][cLen] = { {   1,   2 },
                     {  -1,  -2,  -3,   -4 },
                     {  11,  22 },
                     {  11,  22,  33,   44 },
                     { -11, -22, -33, -444 },
                     { 111, 222, -33,  -44 }
                   };
int main() {
  system("chcp 1251 > nul");
  long ar4[rLen][cLen];
  const int c5Len = 3;
  long ar5[][c5Len] = { {1, 2}, {3, 4}, 5, 6, 7, 8 };
  const int r5Len = sizeof(ar5) / sizeof(ar5[0]);
  for (int r = 0; r < rLen; ++r) {
    for (int c = 0; c < cLen; ++c) cout << "  " << ar1[r][c];
    cout << endl;
  }
  cout << "------------\n";
  for(auto & row : ar2) {
    for (auto elm : row) cout << setw(5) << elm;
    cout << endl;
  }
  cout << "------------\n";
  for (auto & row : ar3) {
    for (auto elm : row) cout << setw(5) << elm;
    cout << endl;
  }
  cout << "------------\n";
  cout << "масив без инициализация:\n";
  for (auto & row : ar4) {
    for (auto elm : row) cout << "  " << elm;
    cout << endl;
  }
  cout << "------------\n";
  for (auto & row : ar5) {
    for (auto elm : row) cout << setw(6) << elm;
    cout << endl;
  }
  cout << "------------\n";
  cout << "r5Len -> " << r5Len << endl;
  for (auto & row : ar5)
    for (auto & elm : row)
      elm *= 1000;
  for (auto& row : ar5) {
    for (auto elm : row) cout << setw(6) << elm;
    cout << endl;
  }
}
