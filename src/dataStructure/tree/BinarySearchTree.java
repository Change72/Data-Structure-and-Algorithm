package dataStructure.tree;

/**
 * @author change
 *
 */
public class BinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private TreeNode root;
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}	

	/*
	 * 遍历 1. 先序 2. 中序 3. 后序
	 */
	public void preorderTreeWalk(TreeNode x) {
		if (x == null)
			return;
		System.out.println(x.val);
		preorderTreeWalk(x.left);
		preorderTreeWalk(x.right);
	}

	public void inorderTreeWalk(TreeNode x) {
		if (x == null)
			return;
		inorderTreeWalk(x.left);
		System.out.println(x.val);
		inorderTreeWalk(x.right);
	}

	public void postorderTreeWalk(TreeNode x) {
		if (x == null)
			return;
		postorderTreeWalk(x.left);
		postorderTreeWalk(x.right);
		System.out.println(x.val);
	}

	/*
	 * 查找 1. 基于递归 2. 基于循环 基于循环的效率要高得多
	 */
	public TreeNode treeSearch(TreeNode x, int val) {
		if (x == null || x.val == val)
			return x;
		if (x.val > val)
			return treeSearch(x.left, val);
		else
			return treeSearch(x.right, val);
	}

	public TreeNode iterativeTreeSearch(TreeNode x, int val) {
		while (x != null && x.val != val) {
			if (x.val > val)
				x = x.left;
			else
				x = x.right;
		}
		return x;
	}

	/*
	 * 最值 1.最大值 2.最小值
	 */
	public TreeNode treeMaximum(TreeNode x) {
		while (x.right != null)
			x = x.right;
		return x;
	}

	public TreeNode treeMinimum(TreeNode x) {
		while (x.left != null)
			x = x.left;
		return x;
	}

	/*
	 * 1. 后继 2.前驱
	 */
	public TreeNode treeSuccessor(TreeNode x) {
		if (x == null)
			return x;
		if (x.right != null)
			return treeMinimum(x.right);
		while (x.parent != null && x == x.parent.right)
			x = x.parent;
		return x.parent;
	}

	public TreeNode treePredecessor(TreeNode x) {
		if (x == null)
			return x;
		if (x.left != null)
			return treeMaximum(x.left);
		while (x.parent != null && x == x.parent.left)
			x = x.parent;
		return x.parent;
	}

	/*
	 * 插入
	 */
	public boolean treeInsert(TreeNode x, int newNodeVal) {
		try {
			if (x == null) {
				x = new TreeNode(newNodeVal);
				return true;
			}
			TreeNode newNode = new TreeNode(newNodeVal);
			while (true) {
				if (x.val >= newNodeVal)
					if (x.left != null)
						x = x.left;
					else {
						x.left = newNode;
						break;
					}
				else if (x.right != null)
					x = x.right;
				else {
					x.right = newNode;
					break;
				}
			}
			newNode.parent = x;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	/*
	 * 删除 预备函数：treeTransplant —— 用节点v及其子树替代节点u及其子树，并使节点u的双亲成为节点v的双亲
	 * 如果u为根节点，则对私有变量root进行更新
	 */
	public void treeTransplant(TreeNode u, TreeNode v) {
			if(u.parent == null)
				this.setRoot(v);
			else if(u == u.parent.left)
				u.parent.left = v;
			else
				u.parent.right = v;
			if(v != null)
				v.parent = u.parent;
		}

	/*
	 * 从直观上讲，删除分为3种情况：
	 * 1. 目标节点z为叶子节点 —— 只需简单删除即可，并修改其与父节点指针
	 * 2. 目标节点z只有一个孩子 —— 将该孩子提升到目标节点的位置，并修改其与父节点指针
	 * 3. 目标节点z有两个孩子 —— 先找到目标节点的后继节点y（y是z的后继节点，y的左孩子一定为null）
	 * 		3.1 如果y是目标节点z的右孩子，直接用y替换z，维护z的父节点和左孩子作为y的父节点和左孩子，y的右孩子维持不变
	 * 		3.2 如果y不是目标节点z的右孩子
	 * 			3.2.1 用y的右孩子替换y，将y提出来后，y的右孩子指向目标节点z的右孩子
	 * 			3.2.2 （回到3.1的情况）用y替换z
	 * 
	 * 实际编码中
	 * 1. 判断z的左孩子是否为空，如果是，直接用右孩子r替换z
	 * 2. 如果左孩子不为空，判断右孩子是否为空，如果是，用左孩子l替换z
	 * 3. 如果两个孩子都不为空，则按照3.1和3.2来设计
	 * 
	 * 注意：当删除的是根节点时，树的根发生变化，因此设计私有变量root来记录树的根节点
	 */
	public boolean treeDelete(TreeNode x, int val) {
		try {
			TreeNode targetDelete = this.iterativeTreeSearch(x, val);
			if (targetDelete.left == null)
				this.treeTransplant(targetDelete, targetDelete.right);
			else if (targetDelete.right == null)
				this.treeTransplant(targetDelete, targetDelete.left);
			else {
				TreeNode y = this.treeMinimum(targetDelete.right);
				if (y.parent != targetDelete) {
					this.treeTransplant(y, y.right);
					y.right = targetDelete.right;
					y.right.parent = y;
				}
				this.treeTransplant(targetDelete, y);
				y.left = targetDelete.left;
				y.left.parent = y;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	
	/*
	 * 以下为测试使用，包括建树和测试样例
	 */

	
	public int left(int i) {
		return 2 * i + 1;
	}
	
	public int right(int i) {
		return 2 * i + 2;
	}
	
	public TreeNode buildTree(int[] nums, int seq) {
		if(seq >= nums.length)
			return null;
		if(nums[seq] == -1)
			return null;
		TreeNode x = new TreeNode(nums[seq]);
		x.left = buildTree(nums, left(seq));
		if(x.left != null)
			x.left.parent = x;
		x.right = buildTree(nums, right(seq));
		if(x.right != null)
			x.right.parent = x;
		return x;
	}
	
	public void TestCase() {
		int[] nums = new int[] {5,3,8,2,4,7,13,1,-1,-1,-1,6,-1,12,16};
		TreeNode root = this.buildTree(nums, 0);
		this.setRoot(root);
		System.out.println("*******************    PreOrder     *********************");
		this.preorderTreeWalk(root);
		System.out.println("*******************    InOrder     *********************");
		this.inorderTreeWalk(root);
		System.out.println("*******************    PostOrder     *********************");
		this.postorderTreeWalk(root);
		System.out.println("*******************    Search     *********************");
		System.out.println(this.treeSearch(root, 4).val);
		System.out.println(this.treeSearch(root, 14));
		System.out.println("*******************    IterativeSearch     *********************");
		System.out.println(this.iterativeTreeSearch(root, 4).val);
		System.out.println("*******************    Maximum     *********************");
		System.out.println(this.treeMaximum(root).val);
		System.out.println("*******************    Minimum     *********************");
		System.out.println(this.treeMinimum(root).val);
		System.out.println("*******************    Successor     *********************");
		System.out.println(this.treeSuccessor(root).val);
		System.out.println(this.treeSuccessor(root.left.right).val);
		System.out.println("*******************    Predecessor     *********************");
		System.out.println(this.treePredecessor(root).val);
		System.out.println(this.treePredecessor(root.right.left.left).val);
		System.out.println("*******************    Insert     *********************");
		System.out.println(this.treeInsert(root, 9));
		this.preorderTreeWalk(root);
		System.out.println("*******************    InOrder     *********************");
		this.inorderTreeWalk(root);
		System.out.println("*******************    Delete     *********************");
		System.out.println(this.treeDelete(this.root, 5));
		this.preorderTreeWalk(this.root);
		System.out.println("*******************    InOrder     *********************");
		this.inorderTreeWalk(this.root);
		System.out.println("*******************    Delete     *********************");
		System.out.println(this.treeDelete(this.root, 9));
		this.preorderTreeWalk(this.root);
		System.out.println("*******************    InOrder     *********************");
		this.inorderTreeWalk(this.root);
	}

	
}
