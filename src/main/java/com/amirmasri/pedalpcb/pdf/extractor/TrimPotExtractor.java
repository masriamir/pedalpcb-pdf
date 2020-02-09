package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.component.ComponentType;
import com.amirmasri.pedalpcb.pdf.component.TrimPot;
import com.amirmasri.pedalpcb.pdf.factory.TrimPotFactory;

public final class TrimPotExtractor extends AbstractComponentExtractor<TrimPot> {
  public TrimPotExtractor() {
    super(ComponentType.TRIM_POT, new TrimPotFactory());
  }
}
