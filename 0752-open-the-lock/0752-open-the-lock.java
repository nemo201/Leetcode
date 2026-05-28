class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));

        if (dict.contains("0000") || dict.contains(target)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        String start = "0000";
        q.offer(start);
        visited.add(start);
        int turns = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (cur.equals(target)) {
                    return turns;
                }

                for (String next : neighbors(cur)) {
                    if (!dict.contains(next) && !visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            turns++;
        }
        return -1;
    }

    private List<String> neighbors(String s) {
        List<String> list = new ArrayList<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < 4; i++) {
            char og = arr[i];
            arr[i] = og == '9' ? '0' : (char)(og + 1);
            list.add(new String (arr));

            arr[i] = og == '0' ? '9' : (char)(og - 1);
            list.add(new String (arr));

            arr[i] = og;
        }
        return list;
    }
}