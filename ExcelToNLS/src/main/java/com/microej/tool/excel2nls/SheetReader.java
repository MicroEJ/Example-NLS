/*
 * Java
 *
 * Copyright 2015-2021 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.tool.excel2nls;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * A SheetReader is able to extract an NLS language from an Excel sheet.
 *
 * It knows the internal structure of the sheet and hence is able to create a {@link Language} for it. See the example file
 * (resources/translations.xlsx) to understand the structure that each sheet must have.
 */
public class SheetReader {

	// Coordinates of the cell that contains the display name of the language
	private static final int DISPLAY_NAME_ROW_INDEX = 0;
	private static final int DISPLAY_NAME_COLUMN_INDEX = 1;

	// Coordinates of the cell that contains the locale of the language
	private static final int LOCALE_ROW_INDEX = 1;
	private static final int LOCALE_COLUMN_INDEX = 1;

	// // Coordinates to find the cells that contain messages
	private static final int FIRST_MESSAGE_ROW_INDEX = 3;
	private static final int ID_COLUMN_INDEX = 0;
	private static final int MESSAGE_COLUMN_INDEX = 1;

	private final Sheet sheet;

	/**
	 * Instantiate a new sheet reader.
	 *
	 * @param sheet
	 *            the sheet
	 */
	public SheetReader(Sheet sheet) {
		super();
		this.sheet = sheet;
	}

	/**
	 * Read the sheet and extract the NLS language it contains.
	 *
	 * @return an NLS language
	 */
	public Language read() {
		Language language = new Language();
		Row row;

		// Extract language
		row = sheet.getRow(DISPLAY_NAME_ROW_INDEX);
		String displayName = row.getCell(DISPLAY_NAME_COLUMN_INDEX).getStringCellValue();
		language.setDisplayName(displayName);

		// Extract local
		row = sheet.getRow(LOCALE_ROW_INDEX);
		String locale = row.getCell(LOCALE_COLUMN_INDEX).getStringCellValue();
		language.setLocale(locale);

		// Extract messages
		int i = FIRST_MESSAGE_ROW_INDEX;
		while ((row = sheet.getRow(i++)) != null) {
			String id = row.getCell(ID_COLUMN_INDEX).getStringCellValue();
			String text = row.getCell(MESSAGE_COLUMN_INDEX).getStringCellValue();
			Message message = new Message(id, text);
			language.add(message);
		}

		return language;
	}
}
