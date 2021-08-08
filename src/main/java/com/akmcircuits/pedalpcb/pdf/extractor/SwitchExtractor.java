package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.Switch;
import com.akmcircuits.pedalpcb.pdf.factory.SwitchFactory;
import com.akmcircuits.pedalpcb.pdf.component.ComponentType;

public final class SwitchExtractor extends AbstractComponentExtractor<Switch> {
  //TODO - ^(SW\d+)\s+(\w+\s+\(.*\))
  public SwitchExtractor() {
    super(ComponentType.SWITCH, new SwitchFactory());
  }
}
