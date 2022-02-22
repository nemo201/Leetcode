class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); res = res *26 + (columnTitle.charAt(i) - 'A' + 1), i++);
        return res;
    }
}