class Solution {
    public int fib(int N) {
        Map<Integer, Integer> cache = new HashMap<>();
        
        if (cache.containsKey(N))
            return cache.get(N);
        
        int result;
        
        if (N < 2)
            result = N;
        else
            result = fib(N - 1) + fib(N - 2);
        
        cache.put(N, result);
        return result;
    }
}