//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.util.Iterator;
//
//public class FileReadWriteWithFile {
//    public void readFile(String filename){
//        try{
//            // getting input file
//            FileInputStream newFile = new FileInputStream(filename);
//
//            // creating a workbook
//            XSSFWorkbook workbook1 = new XSSFWorkbook(newFile);
//
//            // Getting sheet
//            XSSFSheet sheet = workbook1.getSheetAt(0);
//
//            for (Row row : sheet) {
//                // For each row, iterate through all the columns
//                Iterator<Cell> cellIterator = row.cellIterator();
//
////                int indexRow = 0; int indexCol = 0;
////                String data = "";
////                String[][] arr = new String[10][10];
//
//                while (cellIterator.hasNext()) {
//
//                    Cell cell = cellIterator.next();
////                    if(indexCol == 3) {
////                        indexCol = 0;
////                    }
//                    // Checking the cell type and format accordingly
//                    switch (cell.getCellType()) {
//
//                        // Case 1
//                        case Cell.CELL_TYPE_NUMERIC : System.out.print(cell.getNumericCellValue() + " ***** ");
//                        break;
//
//                        // Case 2
//                        case Cell.CELL_TYPE_STRING : System.out.print(cell.getStringCellValue() + "-----------");
////                                                     data = cell.getStringCellValue();
//                        break;
//                    }
////                    arr[indexRow][indexCol++] = data;
////                    System.out.println(arr[indexRow][indexCol]);
//                }
//                System.out.println();
//            }
//
//            // Closing file output streams
//            newFile.close();
//        }catch (Exception ex){
//            System.out.println("Exception caught : "+ ex);
//        }
//    }
//}
