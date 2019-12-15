class Solution {
public:
    int checkCount(string s) {
        bool alpha[30];
        memset(alpha, 0, sizeof(alpha));
        int cnt = 0;
        for(char c : s) {
            if(alpha[c-'a'] == true) {
                continue;
            } else {
                alpha[c-'a'] = true;
                cnt++;
            }
        }
        return cnt;
    }

    int countString(int idx, int cnt, string s, string origin) {
        s += origin[idx];
        cnt = checkCount(s);
        if(cnt > 2) {
            return s.length() - 1;
        }
        if(idx == origin.length()-1) {
            return s.length();
        }
        return countString(idx + 1, cnt, s, origin);
    }

    int lengthOfLongestSubstringTwoDistinct(string s) {
        transform(s.begin(), s.end(), s.begin(), [](unsigned char c){ return std::tolower(c);});
        int maxx = 0;

        for(int i = 0; i < s.length(); i++) {
            maxx = max(maxx, countString(i, 0, "", s));
        }
        return maxx;
    }
};