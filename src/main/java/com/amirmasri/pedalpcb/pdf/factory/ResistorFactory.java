package com.amirmasri.pedalpcb.pdf.factory;

import com.amirmasri.pedalpcb.pdf.component.Resistor;

public final class ResistorFactory implements ComponentFactory<Resistor> {
    @Override
  public Resistor create(String name, String value) {
    return new Resistor(name, value);
  }
}
