/*
 * Java
 *
 * Copyright 2015-2017 IS2T. All rights reserved.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package com.microej.tool.excel2nls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 * From Excel to NLS.
 *
 */
public class App {

	private static final File INPUT_FOLDER = new File("./excel/");
	private static final File EXCEL_FILE = new File(INPUT_FOLDER, "translations.xlsx");

	private static final File OUTPUT_FOLDER = new File("../HelloWorld/src/main/resources");

	public static void main(String[] args) throws IOException {
		// Extract first workbook from Excel file
		InputStream excelIn = new FileInputStream(EXCEL_FILE);
		Workbook workbook = new XSSFWorkbook(excelIn);

		// Extract NLS language from workbook
		System.out.println("*** Converting " + EXCEL_FILE + " ***");
		WorkbookConverter converter = new WorkbookConverter(workbook);
		List<Language> languages = converter.convert();

		// Dump these languages to files
		System.out.println("*** Generating NLS files ***");
		Dumper dumper = new Dumper(OUTPUT_FOLDER, "helloworld", languages);
		dumper.dump();

		// List files
		System.out.println("*** Available files in output folder***");
		File[] files = OUTPUT_FOLDER.listFiles();
		for (File file : files) {
			System.out.println(file);
		}
	}

}
