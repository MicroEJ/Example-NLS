/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.tool.excel2nls.xml;

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
public class XMLDumper extends Dumper {

	private static final String FILENAME_FORMAT = "%s_%s.xml";


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
	public XMLDumper(File outputFolder, String header, List<Language> languages) {
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

				// Write the header of the XML file
				writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
				writer.newLine();
				writer.write("<!-- Translation file sample for " + language.getLocale() + " -->");
				writer.newLine();
				writer.write("<resources>");
				writer.newLine();
				List<Message> messages = language.getMessages();
				for (Message message : messages) {
					writer.write("<string name=\"" + message.getId() + "\">" + message.getText() + "</string>");
					writer.newLine();
				}
				writer.write("</resources>");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
