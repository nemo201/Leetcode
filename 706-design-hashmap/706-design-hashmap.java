class MyHashMap {
    LinkedList<Node>[] map;
    public static int size = 769;

    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int bucket = key % size;
        if (map[bucket] == null) {
            map[bucket] = new LinkedList<Node>();
            map[bucket].add(new Node(key, value));
        } else {
            for (Node node : map[bucket]) {
                if (node.key == key) {
                    node.val = value;
                    return;
                }
            }
            map[bucket].add(new Node(key, value));
        }
    }
    
    public int get(int key) {
        int bucket = key % size;
        LinkedList<Node> nodes = map[bucket];
        if (nodes == null)
            return -1;
        
        for (Node node : nodes)
            if (node.key == key)
                return node.val;
        
        return -1;
    }
    
    public void remove(int key) {
        int bucket = key % size;
        Node toRemove = null;
        if (map[bucket] == null)
            return;
        else {
            for (Node node : map[bucket]) {
                if (node.key == key)
                    toRemove = node;
            }
            if (toRemove == null)
                return;
            
            map[bucket].remove(toRemove);
        }
    }
}

class Node {
    public int key;
    public int val;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */