package yao.jvm;

/**
 * Created by yao on 2014/8/11.
 *
 * Jvm 的栈区：基本数据类型，常量, 对象实例的引用（对象指针）, 对象的方法代码都存在
 * Java指令，方法本身是指令的操作码部分，保存在Stack中；
 * 方法内部变量作为指令的操作数部分，跟在指令的操作码之后，保存在Stack中（实际上是简单类型保存在Stack中，对象类型在Stack中保存地址，在Heap 中保存值）；
 * 上述的指令操作码和指令操作数构成了完整的Java指令。
 *
 * 注意：Java只有类的静态成员变量，静态成员变量放在方法区（method area）
 *
 *
 */
public class StackOverflowTest {

    private int stackLength = 1;
    static int i = 0; // 如果一个类的成员没有任何权限修饰，那么它门就是缺省包访问权限
    public void execute() {

        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength : " + stackLength);
            e.printStackTrace();
        }
    }

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String args[]) {
        StackOverflowTest text = new StackOverflowTest();
        text.execute();
    }

}
