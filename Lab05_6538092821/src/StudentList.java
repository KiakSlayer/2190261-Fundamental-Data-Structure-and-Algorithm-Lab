
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) throws Exception {
		
		DListNode dummyN1 = i1.currentNode;
		DListNode dummyN2 = i2.currentNode;
		DListNode dummyNextN1 = i1.currentNode.nextNode;
		DListNode dummyNextN2 = i2.currentNode.nextNode;
		
		i1.previous();
		i2.previous();
		i1.currentNode.nextNode = dummyN2;
		i2.currentNode.nextNode = dummyN1;
		DListNode dummyPreN1 = i1.currentNode;
		DListNode dummyPreN2 = i2.currentNode;
		
		i1.next();
		i2.next();
		i1.currentNode.previousNode = dummyPreN1;
		i2.currentNode.previousNode = dummyPreN2;
		i1.currentNode.nextNode = dummyNextN1;
		i2.currentNode.nextNode = dummyNextN2;
		DListNode dummyNewN1 = i1.currentNode;
		DListNode dummyNewN2 = i2.currentNode;
		
		i1.next();
		i2.next();
		i1.currentNode.previousNode = dummyNewN1;
		i2.currentNode.previousNode = dummyNewN2;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) {
		if(lst.isEmpty())
			return;
		
		DListNode p1 = i1.currentNode;
		DListNode p2 = i1.currentNode.nextNode;
		DListNode firstNode = lst.header.nextNode;
		DListNode lastNode = lst.header.previousNode;
		
		p1.nextNode = firstNode;
		firstNode.previousNode = p1;
		
		p2.previousNode=lastNode;
		lastNode.nextNode=p2;
	}

	// implement this method
	public void gender(String g) throws Exception {
	
		DListIterator h = new DListIterator(header);
		DListIterator iterator = new DListIterator(header);
		while(iterator.hasNext() && iterator.currentNode.nextNode != header) {
			Student s = (Student)iterator.next();
			if(s.getSex() == g) {
				remove(findPrevious(iterator));
				insert(s, h);
				h.next();
			}
		}
	}

}
