package com.akmcircuits.pedalpcb.pdf;

import com.akmcircuits.pedalpcb.pdf.exception.PedalPcbPdfException;
import com.akmcircuits.pedalpcb.pdf.factory.ComponentsFactory;
import com.akmcircuits.pedalpcb.pdf.model.Components;
import com.akmcircuits.pedalpcb.pdf.model.MultiPedalPcbPdf;
import com.akmcircuits.pedalpcb.pdf.model.PedalPcbPdf;
import com.akmcircuits.pedalpcb.pdf.util.DocumentUtils;
import com.akmcircuits.pedalpcb.pdf.extractor.StringExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PedalPcbPdfExtractor {
  private static final Logger LOGGER = LoggerFactory.getLogger(PedalPcbPdfExtractor.class);

  private static final String REGEX_NAME_BASE = "(Revision.*)\\s(.*)";
  private static final String REGEX_REVISION_BASE = "Revision\\s+.*";

  private static final StringExtractor EXTRACTOR_NAME = new StringExtractor(REGEX_NAME_BASE,
      Pattern.MULTILINE);
  private static final StringExtractor EXTRACTOR_REVISION = new StringExtractor(REGEX_REVISION_BASE,
      Pattern.MULTILINE);

  private static final ComponentsFactory COMPONENTS_FACTORY = new ComponentsFactory();

  public PedalPcbPdf extractPcb(String filePath) throws PedalPcbPdfException {
    PDDocument document = DocumentUtils.loadDocument(filePath);

    String documentText = DocumentUtils.extractDocumentText(document);
    LOGGER.debug("got document text {}", documentText);

    DocumentUtils.closeDocument(document);

    String name = EXTRACTOR_NAME.extract(documentText).get(2);
    String revision = EXTRACTOR_REVISION.extract(documentText).get(0);
    LOGGER.debug("found {}, Revision {}", name, revision);

    Components components = COMPONENTS_FACTORY.create(documentText);

    return new PedalPcbPdf(name, revision, components);
  }

  public MultiPedalPcbPdf extractPcbs(List<String> filePaths) throws PedalPcbPdfException {
    List<PedalPcbPdf> pcbPdfs = new ArrayList<>(filePaths.size());

    for (String filePath : filePaths) {
      pcbPdfs.add(extractPcb(filePath));
    }

    return new MultiPedalPcbPdf(pcbPdfs);
  }
}
