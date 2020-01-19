package com.amirmasri.pedalpcb.pdf.component;

/**
 * Model representation of a potentiometer.
 */
public final class Potentiometer extends AbstractComponent {
  public static final ComponentType TYPE = ComponentType.POTENTIOMETER;

  public Potentiometer(String name, String value) {
    super(name, value);
  }

  @Override
  public ComponentType getType() {
    return TYPE;
  }
}
