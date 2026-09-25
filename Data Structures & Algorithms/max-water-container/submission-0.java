class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while(left < right){
            int lower = heights[left] < heights[right] ? heights[left] : heights[right];
            if(lower * (right - left) > max){
                max = lower * (right - left);
            } else if (heights[left] > heights[right]){
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
