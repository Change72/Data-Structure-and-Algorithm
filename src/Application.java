import solution.Problem_001;
import solution.Problem_002;
import solution.Problem_003;
import solution.Problem_004;
import solution.Problem_007;
import solution.Problem_009;
import solution.Problem_038;

public class Application {

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
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
		
		System.out.println("********** Problem  38 Begin **********");
		Problem_038 problem_38 = new Problem_038();
		problem_38.TestCase();
		System.out.println("********** Problem  38  End  **********");
		System.out.println();
	}
}
