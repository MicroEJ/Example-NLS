/*
 * Java
 *
 * Copyright 2015-2017 IS2T. All rights reserved.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package com.microej.tool.excel2nls;

/**
 * A Message object represent an NLS message, which is a text and an ID.
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
