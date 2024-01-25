package OCP_test;

public class Garden {

	private static Plant plant;

	public static void main(String[] args) {
		//

		plant = new Tree();
		feed(plant);
		feed(plant);
	}

	public static void feed(Plant p) {

		if (p instanceof Tree) {
			System.out.println("Is a tree, ");
		}
		p = null;

	}

}
