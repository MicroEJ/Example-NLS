/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.tool.excel2nls.po;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.microej.tool.excel2nls.Dumper;
import com.microej.tool.excel2nls.Language;
import com.microej.tool.excel2nls.Message;

/**
 * A Dumper creates the NLS files from a set of NLS languages.
 */
public class PODumper extends Dumper {

	private static final String FILENAME_FORMAT = "%s_%s.po";

	/**
	 * Instantiate a new dumper. It has:
	 * <ul>
	 * <li>an output folder, where it will create the files,
	 * <li>a NLS header, that will be included in the file names,
	 * <li>a list of {@link Language}s.
	 * </ul>
	 *
	 * @param outputFolder
	 *            the output folder
	 * @param header
	 *            the NLS header
	 * @param languages
	 *            the list of languages
	 */
	public PODumper(File outputFolder, String header, List<Language> languages) {
		super(outputFolder, header, languages);

	}

	/**
	 * Dump each language to its own file. If the files already exist, they will be
	 * overwritten.
	 */
	@Override
	public void dump() {
		for (Language language : languages) {
			// Create the file
			String fileName = String.format(FILENAME_FORMAT, header, language.getLocale());
			File file = new File(outputFolder, fileName);

			try (BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {

				// Write the header of the PO file
				writer.write("msgid \"\"");
				writer.newLine();
				writer.write("msgstr \"\"");
				writer.newLine();
				writer.write("\"Language: " + language.getLocale() + "\\n\"");
				writer.newLine();
				writer.write("\"Language-Team: " + language.getDisplayName() + "\\n\"");
				writer.newLine();
				writer.write("\"MIME-Version: 1.0\\n\"");
				writer.newLine();
				writer.write("\"Content-Type: text/plain; charset=UTF-8\\n\"");
				writer.newLine();
				writer.newLine();
				List<Message> messages = language.getMessages();
				for (Message message : messages) {
					writer.write("msgid \"" + message.getId() + "\"");
					writer.newLine();
					writer.write("msgstr \"" + message.getText() + "\"");
					writer.newLine();
					writer.newLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
