/**
 * 最小堆  https://blog.csdn.net/DWL0208/article/details/77938258
 */
@SuppressWarnings("all")
public class MinHeap {

    // 使用数组存储堆中的数据
    private int[] data;

    public MinHeap(int[] data) {
        this.data = data;
        bulidHeap();
    }

    /**
     * 建立最小堆
     */
    private void bulidHeap() {
        // 下标小于等于i的节点拥有子节点
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            change(i);
        }
    }

    /**
     * 根据父节点判断是否
     * 与左右孩子交换
     */
    private void change(int i) {
        int temp = 0;
        int left = left(i);
        int right = right(i);

        // 存在右节点则存在左节点
        if (right < data.length) {
            // 拿到左右孩子中小的下标
            temp = min(left, right);
            if (data[i] > data[temp]) {
                swap(i, temp);
                // 如果和子节点发生交换，则要对子节点的左右孩子进行调整
                change(temp);
            }

            // 不存在右节点但存在左节点，则左节点无孩子节点
        } else if (left < data.length) {
            // 孩子节点大于父节点，直接交换位置
            if (data[i] > data[left]) {
                swap(i, left);
            }
        }
    }

    /**
     * 获取两个节点中较小的节点的下标
     */
    private int min(int i, int j) {
        if (data[i] >= data[j]) {
            return j;
        }
        return i;
    }


    /**
     * 根据父节点下标获取
     * 左孩子节点下标
     */
    private int left(int i) {
        return ((i + 1) << 1) - 1;

    }

    /**
     * 根据父节点下标获取
     * 右孩子节点下标
     */
    private int right(int i) {
        // 左移1位相当于乘2
        return (i + 1) << 1;

    }

    /**
     * 根据下标交换数组中的位置
     */
    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 重置堆顶
     */
    public void newRoot(int root) {
        data[0] = root;
        change(0);

    }

    /**
     * 获取堆顶
     */
    public int getRoot() {
        return data[0];
    }

    /**
     * 获取堆数据
     */
    public int[] getData() {
        return data;
    }

}