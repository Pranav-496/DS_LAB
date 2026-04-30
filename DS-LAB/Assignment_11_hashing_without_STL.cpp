/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: Data Structures
Assignment-11-A Dictionary using Hash table: A Dictionary stores key and value pairs
Data: Set of (key, value) pairs, Keys are mapped to values, Keys must be
comparable, Keys must be unique.
Standard Operations: Insert(key, value), Find(key), Delete(key)
Write a menu driven C++ program to provide above standard operations
on dictionaries
Write a menu driven C++ program to provide all the functions of a
dictionary (ADT) using hashing and handle collisions using chaining.
*/

#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
  int key;
  string value;
  Node *next;

  Node(int k, string v)
  {
    key = k;
    value = v;
    next = NULL;
  }
};

class Dictionary
{
  int size;
  Node **table;

public:
  Dictionary(int s)
  {
    size = s;
    table = new Node *[size];
    for (int i = 0; i < size; i++)
      table[i] = NULL;
  }

  int hashFunction(int key)
  {
    return key % size;
  }

  void insert(int key, string value)
  {
    int index = hashFunction(key);
    Node *head = table[index];

    Node *temp = head;
    while (temp)
    {
      if (temp->key == key)
      {
        cout << "Key already exists\n";
        return;
      }
      temp = temp->next;
    }

    Node *newNode = new Node(key, value);
    newNode->next = head;
    table[index] = newNode;

    cout << "Inserted\n";
  }

  void find(int key)
  {
    int index = hashFunction(key);
    Node *temp = table[index];

    while (temp)
    {
      if (temp->key == key)
      {
        cout << "Value: " << temp->value << endl;
        return;
      }
      temp = temp->next;
    }

    cout << "Key not found\n";
  }

  void remove(int key)
  {
    int index = hashFunction(key);
    Node *temp = table[index];
    Node *prev = NULL;

    while (temp)
    {
      if (temp->key == key)
      {
        if (prev == NULL)
          table[index] = temp->next;
        else
          prev->next = temp->next;

        delete temp;
        cout << "Deleted\n";
        return;
      }
      prev = temp;
      temp = temp->next;
    }

    cout << "Key not found\n";
  }

  void display()
  {
    for (int i = 0; i < size; i++)
    {
      cout << i << ": ";
      Node *temp = table[i];
      while (temp)
      {
        cout << "(" << temp->key << "," << temp->value << ") -> ";
        temp = temp->next;
      }
      cout << "NULL\n";
    }
  }
};

int main()
{
  int size, choice, key;
  string value;

  cout << "Enter hash table size: ";
  cin >> size;

  Dictionary d(size);

  do
  {
    cout << "\n1.Insert\n2.Find\n3.Delete\n4.Display\n5.Exit\n";
    cin >> choice;

    switch (choice)
    {
    case 1:
      cout << "Enter key and value: ";
      cin >> key >> value;
      d.insert(key, value);
      break;

    case 2:
      cout << "Enter key: ";
      cin >> key;
      d.find(key);
      break;

    case 3:
      cout << "Enter key: ";
      cin >> key;
      d.remove(key);
      break;

    case 4:
      d.display();
      break;
    }

  } while (choice != 5);

  return 0;
}