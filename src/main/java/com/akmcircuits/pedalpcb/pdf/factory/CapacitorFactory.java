package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.Capacitor;

public final class CapacitorFactory implements ComponentFactory<Capacitor> {
  @Override
  public Capacitor create(String name, String value) {
    return new Capacitor(name, value);
  }
}
