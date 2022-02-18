class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if(needle.isEmpty()) 
            return 0;
       
       for(int i = 0; i <= haystack.length() - needle.length(); i++){

            if(haystack.charAt(i) == needle.charAt(0) && haystack.charAt(i + n - 1) == needle.charAt(n - 1)) { //extra validation

                for(int j = 0; j < needle.length() && haystack.charAt(i +j) == needle.charAt(j); j++) {

                    if(j == needle.length() -1)
                        return i;
                    
                }
            }
       }

       return -1;
    }
}