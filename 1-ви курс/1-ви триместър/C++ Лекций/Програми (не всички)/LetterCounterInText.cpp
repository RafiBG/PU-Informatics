#include <iostream>
#include <string>
using namespace std;

int main()
{
	string input;            // Рафи Цигаров  Фукултетен номер : 2201261077
	getline(cin, input);
	int l[26]{ 0 }; 

	for (int i = 0; i < input.length(); i++)
	{
		l[toupper(input[i]) - 65] += 1;
	}

	for (int i = 0; i < 26; i++)
	{
		if (l[i] > 0)
			cout << char(65 + i) << " Showed Up: " << l[i] << '\n';
	}
}
