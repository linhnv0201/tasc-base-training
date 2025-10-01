package test;

import java.util.HashMap;

public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    // HashMap để lưu số lần xuất hiện của prefix sum
    HashMap<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1); // prefix = 0 xuất hiện 1 lần (trường hợp subarray từ đầu)

    int prefixSum = 0;
    int count = 0;

    for (int num : nums) {
      prefixSum += num;

      // Nếu prefixSum - k đã tồn tại => có subarray có tổng = k
      if (prefixCount.containsKey(prefixSum - k)) {
        count += prefixCount.get(prefixSum - k);
      }

      // Cập nhật số lần xuất hiện của prefixSum
      prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
    }

    return count;
  }

  // Test nhanh
  public static void main(String[] args) {
    SubarraySumEqualsK solution = new SubarraySumEqualsK();
    int[] nums = {1, 2, 3, 4, 5};
    int k = 9;
    System.out.println(solution.subarraySum(nums, k)); // Output: 2
  }
}
