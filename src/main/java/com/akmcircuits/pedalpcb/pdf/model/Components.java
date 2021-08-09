package com.akmcircuits.pedalpcb.pdf.model;

import com.akmcircuits.pedalpcb.pdf.component.Capacitor;
import com.akmcircuits.pedalpcb.pdf.component.Diode;
import com.akmcircuits.pedalpcb.pdf.component.Resistor;
import com.akmcircuits.pedalpcb.pdf.component.Transistor;
import com.akmcircuits.pedalpcb.pdf.component.Component;
import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.component.IntegratedCircuit;
import com.akmcircuits.pedalpcb.pdf.component.Potentiometer;
import com.akmcircuits.pedalpcb.pdf.component.Switch;
import com.akmcircuits.pedalpcb.pdf.component.TrimPot;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Components {
  private final Map<ComponentType, List<? extends Component>> componentTypeMap;

  public Components() {
    componentTypeMap = new HashMap<>(ComponentType.values().length);
  }

  public Map<ComponentType, Map<String, List<Component>>> getComponentTypeValueMap() {
    Map<ComponentType, Map<String, List<Component>>> valueMap = new HashMap<>(
        ComponentType.values().length);

    for (ComponentType type : ComponentType.values()) {
      valueMap.put(type, getComponentValueMap(type));
    }

    return valueMap;
  }

  public void addResistors(List<Resistor> resistors) {
    addComponent(ComponentType.RESISTOR, resistors);
  }

  public void addCapacitors(List<Capacitor> capacitors) {
    addComponent(ComponentType.CAPACITOR, capacitors);
  }

  public void addTransistors(List<Transistor> transistors) {
    addComponent(ComponentType.TRANSISTOR, transistors);
  }

  public void addDiodes(List<Diode> diodes) {
    addComponent(ComponentType.DIODE, diodes);
  }

  public void addIntegratedCircuits(List<IntegratedCircuit> integratedCircuits) {
    addComponent(ComponentType.INTEGRATED_CIRCUIT, integratedCircuits);
  }

  public void addPotentiometers(List<Potentiometer> potentiometers) {
    addComponent(ComponentType.POTENTIOMETER, potentiometers);
  }

  public void addSwitches(List<Switch> switches) {
    addComponent(ComponentType.SWITCH, switches);
  }

  public void addTrimPots(List<TrimPot> trimPots) {
    addComponent(ComponentType.TRIM_POT, trimPots);
  }

  public List<Resistor> getResistors() {
    return (List<Resistor>) componentTypeMap.get(ComponentType.RESISTOR);
  }

  public List<Capacitor> getCapacitors() {
    return (List<Capacitor>) componentTypeMap.get(ComponentType.CAPACITOR);
  }

  public List<Transistor> getTransistors() {
    return (List<Transistor>) componentTypeMap.get(ComponentType.TRANSISTOR);
  }

  public List<Diode> getDiodes() {
    return (List<Diode>) componentTypeMap.get(ComponentType.DIODE);
  }

  public List<IntegratedCircuit> getIntegratedCircuits() {
    return (List<IntegratedCircuit>) componentTypeMap.get(ComponentType.INTEGRATED_CIRCUIT);
  }

  public List<Potentiometer> getPotentiometers() {
    return (List<Potentiometer>) componentTypeMap.get(ComponentType.POTENTIOMETER);
  }

  public List<Switch> getSwitches() {
    return (List<Switch>) componentTypeMap.get(ComponentType.SWITCH);
  }

  public List<TrimPot> getTrimPots() {
    return (List<TrimPot>) componentTypeMap.get(ComponentType.TRIM_POT);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (Map.Entry<ComponentType, Map<String, List<Component>>> componentTypeValue : getComponentTypeValueMap()
        .entrySet()) {
      if (!componentTypeValue.getValue().isEmpty()) {
        sb.append(componentTypeValue.getKey().getLabel())
            .append(System.lineSeparator())
            .append("--------------------")
            .append(System.lineSeparator());

        for (Map.Entry<String, List<Component>> componentValueMap : componentTypeValue.getValue()
            .entrySet()) {
          sb.append(componentValueMap.getValue().parallelStream().map(Component::getName)
              .collect(Collectors.joining(", ", "[", "]"))).append(" = ")
              .append(componentValueMap.getKey())
              .append(" X ").append(componentValueMap.getValue().size())
              .append(System.lineSeparator());
        }

        sb.append(System.lineSeparator());
      }
    }

    return sb.toString();
  }

  private Map<String, List<Component>> getComponentValueMap(ComponentType type) {
    return componentTypeMap.getOrDefault(type, Collections.emptyList()).parallelStream()
        .collect(Collectors.groupingBy(Component::getValue));
  }

  private void addComponent(ComponentType type, List<? extends Component> components) {
    componentTypeMap.put(type, components);
  }
}
