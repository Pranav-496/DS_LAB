/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: DCN
Assignment-07-Write a program to implement link state /Distance vector routing protocol
to find suitable path for transmission.
*/

#include <iostream>
using namespace std;

#define MAX 10
#define INF 9999

int main()
{
  int n, cost[MAX][MAX];

  cout << "Enter number of nodes: ";
  cin >> n;

  cout << "Enter cost matrix (0 for no edge):\n";
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < n; j++)
    {
      cin >> cost[i][j];

      // Convert 0 to INF except diagonal
      if (i != j && cost[i][j] == 0)
      {
        cost[i][j] = INF;
      }
    }
  }

  cout << "\nShortest path matrix:\n";

  // Run Bellman-Ford for each source
  for (int source = 0; source < n; source++)
  {

    int dist[MAX];

    // Initialize distances
    for (int i = 0; i < n; i++)
    {
      dist[i] = INF;
    }
    dist[source] = 0;

    // Relax edges (n-1 times)
    for (int k = 0; k < n - 1; k++)
    {
      for (int i = 0; i < n; i++)
      {
        for (int j = 0; j < n; j++)
        {

          if (cost[i][j] != INF && dist[i] != INF &&
              dist[j] > dist[i] + cost[i][j])
          {

            dist[j] = dist[i] + cost[i][j];
          }
        }
      }
    }

    // Check negative cycle
    bool negativeCycle = false;
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {

        if (cost[i][j] != INF && dist[i] != INF &&
            dist[j] > dist[i] + cost[i][j])
        {

          negativeCycle = true;
        }
      }
    }

    // Print results
    cout << "From node " << source << ":\n";

    if (negativeCycle)
    {
      cout << "Negative weight cycle detected!\n";
    }
    else
    {
      for (int i = 0; i < n; i++)
      {
        if (dist[i] == INF)
          cout << "To " << i << " -> INF\n";
        else
          cout << "To " << i << " -> " << dist[i] << "\n";
      }
    }
    cout << endl;
  }

  return 0;
}

/*
Testcase:
Enter number of nodes: 4
Enter cost matrix (0 for no edge):
0 5 0 10
0 0 3 0
0 0 0 1
0 0 0 0

Shortest path matrix:
From node 0:
To 0 -> 0
To 1 -> 5
To 2 -> 8
To 3 -> 9

From node 1:
To 0 -> INF
To 1 -> 0
To 2 -> 3
To 3 -> 4

From node 2:
To 0 -> INF
To 1 -> INF
To 2 -> 0
To 3 -> 1

From node 3:
To 0 -> INF
To 1 -> INF
To 2 -> INF
To 3 -> 0
*/