class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
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
        return ans;
    }

//    matrix = {
//            {1, 2, 3, 4,5,6,7,8,9,10},
//            {1, 2, 3, 4,5,6,7,8,9,10},
//
//    };
};