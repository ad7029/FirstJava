package OCP_test;
	
	class DeskGame extends GameObject {
		public  Object[] move(Number x, Number y) {
			System.out.println("MoveTo DeskGame");
			return super.moveTo(x.intValue(), y.intValue());
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
