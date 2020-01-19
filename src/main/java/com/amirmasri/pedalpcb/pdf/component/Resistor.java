package com.amirmasri.pedalpcb.pdf.component;

/**
 * Model representation of a resistor.
 */
public final class Resistor extends AbstractComponent {
  public static final ComponentType TYPE = ComponentType.RESISTOR;

  public Resistor(String name, String value) {
    super(name, value);
  }

  @Override
  public ComponentType getType() {
    return TYPE;
  }
}
