# Overview
This project takes all the generated files and uses NLS library to display the same message in several languages.

# Usage
## Run on MicroEJ Simulator
1. Right Click on [Main.java](HelloWorld/src/main/java/com/microej/example/nls/Main.java)
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
1. Right Click on [Main.java](HelloWorld/src/main/java/com/microej/example/nls/Main.java)
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

# Source
N/A

# Restrictions
None.

