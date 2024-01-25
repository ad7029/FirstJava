package hashmap;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Set;

public class CheckVoter2 {
    private static Map<String, Boolean> voted = new HashMap<>();

    private static void checkVoter(String name) {

        if (voted.containsKey(name)) {
            System.out.println("kick them out!");
        } else {
            voted.put(name, true);
            System.out.println("let them vote!");
            logVote(name); // 將投票者姓名和投票時間寫入到文本文件
        }
    }

    public static void main(String[] args) {

    	loadVotes();// 從 votes.txt 檔案載入已經投票的名單
    	 VoterInput input = new VoterInput();
         String name;
         while (!(name = input.getName()).equals("quit")) {
             checkVoter(name);
         }
    	
    }
    
    private static void logVote(String name) {
    	try {
            File file = new File("votes2.txt");
            if (!file.exists()) {
                file.createNewFile(); // 如果文本文件不存在，則創建一個新的文本文件
            }
            Set<String> votedNames = new HashSet<>(voted.keySet());
            votedNames.add(name); // 將新投票者添加到 votedNames 集合中
            if (!voted.containsKey(name)) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    LocalDateTime now = LocalDateTime.now();
                    String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    writer.write(name + " voted at " + timestamp + "\n");
                    voted.put(name, true);
                } catch (IOException e) {
                    System.out.println("Failed to write to file: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Failed to write to file: " + e.getMessage());
        }
    }
    
    private static void loadVotes() {
        try {
            File file = new File("votes2.txt");
            if (!file.exists()) {
                return; // 如果檔案不存在，就不做任何操作
            }
            // 開啟一個 BufferedReader，讀取文本文件中的內容
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" voted at ");
                if (parts.length != 2) {
                    continue; // 如果格式不正確，就忽略這行記錄
                }
                String name = parts[0];
                voted.put(name, true); // 將已經投票的名字加入到 voted 的 Map 中
            }
            reader.close();  // 關閉 BufferedReader
        } catch (IOException e) {
            System.out.println("Failed to read from file: " + e.getMessage());
        }
    }
    
    private static class VoterInput {
    	 private Scanner scanner;

         public VoterInput() {
             scanner = new Scanner(System.in);
         }

         public String getName() {
             System.out.print("Enter a voter name (or 'quit' to exit): ");
             return scanner.nextLine();
         }
    }
    
}
