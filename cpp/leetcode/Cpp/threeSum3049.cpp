class Solution {
public:
    int sol(int idx, int sum) {
        if(sum == 0) {
            ans[idx]
        }
    }
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int> > ans;

        //적절하지 않은 input 예외처리
        if(nums.size() < 3) {
            return ans;
        }

        for(int i = 0; i < nums.size(); i++) {
            if(i==0 || nums[i] > nums[i-1]) {
                int second = i+1;
                int third = nums.size() - 1;

                while(second < third) {
                    int sum = nums[i] + nums[second] + nums[third];
                    if(sum == 0) {
                        vector<int> tmp;
                        tmp.push_back(nums[i]);
                        tmp.push_back(nums[second]);
                        tmp.push_back(nums[third]);
                        ans.push_back(tmp);

                        second++;
                        third--;

                        while(second<third && nums[second] == nums[second-1])
                            second++;

                        while(second<third && nums[third] == nums[third+1])
                            third--;
                    } else if(sum < 0)
                        second++;
                    else
                        third--;
                }
            }
        }

        return ans;
    }
};