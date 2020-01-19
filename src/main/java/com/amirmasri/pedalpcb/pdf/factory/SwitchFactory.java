package com.amirmasri.pedalpcb.pdf.factory;

import com.amirmasri.pedalpcb.pdf.component.Switch;

public final class SwitchFactory implements ComponentFactory<Switch> {
  @Override
  public Switch create(String name, String value) {
    return new Switch(name, value);
  }
}
