package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.Diode;

public final class DiodeFactory implements ComponentFactory<Diode> {
    @Override
    public Diode create(String name, String value) {
        return new Diode(name, value);
    }
}
