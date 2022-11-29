# ExcelToNLS

## Overview

This project converts an Excel file to a set of PO or XML files and saves them as 
resources in the [HelloWorldNLS project](../HelloWorldNLS)

## Project structure

- `src/main/java/` contains the Java sources.
- `excel/` contains the folder with the input Excel file.
- `launches/` contains the project launch configurations.
- `lib/` is the folder where the `Apache POI` JAR files should be extracted.

## Requirements

- MicroEJ SDK `5.4.0` or higher.
- Internet connection to MicroEJ Central Repository.
- Apache POI `5.0.0`.

## Usage

### Project Setup

The `ExcelToNLS` example comes without the JAR files from Apache POI. 
You have to download them from http://poi.apache.org. 

Once downloaded, copy the following JAR files and folders from the 
Apache POI package to the [lib](lib/) folder of the project:

- `poi-[version].jar`.
- `poi-ooxml-[version].jar`.
- `poi-ooxml-full-[version].jar`.
- `ooxml-lib/` folder.
- `lib/` folder.

The Apache POI JAR files need to be added to the Java build path: 

- Right-click on the project and select `Properties`,
- In the left menu, select `Java Build Path`,
- Open the `Libraries` tab,
- Add the above JARs to the Java build path.

### Running the application

In order to launch the `ExcelToNLS` project:

- Go to the `launches/` folder.

Depending on the output format you want:
- For a .po file: Right-click on the `ExcelToPONLS.launch` file and select `Run As -> ExcelToPONLS`.
- For a .xml file: Right-click on the `ExcelToXMLNLS.launch` file and select `Run As -> ExcelToXMLNLS`.

A trace should appear in the console, saying that the NLS files have been
deployed in the output folder:
- [HelloWorldNLS/src/main/resources/nls/po](../HelloWorldNLS/src/main/resources/nls/po/) for a .po file.
- [HelloWorldNLS/src/main/resources/nls/xml](../HelloWorldNLS/src/main/resources/nls/xml/) for a .xml file.

---
_Markdown_   
_Copyright 2021-2022 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._