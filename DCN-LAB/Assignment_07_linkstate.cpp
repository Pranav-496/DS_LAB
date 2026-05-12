/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll No: 41
Subject: DCN

Assignment:
Write a program to implement Link State Routing
using Dijkstra Algorithm.
*/

#include <iostream>
using namespace std;

#define MAX 10
#define INF 9999

int main()
{
    int n;
    int cost[MAX][MAX];

    cout << "Enter number of nodes: ";
    cin >> n;

    cout << "Enter cost matrix (0 for no edge):\n";

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> cost[i][j];

            if (i != j && cost[i][j] == 0)
            {
                cost[i][j] = INF;
            }
        }
    }

    int source;

    cout << "Enter source node: ";
    cin >> source;

    int dist[MAX];
    int visited[MAX] = {0};

    // Initialize distances
    for (int i = 0; i < n; i++)
    {
        dist[i] = INF;
    }

    dist[source] = 0;

    // Dijkstra Algorithm
    for (int count = 0; count < n - 1; count++)
    {
        int min = INF;
        int u = -1;

        // Find nearest unvisited node
        for (int i = 0; i < n; i++)
        {
            if (visited[i] == 0 && dist[i] < min)
            {
                min = dist[i];
                u = i;
            }
        }

        visited[u] = 1;

        // Update distances
        for (int v = 0; v < n; v++)
        {
            if (visited[v] == 0 &&
                cost[u][v] != INF &&
                dist[u] + cost[u][v] < dist[v])
            {
                dist[v] = dist[u] + cost[u][v];
            }
        }
    }

    cout << "\nShortest Paths from Node " << source << ":\n";

    for (int i = 0; i < n; i++)
    {
        if (dist[i] == INF)
        {
            cout << "To " << i << " -> INF\n";
        }
        else
        {
            cout << "To " << i << " -> " << dist[i] << "\n";
        }
    }

    return 0;
}

/*
Test Case:

Enter number of nodes: 4

Enter cost matrix (0 for no edge):

0 2 0 1
2 0 3 2
0 3 0 4
1 2 4 0

Enter source node: 0

Shortest Paths from Node 0:

To 0 -> 0
To 1 -> 2
To 2 -> 5
To 3 -> 1
*/