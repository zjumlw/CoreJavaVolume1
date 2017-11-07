package chapter_09;

public interface Queue<E> {
	void add(E element);
	E remove();
	int size();
}
