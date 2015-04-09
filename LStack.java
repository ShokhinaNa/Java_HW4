package Stack;

public class LStack {

		Node tos;
	
		public class Node{
			Object data;
			Node prev;
			
		public Node(int i, Node n){
				data = i;
				prev = n;
			}
		}
	
		
	public void	push(int i){
		if (isEmpty()) tos = new Node(i, null);
		else tos = new Node(i, tos);
	}
	
	public Object pop() throws StackEmptyException{
		if (isEmpty()){
			throw new StackEmptyException("tos is " + tos);
		}
		else{
			Node cur = tos;
			tos=tos.prev;
			return cur.data;
		}
	}
	
	public Object top(){
		System.out.println("top " + tos.data);		
		return tos.data;
	}

	public boolean isEmpty(){
		return (tos==null);
	}
	
	public void draw(){
		Node cur = tos;
		System.out.print("list: ");
		while(cur != null){
			System.out.print(cur.data+ " ");
			cur = cur.prev;
		}
		System.out.println(" ");
	}
}
