package com.akmcircuits.pedalpcb.pdf.component;

/**
 * Enum representing the different types of passive components.
 */
public enum ComponentType {
  RESISTOR("R", "Resistors"),
  CAPACITOR("C", "Capacitors"),
  TRANSISTOR("Q", "Transistors"),
  DIODE("D", "Diodes"),
  INTEGRATED_CIRCUIT("IC", "Integrated Circuits"),
  POTENTIOMETER("P", "Potentiometers"),
  SWITCH("SW", "Switches"),
  TRIM_POT("TRIM", "Trim Pots");

  private final String prefix;
  private final String label;

  ComponentType(String prefix, String label) {
    this.prefix = prefix;
    this.label = label;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getLabel() {
    return label;
  }
}
