package sort;

/**
 * @Author wzq
 * @Date 2021/12/16
 * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。从小到大
 **/
public class InsertionSort <T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(nums[j],nums[j-1]); j--) {
                swap(nums,j,j-1);
            }
        }
    }
}
