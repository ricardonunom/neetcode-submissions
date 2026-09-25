class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        for(int middle = 0; middle < nums.length; middle++){
            if (middle > 0 && nums[middle] == nums[middle - 1]) continue;

            left = middle + 1;
            right = nums.length - 1;
            while(left < right){
                int value = nums[left] + nums[middle] + nums[right];
                if(value == 0){
                    results.add(Arrays.asList(nums[left], nums[middle], nums[right]));

                    right--;
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (value > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }

        return results;
    }
}
