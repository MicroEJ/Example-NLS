/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.tool.excel2nls.po;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microej.tool.excel2nls.Dumper;
import com.microej.tool.excel2nls.Language;
import com.microej.tool.excel2nls.WorkbookConverter;

/**
 * Hello world!
 *
 * From Excel to NLS.
 *
 */
public class POMain {

	private static final File INPUT_FOLDER = new File("./excel/");
	private static final File EXCEL_FILE = new File(INPUT_FOLDER, "translations.xlsx");

	private static final File OUTPUT_FOLDER = new File("../HelloWorldNLS/src/main/resources/nls/po/");

	public static void main(String[] args) throws IOException {
		// Extract first workbook from Excel file
		InputStream excelIn = new FileInputStream(EXCEL_FILE);
		Workbook workbook = new XSSFWorkbook(excelIn);

		// Extract NLS language from workbook
		System.out.println("*** Converting " + EXCEL_FILE + " ***");
		WorkbookConverter converter = new WorkbookConverter(workbook);
		List<Language> languages = converter.convert();

		// Dump these languages to PO files
		System.out.println("*** Generating PO NLS files ***");
		Dumper dumper = new PODumper(OUTPUT_FOLDER, "POTranslation", languages);
		dumper.dump();

		// List files
		System.out.println("*** Available files in output folder***");
		File[] files = OUTPUT_FOLDER.listFiles();
		for (File file : files) {
			System.out.println(file);
		}
	}

}
