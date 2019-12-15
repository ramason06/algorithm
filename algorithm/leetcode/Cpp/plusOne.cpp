#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int idx = digits.size()-1;
        vector <int> ans;
        int head = 1;
        while(idx > -1){
            int lastNum = digits[idx];
            lastNum += head;
            head = lastNum/10;
            if(head){
                ans.push_back(lastNum%10);
                if(idx == 0){
                    ans.push_back(head);
                }
            }else{
                ans.push_back(lastNum);
            }
            idx--;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
