package Date_Save;

	import java.io.FileOutputStream;
	import java.io.IOException;
//JDK版本太新無法安裝POI
//	import org.apache.poi.ss.usermodel.*;
//	import org.apache.poi.xssf.usermodel.XSSFWorkbook;


		public class tw_census {
	    public static void main(String[] args) {
	        // 建立資料
	        String[] counties = { "基隆市", "台北市", "新北市", "桃園市", "台中市", "台南市", "高雄市", "宜蘭縣", "新竹縣", "苗栗縣",
	                "彰化縣", "南投縣", "雲林縣", "嘉義縣", "屏東縣", "臺東縣", "花蓮縣", "澎湖縣", "金門縣", "連江縣" };
	        double[] malePercentages = { 49.4, 47.9, 49.3, 49.3, 49.3, 49.8, 49.4, 49.5, 49.8, 49.8, 49.6, 49.9, 49.7, 49.9,
	                49.8, 50.2, 50.2, 50.2, 50.6, 52.1 };
	        double[] femalePercentages = new double[malePercentages.length];
	        for (int i = 0; i < malePercentages.length; i++) {
	            femalePercentages[i] = 100.0 - malePercentages[i];
	        }

	        // 創建Excel工作簿和工作表
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("台灣縣市人口比例");

	        // 創建表頭行
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("縣市");
	        headerRow.createCell(1).setCellValue("男性人口比例");
	        headerRow.createCell(2).setCellValue("女性人口比例");

	        // 填充資料行
	        for (int i = 0; i < counties.length; i++) {
	            Row dataRow = sheet.createRow(i + 1);
	            dataRow.createCell(0).setCellValue(counties[i]);
	            dataRow.createCell(1).setCellValue(malePercentages[i]);
	            dataRow.createCell(2).setCellValue(femalePercentages[i]);
	        }

	        // 設定列寬自適應
	        for (int i = 0; i < 3; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        // 儲存Excel檔案
//	        try (FileOutputStream fileOut = new FileOutputStream("台灣人口比例.xlsx")) {
//	            workbook.write(fileOut);
//	            System.out.println("Excel檔案已成功儲存。");
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
	        
	        String filePath = "E:\\GitHubFirstJava\\台灣人口比例.xlsx"; // 替換為你想要的儲存路徑
	        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
	            workbook.write(fileOut);
	            System.out.println("Excel檔案已成功儲存於：" + filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // 關閉工作簿
	        try {
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	


