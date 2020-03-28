
/**
 * 从10万个数中找10个最大的数（https://blog.csdn.net/sky_100/article/details/77675792）
 * 小顶堆大顶堆对于解决TOP-K问题拥有较高的效率，在N个数中找到K（K<N）个最大或最小的数可以分别使用小顶堆算法和大顶堆算法
 */
public class TopK {

    public static void main(String[] args) {
        int[] num = {1, 4, 6, 7, 342, 354, 11, 345, 64, 25, 45, 32, 343, 754};
        // 取前7个数据建立最小堆
        int[] data = {1, 4, 6, 7, 342, 354, 11};
        MinHeap heap = new MinHeap(data);

        for (int i = 7; i < num.length; i++) {
            // 循环与堆顶比较，大于堆顶则重置堆顶
            if (num[i] > heap.getRoot()) {
                heap.newRoot(num[i]);
            }
        }
        // 循环输出前7个最大的数
        for (int n : heap.getData()) {
            System.out.println(n);
        }

    }

}