# HelloWorld NLS

This project allows to display the same message in several languages using PO translation files.
More information on the PO format can be found at 
[gnu.org.](https://www.gnu.org/software/gettext/manual/html_node/PO-Files.html)

By default, some translation files are already included in this project (`src/main/resources/nls`).
New translation files can be generated using the [ExcelToNLS](../ExcelToNLS/) Tool.
The generated files will overwrite the existing translation files of this project.

# Project structure

- `src/main/java` the Java sources.
- `src/main/resources/nls` the folder containing the `.po` translation files.

# Requirements

- MicroEJ SDK `5.4.0` or higher.
- Internet connection to MicroEJ Central Repository.
- A MicroEJ Platform with (at least):
	- `EDC-1.3.3`

This example has been tested on:

- STM32F7508-DK board.
- Architecture `7.14`.
- MicroEJ SDK `5.4.0`.
- STM32CubeIDE `1.5.0`.

# Usage

## Running the Application on Simulator

Using MicroEJ, you may deploy and run your application on an embedded target (if the hardware and related BSP are available) 
or you may run your application on a Java simulator mimicking the behavior of your embedded target.

* Select the **HelloWorldNLS** project,
* Select **Run > Run Configurations...** menu item,
* Select **MicroEJ Application** group,
* Create a new configuration:
	* In **Execution** tab:
		* In **Target** frame:
			* Click the **Browse** button next to the Platform Field and select your platform,
		* In **Execution** frame:
			* Notice that **Execute on Simulator** radio button option is checked,
	* Click on **Run**.
	

The simulator should start and messages in several languages are
printed in the console.

## Running the Application on Device

### Building for the Device

* Select the **HelloWorldNLS** project,
* Select **Run > Run Configurations...** menu item,
* Select **MicroEJ Application** group,
* Create a new configuration:
	* In **Execution** tab:
		* In **Target** frame:
			* Click the **Browse** button next to the Platform Field and select your platform,
		* In **Execution** frame:
			* Notice that **Execute on Device** radio button option is checked,
	* Click on **Run**.
	
### Importing the BSP Project

* Open STM32CubeIDE in an empty workspace,
* Select **File > Import...**,
* Select **General > Existing Projects into Workspace**,
* Press **Next >**,
* Next to the **Select root directory** field, press **Browse...**,
* Navigate to the **stm32f7508_freertos-bsp/projects/microej/SW4STM32** folder,
* Press **OK**,
* Press **Finish**.

### Building the BSP Project

* In STM32CubeIDE, right-click on the **application** project,
* Press **Build Project**,
* Wait for the end of the build.

### Flashing the Application on the Board

* Plug-in your STM32F7508-DK board,
* In STM32CubeIDE, select **Run > Run Configurations...**,
* Under **STM32 Cortex-M C/C++ Application**, select the **application_debug** run configuration,
* Press **Run**.

## Expected results

The application shows the available locales and prints some messages in several languages.

```
Available locales:
- en_US
- es_FR
- fr_FR
Saying:
- English (US) (en_US)
Hello, World
What's up?
- Español (es_FR)
Hola, Mundo
¿ Qué tal ?
- Français (fr_FR)
Bonjour, Le Monde
Ça va ?
```

# Dependencies

_All dependencies are retrieved transitively by MicroEJ Module Manager_.

# Source

N/A.

# Restrictions

None.

---
_Markdown_   
_Copyright 2021 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._ 
