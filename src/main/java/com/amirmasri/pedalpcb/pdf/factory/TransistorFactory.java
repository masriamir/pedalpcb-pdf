package com.amirmasri.pedalpcb.pdf.factory;

import com.amirmasri.pedalpcb.pdf.component.Transistor;

public final class TransistorFactory implements ComponentFactory<Transistor> {
  @Override
  public Transistor create(String name, String value) {
    return new Transistor(name, value);
  }
}
