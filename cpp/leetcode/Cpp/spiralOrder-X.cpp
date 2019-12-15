#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int> > matrix;

class Solution {
public:
    vector<int> spiralOrder() {
        vector<int> ans;
        int xSize = matrix.size();
        int ySize = matrix[0].size();
        int numSize = ySize * xSize;
        int yIdx = -1;
        int xIdx = 0;
        int plus = 1;
        while(ans.size() < numSize){
            for(int i = 0; i < ySize; i++){
                yIdx += plus;
                ans.push_back(matrix[xIdx][yIdx]);
            }
            ySize--;
            xSize--;
            for(int j = 0; j < xSize; j++){
                xIdx += plus;
                ans.push_back(matrix[xIdx][yIdx]);
            }
            plus *= -1;
        }
        for(int i = 0; i< ans.size(); i++){
            printf("%d " , ans[i]);
        }
        return ans;
    }
};

int main(){
    matrix = {
            {1},
            {2},
            {3},
            {4}
    };
    Solution solution;
    solution.spiralOrder();
}