package yao.ds;

/**
 * Created by yao on 2014/9/12.
 *
 * List 接口
 */
public interface IListable<T> {

    public int length();

    public boolean isEmpty();

    public boolean add(T element);

    public boolean add(IListable<T> list);

    public T getElement(int index);

    public boolean addHead(T element);

    public boolean addByIndex(int index, T element);

    public T remove(int index);

    public T remove(T element);

    public boolean removeAll();

    public T setElement(int index, T element);

    public void clear();


}