package chapter_09;

import java.util.Iterator;

public interface Collection<E> {
	boolean add(E e);
	Iterator<E> iterator();	//返回一个实现了Iterator接口的对象，依次访问集合中的元素
}
