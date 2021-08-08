package com.akmcircuits.pedalpcb.pdf;

import com.akmcircuits.pedalpcb.pdf.exception.PedalPcbPdfException;
import com.akmcircuits.pedalpcb.pdf.model.Components;
import com.akmcircuits.pedalpcb.pdf.model.PedalPcbPdf;
import com.akmcircuits.pedalpcb.pdf.component.Capacitor;
import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.component.Diode;
import com.akmcircuits.pedalpcb.pdf.component.IntegratedCircuit;
import com.akmcircuits.pedalpcb.pdf.component.Potentiometer;
import com.akmcircuits.pedalpcb.pdf.component.Resistor;
import com.akmcircuits.pedalpcb.pdf.component.Switch;
import com.akmcircuits.pedalpcb.pdf.component.Transistor;
import java.io.File;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PedalPcbPdfExtractorTests {
  private static PedalPcbPdfExtractor extractor = null;
  private static File pdf = null;

  @BeforeAll
  public static void initAll() {
    extractor = new PedalPcbPdfExtractor();
    pdf = new File(
        Objects.requireNonNull(
            PedalPcbPdfExtractorTests.class.getClassLoader().getResource("provocateur.pdf")).getFile());
  }

  @AfterAll
  public static void tearDownAll() {
    extractor = null;
    pdf = null;
  }

  @Test
  public void extractPcbTest() throws PedalPcbPdfException {
    PedalPcbPdf pcb = extractor.extractPcb(pdf.getPath());
    Assertions.assertNotNull(pcb);

    Components components = pcb.getComponents();
    Assertions.assertNotNull(pcb.getComponents());

    List<Resistor> resistors = components.getResistors();
    Assertions.assertNotNull(resistors);
    Assertions.assertFalse(resistors.isEmpty());
    Assertions.assertEquals(14, resistors.size());
    Assertions.assertEquals(ComponentType.RESISTOR, resistors.get(0).getType());

    List<Capacitor> capacitors = components.getCapacitors();
    Assertions.assertNotNull(capacitors);
    Assertions.assertFalse(capacitors.isEmpty());
    Assertions.assertEquals(10, capacitors.size());
    Assertions.assertEquals(ComponentType.CAPACITOR, capacitors.get(0).getType());

    List<Transistor> transistors = components.getTransistors();
    Assertions.assertNotNull(transistors);
    Assertions.assertFalse(transistors.isEmpty());
    Assertions.assertEquals(3, transistors.size());
    Assertions.assertEquals(ComponentType.TRANSISTOR, transistors.get(0).getType());

    List<Diode> diodes = components.getDiodes();
    Assertions.assertNotNull(diodes);
    Assertions.assertFalse(diodes.isEmpty());
    Assertions.assertEquals(2, diodes.size());
    Assertions.assertEquals(ComponentType.DIODE, diodes.get(0).getType());

    List<IntegratedCircuit> integratedCircuits = components.getIntegratedCircuits();
    Assertions.assertNotNull(integratedCircuits);
    Assertions.assertFalse(integratedCircuits.isEmpty());
    Assertions.assertEquals(2, integratedCircuits.size());
    Assertions.assertEquals(ComponentType.INTEGRATED_CIRCUIT, integratedCircuits.get(0).getType());

    List<Potentiometer> potentiometers = components.getPotentiometers();
    Assertions.assertNotNull(potentiometers);
    Assertions.assertFalse(potentiometers.isEmpty());
    Assertions.assertEquals(4, potentiometers.size());

    List<Switch> switches = components.getSwitches();
    Assertions.assertNotNull(switches);
    Assertions.assertFalse(switches.isEmpty());
    Assertions.assertEquals(1, switches.size());
    Assertions.assertEquals(ComponentType.SWITCH, switches.get(0).getType());

    System.out.println(pcb);
  }
}
