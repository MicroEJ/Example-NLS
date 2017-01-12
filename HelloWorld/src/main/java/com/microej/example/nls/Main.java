/*
 * Java
 *
 * Copyright 2015-2017 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.example.nls;

import ej.nls.BasicImmutablesNLS;
import ej.nls.NLS;

/**
 * This example application will display the same message with all the available locales.
 *
 */
public class Main {

	/**
	 * Entry point of the program.
	 *
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		// create new NLS for the header "helloworld"
		NLS nls = new BasicImmutablesNLS("helloworld");

		// list all available locales
		String[] locales = nls.getAvailableLocales();
		int localesLength = locales.length;
		System.out.println("Available locales:");
		for (int i = -1; ++i < localesLength;) {
			System.out.println("- " + locales[i]);
		}

		// print the messages for each locale
		System.out.println("Saying:");
		for (int i = -1; ++i < localesLength;) {
			nls.setCurrentLocale(locales[i]);
			System.out.println("- " + nls.getDisplayName(nls.getCurrentLocale()) + " (" + locales[i] + ")");
			System.out.println(nls.getMessage(HelloWorld.HELLO) + ", " + nls.getMessage(HelloWorld.WORLD));
			System.out.println(nls.getMessage(HelloWorld.HOW_ARE_YOU));
		}
	}

}
