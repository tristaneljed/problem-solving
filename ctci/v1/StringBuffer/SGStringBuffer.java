public class SGStringBuffer {

	private int size;
	private char[] result;

	public SGStringBuffer() {
		size = 0;
		result = new char[4];
	}

	public SGStringBuffer(String str) {
		size = str.length();
		result = new char[size * 2];
		copy(str);
	}

	public void append(String str) {
		if (size + str.length() > result.length)
			resize((size + str.length())*2);

		copy(str);
	}

	public String toString() {
		String output = new String(result);
		return output.substring(0,size);
	}

	private void copy(String str) {
		for(int i=size; i<size+str.length(); i++)
			result[i] = str.charAt(i-size);

		size += str.length();
	}

	private void resize(int newSize) {
		char[] temp = new char[newSize];
		for (int i=0; i<size; i++)
			temp[i] = result[i];

		result = temp;
	}

	public static void main(String...args) {
		SGStringBuffer obj = new SGStringBuffer("Hello ");
		obj.append(" world");
		obj.append(" java");
		System.out.println(obj.toString());

	}
}
