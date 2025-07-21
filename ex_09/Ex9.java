public class Ex09 {
    public static boolean checkArraySum(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int n = numbers.length;

        for (int num : numbers) {
            if (num > max) max = num;
        }

        return subsetSum(numbers, n, max);
    }

    private static boolean subsetSum(int[] nums, int n, int target) {
        return helper(nums, 0, target, false, 0);
    }

    private static boolean helper(int[] nums, int i, int target, boolean used, int currentSum) {
        if (currentSum == target && used) return true;
        if (i >= nums.length) return false;
        if (nums[i] == target && used == false) return helper(nums, i + 1, target, true, currentSum);
        return helper(nums, i + 1, target, used, currentSum) || helper(nums, i + 1, target, true, currentSum + nums[i]);
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 23, 10, 1, 3};
        System.out.println(checkArraySum(arr));
        // Output:true // Because 4 + 6 + 10 + 3 = 23
    }
}
