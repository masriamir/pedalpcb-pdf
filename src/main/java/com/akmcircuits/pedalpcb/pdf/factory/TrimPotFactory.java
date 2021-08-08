package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.TrimPot;

public final class TrimPotFactory implements ComponentFactory<TrimPot> {
  @Override
  public TrimPot create(String name, String value) {
    return new TrimPot(name, value);
  }
}
