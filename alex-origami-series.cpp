#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>  

using namespace std;
bool debug = false;
double w, h;
int main() {
    //ifstream cin("alex.in");
    //ofstream out("alex.out");
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> h >> w;
    double res = min(w, h/3);
    res = max(res, min(w/2, h/2));
    res = max(res, min(w/3, h));
    res = max(res, min(h/2, w/2));
    cout << fixed << setprecision(3) << res << "\n";
}
