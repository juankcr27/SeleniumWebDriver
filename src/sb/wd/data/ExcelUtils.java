package sb.wd.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public Object[][] getData(String path, String page) {
		ArrayList<ArrayList<Object>> dataGrid = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> singleRow;
		FileInputStream fis = null;
		int i = 0;
		try {
			fis = new FileInputStream(new File(path));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(page);

			if (sheet == null) {
				return null;
			}

			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				XSSFRow row = ((XSSFRow) rows.next());
				Iterator<Cell> cells = row.cellIterator();
				singleRow = new ArrayList<Object>();
				Object value = "";

				i = 0;
				while (cells.hasNext()) {
					XSSFCell cell = (XSSFCell) cells.next();

					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						value = cell.getStringCellValue();
					} else if(cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						value = "";
					} else {
						value = cell.getRawValue();
					}

					if (!value.equals(null)) {
						singleRow.add(value);
						i++;
					}
				}
				dataGrid.add(singleRow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object obj[][] = new Object[dataGrid.size()][i];
		for (int j = 0; j < dataGrid.size(); j++) {
			ArrayList<Object> fillRow = dataGrid.get(j);
			for (int k = 0; k < fillRow.size(); k++) {
				obj[j][k] = fillRow.get(k);
			}
		}
		return obj;
	}
}