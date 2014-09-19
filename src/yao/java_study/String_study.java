package yao.java_study;

/**
 * Created by yao on 2014/9/20.
 * <p/>
 * Java String 笔记
 */
public class String_study {

    /**
     * JVM 内存模型的方法区：类的信息，如类名，访问修饰符，常量池（String pool）
     * 常量池（String pool）:保存着很多String 常量，并且可以被共享使用，因此它提高了效率
     * 常量池(constant pool)指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据。
     * 它包括了关于类、方法、接口等中的常量，也包括字符串常量。
     * <p/>
     * <p/>
     * <p/>
     * 只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对象才会被加入字符串池中。
     * 对于所有包含new方式新建对象（包括null）的“+”连接表达式，它所产生的新对象都不会被加入字符串池中
     */
    public static void main(String args[]) {
        String a = "ab";// 创建了一个对象，并加入字符串池中
        String b = "cd";// 创建了一个对象，并加入字符串池中
        String c = "abcd";// 创建了一个对象，并加入字符串池中
        String d = "ab" + "cd";
        // 如果 d 和 c 指向了同一个对象，则说明 d 也被加入了字符串池
        if (d == c) {
            System.out.println("ab cd 创建的对象 加入了字符串池中");
        } else {
            System.out.println("ab cd 创建的对象 没加入字符串池中");
        }

        /**
         * String.intern()是一个Native方法，它的作用是：
         * 如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；
         * 否则，将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用
         */
        String m = new String("zzz");
        String n = "zzz";
        System.out.println(m == n);
        System.out.println(m.intern() == n);


    }

}
