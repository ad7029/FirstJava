package Algorithm;

import java.util.Scanner;

public class Expense {
    public String name;     // 費用名稱
    public double amount;   // 費用金額 
    public Expense next;    // 下一個節點

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
        this.next = null;
    }
}

//public class ExpenseList {
//    private Expense head;   // 鏈結串列頭節點
//
//    public ExpenseList() {
//        this.head = null;
//    }
//
//    // 插入資料到鏈結串列尾部
//    public void insert(String name, double amount) {
//        Expense newExpense = new Expense(name, amount);
//        if (head == null) {
//            head = newExpense;
//        } else {
//            Expense cur = head;
//            while (cur.next != null) {
//                cur = cur.next;
//            }
//            cur.next = newExpense;
//        }
//    }
//
//    // 計算當月總費用
//    public double calculateTotal() {
//        double total = 0;
//        Expense cur = head;
//        while (cur != null) {
//            total += cur.amount;
//            cur = cur.next;
//        }
//        return total;
//    }
//
//    // 印出當月所有費用
//    public void printAll() {
//        Expense cur = head;
//        while (cur != null) {
//            System.out.println(cur.name + ": " + cur.amount);
//            cur = cur.next;
//        }
//    }
//}
