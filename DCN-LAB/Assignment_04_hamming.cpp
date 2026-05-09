/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: DCN
Assignment-04-Write a program for error detection and correction for 7/8 bits ASCII codes
using Hamming Codes or CRC.
*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
  int m;
  cout << "Enter number of data bits: ";
  cin >> m;

  vector<int> data(m);

  cout << "Enter data bits: ";
  for (int i = 0; i < m; i++)
    cin >> data[i];

  int r = 0;

  while (pow(2, r) < (m + r + 1))
    r++;

  int n = m + r;

  vector<int> hamming(n + 1);

  int k = 0;

  for (int i = 1; i <= n; i++)
  {
    if ((i & (i - 1)) == 0)
      hamming[i] = 0;
    else
      hamming[i] = data[k++];
  }

  for (int p = 1; p <= n; p *= 2)
  {
    int count = 0;

    for (int j = 1; j <= n; j++)
    {
      if (j & p)
        count += hamming[j];
    }

    hamming[p] = count % 2;
  }

  cout << "\nHamming Code: ";

  for (int i = 1; i <= n; i++)
    cout << hamming[i] << " ";

  cout << "\n";

  vector<int> received(n + 1);

  cout << "Enter received code: ";

  for (int i = 1; i <= n; i++)
    cin >> received[i];

  int error = 0;

  for (int i = 1; i <= n; i++)
  {
    if (hamming[i] != received[i])
    {
      error = i;
      break;
    }
  }

  if (error == 0)
  {
    cout << "No error detected\n";
  }
  else
  {
    cout << "Error at position: " << error << "\n";

    received[error] = hamming[error];

    cout << "Corrected code: ";

    for (int i = 1; i <= n; i++) cout << received[i] << " ";
  }

  return 0;
}

/*
Testcase:
Enter number of data bits: 4
Enter data bits: 1 0 1 1

Hamming Code: 0 1 1 0 0 1 1
Enter received code: 0 1 0 0 0 1 1
Error at position: 3
Corrected code: 0 1 1 0 0 1 1
*/