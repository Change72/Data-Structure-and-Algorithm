import algorithm.other.MergeTwoSortedArrays;
import algorithm.sort.BubbleSort;
import algorithm.sort.InsertSort;
import algorithm.sort.MergeSort;
import algorithm.sort.QuickSort;
import solution.Problem_001;
import solution.Problem_002;
import solution.Problem_003;
import solution.Problem_004;
import solution.Problem_007;
import solution.Problem_009;
import solution.Problem_013;
import solution.Problem_014;
import solution.Problem_020;
import solution.Problem_021;
import solution.Problem_026;
import solution.Problem_027;
import solution.Problem_028;
import solution.Problem_035;
import solution.Problem_038;
import solution.Problem_053;

public class Application {

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		System.out.println();
		
		System.out.println("----------     Algorithm    ----------");
		System.out.println("********** QucikSort  Begin **********");
		QuickSort quickSort = new QuickSort();
		quickSort.TestCase();
		System.out.println("********** QucikSort   End  **********");
		System.out.println();
		
		System.out.println("********** MergeSort  Begin **********");
		MergeSort mergeSort = new MergeSort();
		mergeSort.TestCase();
		System.out.println("********** MergeSort   End  **********");
		System.out.println();
		
		System.out.println("********** InsertSort  Begin **********");
		InsertSort insertSort = new InsertSort();
		insertSort.TestCase();
		System.out.println("********** InsertSort   End  **********");
		System.out.println();
		
		System.out.println("********** BubbleSort  Begin **********");
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.TestCase();
		System.out.println("********** BubbleSort   End  **********");
		System.out.println();
		
		System.out.println();

		System.out.println("********** Problem  1  Begin **********");
		Problem_001 problem_1 = new Problem_001();
		problem_1.TestCase();
		System.out.println("********** Problem  1   End  **********");
		System.out.println();
		
		System.out.println("********** Problem  2  Begin **********");
		Problem_002 problem_2 = new Problem_002();
		problem_2.TestCase();
		System.out.println("********** Problem  2   End  **********");
		System.out.println();
		
		System.out.println("********** Problem  3  Begin **********");
		Problem_003 problem_3 = new Problem_003();
		problem_3.TestCase();
		System.out.println("********** Problem  3   End  **********");
		System.out.println();
		
		System.out.println("********** Problem  4  Begin **********");
		Problem_004 problem_4 = new Problem_004();
		problem_4.TestCase();
		System.out.println("********** Problem  4   End  **********");
		System.out.println();
		
		System.out.println("********** Problem  7 Begin  **********");
		Problem_007 problem_7 = new Problem_007();
		problem_7.TestCase();
		System.out.println("********** Problem  7  End   **********");
		System.out.println();
		
		System.out.println("********** Problem  9 Begin  **********");
		Problem_009 problem_9 = new Problem_009();
		problem_9.TestCase();
		System.out.println("********** Problem  9  End   **********");
		System.out.println();
		
		System.out.println("********** Problem  13 Begin **********");
		Problem_013 problem_13 = new Problem_013();
		problem_13.TestCase();
		System.out.println("********** Problem  13  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  14 Begin **********");
		Problem_014 problem_14 = new Problem_014();
		problem_14.TestCase();
		System.out.println("********** Problem  14  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  20 Begin **********");
		Problem_020 problem_20 = new Problem_020();
		problem_20.TestCase();
		System.out.println("********** Problem  20  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  21 Begin **********");
		Problem_021 problem_21 = new Problem_021();
		problem_21.TestCase();
		System.out.println("********** Problem  21  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  26 Begin **********");
		Problem_026 problem_26 = new Problem_026();
		problem_26.TestCase();
		System.out.println("********** Problem  26  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  27 Begin **********");
		Problem_027 problem_27 = new Problem_027();
		problem_27.TestCase();
		System.out.println("********** Problem  27  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  28 Begin **********");
		Problem_028 problem_28 = new Problem_028();
		problem_28.TestCase();
		System.out.println("********** Problem  28  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  35 Begin **********");
		Problem_035 problem_35 = new Problem_035();
		problem_35.TestCase();
		System.out.println("********** Problem  35  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  38 Begin **********");
		Problem_038 problem_38 = new Problem_038();
		problem_38.TestCase();
		System.out.println("********** Problem  38  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  53 Begin **********");
		Problem_053 problem_53 = new Problem_053();
		problem_53.TestCase();
		System.out.println("********** Problem  53  End  **********");
		System.out.println();
		
		System.out.println("------------     Other    ------------");
		System.out.println("********** MergeTwoSortedArrays  Begin **********");
		MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
		mergeTwoSortedArrays.TestCase();
		System.out.println("********** MergeTwoSortedArrays   End  **********");
		System.out.println();
	}
}
