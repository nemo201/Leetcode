class Solution {
    public int minSetSize(int[] arr) {
         Map<Integer,Integer> hm = new HashMap<>();

        for (int x: arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            maxHeap.add(entry);
        }
        int result = 0;
        int counter = 0;
        while (!maxHeap.isEmpty()){
            if (counter>=arr.length/2){
                return result;
            }
            Map.Entry<Integer,Integer> tmp = maxHeap.poll();
            counter+=tmp.getValue();
            result++;
        }
        return result;
    }
}