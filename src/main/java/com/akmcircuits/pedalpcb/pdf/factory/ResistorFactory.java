package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.Resistor;

public final class ResistorFactory implements ComponentFactory<Resistor> {
    @Override
    public Resistor create(String name, String value) {
        return new Resistor(name, value);
    }
}
