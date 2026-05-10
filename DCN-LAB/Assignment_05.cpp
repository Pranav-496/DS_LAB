/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: DCN
Assignment-05-Write a program to simulate Go back N and Selective Repeat Modes of
Sliding Window Protocol in Peer-to-Peer mode.
*/

#include <bits/stdc++.h>
using namespace std;

void goBackN(int n, int ws)
{
  int i = 0;

  while (i < n)
  {
    cout << "\nSending Frames: ";

    for (int j = i; j < i + ws && j < n; j++)
    {
      cout << j << " ";
    }

    int lost;

    cout << "\nEnter lost frame (-1 if none): ";
    cin >> lost;

    if (lost == -1)
    {
      cout << "All frames acknowledged\n";
      i = i + ws;
    }
    else
    {
      cout << "Frame " << lost << " lost\n";
      cout << "Resending from frame " << lost << "\n";

      i = lost;
    }
  }

  cout << "\nTransmission Completed\n";
}

void selectiveRepeat(int n, int ws)
{
  vector<int> ack(n, 0);

  int i = 0;

  while (i < n)
  {
    cout << "\nSending Frames: ";

    for (int j = i; j < i + ws && j < n; j++)
    {
      if (ack[j] == 0)
      {
        cout << j << " ";
      }
    }

    int lost;

    cout << "\nEnter lost frame (-1 if none): ";
    cin >> lost;

    for (int j = i; j < i + ws && j < n; j++)
    {
      if (j != lost)
      {
        ack[j] = 1;
      }
    }

    if (lost != -1)
    {
      cout << "Frame " << lost << " lost\n";
      cout << "Resending frame " << lost << "\n";

      ack[lost] = 1;
    }
    else
    {
      cout << "All frames acknowledged\n";
    }

    while (i < n && ack[i] == 1)
    {
      i++;
    }
  }

  cout << "\nTransmission Completed\n";
}

int main()
{
  int n, ws, choice;

  while (true)
  {
    cout << "\n===== Sliding Window Protocol =====\n";

    cout << "1. Go Back N\n";
    cout << "2. Selective Repeat\n";
    cout << "3. Exit\n";

    cout << "Enter your choice: ";
    cin >> choice;

    if (choice == 3)
    {
      cout << "Program Ended\n";
      break;
    }

    cout << "Enter number of frames: ";
    cin >> n;

    cout << "Enter window size: ";
    cin >> ws;

    if (choice == 1)
    {
      cout << "\n--- Go Back N Simulation ---\n";
      goBackN(n, ws);
    }
    else if (choice == 2)
    {
      cout << "\n--- Selective Repeat Simulation ---\n";
      selectiveRepeat(n, ws);
    }
    else
    {
      cout << "Invalid Choice\n";
    }
  }

  return 0;
}