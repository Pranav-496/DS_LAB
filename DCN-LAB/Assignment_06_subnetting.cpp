/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: DCN
Assignment-06-Write a program to demonstrate Sub-netting and find subnet masks.
*/

#include <bits/stdc++.h>
using namespace std;

void printBinary(int ip[])
{
  for (int i = 0; i < 4; i++)
  {
    cout << bitset<8>(ip[i]) << " ";
  }
  cout << endl;
}

int main()
{
  int ip[4], cidr;

  cout << "Enter IP address (4 octets): ";
  cin >> ip[0] >> ip[1] >> ip[2] >> ip[3];

  cout << "Enter CIDR (e.g., 24): ";
  cin >> cidr;

  int mask[4] = {0, 0, 0, 0};
  int temp = cidr;

  for (int i = 0; i < 4; i++)
  {
    if (temp >= 8)
    {
      mask[i] = 255;
      temp -= 8;
    }
    else
    {
      mask[i] = 256 - (1 << (8 - temp));
      temp = 0;
    }
  }

  int network[4], broadcast[4];

  for (int i = 0; i < 4; i++)
  {
    network[i] = ip[i] & mask[i];
    broadcast[i] = network[i] | (~mask[i] & 255);
  }

  int firstHost[4], lastHost[4];

  for (int i = 0; i < 4; i++)
  {
    firstHost[i] = network[i];
    lastHost[i] = broadcast[i];
  }

  firstHost[3] += 1;
  lastHost[3] -= 1;

  cout << "\nSubnet Mask (Decimal): ";
  for (int i = 0; i < 4; i++)
    cout << mask[i] << ".";
  cout << "\b\n";

  cout << "Subnet Mask (Binary): ";
  printBinary(mask);

  cout << "\nNetwork Address: ";
  for (int i = 0; i < 4; i++)
    cout << network[i] << ".";
  cout << "\b\nBinary: ";
  printBinary(network);

  cout << "\nBroadcast Address: ";
  for (int i = 0; i < 4; i++)
    cout << broadcast[i] << ".";
  cout << "\b\nBinary: ";
  printBinary(broadcast);

  cout << "\nFirst Host: ";
  for (int i = 0; i < 4; i++)
    cout << firstHost[i] << ".";
  cout << "\b\nBinary: ";
  printBinary(firstHost);

  cout << "\nLast Host: ";
  for (int i = 0; i < 4; i++)
    cout << lastHost[i] << ".";
  cout << "\b\nBinary: ";
  printBinary(lastHost);

  return 0;
}

/*
Testcase :
Enter IP address (4 octets): 198 168 1 10
Enter CIDR (e.g., 24): 24

Subnet Mask (Decimal): 255.255.255.0.
Subnet Mask (Binary): 11111111 11111111 11111111 00000000

Network Address: 198.168.1.0.
Binary: 11000110 10101000 00000001 00000000

Broadcast Address: 198.168.1.255.
Binary: 11000110 10101000 00000001 11111111

First Host: 198.168.1.1.
Binary: 11000110 10101000 00000001 00000001

Last Host: 198.168.1.254.
Binary: 11000110 10101000 00000001 11111110
*/