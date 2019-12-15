#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        int size = nums.size();
        bool flag = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    ans.push_back(i);
                    ans.push_back(j);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return ans;
    }
};