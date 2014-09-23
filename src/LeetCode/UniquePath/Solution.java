package LeetCode.UniquePath;

public class Solution {
	//http://oj.leetcode.com/problems/unique-paths/
	public int uniquePaths(int m, int n) {
		int[][] nodeArray = new int[m][n];
		return nodePath(nodeArray, m - 1, n - 1);

	}

	// add memorization
	public int nodePath(int[][] nodeArray, int i, int j) {
		if (nodeArray[i][j] != 0) {
			return nodeArray[i][j];
		}
		if (i == 0 && j == 0) {
			nodeArray[i][j] = 1;
		} else if (i == 0) {
			nodeArray[i][j] = nodePath(nodeArray, i, j - 1);
		} else if (j == 0) {
			nodeArray[i][j] = nodePath(nodeArray, i - 1, j);
		} else {
			nodeArray[i][j] = nodePath(nodeArray, i, j - 1)
					+ nodePath(nodeArray, i - 1, j);
		}
		return nodeArray[i][j];
	}

	//http://oj.leetcode.com/problems/unique-paths-ii/
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int r = obstacleGrid.length;
		int c = obstacleGrid[0].length;
		int[][] nodeArray = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				nodeArray[i][j] = -1;
			}
		}
		return nodePathWithObstacles(obstacleGrid, nodeArray, r - 1, c - 1);
	}

	public int nodePathWithObstacles(int[][] obstacleGrid, int[][] nodeArray,
			int i, int j) {
		if (nodeArray[i][j] != -1) {
			return nodeArray[i][j];
		}
		if(obstacleGrid[i][j]==1)
		{
			nodeArray[i][j] = 0;
			return nodeArray[i][j];
		}
		if (i == 0 && j == 0) {
			if (obstacleGrid[0][0] == 1) {
				nodeArray[0][0] = 0;
			} else {
				nodeArray[0][0] = 1;
			}
		} else if (i == 0) {
			if (obstacleGrid[i][j - 1] == 1) {
				nodeArray[i][j] = 0;
			} else {
				nodeArray[i][j] = nodePathWithObstacles(obstacleGrid,
						nodeArray, i, j - 1);
			}
		} else if (j == 0) {
			if (obstacleGrid[i - 1][j] == 1) {
				nodeArray[i][j] = 0;
			} else {
				nodeArray[i][j] = nodePathWithObstacles(obstacleGrid,
						nodeArray, i - 1, j);
			}

		} else {
			if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
				nodeArray[i][j] = 0;
			} else if (obstacleGrid[i - 1][j] == 1) {
				nodeArray[i][j] = nodePathWithObstacles(obstacleGrid,
						nodeArray, i, j - 1);
			} else if (obstacleGrid[i][j - 1] == 1) {
				nodeArray[i][j] = nodePathWithObstacles(obstacleGrid,
						nodeArray, i - 1, j);
			} else {
				nodeArray[i][j] = nodePathWithObstacles(obstacleGrid,
						nodeArray, i, j - 1)
						+ nodePathWithObstacles(obstacleGrid, nodeArray, i - 1,
								j);
			}
		}
		return nodeArray[i][j];
	}

	//http://oj.leetcode.com/problems/minimum-path-sum/
	  public int minPathSum(int[][] grid) {
	        int m = grid.length;
			int n = grid[0].length;
			int[][] gVals = new int[m][n];
			return minNodeValue(grid, gVals, m-1, n-1);
	    }
	    
	    //add memorization
	    public int minNodeValue(int[][] grid, int[][] gVals, int i, int j)
	    {
			if(i == 0 && j == 0)
			{
			    gVals[0][0]=grid[0][0];
			    return gVals[0][0];
			}
			if(j>0 && gVals[i][j-1] == 0)
			{
			    gVals[i][j-1] = minNodeValue(grid,gVals, i, j-1);
			}
			if(i>0 && gVals[i-1][j] == 0)
			{
			    gVals[i-1][j]= minNodeValue(grid,gVals,i-1, j);
			}
			
	        if(i==0)
	        { 
	            return grid[i][j] + gVals[i][j-1];
	        }
	        if(j==0)
	        {
	            return grid[i][j] + gVals[i-1][j];
	        }
	        return grid[i][j] + Math.min(gVals[i-1][j], gVals[i][j-1]);
	    }
	    
}