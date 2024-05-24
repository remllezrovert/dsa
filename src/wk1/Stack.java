package wk1;
public class Stack {

	private int maxStackSize, topOfStack;
	private int[] stack;

	public Stack(int maxStackSize) {
		if (maxStackSize <= 0)
			System.out.println("Stack size should be a positive integer.");
		else {
			this.maxStackSize = maxStackSize;
			topOfStack = -1;
			stack = new int[maxStackSize];
		}
	}

	public void push(int val) throws Exception {
		//set topOfStack
		if (topOfStack+1 < maxStackSize)
		{
			topOfStack++;
			stack[topOfStack] = val;
		} else {
		}
	}

	public int pop() throws Exception {
	if (topOfStack == -1) {
        throw new Exception("Stack is empty already. Can't pop");
    }
    int ret = stack[topOfStack];
    topOfStack--;
    return ret;
			}

	public int size() {
        return topOfStack + 1;
	}

	public String toString() {
		if (size() == 0)
			return "[]";
		String out = "[";
		for (int i = 0; i < topOfStack; i++)
			out += stack[i] + ", ";
		out += stack[topOfStack] + "]";
		return out;
	}
}
