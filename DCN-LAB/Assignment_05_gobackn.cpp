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

void goBackN(int totalFrames, int windowSize, int lossFrame)
{
  int base = 0;
  int next = 0;
  bool lostOnce = false;

  while (base < totalFrames)
  {

    while (next < base + windowSize && next < totalFrames)
    {
      cout << "Sending Frame " << next << endl;
      next++;
    }

    for (int i = base; i < next; i++)
    {

      if (i == lossFrame && !lostOnce)
      {
        cout << "Frame " << i << " lost! Timeout...\n";
        cout << "Retransmitting from Frame " << i << endl;
        next = i;
        lostOnce = true;
        break;
      }
      else
      {
        cout << "ACK received for Frame " << i << endl;
        base++;
      }
    }
  }

  cout << "All frames successfully transmitted\n";
}

int main()
{
  int totalFrames, windowSize, lossFrame;

  cout << "Enter total number of frames: ";
  cin >> totalFrames;

  cout << "Enter window size: ";
  cin >> windowSize;

  cout << "Enter frame number to simulate loss (-1 if none): ";
  cin >> lossFrame;

  goBackN(totalFrames, windowSize, lossFrame);

  return 0;
}

/*
Testcase 1:
Enter total number of frames: 10
Enter window size: 3
Enter frame number to simulate loss (-1 if none): 5 
Sending Frame 0
Sending Frame 1
Sending Frame 2
ACK received for Frame 0
ACK received for Frame 1
ACK received for Frame 2
Sending Frame 3
Sending Frame 4
Sending Frame 5
ACK received for Frame 3
ACK received for Frame 4
Frame 5 lost! Timeout...
Retransmitting from Frame 5
Sending Frame 5
Sending Frame 6
Sending Frame 7
ACK received for Frame 5
ACK received for Frame 6
ACK received for Frame 7
Sending Frame 8
Sending Frame 9
ACK received for Frame 8
ACK received for Frame 9
All frames successfully transmitted

Testcase 2:
Enter total number of frames: 10
Enter window size: 3
Enter frame number to simulate loss (-1 if none): -1
Sending Frame 0
Sending Frame 1
Sending Frame 2
ACK received for Frame 0
ACK received for Frame 1
ACK received for Frame 2
Sending Frame 3
Sending Frame 4
Sending Frame 5
ACK received for Frame 3
ACK received for Frame 4
ACK received for Frame 5
Sending Frame 6
Sending Frame 7
Sending Frame 8
ACK received for Frame 6
ACK received for Frame 7
ACK received for Frame 8
Sending Frame 9
ACK received for Frame 9
All frames successfully transmitted
*/