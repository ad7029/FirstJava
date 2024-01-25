package OCP_test;

public class Mysub extends Mysuper {
	
	Mysub(){
		this(4);
		System.out.print("1");
	}
	Mysub(int i) {
		System.out.print(i);
	}

	public static void main(String[] args) {
		//
		new Mysub(4);

	}

}
