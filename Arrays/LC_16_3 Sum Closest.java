 // Solution 
    // Time Complexity --> O(n ^ 2)
    // Space Complexity --> O(1)
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length ;
        
        int result = nums[0] + nums [1] + nums[2];

        for(int i = 0 ; i< n ; i++){
            int j = i + 1 ;
            int k = n-1 ;
            while (j < k) {
                
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }

                if (sum < target) {
                    j++;
                } else{
                    k-- ;
                }

                int diffToTarget = Math.abs(target - sum);
                if (diffToTarget < Math.abs(target - result)) {
                    result = sum ;
                   
                }

            }

        }
        return result ;
