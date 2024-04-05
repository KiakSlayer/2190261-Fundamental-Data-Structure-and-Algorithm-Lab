
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if (this.q.isEmpty()) {
	        this.q.insertLast(x);
	        return;
	    }
	    int qSize = this.q.size();
	    boolean inserted = false;
	    for (int i = 0; i < qSize; i++) {
	        int current = this.q.removeFirst();
	        if (!inserted && current > x) {
	            this.q.insertLast(x);
	            inserted = true;
	        }
	        this.q.insertLast(current);
	    }
	    if (!inserted) {
	        this.q.insertLast(x);
	    }
	}

	// implement this.
	public void pop() throws Exception {
		this.q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return this.q.front();
	}

}
