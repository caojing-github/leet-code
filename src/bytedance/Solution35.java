package bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * **容易**
 * <p>
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
     * 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
     */
    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    /**
     * 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
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
     * 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
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
     * 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
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
