class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> prev = list.get(i - 1);
            cur.add(1);
            for (int j = 1; j < prev.size(); j++)
                cur.add(prev.get(j - 1) + prev.get(j));
            cur.add(1);
            list.add(cur);
        }
        return list;
    }
}