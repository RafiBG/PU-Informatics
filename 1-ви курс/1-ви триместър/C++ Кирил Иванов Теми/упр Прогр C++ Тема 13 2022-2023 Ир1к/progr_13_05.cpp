// Програмиране с езика C++ за И, редовно, първи курс
// Тема 13. Двумерни масиви
// Файл progr_13_05.cpp
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  srand((unsigned) time(NULL));
  const int Len = 5, width = 4;
  int tabl[Len][Len];
  for (int i = Len * Len - 1; i >= 0; --i)
    tabl[0][i] = i + 1;
  for (auto &r : tabl) {
    for (auto elm : r)
      cout << setw(width) << elm;
    cout << endl;
  }
  cout << endl;
  for (int r = 0, c = Len - 1; r < Len; c > 0 ? --c : ++r) {
    for (int r1 = r, c1 = c; r1 < Len && c1 < Len; ++r1, ++c1)
      cout << " " << tabl[r1][c1];
    cout << endl;
  }
}
