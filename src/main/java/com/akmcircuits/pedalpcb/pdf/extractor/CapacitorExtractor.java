package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.Capacitor;
import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.factory.CapacitorFactory;

public final class CapacitorExtractor extends AbstractComponentExtractor<Capacitor> {
  public CapacitorExtractor() {
    super(ComponentType.CAPACITOR, new CapacitorFactory());
  }
}
