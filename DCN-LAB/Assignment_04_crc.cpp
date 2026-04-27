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

string xorOperation(string a, string b)
{
  string result = "";
  for (int i = 1; i < b.length(); i++)
  {
    if (a[i] == b[i])
      result += '0';
    else
      result += '1';
  }
  return result;
}

string mod2div(string dividend, string divisor)
{
  int pick = divisor.length();
  string temp = dividend.substr(0, pick);

  while (pick < dividend.length())
  {
    if (temp[0] == '1')
      temp = xorOperation(divisor, temp) + dividend[pick];
    else
      temp = xorOperation(string(divisor.length(), '0'), temp) + dividend[pick];

    pick++;
  }

  if (temp[0] == '1')
    temp = xorOperation(divisor, temp);
  else
    temp = xorOperation(string(divisor.length(), '0'), temp);

  return temp;
}

int main()
{
  string data, key;

  cout << "Enter data (binary): ";
  cin >> data;

  cout << "Enter generator polynomial: ";
  cin >> key;

  int key_len = key.length();

  string appended_data = data + string(key_len - 1, '0');

  string remainder = mod2div(appended_data, key);

  string codeword = data + remainder;

  cout << "Transmitted Codeword: " << codeword << endl;

  string received;
  cout << "Enter received codeword: ";
  cin >> received;

  string check = mod2div(received, key);

  bool error = false;
  for (char c : check)
  {
    if (c == '1')
    {
      error = true;
      break;
    }
  }

  if (error)
    cout << "Error detected in received data\n";
  else
    cout << "No error detected\n";

  return 0;
}

/* 
Testcase 1:
Enter data (binary): 1101
Enter generator polynomial: 1011
Enter received codeword: 1101001

Transmitted Codeword: 1101001
No error detected

Testcase 2:
Enter data (binary): 1101
Enter generator polynomial: 1011
Enter received codeword: 1101101

Transmitted Codeword: 1101001
Error detected in received data
*/