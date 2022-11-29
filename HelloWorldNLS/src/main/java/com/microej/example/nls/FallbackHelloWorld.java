/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.nls;



import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.microej.example.nls.generated.POFallback;
import com.microej.example.nls.generated.POTranslation;
import com.microej.example.nls.generated.XMLFallback;
import com.microej.example.nls.generated.XMLTranslation;

import ej.nls.NLS;

/**
 * This example application shows the fallback feature from NLS to handle
 * missing translations.
 *
 */
public class FallbackHelloWorld {

	/**
	 * Entry point of the program.
	 *
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		displayFallbackValues();

	}

	public static void displayFallbackValues() {

		// Use a custom PrintStream to ensure the UTF-8 Encoding
		try (PrintStream outUtf8 = new PrintStream(System.out, true, "UTF-8")) {


			NLS XMLFallbackTranslation = XMLFallback.NLS;
			NLS POFallbackTranslation = POFallback.NLS;

			// List all the available locales
			String[] XMLlocales = XMLFallbackTranslation.getAvailableLocales();
			String[] POlocales = POFallbackTranslation.getAvailableLocales();

			// Print the messages for each locale
			outUtf8.println("XML Translations: (en_US fallback)");
			for (int i = 0; i < XMLlocales.length; i++) {
				XMLFallbackTranslation.setCurrentLocale(XMLlocales[i]);

				outUtf8.println(
						XMLFallbackTranslation.getDisplayName(XMLFallbackTranslation.getCurrentLocale()) + " ("
								+ XMLlocales[i]
										+ ")");

				outUtf8.println(
						"- " + XMLFallbackTranslation.getMessage(XMLTranslation.Hello) + ", "
								+ XMLFallbackTranslation.getMessage(XMLTranslation.World));

				outUtf8.println("- " + XMLFallbackTranslation.getMessage(XMLTranslation.HowAreYou));

			}

			outUtf8.println();

			outUtf8.println("PO Translations: (es_ES fallback)");
			for (int i = 0; i < POlocales.length; i++) {
				POFallbackTranslation.setCurrentLocale(POlocales[i]);

				outUtf8.println(POFallbackTranslation.getDisplayName(POFallbackTranslation.getCurrentLocale()) + " ("
						+ POlocales[i] + ")");

				outUtf8.println("- " + POFallbackTranslation.getMessage(POTranslation.Hello) + ", "
						+ POFallbackTranslation.getMessage(POTranslation.World));

				outUtf8.println("- " + POFallbackTranslation.getMessage(POTranslation.HowAreYou));

			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
