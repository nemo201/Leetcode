class Solution {
public:
        int characterReplacement(string a, int k) {
        int i=0,j=0, maxRepeating = 0, maxLen = 0;
        unordered_map<char, int> m;
        
        //Character other than maximum repeating character should at most be k, becuase we can make only k changes in the string.
        //(length of substring - number of times of the maximum occurring character in the substring) <= k
		
        for(j=0; j<a.size(); j++){
            m[a[j]]++;
            maxRepeating = max(maxRepeating, m[a[j]]);
            //When other characters become greater than k, we move window ahead.
            if(j-i+1 - maxRepeating > k){
                m[a[i]]--;
                i++;
            }
            maxLen = max(maxLen, j-i+1);
        }
        return maxLen;
    }
};