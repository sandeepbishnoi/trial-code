class Solution1 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int row =0 ; row < grid.length; row++) {
            for(int col=0; col < grid[row].length; col++) {
                if(grid[row][col] == 1) {
                    int area = computeArea(grid, row, col);
                    if(area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
    
    public int computeArea(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col]==0 ) {
            return 0;
        } else {
            grid[row][col]=0;
            return 1 + computeArea(grid, row-1, col) + computeArea(grid, row, col-1) + computeArea(grid, row+1, col) + computeArea(grid, row, col+1);
        }
    }
}
