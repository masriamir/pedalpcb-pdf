package com.amirmasri.pedalpcb.pdf;

import com.amirmasri.pedalpcb.pdf.exception.PedalPcbPdfException;
import com.amirmasri.pedalpcb.pdf.model.MultiPedalPcbPdf;
import com.amirmasri.pedalpcb.pdf.model.PedalPcbPdf;
import java.util.Arrays;

public class Main {
  private static final PedalPcbPdfExtractor EXTRACTOR = new PedalPcbPdfExtractor();

  public static void main(String[] args) {
    if (args.length < 1) {
      System.err.println("Invalid arguments.");
      System.err.println("Usage: java -jar pedalpcb-pdf.jar filename1 [filename2, ...]");
      System.exit(1);
    }

    try {
      if (args.length == 1) {
        PedalPcbPdf pcb = EXTRACTOR.extractPcb(args[0]);
        System.out.println(pcb);
      } else {
        MultiPedalPcbPdf pcbs = EXTRACTOR.extractPcbs(Arrays.asList(args));
        pcbs.printBOM();
      }
    } catch (PedalPcbPdfException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }

    System.exit(0);
  }
}
