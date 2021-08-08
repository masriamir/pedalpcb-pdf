package com.akmcircuits.pedalpcb.pdf;

import com.akmcircuits.pedalpcb.pdf.exception.PedalPcbPdfException;
import com.akmcircuits.pedalpcb.pdf.model.MultiPedalPcbPdf;
import com.akmcircuits.pedalpcb.pdf.model.PedalPcbPdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MultiPedalPcbPdfExtractorTests {
  private static PedalPcbPdfExtractor extractor = null;
  private static List<File> pdfs = null;

  @BeforeAll
  public static void initAll() {
    extractor = new PedalPcbPdfExtractor();
    pdfs = new ArrayList<>(2);
    pdfs.add(new File(
        Objects.requireNonNull(
            MultiPedalPcbPdfExtractorTests.class.getClassLoader().getResource("provocateur.pdf")).getFile()));
    pdfs.add(new File(
        Objects.requireNonNull(
            MultiPedalPcbPdfExtractorTests.class.getClassLoader().getResource("cracklejack.pdf")).getFile()));
  }

  @AfterAll
  public static void tearDownAll() {
    extractor = null;
    pdfs = null;
  }

  @Test
  public void extractPcbsTest() throws PedalPcbPdfException {
    MultiPedalPcbPdf pcbs = extractor.extractPcbs(
        pdfs.parallelStream().map(File::getAbsolutePath).collect(Collectors.toList()));
    Assertions.assertNotNull(pcbs);

    List<PedalPcbPdf> pcbPdfs = pcbs.getPcbPdfs();
    Assertions.assertNotNull(pcbPdfs);
    Assertions.assertFalse(pcbPdfs.isEmpty());
    Assertions.assertEquals(2, pcbPdfs.size());

    pcbs.printBOM();
    System.out.println(pcbs);
  }
}
