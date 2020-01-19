# pedalpcb-pdf

## What is it?

A command-line Java library to generate bill of materials information from PedalPCB build documentation PDF files.

## Usage

See below for usage examples. Either a single file or a list or files can be provided.

```bash
# Single-file
$ java -jar pedalpcb-pdf.jar document.pdf

# Multi-file
$ java -jar pedalpcb-pdf.jar document1.pdf document2 ...

# Entire directory
$ find /path/to/dir -name *.pdf | xargs -exec java -jar pedalpcb-pdf.jar
```

## Example output

```
Kalle
Revision 06.24.18
====================

Diodes
--------------------
[D2] = BAT46 X 1
[D100] = 1N5817 X 1
[D1] = 1N914 X 1

Resistors
--------------------
[R101] = 330 X 1
[R100] = 4K7 X 1
[R3] = 3M3 X 1
[R2] = 1K X 1
[R4] = 3K3 X 1
[R5, R6] = 10K X 2
[R1] = 1M X 1

Transistors
--------------------
[Q3] = 2N3904 X 1
[Q2] = 2N3906 X 1
[Q1] = 2N5089 X 1

Capacitors
--------------------
[C100] = 47u X 1
[C101] = 100u X 1
[C2] = 22u X 1
[C3, C5] = 220n X 2
[C1] = 47n X 1
[C4] = 390p X 1

Potentiometers
--------------------
[VOLUME] = B500K X 1
[INTENSITY] = B5K X 1
```

## Utilizes

* [Apache PDFBox](https://pdfbox.apache.org/ "Apache PDFBox")
