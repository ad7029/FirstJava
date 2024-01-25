package OCP_test;

public class Exam {
	
	enum Machine {
		
		//常數設定type和建構子
		AUTO("car"), MEDICAL("Printer");
		private String type; 
		private Machine(String type) {
			this.type = type;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}

	public static void main(String[] args) {
		//
		Machine.AUTO.setType("abcd");
		for(Machine p : Machine.values()) {
			System.out.println(p + ": " + p.getType());
		}

	}

}
