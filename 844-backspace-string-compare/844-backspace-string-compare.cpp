class Solution {
public:
    bool backspaceCompare(string s, string t) {
       s=solve(s);
       t=solve(t);
       if(s.size()- count(s.begin(),s.end(),'#') != t.size() - count(t.begin(),t.end(),'#')) return false; 
       int l=0,r=0;
       while(l<s.size() && r<t.size()) {
             while(l<s.size() && s[l]=='#') l++;
             while(r<t.size() && t[r]=='#') r++;
             if(l<s.size() && r<t.size() && s[l]!=t[r]) return false;
             l++;
             r++;
       }
       return true;
    }
    string solve(string s) {
        int l = 0 ,r = 0; 
        for(int i=l; i<s.size(); i++) {
              if(s[i]=='#') {
                    while(r>=0 && s[r]=='#') r--;
                    if(r>=0) {
                      s[r]='#';
                      r--;
                    }
              }else {
                  r=i;
              }
        }
       return s; 
    }
};