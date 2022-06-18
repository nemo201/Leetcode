// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> list = new ArrayList<>();
//         Arrays.sort(candidates);
//         findComb(0, candidates, target, list, new ArrayList());
//         return list;
//     }
    
//     public void findComb(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
//         if (target == 0){
//             ans.add(new ArrayList(ds));
//             return;
//         }
        
//         for (int i = index; i < arr.length; i++) {
//             if (i > index && arr[i] == arr[i - 1])
//                 continue;
//             if (arr[i] > target)
//                 break;
            
//             ds.add(arr[i]);
//             findComb(i + 1, arr, target - arr[i], ans, ds);
//             ds.remove(ds.size() - 1);
//         }
//     }
// }
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findComb(0, candidates, target, list, new ArrayList());
        return list;
    }
    
    public void findComb(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList(ds));
            return;
        }
        
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;
            
            ds.add(arr[i]);
            findComb(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}