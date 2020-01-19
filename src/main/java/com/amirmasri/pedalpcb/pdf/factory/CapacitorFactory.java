package com.amirmasri.pedalpcb.pdf.factory;

import com.amirmasri.pedalpcb.pdf.component.Capacitor;

public final class CapacitorFactory implements ComponentFactory<Capacitor> {
  @Override
  public Capacitor create(String name, String value) {
    return new Capacitor(name, value);
  }
}
