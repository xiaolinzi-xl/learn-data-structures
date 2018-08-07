package _07_map_solution;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by xiaolinzi on 2018/8/7.
 */
public class Solution_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }
}
