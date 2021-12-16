package sort;

/**
 * @Author wzq
 * @Date 2021/12/16
 **/
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T v,T w){
       return v.compareTo(w) < 0;
    }

    protected void swap(T[] nums,int i,int j){
        T t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
