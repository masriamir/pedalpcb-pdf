package com.amirmasri.pedalpcb.pdf.component;

public final class TrimPot extends AbstractComponent {
  public static final ComponentType TYPE = ComponentType.TRIM_POT;

  public TrimPot(String name, String value) {
    super(name, value);
  }

  @Override
  public ComponentType getType() {
    return TYPE;
  }
}
