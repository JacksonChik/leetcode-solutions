class Solution {
    char[][] globalGrid;
    public int numIslands(char[][] grid) {
        int sum = 0;
        globalGrid = grid;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                
                if(grid[i][j] == '1'){
                    DFS(i, j);
                    sum++;
                }
            }
        }
        return sum;
    }
    
    public void DFS(int x, int y){
        if(x > globalGrid.length-1 || y > globalGrid[0].length-1 ||x < 0 || y < 0 || globalGrid[x][y] == '0' ||  globalGrid[x][y] == '2') return;
        
            globalGrid[x][y] = '2';
             DFS(x+1,y);
             DFS(x-1,y);
             DFS(x,y+1);
             DFS(x,y-1);
        }
    }
    
    
