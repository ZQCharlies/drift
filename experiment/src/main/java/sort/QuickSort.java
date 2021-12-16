package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author wzq
 * @Date 2021/12/16
 *归并排序将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序；
 *快速排序通过一个切分元素将数组分为两个子数组，左子数组小于等于切分元素，右子数组大于等于切分元素，将这两个子数组排序也就将整个数组排序了。
 **/
public class QuickSort <T extends Comparable<T>> extends Sort<T>{


    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,8};
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(nums);
    }

    @Override
    public void sort(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
        Arrays.stream(nums).forEach(i ->System.out.print(i+"_"));
        System.out.println();
        sort(nums,0,nums.length-1);
        Arrays.stream(nums).forEach(i ->System.out.print(i+"_"));
    }

    private void sort(T[] nums,int l,int h){
        if (l >= h){
            return;
        }
        int partition = partition(nums, l, h);
        sort(nums,l,partition-1);
        sort(nums,partition+1,h);
    }

    private int partition(T[] nums,int l,int h){
        int i = l,j = h+1;
        T v = nums[l];
        while (true){
            while (less(nums[++i],v) && i!=h);
            while (less(v,nums[--j]) && j!=l);
            if (i >= j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

}
