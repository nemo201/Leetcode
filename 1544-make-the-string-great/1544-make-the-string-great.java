class Solution {
    public String makeGood(String s) {
        StringBuilder newS = new StringBuilder(s);
        
        while (newS.length() > 1) {
            boolean find = false;
            
            for (int i = 0; i < newS.length() - 1; i++) {
                char currChar = newS.charAt(i), nextChar = newS.charAt(i + 1);
                
                if (Math.abs(currChar - nextChar) == 32) {
                    newS.deleteCharAt(i);
                    newS.deleteCharAt(i);
                    find = true;
                    break;
                }
            }
            
            if (!find)
                break;
        }
        return newS.toString();
    }
}