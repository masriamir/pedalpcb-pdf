package com.akmcircuits.pedalpcb.pdf.util;

import com.akmcircuits.pedalpcb.pdf.exception.PedalPcbPdfException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DocumentUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(DocumentUtils.class);

  private DocumentUtils() {
  }

  public static PDDocument loadDocument(String filePath) throws PedalPcbPdfException {
    LOGGER.info("loading document {}", filePath);

    try {
      PDDocument document = PDDocument.load(Paths.get(filePath).toFile());
      AccessPermission permission = document.getCurrentAccessPermission();

      if (!permission.canExtractContent()) {
        throw new PedalPcbPdfException("invalid permissions to read document");
      }

      return document;
    } catch (IOException e) {
      throw new PedalPcbPdfException("unable to load document", e);
    }
  }

  public static String extractDocumentText(PDDocument document) throws PedalPcbPdfException {
    if (document.isEncrypted()) {
      throw new PedalPcbPdfException("cannot extract text from encrypted document");
    }

    PDFTextStripper stripper;

    try {
      stripper = new PDFTextStripper();
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
      throw new PedalPcbPdfException("unable to create new PDFTextStripper", e);
    }

    stripper.setStartPage(1);
    stripper.setEndPage(document.getNumberOfPages());

    try {
      return stripper.getText(document);
    } catch (IOException e) {
      LOGGER.error(e.getMessage(), e);
      throw new PedalPcbPdfException("unable to extract text from document", e);
    }
  }

  public static void closeDocument(PDDocument document) {
    try {
      document.close();
    } catch (IOException e) {
      LOGGER.warn(e.getMessage(), e);
    }
  }
}
