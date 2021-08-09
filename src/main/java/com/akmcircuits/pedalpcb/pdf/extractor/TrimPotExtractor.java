package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.component.TrimPot;
import com.akmcircuits.pedalpcb.pdf.factory.TrimPotFactory;

public final class TrimPotExtractor extends AbstractComponentExtractor<TrimPot> {
    public TrimPotExtractor() {
        super(ComponentType.TRIM_POT, new TrimPotFactory());
    }
}
