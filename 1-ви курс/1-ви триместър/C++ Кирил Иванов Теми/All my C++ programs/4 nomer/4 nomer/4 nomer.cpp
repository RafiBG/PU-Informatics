#include <iostream>
using namespace std;
int main()
{
	// ���� �������  ���������� ����� : 2201261077
	setlocale(LC_ALL, "bg");
	int temp;
	int Rtemp = 0;
	int den;
	cout << "������ ������������� � �������." << endl;
	for (int i = 1; i < 29; i++)
	{
		cin >> temp;
		cout << "���: " << i << " �����������: " << temp << endl;
		den = i;
		Rtemp += temp;
	}
	cout << "������ ����������� � ������� : " << Rtemp / den;
}