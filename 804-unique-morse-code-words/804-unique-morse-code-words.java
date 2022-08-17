class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int ans = 0;
        Set<String> set = new HashSet<>();
        
        for (String s : words) {
            String uniq = null;
            for (char c : s.toCharArray()) {
                uniq += morse[c - 'a'];
            }
            set.add(uniq);
        }
        return set.size();
    }
}