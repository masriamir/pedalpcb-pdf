package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.Resistor;
import com.akmcircuits.pedalpcb.pdf.factory.ResistorFactory;

public final class ResistorExtractor extends AbstractComponentExtractor<Resistor> {
  public ResistorExtractor() {
    super(Resistor.TYPE, new ResistorFactory());
  }
}
