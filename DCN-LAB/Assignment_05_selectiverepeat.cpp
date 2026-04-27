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

void selectiveRepeat(int totalFrames, int windowSize, int lossFrame)
{
  vector<bool> received(totalFrames, false);
  int base = 0;
  bool lostOnce = false;

  while (base < totalFrames)
  {

    for (int i = base; i < base + windowSize && i < totalFrames; i++)
    {

      if (!received[i])
      {
        if (lossFrame >= 0 && i == lossFrame && !lostOnce)
        {
          cout << "Frame " << i << " lost\n";
          lostOnce = true;
        }
        else
        {
          cout << "Frame " << i << " received. ACK " << i << endl;
          received[i] = true;
        }
      }
    }

    if (lossFrame >= 0 && lossFrame < totalFrames && !received[lossFrame])
    {
      cout << "Retransmitting Frame " << lossFrame << endl;
      cout << "Frame " << lossFrame << " received. ACK " << lossFrame << endl;
      received[lossFrame] = true;
    }

    while (base < totalFrames && received[base])
    {
      base++;
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

  cout << "Enter frame number to simulate loss (-1 for no loss): ";
  cin >> lossFrame;

  selectiveRepeat(totalFrames, windowSize, lossFrame);

  return 0;
}

/*
Testcase 1:
Enter total number of frames: 5
Enter window size: 3
Enter frame number to simulate loss (-1 for no loss): 2 
Frame 0 received. ACK 0
Frame 1 received. ACK 1
Frame 2 lost
Retransmitting Frame 2
Frame 2 received. ACK 2
Frame 3 received. ACK 3
Frame 4 received. ACK 4
All frames successfully transmitted

Testcase 2:
Enter total number of frames: 5
Enter window size: 3
Enter frame number to simulate loss (-1 for no loss): -1
Frame 0 received. ACK 0
Frame 1 received. ACK 1
Frame 2 received. ACK 2
Frame 3 received. ACK 3
Frame 4 received. ACK 4
All frames successfully transmitted

*/