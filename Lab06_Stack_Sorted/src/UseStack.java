
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack tempStack = new ArrayListStack();
		while (!s.isEmpty()) {
            int temp = s.top();
            s.pop();
            
            while (tempStack.top()> temp && !tempStack.isEmpty()) {
                s.push(tempStack.top());
                tempStack.pop();
            }
            tempStack.push(temp);
        }
		
		s.makeEmpty(); 
        while (!tempStack.isEmpty()) {
            s.push(tempStack.top());
            tempStack.pop();
        }
        return s;
	}

}

