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