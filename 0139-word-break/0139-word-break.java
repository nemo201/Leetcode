class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean [] memo = new Boolean[s.length()];
        return helper (s, wordDict, 0, memo);
    }

    private boolean helper (String s, List<String> dict, int index, Boolean [] memo) {
        if (index == s.length()) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        for (String word : dict) {
            if (index + word.length() > s.length()) {
                continue;
            }

            if (s.startsWith(word, index)) {
                if (helper (s, dict, index + word.length(), memo)) {
                    return memo[index] = true;
                }
            }
        }
        return memo[index] = false;
    }
}