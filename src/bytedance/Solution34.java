package bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * **容易**
 * <p>
 * LRU缓存机制 https://leetcode-cn.com/explore/interview/card/bytedance/245/data-structure/1032/
 *
 * @author CaoJing
 * @date 2019/11/12 10:23
 */
public class Solution34 {

    class LRUCacheMap<K, V> extends LinkedHashMap<K, V> {

        // 缓存容量
        int capacity;

        /**
         * @param accessOrder 为true使用访问顺序排序，false使用插入顺序排序
         */
        public LRUCacheMap(int initialCapacity, float loadFactor, boolean accessOrder) {
            super(initialCapacity, loadFactor, accessOrder);
            capacity = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }

    LRUCacheMap<Integer, Integer> map;

    public Solution34(int capacity) {
        map = new LRUCacheMap<>(capacity, 0.75f, true);
    }

    /**
     * 获取数据，如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1
     */
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    /**
     * 写入数据， 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间
     */
    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        Solution34 cache = new Solution34(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
