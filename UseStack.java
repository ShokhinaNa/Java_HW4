package Stack;

public class UseStack {

	public static void main(final String[] args)  {
		LStack stack = new LStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.draw();
		
		try {
			System.out.println("pop " + stack.pop());
			System.out.println("pop " + stack.pop());
		} catch  (StackEmptyException e) {
			System.out.println(e);
		}
		
		stack.draw();		
		
		try {
			System.out.println("pop " + stack.pop());
			System.out.println("pop " + stack.pop());
			System.out.println("pop " + stack.pop());
		} catch  (StackEmptyException e) {
			System.out.println(e);
		}
	
	}
}
