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

bool isParityPos(int pos)
{
  return (pos & (pos - 1)) == 0;
}

int countParityBits(int m)
{
  int r = 0;
  while ((1 << r) < (m + r + 1))
    r++;
  return r;
}

vector<int> buildHamming(vector<int> &data, int m, int r)
{
  int n = m + r;
  vector<int> hamming(n + 1, 0);

  int dataIdx = 0;
  for (int i = 1; i <= n; i++)
    if (!isParityPos(i))
      hamming[i] = data[dataIdx++];

  for (int i = 0; i < r; i++)
  {
    int p = 1 << i;
    int parity = 0;
    for (int j = p; j <= n; j++)
      if (j & p)
        parity ^= hamming[j];
    hamming[p] = parity;
  }

  return hamming;
}

int findError(vector<int> &received, int r)
{
  int errorPos = 0;
  int n = received.size() - 1;

  for (int i = 0; i < r; i++)
  {
    int p = 1 << i;
    int parity = 0;
    for (int j = 1; j <= n; j++)
      if (j & p)
        parity ^= received[j];
    if (parity)
      errorPos += p;
  }

  return errorPos;
}

int main()
{
  int m;
  cout << "Enter number of data bits: ";
  cin >> m;

  vector<int> data(m);
  cout << "Enter data bits: ";
  for (int &b : data)
    cin >> b;

  int r = countParityBits(m);
  vector<int> hamming = buildHamming(data, m, r);

  cout << "\nHamming Code: ";
  for (int i = 1; i < hamming.size(); i++)
    cout << hamming[i] << " ";
  cout << "\n";

  int n = m + r;
  vector<int> received(n + 1);
  cout << "Enter received code: ";
  for (int i = 1; i <= n; i++)
    cin >> received[i];

  int errorPos = findError(received, r);
  if (errorPos == 0)
  {
    cout << "No error detected.\n";
  }
  else
  {
    cout << "Error at position: " << errorPos << "\n";
    received[errorPos] ^= 1;
    cout << "Corrected code: ";
    for (int i = 1; i <= n; i++)
      cout << received[i] << " ";
    cout << "\n";
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