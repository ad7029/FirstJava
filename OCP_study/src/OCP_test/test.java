package OCP_test;

public class test {

	public static void main(String[] args) {
		// 
		
//		char[][] arrays = {{'1','2'}, {'3','4'},{'5','6'}};
//		for(char[] xx : arrays) {
//			for (char yy : xx) {
//				System.out.print(yy);
//			}
//			System.out.print(" ");
//		}
		
//		String [][] color2dArr= {
//				{"Brown" , "Pink" },{"Black"},{"Blue","Yellow","Green","Grey"}
//		};
//		for(int row=0; row < color2dArr.length; row++) {
//			int column =0;
//			for(; column < color2dArr[row].length; column++) {
//				System.out.println(
//						"[" + row + "," + column + "]=" + color2dArr[row][column] + " ");
//			}
//		}
		
		//二維可以多組多數值
		String[][] color2dArr = {
		        {"Brown", "Pink"},
		        {"Black"},
		        {"Blue", "Yellow", "Green", "Grey"}
		};

		// 迭代二維數組，逐行遍歷
		for (int i = 0; i < color2dArr.length; i++) {
		    // 獲取當前行的數組
		    String[] rowArr = color2dArr[i];

		    // 迭代當前行的數組，逐列遍歷
		    for (int j = 0; j < rowArr.length; j++) {
		        // 獲取當前元素
		        String color = rowArr[j];

		        // 輸出當前元素的位置和值
		        System.out.println("[" + i + "," + j + "]=" + color);
		    }
		}
		

	}

}
