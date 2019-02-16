package solution;

import java.util.ArrayList;
import java.util.List;

public class Problem_125 {
	//125
	public static class Solution {
	    public boolean isPalindrome(String s) {
	    	if(s.length() == 0)
	    		return true;
	    	s = s.toLowerCase();
	    	List<Character> chars = new ArrayList<Character>();
	    	for(int i = 0; i < s.length(); i ++) {
	    		if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a')
	    			chars.add(s.charAt(i));
	    		if(s.charAt(i) <= '9' && s.charAt(i) >= '0')
	    			chars.add(s.charAt(i));
	    	}
	    	for(int j = 0; j < (chars.size()) / 2; j ++)
	    		if(chars.get(j) != chars.get(chars.size() - j - 1))
	    			return false;
	    	return true;
	    }
	}
}
