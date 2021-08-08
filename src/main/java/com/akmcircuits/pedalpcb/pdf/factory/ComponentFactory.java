package com.akmcircuits.pedalpcb.pdf.factory;

import com.akmcircuits.pedalpcb.pdf.component.Component;

/**
 * Factory interface to create a {@link Component} of type {@link T}.
 *
 * @param <T> the type of {@code Component} to create
 */
public interface ComponentFactory<T extends Component> {
  /**
   * Create and return a {@link Component} of type {@link T} using the provided {@code name} and
   * {@code value.}
   *
   * @param name the name of the component
   * @param value the value of the component
   * @return the {@code Component}
   */
  T create(String name, String value);
}
