package yao.design_patterns;

/**
 * Created by yao on 2014/8/28.
 * <p/>
 * 几种单例模式
 */
public class Singleton {

    /**
     * 1.最简单，非线程安全
     */
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            return new Singleton();
        } else
            return instance;
    }

    // 怎么改进，增加同步 synchronized
    public static synchronized Singleton getInstance1() {
        if (instance == null) {
            return new Singleton();
        } else
            return instance;
    }

    /**
     * 2.classloader机制，instance在类装载时就实例化
     */

    private static final Singleton instance2 = new Singleton();

    public static Singleton getInstance2() {
        return instance2;
    }

    /**
     * 3.静态内部类
     */

    private static class LoadSingleton {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance3() {
        return LoadSingleton.INSTANCE;
    }

    /**
     * 枚举，java_study 1.5开始有的，推荐的用法
     */
    public enum single {
        INSTANCE;
    }
}
