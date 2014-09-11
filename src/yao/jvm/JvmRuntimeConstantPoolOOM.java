package yao.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yao on 2014/8/11.
 *
 * 方法区 （method area ）测试
 * 方法区：类的信息，如类名，访问修饰符，常量池（String pool），方法描述等
 */
public class JvmRuntimeConstantPoolOOM {
    private int runtimeConstantCount = 1;

    public void execute() {
        try {
            runtimeConstantLeak();
        } catch (Throwable e) {
            System.out.println("runtimeConstantCount : " + runtimeConstantCount);
            e.printStackTrace();
        }
    }

    /**
     * 使用String的intern()方法向方法区中灌入数据，当方法区内存不足时，抛出OutOfMemoryError: PermGen space，
     * String 常量池属于方法区的一部分
     * String.intern()是一个Native方法，它的作用是：如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；
     * 否则，将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用
     */
    private void runtimeConstantLeak() {
        List<String> list = new ArrayList<String>();
        while (true) {
            list.add(String.valueOf(runtimeConstantCount).intern());
            runtimeConstantCount = runtimeConstantCount + 1000;
            System.out.println(runtimeConstantCount);
        }
    }

    public static void main(String[] args) {
        JvmRuntimeConstantPoolOOM test = new JvmRuntimeConstantPoolOOM();
        test.execute();
    }
}
