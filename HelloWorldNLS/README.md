# HelloWorld NLS

This project shows how to display the same message in several languages using either: 
- PO translation files, More information on the PO format can be found at
  [gnu.org](https://www.gnu.org/software/gettext/manual/html_node/PO-Files.html).
- XML translation files, More information on string resources (XML) can be found at [developer.android.com](https://developer.android.com/guide/topics/resources/string-resource).

By default, some translation files are already included in this project (`src/main/resources/nls/po` and `src/main/resources/nls/xml`).
New translation files can be generated using the [ExcelToNLS](../ExcelToNLS/) Tool.
The generated files will overwrite the existing translation files of this project.

This project also contains an example of the fallback feature.
The fallback settings can be updated in [HelloWorld.nls.list](src/main/resources/com/microej/example/nls/HelloWorld.nls.list).

# Project structure

- `src/main/java` the Java sources.
- `src/main/resources/nls/po` the folder containing `.po` translation files.
- `src/main/resources/nls/xml` the folder containing `.xml` translation files.
- ``launches`` the folder containing the following project launch configurations.
  - ``Fallback HelloWorld (EMB)``: embedded build for the fallback example.
  - ``Fallback HelloWorld (SIM)``: simulator build for the fallback example.
  - ``HelloWorld (PO) (EMB)``: embedded build displaying HelloWorlds using the PO files.
  - ``HelloWorld (PO) (SIM)``: simulator build displaying HelloWorlds using the PO files.
  - ``HelloWorld (XML) (EMB)``: embedded build displaying HelloWorlds using the XML files.
  - ``HelloWorld (XML) (SIM)``: simulator build displaying HelloWorlds using the XML files.

# Requirements

- MicroEJ SDK `5.4.0` or higher.
- Internet connection to MicroEJ Central Repository.
- A MicroEJ Platform with (at least):
	- `EDC-1.3.3`

This example has been tested on:

- STM32F7508-DK board with the [STM32F7508 platform](https://github.com/MicroEJ/Platform-STMicroelectronics-STM32F7508-DK/tree/1.5.0) ``1.5.0``.
- Architecture `7.16`.
- MicroEJ SDK `5.4.0`.
- STM32CubeIDE `1.9.0`.

# Usage

> Translation examples provided in this project are using UTF-8 encoding, if you encounter issues with character display, please make sure that your MicroEJ SDK console is well configured (see [docs.microej.com](https://docs.microej.com/en/latest/ApplicationDeveloperGuide/characterEncoding.html#set-encoding-in-microej-sdk-console)), this issue can also appear in embedded depending on the terminal you are using to listen to output traces. 

## Running the Application on Simulator

Using MicroEJ, you may deploy and run your application on an embedded target (if the hardware and related BSP are available) 
or you may run your application on a Java simulator mimicking the behavior of your embedded target.

- Import the ``HelloWorldNLS`` in the MicroEJ SDK.
- Go to the ``launches`` folder.
- Right click on one of the ``(SIM)`` launch configuration.
- Select ``Run As > the (SIM) project of your choice``.

> Note: you may be asked to select a platform if you are using a different one from the above specifications.

The simulator should start and run the selected project launch configuration.

## Running the Application on Device

### Building for the Device

- Import the ``HelloWorldNLS`` in the MicroEJ SDK.
- Go to the ``launches`` folder.
- Right click on one of the ``(EMB)`` launch configuration.
- Select ``Run As > the (EMB) project of your choice``.

> Note: you may be asked to select a platform if you are using a different one from the above specifications.

### Building the BSP

> The following part is also documented with further explanations in the [platform README](https://github.com/MicroEJ/Platform-STMicroelectronics-STM32F7508-DK/tree/1.5.0#bsp-compilation)

- Open a file explorer.
- Navigate to ``stm32f7508_freertos-bsp/projects/microej/SW4STM32`` folder.
- Make sure that the ``set_project_env.bat`` is well configured.
- Run the ``build.bat`` script using a terminal.

The BSP has been built with your application and is now ready to be built.

### Flashing the Application on the Board

- Plug-in your STM32F7508-DK board,
- Run the ``run.bat`` script using a terminal.

The application should now be running on your board.

## Expected results

The application shows the available locales and prints some messages in several languages.

```
PO example:

Available PO locales:
- en_US
- es_ES
- fr_FR
  Saying:
  English (US) (en_US)
- Hello, World
- What's up?
  Español (es_ES)
- Hola, Mundo
- ¿ Qué tal ?
  Français (fr_FR)
- Bonjour, Le Monde
- Ça va ?

XML example:

Available XML locales:
- en_US
- es_ES
- fr_FR
  Saying:
  en_US (en_US)
- Hello, World
- What's up?
  es_ES (es_ES)
- Hola, Mundo
- ¿ Qué tal ?
  fr_FR (fr_FR)
- Bonjour, Le Monde
- Ça va ?

Fallback example:
XML Translations: (en_US fallback)
en_US (en_US)
- Hello, World
- HOW_ARE_YOU
es_ES (es_ES)
- Hola, World
- ¿ Qué tal ?
fr_FR (fr_FR)
- Hello, Le Monde
- Ça va ?

PO Translations: (es_ES fallback)
English (US) (en_US)
- Hello, World
- ¿ Qué tal ?
Español (es_ES)
- Hola, WORLD
- ¿ Qué tal ?
Français (fr_FR)
- Hola, Le Monde
- Ça va ?
```



# Dependencies

_All dependencies are retrieved transitively by MicroEJ Module Manager_.

# Source

N/A.

# Restrictions

None.

---
_Markdown_   
_Copyright 2021-2022 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._ 
