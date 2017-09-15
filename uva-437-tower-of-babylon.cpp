#include <bits/stdc++.h> 
using namespace std;
// global variables
bool debug = false;
int n, caseNum = 1;
struct brick {
    int x, y, z;
    brick(int a, int b, int c) {
        x = a; y = b; z = c;
    }
    
};

bool compare (const brick &a, const brick &b) {
        // if (a.x < b.x && a.y < b.y) return true;
        if (a.x == b.x) {
            return a.y < b.y;
        }
        else return a.x < b.x;
    }
int main() {
    ifstream cin("babylon.inp");
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    while (cin >> n && n != 0) {
        vector<brick> bricks;
        bricks.push_back(brick(0, 0, 0));
        for (int i = 1; i <= n; i++) {
            int x, y, z;
            cin >> x >> y >> z;
            bricks.push_back(brick(x, y, z));
            bricks.push_back(brick(y, x, z));
            bricks.push_back(brick(x, z, y));
            bricks.push_back(brick(z, x, y));
            bricks.push_back(brick(y, z, x));
            bricks.push_back(brick(z, y, x));
        }   
        sort(bricks.begin(), bricks.end(), compare);
        if (debug) for (int i = 0; i < bricks.size(); i++) cout << bricks[i].x << ", " << bricks[i].y << ", " << bricks[i].z << "\n";
        int num = bricks.size()-1;
        if (debug) cout << "n= " << n << ", num= " << num << "\n";
        int LIS[num], totalMaxH = 0, maxH = 0;
        for (int i = 1; i <= num; i++) {
            maxH = 0;
            for (int j = i-1; j >= 1; j--) {
                if (bricks[j].x < bricks[i].x && bricks[j].y < bricks[i].y && bricks[j].z > maxH) {
                    maxH = bricks[j].z;
                }
            }
            // if (debug) cout << bricks[i].x << ", " << bricks[i].y << ", " << bricks[i].z << "\n";
            bricks[i].z += maxH;
            totalMaxH = max(totalMaxH, bricks[i].z);
        } 
        cout << "Case " << caseNum++ << ": maximum height = " << totalMaxH << "\n";
    }
}
