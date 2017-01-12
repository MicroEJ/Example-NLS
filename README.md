# Overview
Internalization is an important part of many projects so that users can select the language they want for their system. MicroEJ offers a library named NLS (National Language Support) to help developers internationalize the messages in their applications. NLS imposes the structure of the translation files, with a simple and efficient "[key]=[message]" format. Nevertheless, each company may have its own format for the translation files they share with their translators, often using Microsoft Excel.

Here, we demonstrate how an Excel file (xlsx) can be converted to files in NLS format. We use the Apache POI library to perform this transformation. You can adapt this tool to your specific file format.

Two Eclipse projects are provided:
1. [Excel-to-NLS](/Excel-to-NLS) converts an Excel file to a set of NLS files and saves them as resources of the second project.
2. [HelloWorld](/HelloWorld) takes all the generated files and uses NLS library to display the same message in several languages.

## Project Setup
Excel-to-NLS comes without the JAR files from Apache POI. You have to download them from http://poi.apache.org. You have to copy the following JAR files to the [lib](/Excel-to-NLS/lib) folder of the project:
- poi-[version].jar
- poi-ooxml-[version].jar
- poi-ooxml-schemas-[version].jar
- xmlbeans-[version].jar

Then, right-click on the project and select **Properties**. In the left menu, select **Java Build Path** and open the **Libraries** tab. Add the above JARs to the Java build path.

HelloWorld is already fully configured.

### Project structure
- Tool-Excel-to-NLS

 - Excel-to-NLS
  - `excel/`:  folder with a example xlsx file
  - `launches/`: Java launch configuration
  - `lib/`:  folder to place the required JAR files  
  - `src/main/java/`: Java sources
  
 - HelloWorld
  - `excel/`:  folder with a example xlsx file
  - `launches/`: MicroEJ launch configuration 
  - `src/main/java/`: Java sources
  - `src/main/resources/`: resources
  
 - `LICENCE.md`
 - `README.md`

# Usage
## Run XLS to NLS tool
1. Execute the App class of the Excel-to-NLS project as a regular Java Application. A [Java launch configuration](/Excel-to-NLS/launches/Excel-to-NLS.launch) is provided for convenience, right-click on [launches/Excel-to-NLS.launch](/Excel-to-NLS/launches/Excel-to-NLS.launch) and select **Run as->Excel-to-NLS**. This will generate a set of NLS files and drop them in the appropriate folder of the HelloWorld project.

Second, execute the [Main](/HelloWorld/src/main/java/ej/examples/nls/Main.java) class of the HelloWorld project as a MicroEJ Application. A [MicroEJ launch configuration](/HelloWorld/launches/HelloWorld on STM32429I-DISCO SimJPF.properties) is provided with the path to the [nls.list](/HelloWorld/src/main/resources/nls.list) file properly configured. This will print the same message with all the available locales in the Eclipse console.

## Run on MicroEJ Simulator
1. Right Click on [Main.java](HelloWorld/src/main/java/ej/examples/nls/Main.java)
2. Select **Run as -> Run Configuration** 
3. Select **MicroEJ Application** configuration kind
4. Click on **New launch configuration** icon
5. Go to **Execution** tab
	* Select your platform 
6. Go to **Configuration** tab
	* Go to **Libraries -> NLS**
		* Check Use NLS messages
		* Set the **NLS list file** to`${project_loc:HelloWorld}/src/main/resources/HelloWorld/HelloWorld.nls.list`
7. Press **Apply**
8. Press **Run**


## Run on device
### Build
1. Right Click on [Main.java](HelloWorld/src/main/java/ej/examples/nls/Main.java)
2. Select **Run as -> Run Configuration**
3. Select **MicroEJ Application** configuration kind
4. Click on **New launch configuration** icon
5. Select **Execute on Device**
6. Select **Build & Deploy**
7. Go to **Execution** tab
	* Select your platform 
8. Go to **Configuration** tab
	* Go to **Libraries -> NLS**
		* Check Use NLS messages
		* Set the **NLS list file** to`${project_loc:HelloWorld}/src/main/resources/HelloWorld/HelloWorld.nls.list`
9. Press **Apply**
10. Press **Run**
11. Copy the generated `.out` file path

### Flash
1. Use the appropriate flashing tool.

# Requirements
* MicroEJ Studio or SDK 4.0 or later
* A platform with at least:
	* EDC-1.2 or higher
	* NLS-2.0 or higher
	
## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.

# License
See the license file [LICENSE.md](LICENSE.md) located at the root of this repository.

# Changes
See the changelog file [CHANGELOG.md](CHANGELOG.md) located at the root of this repository.
