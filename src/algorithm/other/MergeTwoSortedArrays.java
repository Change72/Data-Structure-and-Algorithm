package algorithm.other;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	
	public int[] merge(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] ans = new int[m + n];
		int i = 0, j = 0;
		for (int k = 0; k < m + n; k++) {
			if (i < m && j < n) {
				if (nums1[i] <= nums2[j]) {
					ans[k] = nums1[i];
					i++;
				} else {
					ans[k] = nums2[j];
					j++;
				}
				continue;
			}
			while (i < m) {
				ans[k] = nums1[i];
				i++;
				k++;
			}
			while (j < n) {
				ans[k] = nums2[j];
				j++;
				k++;
			}
		}
		return ans;
	}
	
	public void TestCase() {
		int[] nums1 = new int[] {0, 2, 7, 11, 15};
		int[] nums2 = new int[] {-5, 4, 9};
		System.out.println(Arrays.toString(merge(nums1,nums2)));
	}
}
