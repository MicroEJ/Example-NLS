/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.tool.excel2nls;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * A WorkbookConverter which converts an Excel workbook to a list of NLS
 * languages.
 *
 * It assumes that each sheet of this workbook contains one NLS language and
 * uses a {@link SheetReader} to extract this language.
 */
public class WorkbookConverter {

	private final Workbook workbook;

	/**
	 * Instantiate a new workbook converter.
	 *
	 * @param workbook
	 *            the workbook
	 */
	public WorkbookConverter(Workbook workbook) {
		super();
		this.workbook = workbook;
	}

	/**
	 * Convert the workbook to a list of NLS languages.
	 *
	 * @return the languages extracted from the workbook
	 */
	public List<Language> convert() {
		int sheetCount = workbook.getNumberOfSheets();
		List<Language> languages = new ArrayList<Language>(sheetCount);

		for (int i = 0; i < sheetCount; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			System.out.println("Converting sheet " + i + " " + sheet.getSheetName());
			SheetReader reader = new SheetReader(sheet);
			Language language = reader.read();
			languages.add(language);
		}

		return languages;
	}
}
