/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.tool.excel2nls;

import java.io.File;
import java.util.List;

/**
 * An abstract class that represents a Dumper which will be used to write the
 * content of the xlsx file from a set of NLS languages into the desired output
 * format.
 */
public abstract class Dumper {

	protected final File outputFolder;
	protected final String header;
	protected final List<Language> languages;

	public Dumper(File outputFolder, String header, List<Language> languages) {
		this.outputFolder = outputFolder;
		this.header = header;
		this.languages = languages;
	}

	/*
	 * Write the content of the xlsx file into an ouput file (.po or .xml).
	 */
	public abstract void dump();
}
