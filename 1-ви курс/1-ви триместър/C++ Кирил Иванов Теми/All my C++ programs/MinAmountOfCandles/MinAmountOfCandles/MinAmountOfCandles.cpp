#include <bits/stdc++.h>
#include <iostream>
using namespace std;


int countCandies(int arr[], int n)
{
    int sum = 0;
    int ans[n];
    if (n == 1) {
        return 1;
    }

    for (int i = 0; i < n; i++)
        ans[i] = 1;

    for (int i = 0; i < n - 1; i++) {


        if (arr[i + 1] > arr[i]) {
            ans[i + 1] = ans[i] + 1;
        }
    }

    for (int i = n - 2; i >= 0; i--) {

        if (arr[i] > arr[i + 1]
            && ans[i] <= ans[i + 1]) {

            ans[i] = ans[i + 1] + 1;
        }
        sum += ans[i];
    }

    sum += ans[n - 1];
    return sum;
}
int main()
{
    int arr[] = { 1, 0, 1 };
    int N = sizeof(arr) / sizeof(arr[0]);
    cout << countCandies(arr, N);
    return 0;
}
