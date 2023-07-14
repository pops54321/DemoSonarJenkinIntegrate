import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import java.util.Scanner;

public class FileReadWriteWithData {
    public static void main(String[] args) {
//        System.out.println("Enter filename with path :");
//        Scanner sc = new Scanner(System.in);
//        String filename = sc.nextLine();
//
//        FileReadWriteWithFile obj = new FileReadWriteWithFile();
//        obj.readFile(filename);
        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Creating a blank Excel sheet
        XSSFSheet sheet = workbook.createSheet("student details");
        Map<String, Object[]> store = new TreeMap<>();

//         Adding value to map
        store.put("1", new Object[]{"ID", "Name", "Roll"});
        store.put("2", new Object[]{"1", "Jyoti", "Developer"});
        store.put("3", new Object[]{"2", "Gopal", "Architect"});
        store.put("4", new Object[]{"3", "Kumar", "Tester"});
        store.put("5", new Object[]{"4", "Gola", "Devops Engineer"});

        Set<String> keyset = store.keySet();
        int rownum = 0;
        for(String key : keyset){
            Row row = sheet.createRow(rownum++);
            Object[] objArr = store.get(key);

            int cellnum = 0;
            for(Object obj : objArr){
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String){
                    cell.setCellValue((String)obj);
                }else{
                    cell.setCellValue((Integer)obj);
                }
            }
        }

        try{
            FileOutputStream out = new FileOutputStream("results.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("File created successfully");
        }catch (Exception ex){
            System.out.println("Exception found " + ex );
        }

        readFile("result.xlsx");
    }

    public static void readFile(String filename){
        try{
            // getting input file
            FileInputStream newFile = new FileInputStream(filename);

            // creating a workbook
            XSSFWorkbook workbook1 = new XSSFWorkbook(newFile);

            // Getting sheet
            XSSFSheet sheet = workbook1.getSheetAt(0);

            for (Row row : sheet) {
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    // Checking the cell type and format accordingly
                    switch (cell.getCellType()) {

                        // Case 1
                        case Cell.CELL_TYPE_NUMERIC -> System.out.print(cell.getNumericCellValue() + "-----------");

                        // Case 2
                        case Cell.CELL_TYPE_STRING -> System.out.print(cell.getStringCellValue() + "-----------");
                    }
                }
                System.out.println();
            }

            // Closing file output streams
            newFile.close();
        }catch (Exception ex){
            System.out.println("Exception caught : "+ ex);
        }
    }

}




