package solution;

public class Problem_691 {
	/*
	 * 1. 与给出答案的思路相同，都使用 isVisit 数组用来记录是否访问过
	 * 2. 考虑到全局变量 grid，代码可进一步精简（原先grid作为形参传的）
	 * 3. 除了递归写法外，还可以用 循环 + 栈 来实现，时空成本几乎不变
	 * 		提供了 递归->循环 的一种思路
	 */
    private boolean[][] isVisit;
    private int[][] grid;
    
    public boolean xBoundary(int x, int xSize){
        return x >= 0 && x < xSize;
    }
    
    public boolean yBoundary(int y, int ySize){
        return y >= 0 && y < ySize;
    }
    
    public int maxConnectedSize(int j, int i){
        int ySize = grid.length;
        int xSize = grid[0].length;
        int thisConnectedSize = 0;
        if(xBoundary(i + 1, xSize) && yBoundary(j, ySize))
            if(!isVisit[j][i + 1]){
                isVisit[j][i + 1] = true;
                if(grid[j][i + 1] == 1){
                    thisConnectedSize += maxConnectedSize(j, i + 1);
                }
            }
        if(xBoundary(i - 1, xSize) && yBoundary(j, ySize))
            if(!isVisit[j][i - 1]){
                isVisit[j][i - 1] = true;
                if(grid[j][i - 1] == 1){
                    thisConnectedSize += maxConnectedSize(j, i - 1);
                }
            }
        if(xBoundary(i, xSize) && yBoundary(j + 1, ySize))
            if(!isVisit[j + 1][i]){
                isVisit[j + 1][i] = true;
                if(grid[j + 1][i] == 1){
                    thisConnectedSize += maxConnectedSize(j + 1, i);
                }
            }
        if(xBoundary(i, xSize) && yBoundary(j - 1, ySize))
            if(!isVisit[j - 1][i]){
                isVisit[j - 1][i] = true;
                if(grid[j - 1][i] == 1){
                    thisConnectedSize += maxConnectedSize(j - 1, i);
                }
            }
        return 1 + thisConnectedSize;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0)
            return 0;
        if(grid[0].length == 0)
            return 0;
        int ySize = grid.length;
        int xSize = grid[0].length;
        isVisit = new boolean [ySize][xSize];
        this.grid = grid;
        int max = 0;
        for(int j = 0; j < ySize; j ++){
            for(int i = 0; i < xSize; i ++){
                if(!isVisit[j][i])
                    isVisit[j][i] = true;
                else
                    continue;
                if(grid[j][i] == 1){
                    max = Math.max(max, maxConnectedSize(j, i));
                }
            }
        }
        return max;
    }
}
