/*
 * Java
 *
 * Copyright 2015-2022 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.tool.excel2nls;

/**
 * A Message object which represents an NLS message, containing a text and an
 * ID.
 */
public class Message {

	private final String id;
	private final String text;

	/**
	 * Instantiate a new message.
	 *
	 * @param id
	 *            the id
	 * @param text
	 *            the text
	 */
	public Message(String id, String text) {
		this.id = id;
		this.text = text;
	}

	/**
	 * Get the ID of this message.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Get the text of this message.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

}
