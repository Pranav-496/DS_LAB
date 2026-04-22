#include <bits/stdc++.h>
using namespace std;

struct Data {
    float temperature;
    float humidity;
    float pollution;
};

vector<Data> records;

void inputData(int n) {
    Data d;
    for (int i = 0; i < n; i++) {
        cin >> d.temperature >> d.humidity >> d.pollution;
        records.push_back(d);
    }
}

void findMinMax() {
    float minT = records[0].temperature, maxT = records[0].temperature;
    float minH = records[0].humidity, maxH = records[0].humidity;
    float minP = records[0].pollution, maxP = records[0].pollution;

    for (auto &d : records) {
        minT = min(minT, d.temperature);
        maxT = max(maxT, d.temperature);

        minH = min(minH, d.humidity);
        maxH = max(maxH, d.humidity);

        minP = min(minP, d.pollution);
        maxP = max(maxP, d.pollution);
    }

    cout << "Temperature Min: " << minT << " Max: " << maxT << endl;
    cout << "Humidity Min: " << minH << " Max: " << maxH << endl;
    cout << "Pollution Min: " << minP << " Max: " << maxP << endl;
}

void averageValues() {
    float sumT = 0, sumH = 0, sumP = 0;

    for (auto &d : records) {
        sumT += d.temperature;
        sumH += d.humidity;
        sumP += d.pollution;
    }

    int n = records.size();

    cout << "Avg Temperature: " << sumT / n << endl;
    cout << "Avg Humidity: " << sumH / n << endl;
    cout << "Avg Pollution: " << sumP / n << endl;
}

void sortByPollution() {
    sort(records.begin(), records.end(), [](Data a, Data b) {
        return a.pollution < b.pollution;
    });

    cout << "Sorted by Pollution:\n";
    for (auto &d : records) {
        cout << d.temperature << " " << d.humidity << " " << d.pollution << endl;
    }
}

void safeRangeCheck() {
    float safeMin = 0, safeMax = 50; 

    float lowest = 1e9, highest = -1e9;

    for (auto &d : records) {
        if (d.pollution >= safeMin && d.pollution <= safeMax) {
            lowest = min(lowest, d.pollution);
            highest = max(highest, d.pollution);
        }
    }

    if (lowest == 1e9)
        cout << "No safe values found\n";
    else
        cout << "Safe Pollution Range Found: " << lowest << " to " << highest << endl;
}

void environmentalImpact() {
    for (auto &d : records) {
        if (d.pollution > 100)
            cout << "High Environmental Risk\n";
        else if (d.pollution > 50)
            cout << "Moderate Risk\n";
        else
            cout << "Low Risk\n";
    }
}

void healthImpact() {
    for (auto &d : records) {
        if (d.pollution > 100)
            cout << "Severe health hazard\n";
        else if (d.pollution > 70)
            cout << "Respiratory issues possible\n";
        else
            cout << "Safe for general population\n";
    }
}

int main() {
    int n, choice;
    cout << "Enter number of records: ";
    cin >> n;

    inputData(n);

    do {
        cout << "\n1.Min-Max\n2.Average\n3.Sort(Pollution)\n4.Safe Range\n5.Env Impact\n6.Health Impact\n7.Exit\n";
        cin >> choice;

        switch (choice) {
        case 1: findMinMax(); break;
        case 2: averageValues(); break;
        case 3: sortByPollution(); break;
        case 4: safeRangeCheck(); break;
        case 5: environmentalImpact(); break;
        case 6: healthImpact(); break;
        }
    } while (choice != 7);

    return 0;
}