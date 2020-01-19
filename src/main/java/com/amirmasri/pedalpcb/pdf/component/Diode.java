package com.amirmasri.pedalpcb.pdf.component;

/**
 * Model representation of a diode.
 */
public final class Diode extends AbstractComponent {
  public static final ComponentType TYPE = ComponentType.DIODE;

  public Diode(String name, String value) {
    super(name, value);
  }

  @Override
  public ComponentType getType() {
    return TYPE;
  }
}
