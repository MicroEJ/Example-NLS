/*
 * Java
 *
 * Copyright 2015-2021 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.nls;

import com.microej.example.nls.generated.HelloWorldMessages;

import ej.nls.NLS;

/**
 * This example application will display the same message in several languages,
 * using all the available locales.
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

		// Create new NLS for the header "HelloWorldMessages"
		NLS nls = HelloWorldMessages.NLS;


		// List all the available locales
		String[] locales = nls.getAvailableLocales();

		System.out.println("Available locales:");
		for (int i = 0; i < locales.length; i++) {
			System.out.println("- " + locales[i]);
		}

		// Print the messages for each locale
		System.out.println("Saying:");
		for (int i = 0; i < locales.length; i++) {
			nls.setCurrentLocale(locales[i]);

			System.out.println(nls.getDisplayName(nls.getCurrentLocale()) + " (" + locales[i] + ")");

			System.out.println(
					"- " + nls.getMessage(HelloWorldMessages.Hello) +
					", " + nls.getMessage(HelloWorldMessages.World));

			System.out.println("- " + nls.getMessage(HelloWorldMessages.Howareyou));
		}
	}

}
