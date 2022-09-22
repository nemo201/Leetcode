class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for (String str : arr) {
            for (int i = str.length() - 1; i >= 0; i--)
                sb.append(str.charAt(i));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}