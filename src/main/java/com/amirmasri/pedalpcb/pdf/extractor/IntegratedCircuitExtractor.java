package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.IntegratedCircuitFactory;
import com.amirmasri.pedalpcb.pdf.component.ComponentType;
import com.amirmasri.pedalpcb.pdf.component.IntegratedCircuit;

public final class IntegratedCircuitExtractor extends AbstractComponentExtractor<IntegratedCircuit> {
  public IntegratedCircuitExtractor() {
    super(ComponentType.INTEGRATED_CIRCUIT, new IntegratedCircuitFactory());
  }
}
