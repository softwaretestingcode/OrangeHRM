package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchData {
	public static String DataProvider(int i, int j) throws EncryptedDocumentException, IOException {
		String data = "";
		String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "TestExcel" + File.separator + "TestPOi.xlsx";
		FileInputStream file = new FileInputStream(path);
		Sheet o = WorkbookFactory.create(file).getSheet("TestDataSheet");
		Cell cell = o.getRow(i).getCell(j);
		CellType type = cell.getCellType();
		if (type == CellType.STRING) {
			data = cell.getStringCellValue();
		} else if (type == CellType.NUMERIC) {
			double number = cell.getNumericCellValue();
			data = Double.toString(number);
			// data =String.valueOf(number);
		} else if (type == CellType.BLANK) {
			data = "";
		}
		return data;
	}
}
