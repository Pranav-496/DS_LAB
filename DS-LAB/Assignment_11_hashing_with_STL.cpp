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

int main()
{
  unordered_map<int, string> dict;

  int choice, key;
  string value;

  do
  {
    cout << "\n1.Insert\n2.Find\n3.Delete\n4.Display\n5.Exit\n";
    cin >> choice;

    switch (choice)
    {
    case 1:
      cout << "Enter key and value: ";
      cin >> key >> value;

      if (dict.find(key) != dict.end())
      {
        cout << "Key already exists\n";
      }
      else
      {
        dict[key] = value;
        cout << "Inserted\n";
      }
      break;

    case 2:
      cout << "Enter key: ";
      cin >> key;

      if (dict.find(key) != dict.end())
      {
        cout << "Value: " << dict[key] << endl;
      }
      else
      {
        cout << "Key not found\n";
      }
      break;

    case 3:
      cout << "Enter key: ";
      cin >> key;

      if (dict.erase(key))
        cout << "Deleted\n";
      else
        cout << "Key not found\n";
      break;

    case 4:
      for (auto &pair : dict)
      {
        cout << "(" << pair.first << ", " << pair.second << ")\n";
      }
      break;
    }

  } while (choice != 5);

  return 0;
}