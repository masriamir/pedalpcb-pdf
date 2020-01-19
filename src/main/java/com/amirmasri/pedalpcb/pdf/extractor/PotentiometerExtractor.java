package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.PotentiometerFactory;
import com.amirmasri.pedalpcb.pdf.component.ComponentType;
import com.amirmasri.pedalpcb.pdf.component.Potentiometer;

public final class PotentiometerExtractor extends AbstractComponentExtractor<Potentiometer> {
  public PotentiometerExtractor() {
    super("^(.*\\w)\\s+([A,B,C]\\d+[M,K])", ComponentType.POTENTIOMETER, new PotentiometerFactory());
  }
}
