package fireflink.ninzacrm.automationframework.genericUtiltiy;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;



import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;



/**

 * This class consists of generic methods related to file operations like properties , excel

 * @author Bhuvan K P

 * 

 */

public class FileUtility {



	/**

	 * This method will read data from properties file

	 * @param key

	 * @return String

	 * @throws IOException

	 */

	public String readDataFromPropertyFile(String key) throws IOException {

		

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");

		Properties p = new Properties();

		p.load(fis);

		return p.getProperty(key);

	}

	

	/**

	 * This methods read data from excel file and returns value to the caller

	 * @param sheetName

	 * @param rowNumber

	 * @param cellNumber

	 * @return String

	 * @throws EncryptedDocumentException

	 * @throws IOException

	 */

	public String readDataFromFile(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testscriptdata1.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		return wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).toString();

		

	}

}


