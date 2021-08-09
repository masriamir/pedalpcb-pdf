package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.component.Potentiometer;
import com.akmcircuits.pedalpcb.pdf.factory.PotentiometerFactory;

public final class PotentiometerExtractor extends AbstractComponentExtractor<Potentiometer> {
    public PotentiometerExtractor() {
        super("^(.*\\w)\\s+([A,B,C]\\d+[M,K])", ComponentType.POTENTIOMETER, new PotentiometerFactory());
    }
}
