package com.amirmasri.pedalpcb.pdf.factory;

import com.amirmasri.pedalpcb.pdf.component.IntegratedCircuit;

public final class IntegratedCircuitFactory implements ComponentFactory<IntegratedCircuit> {
  @Override
  public IntegratedCircuit create(String name, String value) {
    return new IntegratedCircuit(name, value);
  }
}
