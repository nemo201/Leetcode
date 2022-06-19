class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        part(0, s, list, new ArrayList());
        return list;
    }
    
    public void part(int index, String s, List<List<String>> ans, List<String> ds) {
        if (index == s.length()) {
            ans.add(new ArrayList(ds));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (isPal(index, i, s)) {
                ds.add(s.substring(index, i + 1));
                part(i + 1, s, ans, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }
    
    public boolean isPal(int start, int end, String s) {
        while (start <= end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}