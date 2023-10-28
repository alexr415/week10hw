import java.util.EmptyStackException;public final class LinkedStack<T> implements StackInterface<T> {	private Node topNode; 	public LinkedStack() {		topNode = null;	} 	public void push(T element) {		Node newNode = new Node(element, topNode);		topNode = newNode;		//topNode = new Node(element, topNode); // Alternate code	} 	public T peek() {		if (isEmpty()) {			throw new EmptyStackException();		} else {			return topNode.data;		}	} 	public T pop() {		T top = peek(); // Might throw EmptyStackException				// Assertion: topNode != null		topNode = topNode.next;		return top;	} 	public boolean isEmpty() {		return topNode == null;	} 	public void clear() {		while(topNode!=null) {			topNode.data = null;			topNode = topNode.next;		}	} 		public boolean priorityPush(T element) {		boolean returnBool = false;		if (isEmpty()){			push(element);			return returnBool;		}		LinkedStack<T> temp = new LinkedStack<>();		temp.push(pop());		while(!isEmpty()){			if(temp.peek().equals(element)){				pop();				returnBool=true;				while(!temp.isEmpty()){					push(temp.pop());				}			}			else{				temp.push(pop());			}		}		push(element);		return returnBool;	}	public T peekNext() {		// YOUR CODE HERE FOR EXTRA CREDIT		return null;	}	private class Node {		private T data; 		private Node next; 		private Node(T data) {			this(data, null);		} 		private Node(T data, Node next) {			this.data = data;			this.next = next;		} 		private T getData() {			return data;		} 		private void setData(T data) {			this.data = data;		} 		private Node getNextNode() {			return next;		} 		private void setNextNode(Node next) {			this.next = next;		} 	} } 