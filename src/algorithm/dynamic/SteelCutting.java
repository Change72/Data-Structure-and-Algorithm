package algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author change
 *
 */

public class SteelCutting {
	
	private Map<Integer, Integer> selling_price_table;
	private Map<Integer, Integer> max_price;

	/*
	 * 钢条切割问题
	 */
	public SteelCutting() {
		super();
		selling_price_table = new HashMap<Integer, Integer>();
		max_price = new HashMap<Integer, Integer>();
		selling_price_table.put(1, 1);
		selling_price_table.put(2, 5);
		selling_price_table.put(3, 8);
		selling_price_table.put(4, 9);
		selling_price_table.put(5, 10);
		selling_price_table.put(6, 17);
		selling_price_table.put(7, 17);
		selling_price_table.put(8, 20);
		selling_price_table.put(9, 24);
		selling_price_table.put(10, 30);
	}
	/*
	 * 1. 递归解法
	 */
	public int recursionSolution(int n) {
		if(n == 0)
			return 0;
		int p = selling_price_table.get(n);
		for(int i = 1; i < n; i ++) 
			p = Math.max(p, recursionSolution(i) + recursionSolution(n - i));
		return p;
	}
	
	/*
	 * 2. 带备忘的自顶向下法 top-down with memoization
	 */
	
	public int topDownSolution(int n) {
		if(max_price.containsKey(n))
			return max_price.get(n);
		if(n == 0)
			return 0;
		int p = selling_price_table.get(n);
		for(int i = 1; i < n; i ++) 
			p = Math.max(p, recursionSolution(i) + recursionSolution(n - i));
		max_price.put(n, p);
		return p;
	}
	
	/*
	 * 3. 自底向上法 bottom-up method
	 */
	public int bottomUpSolution(int n) {
		if(n == 0)
			return 0;
		max_price.clear();
		for(int i = 1; i <= n; i++) {
			int p = selling_price_table.get(i);
			for(int j = 1; j < i; j++) 
				p = Math.max(p, max_price.get(j) + max_price.get(i - j));
			max_price.put(i, p);
		}
		return max_price.get(n);
		
	}
	
	public void TestCase() {
		System.out.println("********* recursion *********");
		for(int i = 1; i < 10; i ++) {
			long begintime = System.currentTimeMillis();
			System.out.println(recursionSolution(i));
			long endtime = System.currentTimeMillis();
			System.out.println("Filter top 10 records..." + (endtime - begintime) + " millseconds");
		}
		
		System.out.println("********* top-down *********");
		for(int i = 1; i < 10; i ++) {
			long begintime = System.currentTimeMillis();
			System.out.println(topDownSolution(i));
			long endtime = System.currentTimeMillis();
			System.out.println("Filter top 10 records..." + (endtime - begintime) + " millseconds");
		}
		
		System.out.println("********* bottom-up *********");
		for(int i = 1; i < 10; i ++) {
			long begintime = System.currentTimeMillis();
			System.out.println(bottomUpSolution(i));
			long endtime = System.currentTimeMillis();
			System.out.println("Filter top 10 records..." + (endtime - begintime) + " millseconds");
		}
	}
	
}
