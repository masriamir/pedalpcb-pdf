package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.TransistorFactory;
import com.amirmasri.pedalpcb.pdf.component.ComponentType;
import com.amirmasri.pedalpcb.pdf.component.Transistor;

public final class TransistorExtractor extends AbstractComponentExtractor<Transistor> {
  public TransistorExtractor() {
    super(ComponentType.TRANSISTOR, new TransistorFactory());
  }
}
