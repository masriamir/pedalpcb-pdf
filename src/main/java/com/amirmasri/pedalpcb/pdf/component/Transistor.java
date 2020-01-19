package com.amirmasri.pedalpcb.pdf.component;

/**
 * Model representation of a transistor.
 */
public final class Transistor extends AbstractComponent {
  public static final ComponentType TYPE = ComponentType.TRANSISTOR;

  public Transistor(String name, String value) {
    super(name, value);
  }

  @Override
  public ComponentType getType() {
    return TYPE;
  }
}
