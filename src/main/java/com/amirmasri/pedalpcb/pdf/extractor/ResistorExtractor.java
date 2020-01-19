package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.ResistorFactory;
import com.amirmasri.pedalpcb.pdf.component.Resistor;

public final class ResistorExtractor extends AbstractComponentExtractor<Resistor> {
  public ResistorExtractor() {
    super(Resistor.TYPE, new ResistorFactory());
  }
}
