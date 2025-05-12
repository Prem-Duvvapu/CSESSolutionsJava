#include <bits/stdc++.h>
using namespace std;

const long long INF = 1e12;

class Solution {
public:
    stringstream sb;

    void solve(vector<vector<long long>>& adjMatrix, int n, int q) {
        for (int i = 1; i <= n; i++)
            adjMatrix[i][i] = 0;

        // Floyd-Warshall Algorithm
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (adjMatrix[i][k] == INF) continue;

                for (int j = 1; j <= n; j++) {
                    if (adjMatrix[k][j] == INF) continue;

                    long long newDist = adjMatrix[i][k] + adjMatrix[k][j];
                    if (newDist < adjMatrix[i][j]) {
                        adjMatrix[i][j] = newDist;
                    }
                }
            }
        }

        // Query processing
        for (int i = 0; i < q; i++) {
            int a, b;
            cin >> a >> b;

            if (adjMatrix[a][b] >= INF)
                sb << "-1\n";
            else
                sb << adjMatrix[a][b] << "\n";
        }
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, q;
    cin >> n >> m >> q;

    vector<vector<long long>> adjMatrix(n + 1, vector<long long>(n + 1, INF));

    for (int i = 0; i < m; i++) {
        int a, b;
        long long c;
        cin >> a >> b >> c;

        adjMatrix[a][b] = min(adjMatrix[a][b], c);
        adjMatrix[b][a] = min(adjMatrix[b][a], c);
    }

    Solution solution;
    solution.solve(adjMatrix, n, q);

    cout << solution.sb.str();

    return 0;
}
