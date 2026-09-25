class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
/*
        int left = 0;
        for(int row = 0; row < matrix.length; row++){
            int colums = matrix[row].length;
            if(matrix[row][colums - 1] < target) continue; 

                
            int right = colums - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(matrix[row][mid] == target) return true;
                else if(matrix[row][mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
*/
            
            int rows = matrix.length;
            int columns = matrix[0].length;

            int left = 0;
            int right = rows * columns - 1;
            
            while(left <= right){
                int mid = left + (right - left) / 2;
                int row = mid / columns;
                int column = mid % columns;
                
                if(matrix[row][column] == target){
                    
                     return true;
                } else if(matrix[row][column] > target) right = mid - 1;
                else left = mid + 1;
            }


        return false;
    }
}
