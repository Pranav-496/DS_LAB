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
  int n, m;

  cout << "Enter number of data bits: ";
  cin >> n;

  vector<int> data(n);

  cout << "Enter data bits: ";

  for (int i = 0; i < n; i++) cin >> data[i];

  cout << "Enter number of generator bits: ";
  cin >> m;

  vector<int> gen(m);

  cout << "Enter generator bits: ";

  for (int i = 0; i < m; i++) cin >> gen[i];

  vector<int> temp(n + m - 1);

  for (int i = 0; i < n; i++) temp[i] = data[i];

  for (int i = 0; i < n; i++)
  {
    if (temp[i] == 1)
    {
      for (int j = 0; j < m; j++)
      {
        temp[i + j] ^= gen[j];
      }
    }
  }

  vector<int> codeword(n + m - 1);

  for (int i = 0; i < n; i++) codeword[i] = data[i];

  for (int i = 0; i < m - 1; i++) codeword[n + i] = temp[n + i];

  cout << "\nTransmitted Codeword: ";

  for (int i = 0; i < n + m - 1; i++) cout << codeword[i] << " ";

  cout << endl;

  vector<int> received(n + m - 1);

  cout << "\nEnter received codeword: ";

  for (int i = 0; i < n + m - 1; i++) cin >> received[i];

  for (int i = 0; i < n; i++)
  {
    if (received[i] == 1)
    {
      for (int j = 0; j < m; j++)
      {
        received[i + j] ^= gen[j];
      }
    }
  }

  bool error = false;

  for (int i = n; i < n + m - 1; i++)
  {
    if (received[i] != 0)
    {
      error = true;
      break;
    }
  }

  if (error) cout << "Error detected\n";
  else cout << "No error detected\n";

  return 0;
}

/*
Testcase:
Enter number of data bits: 4
Enter data bits: 1 0 1 1
Enter number of generator bits: 4      
Enter generator bits: 1 0 1 1

Transmitted Codeword: 1 0 1 1 0 0 0 

Enter received codeword: 1 1 1 1 0 0 0
Error detected
*/