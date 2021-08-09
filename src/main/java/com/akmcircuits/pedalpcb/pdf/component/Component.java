package com.akmcircuits.pedalpcb.pdf.component;

/**
 * Base interface representing a component.
 */
public interface Component {
    /**
     * Return the {@link ComponentType} for this {@code Component}.
     *
     * @return the type of component
     */
    ComponentType getType();

    /**
     * Return the name for this {@code Component}.
     * <p>The {@code name} identifies the component on the pcb.</p>
     *
     * @return the component name
     */
    String getName();

    /**
     * Return the value for this {@code Component}.
     * <p>The {@code value} identifies the "value" of the component</p>
     *
     * @return the component value
     */
    String getValue();
}
