package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author wzq
 * @Date 2021/7/7
 **/
public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TreadDemo treadDemo = new TreadDemo();

        //使用Callable需要FutureTask支持获取返回值
        FutureTask<Integer> result = new FutureTask<>(treadDemo);
        new Thread(result).start();
        //获取结果
        Integer integer = result.get();
        System.out.println(integer);

    }

}

class TreadDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 2 ;
    }
}
