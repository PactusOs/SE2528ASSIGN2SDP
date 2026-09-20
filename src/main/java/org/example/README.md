# Assignment 2 - Factory Method and Abstract Factory

## Purpose

This Java 17 console application demonstrates two creational design patterns in one logistics system:

- Factory Method creates the delivery transport (`Truck` or `Ship`) through `Logistics` subclasses.
- Abstract Factory creates a matching UI family (`Button` and `Checkbox`) for Windows or macOS.

The application supports all four combinations without changing the source code.

## Prerequisites

- JDK 17 or later
- Maven 3.9+ is optional
- No external Java libraries are required

## Package structure

```text
src/main/java/kz/aitu/assignment2/
├── Main.java
├── app/
│   └── DeliveryApplication.java
├── factorymethod/
│   ├── Logistics.java
│   ├── RoadLogistics.java
│   ├── SeaLogistics.java
│   ├── Transport.java
│   ├── Truck.java
│   └── Ship.java
└── abstractfactory/
    ├── Button.java
    ├── Checkbox.java
    ├── GUIFactory.java
    ├── WindowsButton.java
    ├── WindowsCheckbox.java
    ├── MacOSButton.java
    ├── MacOSCheckbox.java
    ├── WindowsFactory.java
    └── MacOSFactory.java
```

## Supported input values

Delivery mode:

- `ROAD`
- `SEA`

UI platform:

- `WINDOWS`
- `MACOS`

Values are case-insensitive because input is normalized to uppercase.

## Build with JDK 17 directly

Linux/macOS:

```bash
rm -rf out
mkdir out
javac --release 17 -d out $(find src/main/java -name "*.java")
```

Windows PowerShell:

```powershell
Remove-Item -Recurse -Force out -ErrorAction SilentlyContinue
New-Item -ItemType Directory out | Out-Null
javac --release 17 -d out (Get-ChildItem -Recurse src/main/java -Filter *.java | ForEach-Object FullName)
```

## Build with Maven

```bash
mvn clean package
```

## Run

After direct compilation:

```bash
java -cp out aitu.assignment2.Main ROAD WINDOWS
```

After Maven build, the compiled classes are in `target/classes`:

```bash
java -cp target/classes aitu.assignment2.Main ROAD WINDOWS
```

The project intentionally keeps the Java runtime dependency-free.

The program also supports interactive input:

```text
Enter delivery mode (ROAD or SEA): ROAD
Enter UI platform (WINDOWS or MACOS): WINDOWS
```

## Sample run

```text
Delivery mode: ROAD
UI platform: WINDOWS
Rendering Windows button
Rendering Windows checkbox
Truck delivers laboratory equipment by road to Aktau warehouse
```

## Four supported combinations

```text
ROAD + WINDOWS -> Truck + WindowsButton + WindowsCheckbox
SEA + WINDOWS  -> Ship + WindowsButton + WindowsCheckbox
ROAD + MACOS   -> Truck + MacOSButton + MacOSCheckbox
SEA + MACOS    -> Ship + MacOSButton + MacOSCheckbox
```

## Validation behavior

- Unsupported delivery mode: prints a clear validation message and stops before delivery.
- Unsupported platform: prints a clear validation message and stops before UI construction.
- Missing input: prints a clear message and stops; no default value is selected.

## UML

PlantUML source files are in `uml/`.

- `factory-method.puml`
- `abstract-factory.puml`

Rendered PNG and SVG versions are included beside the source files.

## Verification

The `verification/` directory contains the actual console outputs for the six required checks and the missing-input case.

## Report

The `report/` directory contains an English report template matching the requested assignment structure. Replace:

- `[SURNAME NAME]`
- `[GROUP]`
- `[GITHUB REPOSITORY LINK]`
- `[SUBMITTED COMMIT]`

before Moodle submission. The requested PDF filename format is `Assignment2_Group_Surname_Name.pdf`.

## References used for the design explanation

1. Assignment 2 - Factory Method and Abstract Factory, Astana IT University, 2026-2027.
2. Refactoring Guru, Factory Method: https://refactoring.guru/design-patterns/factory-method
3. Refactoring Guru, Abstract Factory: https://refactoring.guru/design-patterns/abstract-factory
4. Freeman & Robson, *Head First Design Patterns*, Chapter 4, O'Reilly: https://www.oreilly.com/library/view/head-first-design/9781492077992/ch04.html

## Defense focus

Be able to locate and explain:

- `Transport` as the Factory Method product.
- `Truck` and `Ship` as concrete products.
- `Logistics` as the creator and `createTransport()` as the factory method.
- `RoadLogistics` and `SeaLogistics` as concrete creators.
- `planDelivery()` calling `createTransport()` and then `deliver()` through `Transport`.
- `Button` and `Checkbox` as Abstract Factory product interfaces.
- Windows and macOS concrete product pairs.
- `GUIFactory` and its two creation methods.
- `WindowsFactory` and `MacOSFactory` as concrete factories.
- `DeliveryApplication` using the injected factory and product interfaces.
