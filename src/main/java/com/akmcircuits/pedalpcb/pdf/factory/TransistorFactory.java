package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.Transistor;

public final class TransistorFactory implements ComponentFactory<Transistor> {
    @Override
    public Transistor create(String name, String value) {
        return new Transistor(name, value);
    }
}
