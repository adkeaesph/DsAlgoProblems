package complexstructures;

import corestructures.SinglyNode;
import customexceptions.ListException;

public class SinglyLinkedList<T> implements List<T> {

	private SinglyNode<T> head;
	private SinglyNode<T> tail;
	private int size;

	public SinglyNode<T> getHead() {
		return head;
	}
	
	public void setHead(SinglyNode<T> head) {
		this.head = head;
	}

	public SinglyNode<T> getTail() {
		return tail;
	}
	
	public SinglyLinkedList() {
		head = null;
		tail = head;
		size = 0;
	}

	@Override
	public void add(T data) {
		if (size == 0) {
			head = new SinglyNode<>(data);
			tail = head;
		} else {
			SinglyNode<T> newNode = new SinglyNode<>(data);
			tail.setNext(newNode);
			tail = tail.getNext();
		}
		size++;
	}

	@Override
	public void add(T data, int position) throws ListException {
		if (position < 0 || position > getSize())
			throw new ListException("Position can be 0 to n where n is the size of the list");

		if (position == 0) {
			if (getSize() == 0)
				add(data);
			else {
				SinglyNode<T> newNode = new SinglyNode<>(data, head);
				head = newNode;
				size++;
			}
		} else if (position == getSize())
			add(data);
		else {
			SinglyNode<T> newNode = new SinglyNode<>(data);
			SinglyNode<T> currentNode = head;
			int index = 0;
			while (currentNode != null) {
				if (index == position - 1) {
					newNode.setNext(currentNode.getNext());
					currentNode.setNext(newNode);
					size++;
					break;
				}
				currentNode = currentNode.getNext();
				index++;
			}
		}
	}

	@Override
	public void removeObject(T data) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");

		if (head.getData().equals(data)) {
			if (size == 1) {
				head = null;
				tail = head;
			} else
				head = head.getNext();
			size--;
		} else {
			SinglyNode<T> currentNode = head;
			while (currentNode != null && currentNode.getNext() != null) {
				SinglyNode<T> nextNode = currentNode.getNext();
				if (nextNode.getData().equals(data)) {
					if (nextNode.equals(tail))
						tail = currentNode;
					currentNode.setNext(nextNode.getNext());
					size--;
					break;
				}
				currentNode = nextNode;
			}
		}
	}

	@Override
	public void removeAt(int position) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");

		if (position < 0 || position >= getSize())
			throw new ListException("Position can be 0 to n-1 where n is the size of the list");

		if (position == 0) {
			if (size == 1) {
				head = null;
				tail = head;
			} else
				head = head.getNext();
			size--;
		} else {
			SinglyNode<T> currentNode = head;
			int index = 0;
			while (currentNode != null && currentNode.getNext() != null) {
				SinglyNode<T> nextNode = currentNode.getNext();
				if (index == position - 1) {
					if (nextNode.equals(tail))
						tail = currentNode;
					currentNode.setNext(nextNode.getNext());
					size--;
					break;
				}
				currentNode = nextNode;
				index++;
			}
		}
	}

	@Override
	public void removeAllObjects(T data) throws ListException {
		if (isEmpty())
			throw new ListException("List is empty.");
		do {
			if (head.getData().equals(data)) {
				head = head.getNext();
				size--;
				if (head == null)
					tail = head;
			} else
				break;
		} while (head != null);

		SinglyNode<T> currentNode = head;
		while (currentNode != null && currentNode.getNext() != null) {
			SinglyNode<T> nextNode = currentNode.getNext();
			if (nextNode.getData().equals(data)) {
				if (nextNode.equals(tail))
					tail = currentNode;
				currentNode.setNext(nextNode.getNext());
				size--;
			} else
				currentNode = nextNode;
		}
	}

	@Override
	public T get(int position) throws ListException {
		if (position >= getSize() || position < 0)
			throw new ListException("Position can be 0 to n-1 where n is the size of the list");

		T dataToBeReturned = null;
		if (position == getSize() - 1)
			return tail.getData();
		else {
			SinglyNode<T> currentNode = head;
			int index = 0;
			while (currentNode != null) {
				if (position == index) {
					dataToBeReturned = currentNode.getData();
					break;
				}
				currentNode = currentNode.getNext();
				index++;
			}
		}
		return dataToBeReturned;
	}

	@Override
	public int getPositionOf(T data) {
		SinglyNode<T> currentNode = head;
		int index = 0;
		while (currentNode != null) {
			if (currentNode.getData().equals(data)) {
				return index;
			}
			currentNode = currentNode.getNext();
			index++;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public int getSize() {
		return size;
	}
	
	public void reverse() {
		SinglyNode<T> prev = null;
		SinglyNode<T> temp = getHead();
		SinglyNode<T> next;
		while (temp != null) {
			next = temp.getNext();
			temp.setNext(prev);
			prev = temp;
			temp = next;
		}
		setHead(prev);
	}

	@Override
	public String toString() {
		String result = "";
		SinglyNode<T> currentNode = head;
		while (currentNode != null) {
			result += (currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		return result;
	}

}
