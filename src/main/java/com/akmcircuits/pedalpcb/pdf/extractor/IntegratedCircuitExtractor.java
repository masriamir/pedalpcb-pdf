package com.akmcircuits.pedalpcb.pdf.extractor;

import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.component.IntegratedCircuit;
import com.akmcircuits.pedalpcb.pdf.factory.IntegratedCircuitFactory;

public final class IntegratedCircuitExtractor extends AbstractComponentExtractor<IntegratedCircuit> {
    public IntegratedCircuitExtractor() {
        super(ComponentType.INTEGRATED_CIRCUIT, new IntegratedCircuitFactory());
    }
}
