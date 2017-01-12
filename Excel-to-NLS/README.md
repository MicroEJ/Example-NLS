# Overview
This project converts an Excel file to a set of NLS files and saves them as resources of the second project.

# Usage
## Project Setup
Excel-to-NLS comes without the JAR files from Apache POI. You have to download them from http://poi.apache.org. You have to copy the following JAR files to the [lib](/Excel-to-NLS/lib) folder of the project:
- poi-[version].jar
- poi-ooxml-[version].jar
- poi-ooxml-schemas-[version].jar
- xmlbeans-[version].jar

Then, right-click on the project and select **Properties**. In the left menu, select **Java Build Path** and open the **Libraries** tab. Add the above JARs to the Java build path.

HelloWorld is already fully configured.

# Requirements
* MicroEJ Studio or SDK 4.0 or later

## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.

# Source
N/A

# Restrictions
None.

