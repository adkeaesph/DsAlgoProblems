package ds_problems.lists;

import complexstructures.SinglyLinkedList;
import corestructures.SinglyNode;

public class StringComparison {

	public static int compare(SinglyLinkedList<Character> sl1, SinglyLinkedList<Character> sl2) {
		if (sl1.getHead() == null) {
			if (sl2.getHead() == null)
				return 0;
			else
				return -1;
		} else {
			if (sl2.getHead() == null)
				return 1;
			else {
				SinglyNode<Character> head1 = sl1.getHead(), head2 = sl2.getHead();
				while (head1 != null && head2 != null) {
					if (head1.getData() < head2.getData())
						return -1;
					else if (head1.getData() > head2.getData())
						return 1;

					head1 = head1.getNext();
					head2 = head2.getNext();
				}

				if (head1 == null) {
					if (head2 == null)
						return 0;
					else
						return -1;
				} else {
					return 1;
				}

			}
		}
	}

	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "abcdefgh";
		System.out.println("Strings to compare - "+str1+", "+str2);
		SinglyLinkedList<Character> s1 = new SinglyLinkedList<Character>();
		for(int i=0; i<str1.length(); i++)
			s1.add(str1.charAt(i));

		SinglyLinkedList<Character> s2 = new SinglyLinkedList<Character>();
		for(int i=0; i<str2.length(); i++)
			s2.add(str2.charAt(i));

		System.out.println(compare(s1, s2));

	}

}
