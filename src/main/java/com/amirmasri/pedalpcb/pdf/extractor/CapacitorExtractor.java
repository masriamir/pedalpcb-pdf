package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.CapacitorFactory;
import com.amirmasri.pedalpcb.pdf.component.Capacitor;
import com.amirmasri.pedalpcb.pdf.component.ComponentType;

public final class CapacitorExtractor extends AbstractComponentExtractor<Capacitor> {
  public CapacitorExtractor() {
    super(ComponentType.CAPACITOR, new CapacitorFactory());
  }
}
