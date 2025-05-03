#include <bits/stdc++.h>
using namespace std;

struct Pair {
    int index;
    int profit;
    Pair(int i, int p) : index(i), profit(p) {}
};

void solve(vector<array<int, 3>>& arr, int n) {
    map<int, int> coordCompress;

    // Collect and prepare coordinates for compression
    for (int i = 0; i < n; ++i) {
        coordCompress[arr[i][0]] = 0;
        coordCompress[arr[i][1] + 1] = 0;
    }

    int idx = 0;
    for (auto& [key, val] : coordCompress) {
        val = idx++;
    }

    vector<vector<Pair>> projectsByEndDay(idx);
    for (int i = 0; i < n; ++i) {
        int start = coordCompress[arr[i][0]];
        int end = coordCompress[arr[i][1] + 1];
        projectsByEndDay[end].emplace_back(start, arr[i][2]);
    }

    vector<long long> dp(idx, 0);

    for (int i = 1; i < idx; ++i) {
        dp[i] = dp[i - 1];
        for (auto& pair : projectsByEndDay[i]) {
            dp[i] = max(dp[i], dp[pair.index] + pair.profit);
        }
    }

    cout << dp[idx - 1] << '\n';
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    vector<array<int, 3>> arr(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
    }

    solve(arr, n);
    return 0;
}
