class NumArray {
    private int[] tree;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            updateTree(i + 1, nums[i]);
        }
    }

    public void updateTree(int index, int delta) {
        while (index < tree.length) {
            tree[index] += delta;
            index += index & -index;
        }
    }

    public int query(int index) {
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        updateTree(index + 1, delta);
    }
    
    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */