package _07_map_solution;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xiaolinzi on 2018/8/7.
 */
public class Solution_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> array = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                array.add(num);
                map.put(num, map.get(num) - 1);

                if (map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] res = new int[array.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = array.get(i);
        return res;
    }
}
