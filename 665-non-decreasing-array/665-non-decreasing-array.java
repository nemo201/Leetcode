public class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int cnt = 0;    
        int len = nums.length;
        int break_index = -1;
        
        for(int i=0;i<len-1 && cnt < 2;++i){           
            if(nums[i] > nums[i+1]){
                cnt += 1;
                break_index = i+1;
            }            
        }
        
        if(cnt > 1) 
            return false;     
        if(break_index == len-1 || break_index == 1) 
            return true;
        if(cnt == 1 && nums[break_index-1] <= nums[break_index+1]) 
            return true;
        if(cnt == 1 && nums[break_index-2] <= nums[break_index]) 
            return true;
        
        return cnt == 0;
    }
}