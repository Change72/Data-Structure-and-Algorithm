import algorithm.dynamic.SteelCutting;
import algorithm.other.MergeTwoSortedArrays;
import algorithm.sort.BubbleSort;
import algorithm.sort.CountingSort;
import algorithm.sort.HeapSort;
import algorithm.sort.InsertSort;
import algorithm.sort.MergeSort;
import algorithm.sort.QuickSort;
import dataStructure.heap.MaxHeap;
import dataStructure.heap.MaxHeapModel;
import dataStructure.heap.MinHeap;
import dataStructure.heap.MinHeapModel;
import dataStructure.tree.BinarySearchTree;
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
import solution.Problem_058;
import solution.Problem_066;
import solution.Problem_067;
import solution.Problem_070;
import solution.Problem_080;
import solution.Problem_082;
import solution.Problem_083;

public class Application {

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		System.out.println();
		
		System.out.println("----------     Algorithm    ----------");
		System.out.println("********** QuickSort  Begin **********");
		QuickSort quickSort = new QuickSort();
		quickSort.TestCase();
		System.out.println("********** QuickSort   End  **********");
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
		
		System.out.println("********** HeapSort  Begin **********");
		HeapSort heapSort = new HeapSort();
		heapSort.TestCase();
		System.out.println("********** HeapSort   End  **********");
		System.out.println();
		
		System.out.println("********** CountingSort  Begin **********");
		CountingSort countingSort = new CountingSort();
		countingSort.TestCase();
		System.out.println("********** CountingSort   End  **********");
		System.out.println();
		
		System.out.println("********** CountingSort  Begin **********");
		SteelCutting steelCutting = new SteelCutting();
		steelCutting.TestCase();
		System.out.println("********** CountingSort   End  **********");
		System.out.println();
		
		System.out.println();
		
		System.out.println("-------     Data Structure    -------");
		System.out.println("********** MaxHeap  Begin **********");
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.TestCase();
		System.out.println("********** MaxHeap   End  **********");
		System.out.println();
		
		System.out.println("********** MaxHeapModel  Begin **********");
		MaxHeapModel maxHeapModel = new MaxHeapModel();
		maxHeapModel.TestCase();
		System.out.println("********** MaxHeapModel   End  **********");
		System.out.println();
		
		System.out.println("********** MinHeap  Begin **********");
		MinHeap minHeap = new MinHeap();
		minHeap.TestCase();
		System.out.println("********** MinHeap   End  **********");
		System.out.println();
		
		System.out.println("********** MinHeapModel  Begin **********");
		MinHeapModel minHeapModel = new MinHeapModel();
		minHeapModel.TestCase();
		System.out.println("********** MinHeapModel   End  **********");
		System.out.println();
		
		System.out.println("********** Binary Search Tree Begin **********");
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.TestCase();
		System.out.println("********** Binary Search Tree   End  **********");
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
		
		System.out.println("****** Problem  38 Beats 100% !~ ******");
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
		
		System.out.println("********** Problem  58 Begin **********");
		Problem_058 problem_58 = new Problem_058();
		problem_58.TestCase();
		System.out.println("********** Problem  58  End  **********");
		System.out.println();
		
		System.out.println("****** Problem  66 Beats 100% !~ ******");
		System.out.println("********** Problem  66 Begin **********");
		Problem_066 problem_66 = new Problem_066();
		problem_66.TestCase();
		System.out.println("********** Problem  66  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  67 Begin **********");
		Problem_067 problem_67 = new Problem_067();
		problem_67.TestCase();
		System.out.println("********** Problem  67  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  70 Begin **********");
		Problem_070 problem_70 = new Problem_070();
		problem_70.TestCase();
		System.out.println("********** Problem  70  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  80 Begin **********");
		Problem_080 problem_80 = new Problem_080();
		problem_80.TestCase();
		System.out.println("********** Problem  80  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  82 Begin **********");
		Problem_082 problem_82 = new Problem_082();
		problem_82.TestCase();
		System.out.println("********** Problem  82  End  **********");
		System.out.println();
		
		System.out.println("********** Problem  83 Begin **********");
		Problem_083 problem_83 = new Problem_083();
		problem_83.TestCase();
		System.out.println("********** Problem  83  End  **********");
		System.out.println();
		
		System.out.println("****** Problem  100 Beats 100% !~ ******");
		System.out.println("****** Problem  104 Beats 100% !~ ******");
		System.out.println("****** Problem  107 Beats 100% !~ ******");
		System.out.println("****** Problem  112 Beats 100% !~ ******");
		
		System.out.println("------------     Other    ------------");
		System.out.println("********** MergeTwoSortedArrays  Begin **********");
		MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
		mergeTwoSortedArrays.TestCase();
		System.out.println("********** MergeTwoSortedArrays   End  **********");
		System.out.println();
	}
}
