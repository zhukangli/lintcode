package linear.linkedList;

import java.util.HashMap;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。
 注意这里下标的范围是 0 到 n-1。
 样例
 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].


 * Created by Conley on 2018/2/25.
 * 解题思路1：暴力破解法
 * 解题思路2：耗费O(n)空间构造哈希表，遍历数组每个元素nums[i]，
 *      哈希表对应存储<target - nums[i], i>，存储nums[i]期望的“另一半”，
 *      一旦哈希表中包含nums[i]，代表“另一半”早已存储在哈希表中，直接返回即可；
        复杂度分析：时间复杂度O(n)，空间复杂度O(n)
 *
 *
 *
 */
public class TwoSum {
    /**
     * @param nums: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap();
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                results[0] = map.get(nums[i]) ;
                results[1] = i ;
                break;
            }
            map.put(target - nums[i], i);
        }
        return results;
    }
}
