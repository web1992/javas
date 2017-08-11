package cn.web1992.utils.interviews.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web1992
 * @date 2017/3/28 9:25
 * @desc 给定一个数组，[a,c,c,d,e,f...]找出a+b+c=0的所有元素
 * 并按照 [a,b,c]  打印
 */
public class Solution2 {

	public List<List<Integer>> filterNum(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();

		Arrays.sort(nums);// 从小到大


		for (int i = 0; i < nums.length - 2; i++) {

			int first  = nums[i + 1];
			int last   = nums.length - 1;
			int target = -nums[i];

			while (first < last) {

				if (nums[first] + nums[last] == target) {

					List<Integer> l = new ArrayList<>();

					l.add(nums[first]);
					l.add(nums[last]);
					l.add(nums[target]);

				} else if (nums[first] + nums[last] > target) {
						last--;
				}else{
					first++;
				}

			}
		}
		return list;
	}



	public static void main(String[] args){
		Integer[] nums=new Integer[]{0,1,2,3,4,-4,-3,-2,-1,0};
		List<List<Integer>> lists = new Solution().threeSum(nums);

		System.out.println(lists);
	}

}

