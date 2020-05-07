#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cmath>
#include <vector>
#include <set>
#include <cctype>
#include <map>

using namespace std;


class Solution {
public:
    int totalFruit(vector<int>& tree) {
        int maxx = 1;
        //start
        int l = 0;
        //end
        int r = 0;
        map<int,int> m1;

        //1,2,1
        while(r < tree.size()) {
            if(m1.size() <= 2) {
                m1[tree[r]] = r;
            }
            if(m1.size() > 2) {
                int minn = tree.size() -1;//max set
                for(auto it = m1.begin(); it != m1.end(); it++) {
                    minn = min(minn, it->second);
                }

                l = minn + 1;
                m1.erase(tree[minn]);
            }
            r++;
            maxx = max(maxx, r - l);
        }
        return maxx;
    }
};

int main() {
    Solution solution;
    vector<int> arr;
    arr.push_back(0);
    arr.push_back(1);
    arr.push_back(2);
    arr.push_back(2);

    cout<<solution.totalFruit(arr);
}