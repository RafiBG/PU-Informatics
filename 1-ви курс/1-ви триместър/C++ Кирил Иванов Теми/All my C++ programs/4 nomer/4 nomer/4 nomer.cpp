#include <iostream>
using namespace std;
int main()
{
	// Рафи Цигаров  Фукултетен номер : 2201261077
	setlocale(LC_ALL, "bg");
	int temp;
	int Rtemp = 0;
	int den;
	cout << "Въдете температурите в Пловдив." << endl;
	for (int i = 1; i < 29; i++)
	{
		cin >> temp;
		cout << "Ден: " << i << " Температура: " << temp << endl;
		den = i;
		Rtemp += temp;
	}
	cout << "Средна температура в Пловдив : " << Rtemp / den;
}