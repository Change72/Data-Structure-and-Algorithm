package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_347 {
	/*
	 * 新知识：Java 内置 PriorityQueue 实现堆，及重写默认比较方法
	 */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // boundary
        if(nums.length == 0)
            return new ArrayList<Integer>();
        if(nums.length == 1){
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(nums[0]);
            return ans;
        }
        //firstly build a map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
            	map.put(nums[i], map.get(nums[i]) + 1);
            else
            	map.put(nums[i], 1);            	
        }
        //secondly build a heap for frequent list, heap sort, each swap also swap element list O(nlogn)
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //小顶堆，容量11，重写默认的比较方法
            @Override
            public int compare(Integer i1,Integer i2){
                return map.get(i1) - map.get(i2);
            }
        });
        
        for(Integer key: map.keySet()) {
        	heap.add(key);
        	if(heap.size() > k)
        		heap.poll();		// 不按插入顺序，按指定的大小顺序
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        while(!heap.isEmpty()) 
        	ans.add(heap.poll());
        Collections.reverse(ans);
        
        return ans;
    }   
}
