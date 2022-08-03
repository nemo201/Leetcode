class MyCalendar {
    TreeMap<Integer, Integer> cal;

    public MyCalendar() {
        cal = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = cal.floorKey(start),
                next = cal.ceilingKey(start);
        
        if ((prev == null || cal.get(prev) <= start) && (next == null || end <= next)){
            cal.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */