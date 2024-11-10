package utils;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	// This will serve as data source for POST, GET, PUT APIs
	@DataProvider(name = "AllData")
	public String[][] getAllData() throws IOException {

		File file1 = new File("TestData\\TestData.xlsx");

		String XLFIle = file1.getAbsolutePath();
		String sheetName = "Sheet1";
		int rowcount = ReadXL.getRowCount(XLFIle, sheetName);
		int colcount = ReadXL.getCellCount(XLFIle, sheetName, 0);

		String apiData[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {

			for (int j = 0; j < colcount; j++) {

				apiData[i - 1][j] = ReadXL.getCellData(XLFIle, sheetName, i, j);

			}
		}

		return apiData;

	}

	// This will serve as data source for DELETE APIs

	@DataProvider(name = "UsernameData")
	public String[] getUsernames() throws IOException {

		File file1 = new File("TestData\\TestData.xlsx");
		String XLFIle = file1.getAbsolutePath();

		String sheetName = "Sheet1";
		int rowcount = ReadXL.getRowCount(XLFIle, sheetName);

		String apiData[] = new String[rowcount];

		for (int i = 1; i <= rowcount; i++) {

			apiData[i - 1] = ReadXL.getCellData(XLFIle, sheetName, i, 1);

		}

		return apiData;

	}
}
