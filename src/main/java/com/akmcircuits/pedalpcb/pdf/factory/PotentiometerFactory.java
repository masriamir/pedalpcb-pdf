package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.Potentiometer;

public final class PotentiometerFactory implements ComponentFactory<Potentiometer> {
  @Override
  public Potentiometer create(String name, String value) {
    return new Potentiometer(name, value);
  }
}
