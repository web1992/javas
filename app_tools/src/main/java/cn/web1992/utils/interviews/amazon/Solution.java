package cn.web1992.utils.interviews.amazon;
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
//
// Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<List<Integer>> threeSum(Integer[] nums) {


		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {

				continue;

			}

			int next      = i + 1;
			int last      = nums.length - 1;
			int target = -nums[i];

			while (next < last) {

				if (nums[next] + nums[last] == target) {

					ArrayList<Integer> temp = new ArrayList<Integer>();

					temp.add(nums[i]);
					temp.add(nums[next]);
					temp.add(nums[last]);

					result.add(temp);

					next++;
					last--;

					while (next < last && nums[next] == nums[next - 1]) next++;
					while (next < last && nums[last] == nums[last + 1]) last--;

				} else if (nums[next] + nums[last] > target) {

					last--;

				} else {

					next++;

				}

			}

		}

		return result;

	}


	public static void main(String[] args){

		//[[-4, 0, 4], [-4, 1, 3], [-3, -1, 4], [-3, 0, 3], [-3, 1, 2], [-2, -1, 3], [-2, 0, 2], [-1, 0, 1]]
		//[[-4, 0, 4], [-4, 1, 3], [-3, -1, 4], [-3, 0, 3], [-3, 1, 2], [-2, -1, 3], [-2, 0, 2], [-1, 0, 1]]

		Integer[] nums=new Integer[]{0,1,2,3,4,-4,-3,-2,-1,0};
		List<List<Integer>> lists = new Solution().threeSum(nums);

		System.out.println(lists);
	}
}