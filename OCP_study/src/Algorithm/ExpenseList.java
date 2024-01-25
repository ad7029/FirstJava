package Algorithm;

import java.util.Scanner;

public class ExpenseList {
	private Expense head; // 鏈結串列頭節點

	public ExpenseList() {
		this.head = null;
	}

	// 插入資料到鏈結串列尾部
	public void insert(String name, double amount) {
		Expense newExpense = new Expense(name, amount);
		if (head == null) {
			head = newExpense;
		} else {
			Expense cur = head;
			while (cur.next != null) {
				cur = cur.next;
			}
			cur.next = newExpense;
		}
	}

	// 計算當月總費用
	public double calculateTotal() {
		double total = 0;
		Expense cur = head;
		while (cur != null) {
			total += cur.amount;
			cur = cur.next;
		}
		return Double.parseDouble(String.format("%.2f", total));
	}

	// 印出當月所有費用
	public void printAll() {
		Expense cur = head;
		while (cur != null) {
			System.out.println(cur.name + ": " + cur.amount);
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in, "big5");
		ExpenseList list = new ExpenseList();

		System.out.println("請輸入當月份花費, 輸入0結束");
		while (true) {
			// System.setProperty("console.encoding","big-5");
			System.out.print("費用名稱: ");
			String name = scanner.nextLine();
			if (name.equals("0")) {
				break;
			}

			double amount = 0;
			boolean validInput = false;
			while (!validInput) {
				System.out.print("費用金額: ");
				String amountStr = scanner.nextLine();
				if (amountStr.matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
					amount = Double.parseDouble(amountStr);
					validInput = true;
				} else {
					System.out.println("請輸入正確的數字!");
					// scanner.next(); //清除非double型態輸入
				}

			}
			// scanner.nextLine(); // 讀取換行符

			list.insert(name, amount);
		}
		// System.setProperty("console.encoding","big-5");
		System.out.println("當月總花費: " + String.format("%.2f", list.calculateTotal())); // 顯示數字到小數點第2位
		System.out.print("所有費用: ");
		list.printAll();

	}
}