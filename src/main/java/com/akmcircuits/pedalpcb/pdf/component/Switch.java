package com.akmcircuits.pedalpcb.pdf.component;

public final class Switch extends AbstractComponent {
    public static final ComponentType TYPE = ComponentType.SWITCH;

    public Switch(String name, String value) {
        super(name, value);
    }

    @Override
    public ComponentType getType() {
        return TYPE;
    }
}
