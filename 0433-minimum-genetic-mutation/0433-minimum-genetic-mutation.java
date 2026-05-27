class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> dict = new HashSet<>();

        for (String s : bank) {
            dict.add(s);
        }
        char[] mutations = new char[]{'A', 'C', 'G', 'T'};

        if (!dict.contains(endGene)) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (cur.equals(endGene)) {
                    return level;
                }

                char[] curGene = cur.toCharArray();
                for (int j = 0; j < curGene.length; j++) {
                    char og = curGene[j];
                    for (int k = 0; k < mutations.length; k++) {
                        curGene[j] = mutations[k];

                        String newGene = new String(curGene);

                        if (dict.contains(newGene)) {
                            q.offer(newGene);
                            dict.remove(newGene);
                        }
                    }
                    curGene[j] = og;
                }
            }
            level++;
        }
        return -1;
    }
}