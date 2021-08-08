package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.Transistor;
import com.akmcircuits.pedalpcb.pdf.factory.TransistorFactory;
import com.akmcircuits.pedalpcb.pdf.component.ComponentType;

public final class TransistorExtractor extends AbstractComponentExtractor<Transistor> {
  public TransistorExtractor() {
    super(ComponentType.TRANSISTOR, new TransistorFactory());
  }
}
