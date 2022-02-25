class Solution {
    public int compareVersion(String v1, String v2) {
        String[] l1 = v1.split("\\.");
        String[] l2 = v2.split("\\.");
        
        int len = Math.max(v1.length(), v2.length());
        for (int i = 0; i < len; i++) {
            Integer c1 = (i < l1.length) ? Integer.parseInt(l1[i]) : 0;
            Integer c2 = (i < l2.length) ? Integer.parseInt(l2[i]) : 0;
            
            if (c1 > c2)
                return 1;
            if (c2 > c1)
                return -1;
        }
        return 0;
    }
}