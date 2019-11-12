package bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 全 O(1) 的数据结构 https://leetcode-cn.com/explore/interview/card/bytedance/245/data-structure/1033/
 *
 * @author CaoJing
 * @date 2019/11/12 10:31
 */
public class Solution35 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36265368/
     */
    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public Solution35() {
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        int t = map.getOrDefault(key, -1);
        if (t == 1) {
            map.remove(key);
        }
        if (t >= 2) {
            map.put(key, t - 1);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()
        ) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        int min = Integer.MAX_VALUE;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()
        ) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
