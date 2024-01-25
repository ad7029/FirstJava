package OCP_test;

public class test90 {

	public static void main(String[] args) {
		//
		StringBuilder sb = new StringBuilder("MMNOOOPQQ");
		int i = 0;
		a:
			while(i < sb.length()) {
				char x = sb.charAt(i);
				int j = 0;
				i ++;
				b:
					while(j < sb.length()) {
						char y = sb.charAt(j);
						if(i != j && y == x) {
							sb.deleteCharAt(j);
							j--;
						}
						j++;
					}
			}
System.out.println(sb);
	}

}
