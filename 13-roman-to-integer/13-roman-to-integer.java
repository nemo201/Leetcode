class Solution {
static Map<Character, Integer> map = new HashMap<>();

static {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
}

public int romanToInt(String s) {
    int sum = 0;
    int i = 0;
    int n = s.length();
    while (i < n) {
        int currentValue = map.get(s.charAt(i));
        int nextValue = (i + 1 < n) ? map.get(s.charAt(i + 1)) : 0;
        if (nextValue > currentValue) {
            sum += nextValue - currentValue;
            i +=2;
        } else {
            sum += currentValue;
            i++;
        }
        
    }
    return sum;
}
}