#include <iostream>
using namespace std;
int main()
{
	setlocale(LC_ALL, "bg");    // ���� �������  ���������� ����� : 2201261077
	cout << "���� �� ���������� �� ���� ����� (����. � C D)" << endl;
	char fLetter, sLetter, tLetter;
	cin >> fLetter >> sLetter >> tLetter;
	char fResult = fLetter + 2;
	char sResult = sLetter + 2;
	char tResult = tLetter + 2;
	cout << fResult << "." << sResult << "." << tResult << "." << endl;
}