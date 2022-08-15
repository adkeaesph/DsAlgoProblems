package corestructures;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeNode<T> {
	private T data;
	private List<NaryTreeNode<T>> children;

	public NaryTreeNode() {
		data = null;
		children = new ArrayList<>();
	}

	public NaryTreeNode(T data) {
		this();
		this.data = data;
	}

	public NaryTreeNode(T data, List<NaryTreeNode<T>> children) {
		this.data = data;
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<NaryTreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<NaryTreeNode<T>> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		String result = "NaryTreeNode [data=" + data + ", children= ";
		if (children == null) {
			result += null + "]";
			return result;
		}
		for(NaryTreeNode<T> child : children)
			result += child.getData() + " ";
		result += "]";
		return result;
	}

}
