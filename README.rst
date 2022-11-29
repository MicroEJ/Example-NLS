.. image:: https://shields.microej.com/endpoint?url=https://repository.microej.com/packages/badges/sdk_5.6.json
   :alt: sdk_5.6 badge
   :align: left

.. image:: https://shields.microej.com/endpoint?url=https://repository.microej.com/packages/badges/arch_7.16.json
   :alt: arch_7.16 badge
   :align: left

..
  Copyright 2021-2022 MicroEJ Corp. All rights reserved.
  Use of this source code is governed by a BSD-style license that can be found with this software.

===========
Example-NLS
===========

Overview
========

Native Language Support (NLS) allows the application to facilitate internationalization.
It provides support to manipulate messages and translate them in different languages.
Each message to be internationalized is referenced by a key, which can be used in the application code instead of using the message directly.
There are two ways to describe the translations: 
- a PO file that can be generated using the `ExcelToNLS <ExcelToNLS/>`__ project.
- a XML file using the `string resources <https://developer.android.com/guide/topics/resources/string-resource>`__ from android that can be generated using the `ExcelToNLS <ExcelToNLS/>`__ project.

Please refer to the `MicroEJ documentation <https://docs.microej.com/en/latest/ApplicationDeveloperGuide/applicationResources.html#native-language-support>`__
for more details on NLS.

The `HelloWorldNLS <HelloWorldNLS/>`__ project shows how to display the same message in several languages using PO and XML translation files.

Additionally to the example project, we provide a tool that allows to convert an Excel file ``.xlsx`` to files in PO or XML format. 
You can adapt this tool to your specific file format.

The `ExcelToNLS <ExcelToNLS/>`__ project converts an Excel file to a set of PO or XML files. In this example, the PO files are saved as resources in the
`HelloWorldNLS <HelloWorldNLS/>`__ project, so that the translation is directly propagated from the Excel file to the target application. 

FallBack Feature
~~~~~~~~~~~~~~~~

This project also include an example of the fallback feature.
The fallback feature allows to specify different behaviors when language translations are missing.
You can find more informations about the fallback feature `here <https://docs.microej.com/en/latest/ApplicationDeveloperGuide/nls.html>`__.


Requirements
============

- MicroEJ SDK 5.4.0 or higher.
- A MicroEJ Platform with (at least):
	- EDC-1.3.3
	- NLS-3.1.0

Usage
=====

Follow the README file located at the root of each project to run the two examples:

- `HelloWorldNLS README. <HelloWorldNLS/README.md>`__
- `ExcelToNLS README. <ExcelToNLS/README.md>`__

Changes
=======

See the changelog file `CHANGELOG.rst <CHANGELOG.rst>`__ located at the root of this repository.
