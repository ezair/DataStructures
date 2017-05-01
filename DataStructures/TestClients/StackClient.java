//test the stack.

public class StackClient
{
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		System.out.println(s);
		s.push(31);
		//System.out.println(s.pop());
		System.out.println(s);
		s.push(30);
		System.out.println(s);

		System.out.println(s.pop());
		System.out.println(s);

		System.out.println(s.pop());
	
		//test contains.
		s.push(20);
		//true.
		System.out.println(s.contains(20));
		//false.
		System.out.println(s.contains(100));
	
		//test out search.
		//return 0
		System.out.println(s.search(20));
		//return -1
		System.out.println(s.search(100));
	
		//test peek
		//return 20
		System.out.println(s.peek());
	}
}
