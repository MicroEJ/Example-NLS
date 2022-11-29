/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.nls;



import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.microej.example.nls.generated.XMLTranslation;

import ej.nls.NLS;

/**
 * This example application will display the same message in several languages,
 * using all the available XML file locales.
 *
 */
public class XMLHelloWorld {

	/**
	 * Entry point of the program.
	 *
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		// Display NLS from XML files
		displayNLSValues();

	}

	public static void displayNLSValues() {

		// Use a custom PrintStream to ensure the UTF-8 Encoding
		try (PrintStream outUtf8 = new PrintStream(System.out, true, "UTF-8")) {
			// Create new NLS for the header "XMLTranslation"
			NLS nls = XMLTranslation.NLS;

			// List all the available locales
			String[] locales = nls.getAvailableLocales();

			outUtf8.println("Available XML locales:");
			for (int i = 0; i < locales.length; i++) {
				System.out.println("- " + locales[i]);
			}

			// Print the messages for each locale
			outUtf8.println("Saying:");
			for (int i = 0; i < locales.length; i++) {
				nls.setCurrentLocale(locales[i]);

				outUtf8.println(nls.getDisplayName(nls.getCurrentLocale()) + " (" + locales[i] + ")");

				outUtf8.println(
						"- " + nls.getMessage(XMLTranslation.Hello) + ", " + nls.getMessage(XMLTranslation.World));

				outUtf8.println("- " + nls.getMessage(XMLTranslation.HowAreYou));

			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
