package com.amirmasri.pedalpcb.pdf.factory;

import com.amirmasri.pedalpcb.pdf.component.Diode;

public final class DiodeFactory implements ComponentFactory<Diode> {
  @Override
  public Diode create(String name, String value) {
    return new Diode(name, value);
  }
}
