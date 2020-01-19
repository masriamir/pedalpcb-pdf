package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.DiodeFactory;
import com.amirmasri.pedalpcb.pdf.component.ComponentType;
import com.amirmasri.pedalpcb.pdf.component.Diode;

public final class DiodeExtractor extends AbstractComponentExtractor<Diode> {
  public DiodeExtractor() {
    super(ComponentType.DIODE, new DiodeFactory());
  }
}
