class Solution {
public:
    int divide(long a, long b) {
    return a/b>INT_MAX?INT_MAX:a/b;
}
};