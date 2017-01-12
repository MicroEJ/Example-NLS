/*
 * Java
 *
 * Copyright 2015-2017 IS2T. All rights reserved.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package com.microej.tool.excel2nls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * A Dumper creates the NLS files from a set of NLS languages.
 */
public class Dumper {

	private static final String FILENAME_FORMAT = "%s_%s.nls";

	private final File outputFolder;
	private final String header;
	private final List<Language> languages;

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
	public Dumper(File outputFolder, String header, List<Language> languages) {
		super();
		this.outputFolder = outputFolder;
		this.header = header;
		this.languages = languages;
	}

	/**
	 * Dump each language to its own file. If files exists, there are overridden.
	 */
	public void dump() {
		for (Language language : languages) {
			// Create the file
			String fileName = String.format(FILENAME_FORMAT, header, language.getLocale());
			File file = new File(outputFolder, fileName);

			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {

				// First line contains the display name of the language
				writer.write("DISPLAY_NAME=" + language.getDisplayName());
				writer.newLine();
				System.out.println(language.getDisplayName());

				// Following lines contain the messages with their IDs
				List<Message> messages = language.getMessages();
				for (Message message : messages) {
					writer.write(message.getId() + "=" + message.getText());
					writer.newLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
