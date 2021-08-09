package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.component.Diode;
import com.akmcircuits.pedalpcb.pdf.factory.DiodeFactory;

public final class DiodeExtractor extends AbstractComponentExtractor<Diode> {
    public DiodeExtractor() {
        super(ComponentType.DIODE, new DiodeFactory());
    }
}
