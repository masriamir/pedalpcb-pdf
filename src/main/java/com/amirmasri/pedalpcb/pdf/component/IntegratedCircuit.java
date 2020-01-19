package com.amirmasri.pedalpcb.pdf.component;

/**
 * Model representation of an integrated circuit.
 */
public final class IntegratedCircuit extends AbstractComponent {
  public static final ComponentType TYPE = ComponentType.INTEGRATED_CIRCUIT;

  public IntegratedCircuit(String name, String value) {
    super(name, value);
  }

  @Override
  public ComponentType getType() {
    return TYPE;
  }
}
