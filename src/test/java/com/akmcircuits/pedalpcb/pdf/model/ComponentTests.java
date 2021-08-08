package com.akmcircuits.pedalpcb.pdf.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.akmcircuits.pedalpcb.pdf.component.Capacitor;
import com.akmcircuits.pedalpcb.pdf.component.Diode;
import com.akmcircuits.pedalpcb.pdf.component.Resistor;
import com.akmcircuits.pedalpcb.pdf.component.Transistor;
import com.akmcircuits.pedalpcb.pdf.component.ComponentType;
import com.akmcircuits.pedalpcb.pdf.component.IntegratedCircuit;
import com.akmcircuits.pedalpcb.pdf.component.Potentiometer;
import com.akmcircuits.pedalpcb.pdf.component.Switch;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComponentTests {
  private static Resistor r1 = null;
  private static Resistor r2 = null;
  private static Resistor r3 = null;

  private static Capacitor c1 = null;
  private static Capacitor c2 = null;
  private static Capacitor c3 = null;

  private static Transistor q1 = null;
  private static Transistor q2 = null;
  private static Transistor q3 = null;

  private static Diode d1 = null;
  private static Diode d2 = null;
  private static Diode d3 = null;

  private static IntegratedCircuit ic1 = null;
  private static IntegratedCircuit ic2 = null;
  private static IntegratedCircuit ic3 = null;

  private static Potentiometer p1 = null;
  private static Potentiometer p2 = null;
  private static Potentiometer p3 = null;

  private static Switch sw1 = null;
  private static Switch sw2 = null;
  private static Switch sw3 = null;

  @BeforeAll
  public static void initAll() {
    r1 = new Resistor("R1", "2K2");
    r2 = new Resistor("R8", "100R");
    r3 = new Resistor("R1", "2K2");

    c1 = new Capacitor("C3", "10U");
    c2 = new Capacitor("C100", "47p");
    c3 = new Capacitor("C3", "1U");

    q1 = new Transistor("Q1", "2N2907A");
    q2 = new Transistor("Q2", "2N3906");
    q3 = new Transistor("Q100", "2N2907A");

    d1 = new Diode("D1", "1N4001");
    d2 = new Diode("D100", "1N394A");
    d3 = new Diode("D101", "1N4001");

    ic1 = new IntegratedCircuit("IC1", "LM741");
    ic2 = new IntegratedCircuit("IC200", "JRC2068");
    ic3 = new IntegratedCircuit("IC2", "LM741");

    p1 = new Potentiometer("P1", "B25K");
    p2 = new Potentiometer("P2", "A100K");
    p3 = new Potentiometer("P3", "B25K");

    sw1 = new Switch("SW1", "SPDT");
    sw2 = new Switch("SW2", "DPDT");
    sw3 = new Switch("SW3", "SPDT");
  }

  @AfterAll
  public static void tearDownAll() {
    r1 = null;
    r2 = null;
    r3 = null;

    c1 = null;
    c2 = null;
    c3 = null;

    q1 = null;
    q2 = null;
    q3 = null;

    d1 = null;
    d2 = null;
    d3 = null;

    ic1 = null;
    ic2 = null;
    ic3 = null;

    p1 = null;
    p2 = null;
    p3 = null;

    sw1 = null;
    sw2 = null;
    sw3 = null;
  }

  @Test
  public void resistorEqualityTest() {
    assertEquals(r1.getType(), ComponentType.RESISTOR);
    assertEquals(r2.getType(), ComponentType.RESISTOR);
    assertEquals(r3.getType(), ComponentType.RESISTOR);
    assertEquals(r1, r1);
    assertEquals(r1.hashCode(), r1.hashCode());
    assertEquals(r1, r3);
    assertEquals(r1.hashCode(), r3.hashCode());
    assertNotEquals(r1, r2);
    assertNotEquals(r1.hashCode(), r2.hashCode());
    assertNotEquals(r1, c1);
    assertNotEquals(r1.hashCode(), c1.hashCode());
    assertNotEquals(r1, q1);
    assertNotEquals(r1, d1);
    assertNotEquals(r1, ic1);
    assertNotEquals(r1, p1);
    assertNotEquals(r1, sw1);
  }

  @Test
  public void capacitorEqualityTest() {
    assertEquals(c1.getType(), ComponentType.CAPACITOR);
    assertEquals(c2.getType(), ComponentType.CAPACITOR);
    assertEquals(c3.getType(), ComponentType.CAPACITOR);
    assertEquals(c1, c1);
    assertEquals(c1.hashCode(), c1.hashCode());
    assertNotEquals(c1, c3);
    assertNotEquals(c1.hashCode(), c3.hashCode());
    assertNotEquals(c1, c2);
    assertNotEquals(c1.hashCode(), c2.hashCode());
    assertNotEquals(c1, r1);
    assertNotEquals(c1, q1);
    assertNotEquals(c1.hashCode(), q1.hashCode());
    assertNotEquals(c1, d1);
    assertNotEquals(c1, ic1);
    assertNotEquals(c1, p1);
    assertNotEquals(c1, sw1);
  }

  @Test
  public void transistorEqualityTest() {
    assertEquals(q1.getType(), ComponentType.TRANSISTOR);
    assertEquals(q2.getType(), ComponentType.TRANSISTOR);
    assertEquals(q3.getType(), ComponentType.TRANSISTOR);
    assertEquals(q1, q1);
    assertEquals(q1.hashCode(), q1.hashCode());
    assertEquals(q1, q3);
    assertEquals(q1.hashCode(), q3.hashCode());
    assertNotEquals(q1, q2);
    assertNotEquals(q1.hashCode(), q2.hashCode());
    assertNotEquals(q1, r1);
    assertNotEquals(q1.hashCode(), r1.hashCode());
    assertNotEquals(q1, c1);
    assertNotEquals(q1, d1);
    assertNotEquals(q1, ic1);
    assertNotEquals(q1, p1);
    assertNotEquals(q1, sw1);
  }

  @Test
  public void diodeEqualityTest() {
    assertEquals(d1.getType(), ComponentType.DIODE);
    assertEquals(d2.getType(), ComponentType.DIODE);
    assertEquals(d3.getType(), ComponentType.DIODE);
    assertEquals(d1, d1);
    assertEquals(d1.hashCode(), d1.hashCode());
    assertEquals(d1, d3);
    assertEquals(d1.hashCode(), d3.hashCode());
    assertNotEquals(d1, d2);
    assertNotEquals(d1.hashCode(), d2.hashCode());
    assertNotEquals(d1, r1);
    assertNotEquals(d1.hashCode(), r1.hashCode());
    assertNotEquals(d1, c1);
    assertNotEquals(d1, q1);
    assertNotEquals(d1, ic1);
    assertNotEquals(d1, p1);
    assertNotEquals(d1, sw1);
  }

  @Test
  public void integratedCircuitEqualityTest() {
    assertEquals(ic1.getType(), ComponentType.INTEGRATED_CIRCUIT);
    assertEquals(ic2.getType(), ComponentType.INTEGRATED_CIRCUIT);
    assertEquals(ic3.getType(), ComponentType.INTEGRATED_CIRCUIT);
    assertEquals(ic1, ic1);
    assertEquals(ic1.hashCode(), ic1.hashCode());
    assertEquals(ic1, ic3);
    assertEquals(ic1.hashCode(), ic3.hashCode());
    assertNotEquals(ic1, ic2);
    assertNotEquals(ic1.hashCode(), ic2.hashCode());
    assertNotEquals(ic1, r1);
    assertNotEquals(ic1.hashCode(), r1.hashCode());
    assertNotEquals(ic1, c1);
    assertNotEquals(ic1, q1);
    assertNotEquals(ic1, d1);
    assertNotEquals(ic1, p1);
    assertNotEquals(ic1, sw1);
  }

  @Test
  public void potentiometerEqualityTest() {
    assertEquals(p1.getType(), ComponentType.POTENTIOMETER);
    assertEquals(p2.getType(), ComponentType.POTENTIOMETER);
    assertEquals(p3.getType(), ComponentType.POTENTIOMETER);
    assertEquals(p1, p1);
    assertEquals(p1.hashCode(), p1.hashCode());
    assertEquals(p1, p3);
    assertEquals(p1.hashCode(), p3.hashCode());
    assertNotEquals(p1, p2);
    assertNotEquals(p1.hashCode(), p2.hashCode());
    assertNotEquals(p1, r1);
    assertNotEquals(p1.hashCode(), r1.hashCode());
    assertNotEquals(p1, c1);
    assertNotEquals(p1, q1);
    assertNotEquals(p1, ic1);
    assertNotEquals(p1, d1);
    assertNotEquals(p1, sw1);
  }

  @Test
  public void switchEqualityTest() {
    assertEquals(sw1.getType(), ComponentType.SWITCH);
    assertEquals(sw2.getType(), ComponentType.SWITCH);
    assertEquals(sw3.getType(), ComponentType.SWITCH);
    assertEquals(sw1, sw1);
    assertEquals(sw1.hashCode(), sw1.hashCode());
    assertEquals(sw1, sw3);
    assertEquals(sw1.hashCode(), sw3.hashCode());
    assertNotEquals(sw1, sw2);
    assertNotEquals(sw1.hashCode(), sw2.hashCode());
    assertNotEquals(sw1, r1);
    assertNotEquals(sw1.hashCode(), r1.hashCode());
    assertNotEquals(sw1, c1);
    assertNotEquals(sw1, q1);
    assertNotEquals(sw1, ic1);
    assertNotEquals(sw1, d1);
    assertNotEquals(sw1, p1);
  }
}
