package solution;

import java.util.ArrayList;
import java.util.List;

public class Problem_228 {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<String>();
        int first = 0;
        int second = 0;
        List<String> result = new ArrayList<String>();
        int iterator = nums[0] + 1;
        boolean isPair = false;
        first = nums[0];
        for(int i = 1; i < nums.length; i++, iterator ++){
            if(nums[i] == iterator){
                isPair = true;
                second = nums[i];
            }else{
                if(isPair){
                    result.add(itemPair(first, second));
                }else{
                    result.add(String.valueOf(first));
                }
                iterator = nums[i];
                first = nums[i];
                isPair = false;
            }
        }
        if(isPair){
            result.add(itemPair(first, second));
        }else{
            result.add(String.valueOf(first));
        }
        return result;
    }
    
    public String itemPair(int nums1, int nums2){
        return nums1 + "->" + nums2;
    }
}
