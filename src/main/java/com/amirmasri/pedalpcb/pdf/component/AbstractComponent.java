package com.amirmasri.pedalpcb.pdf.component;

import java.util.Objects;

/**
 * Abstract class from which all {@link Component} sub-classes will extend.
 */
abstract class AbstractComponent implements Component {
  private final String name;
  private final String value;

  public AbstractComponent(String name, String value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("[name='%s', value='%s']", getName(), getValue());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof AbstractComponent)) {
      return false;
    }

    AbstractComponent ac = (AbstractComponent) obj;

    return ac.getValue().equals(value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }
}
