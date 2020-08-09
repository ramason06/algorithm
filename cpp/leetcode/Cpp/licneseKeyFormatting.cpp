class Solution {
public:
    string licenseKeyFormatting(string S, int K) {
        int charlen = 0;
        string ans;
        int len = S.length();
        for(int i = len-1; i >= 0; i--) {
            if(S[i] == '-') {
                continue;
            } else if(charlen && !(charlen % K)) {
                ans += '-';
                charlen = 0;
                i++;
            } else {
                ans += toupper(S[i]);
                charlen++;
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};