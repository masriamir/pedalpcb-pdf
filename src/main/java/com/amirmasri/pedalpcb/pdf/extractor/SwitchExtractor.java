package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.SwitchFactory;
import com.amirmasri.pedalpcb.pdf.component.ComponentType;
import com.amirmasri.pedalpcb.pdf.component.Switch;

public final class SwitchExtractor extends AbstractComponentExtractor<Switch> {
  //TODO - ^(SW\d+)\s+(\w+\s+\(.*\))
  public SwitchExtractor() {
    super(ComponentType.SWITCH, new SwitchFactory());
  }
}
