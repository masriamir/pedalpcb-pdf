package com.akmcircuits.pedalpcb.pdf.component;

/**
 * Model representation of a capacitor.
 */
public final class Capacitor extends AbstractComponent {
    public static final ComponentType TYPE = ComponentType.CAPACITOR;

    public Capacitor(String name, String value) {
        super(name, value);
    }

    @Override
    public ComponentType getType() {
        return TYPE;
    }
}
