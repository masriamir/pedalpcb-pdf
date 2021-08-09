package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.Switch;

public final class SwitchFactory implements ComponentFactory<Switch> {
    @Override
    public Switch create(String name, String value) {
        return new Switch(name, value);
    }
}
