package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.IntegratedCircuit;

public final class IntegratedCircuitFactory implements ComponentFactory<IntegratedCircuit> {
  @Override
  public IntegratedCircuit create(String name, String value) {
    return new IntegratedCircuit(name, value);
  }
}
