// Програмиране с езика C++ за И, редовно, първи курс
// Тема 13. Двумерни масиви
// Файл progr_13_01_demo.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  const int Len = 6;
  long a[Len];
  typedef long TArr[Len]; // декларира ново име на тип на масив
  TArr ar1 = { 11L, 22L, 33L }; // използва името на тип
  for (auto elm : ar1) cout << "  " << elm;
  // auto декларира, че типът на elm ще бъде същия,
  // като типа на стойността, с която се инициализира elm
  cout << endl;
  decltype(ar1) ar2; // decltype(ar1) назовава точно типа на ar1
  for (auto & elm : ar2) elm = ar1[0] += 100;
  cout << "===============\n";
  for (auto elm : ar2) cout << "  " << elm;
  cout << endl;
  long (& refAr1)[Len] = ar1;
        // refAr1 е псевдоним на масив
  for (auto elm : refAr1) cout << "  " << elm;
  cout << endl;
  TArr & refAr2 = ar1;
        // refAr2 също е псевдоним на масив
  for (auto elm : refAr2) cout << "  " << elm;
  cout << endl;
  decltype(ar1) & refAr3 = ar1;
        // refAr3 също е псевдоним на масив
  for (auto elm : refAr3) cout << "  " << elm;
  cout << endl;
  typedef long (& TrefAr)[Len];
  TrefAr & refAr4 = ar1; // refAr4 също е псевдоним на масив
  for (auto elm : refAr4) cout << "  " << elm;
  cout << "\n\n";
  // операторът typeid дава описание (във вид на структура)
  // на типа на стойността, зададена чрез операнда
  cout << "typeid(a).name() -> "
       << typeid(a).name() << endl; // a е масив
  cout << "typeid(ar1).name() -> "
       << typeid(ar1).name() << endl; // ar1 е масив
  cout << "typeid(ar2).name() -> "
       << typeid(ar2).name() << endl; // ar2 е масив
  cout << "typeid(refAr1).name() -> "
       << typeid(refAr1).name() << endl; // refAr1 е псевдоним
  cout << "typeid(refAr2).name() -> "
       << typeid(refAr2).name() << endl; // refAr2 е псевдоним
  cout << "typeid(refAr3).name() -> "
       << typeid(refAr3).name() << endl; // refAr3 е псевдоним
  cout << "typeid(refAr4).name() -> "
       << typeid(refAr4).name() << endl; // refAr4 е псевдоним
  cout << "typeid(TArr).name() -> "
       << typeid(TArr).name() << endl;
       // TArr е тип на масив
  cout << "typeid(TArr&).name() -> "
       << typeid(TArr&).name() << endl;
       // TArr& е тип на псевдоним на масив
  cout << "typeid(TrefAr).name() -> "
       << typeid(TrefAr).name() << endl;
       // TrefAr е тип на псевдоним на масив
  cout << endl;
  // Типове на указатели към едномерни масиви:
  typedef long (* TPAr1)[Len];
  typedef decltype(ar1) * TPAr2;
  TPAr1 pAr1 = & ar1;
  for (auto elm : * pAr1) cout << "  " << elm;
  cout << endl;
  TPAr2 pAr2 = & ar1;
  for (auto elm : * pAr2) cout << "  " << elm;
  cout << "\n\n";
  cout << "typeid(TPAr1).name() -> "
       << typeid(TPAr1).name() << endl;
       // TPAr1 е тип на указател към масив
  cout << "typeid(TPAr2).name() -> "
       << typeid(TPAr2).name() << endl;
       // TPAr2 е тип на указател към масив
}
