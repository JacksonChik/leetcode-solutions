class Solution {
    List<Integer> result = new ArrayList<Integer>();
    int[][] arr;
    int count;
    public List<Integer> spiralOrder(int[][] matrix) {
        arr = matrix;
        count = matrix.length * matrix[0].length;
        traverse(1, 0, 0);
        return result;
    }
    public void traverse(int direction, int x, int y){
        // 1 right, 2 down, 3 left, 4 up
        if(count == 0) return;
        // System.out.println(y);
        result.add(arr[x][y]);
        arr[x][y] = -999;
        count--;
        switch(direction){
            case 1:
                if(y + 1 == arr[0].length || arr[x][y+1] == -999) traverse(2, x + 1, y);
                else traverse(1, x, y + 1);
                break;
            case 2:
                if(x + 1 == arr.length || arr[x+1][y] == -999) traverse(3, x, y - 1);
                else traverse(2, x + 1, y);
                break;
            case 3:
                if(y - 1 == -1 || arr[x][y-1] == -999) traverse(4, x - 1, y);
                else traverse(3, x, y - 1);
                break;
            case 4:
                if(x - 1 == -1 || arr[x-1][y] == -999) traverse(1, x, y + 1);
                else traverse(4, x - 1, y);
                break;
            default:
                break;
        }
    }
}