package bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制 https://leetcode-cn.com/explore/interview/card/bytedance/245/data-structure/1032/
 *
 * @author CaoJing
 * @date 2019/11/12 10:23
 */
public class Solution34 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36263834/
     */
    class LRUCacheMap<K, V> extends LinkedHashMap<K, V> {
        int capacity;

        public LRUCacheMap(int initialCapacity, float loadFactor, boolean accessOrder) {
            super(initialCapacity, loadFactor, accessOrder);
            capacity = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }

    LRUCacheMap<Integer, Integer> map = null;

    public Solution34(int capacity) {
        map = new LRUCacheMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
