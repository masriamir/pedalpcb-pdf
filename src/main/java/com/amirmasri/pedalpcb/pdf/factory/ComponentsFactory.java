package com.amirmasri.pedalpcb.pdf.factory;

import com.amirmasri.pedalpcb.pdf.extractor.CapacitorExtractor;
import com.amirmasri.pedalpcb.pdf.extractor.DiodeExtractor;
import com.amirmasri.pedalpcb.pdf.extractor.IntegratedCircuitExtractor;
import com.amirmasri.pedalpcb.pdf.extractor.PotentiometerExtractor;
import com.amirmasri.pedalpcb.pdf.extractor.ResistorExtractor;
import com.amirmasri.pedalpcb.pdf.extractor.SwitchExtractor;
import com.amirmasri.pedalpcb.pdf.extractor.TransistorExtractor;
import com.amirmasri.pedalpcb.pdf.extractor.TrimPotExtractor;
import com.amirmasri.pedalpcb.pdf.model.Components;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ComponentsFactory {
  private static final Logger LOGGER = LoggerFactory.getLogger(ComponentFactory.class);

  private static final ResistorExtractor EXTRACTOR_RESISTOR = new ResistorExtractor();
  private static final CapacitorExtractor EXTRACTOR_CAPACITOR = new CapacitorExtractor();
  private static final TransistorExtractor EXTRACTOR_TRANSISTOR = new TransistorExtractor();
  private static final DiodeExtractor EXTRACTOR_DIODE = new DiodeExtractor();
  private static final IntegratedCircuitExtractor EXTRACTOR_INTEGRATED_CIRCUIT = new IntegratedCircuitExtractor();
  private static final PotentiometerExtractor EXTRACTOR_POTENTIOMETER = new PotentiometerExtractor();
  private static final SwitchExtractor EXTRACTOR_SWITCH = new SwitchExtractor();
  private static final TrimPotExtractor EXTRACTOR_TRIM_POT = new TrimPotExtractor();

  public Components create(String text) {
    Components components = new Components();

    components.addResistors(EXTRACTOR_RESISTOR.extract(text));
    LOGGER.debug("resistors = {}", components.getResistors());

    components.addCapacitors(EXTRACTOR_CAPACITOR.extract(text));
    LOGGER.debug("capacitors = {}", components.getCapacitors());

    components.addTransistors(EXTRACTOR_TRANSISTOR.extract(text));
    LOGGER.debug("transistors = {}", components.getTransistors());

    components.addDiodes(EXTRACTOR_DIODE.extract(text));
    LOGGER.debug("diodes = {}", components.getDiodes());

    components.addIntegratedCircuits(EXTRACTOR_INTEGRATED_CIRCUIT.extract(text));
    LOGGER.debug("integrated circuits = {}", components.getIntegratedCircuits());

    components.addPotentiometers(EXTRACTOR_POTENTIOMETER.extract(text));
    LOGGER.debug("potentiometers = {}", components.getPotentiometers());

    components.addSwitches(EXTRACTOR_SWITCH.extract(text));
    LOGGER.debug("switches = {}", components.getSwitches());

    components.addTrimPots(EXTRACTOR_TRIM_POT.extract(text));
    LOGGER.debug("trim pots = {}", components.getTrimPots());

    return components;
  }
}
