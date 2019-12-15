class Solution {
public:
    string nextClosestTime(string time) {
        set<int> unit;
        int mark = 60 * stoi(time.substr(0,2));
        mark += stoi(time.substr(3));
        int minTime = 24*60;

        for(int i = 0; i < time.length(); i++) {
            if(time[i] == ':') {
                continue;
            }
            unit.insert(time[i] - '0');
        }

        string ans;

        if(unit.size() == 1) {
            return time;
        }

        for(int hr : unit) {
            for(int hr2 : unit ) {
                int hh = hr* 10 + hr2;
                if( hh < 24 ) {
                    for(int m1 : unit) {
                        for(int m2 : unit) {
                            int mn = m1 * 10 + m2;
                            if(mn < 60) {
                                int x = (hh * 60 + mn) - mark;
                                int y = 24*60;
                                int cal = ((x%y) +y ) % y;
                                if(cal > 0 && cal < minTime) {
                                    minTime = cal;
                                    ans = to_string(hr) + to_string(hr2) + ":" + to_string(m1) + to_string(m2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
};
