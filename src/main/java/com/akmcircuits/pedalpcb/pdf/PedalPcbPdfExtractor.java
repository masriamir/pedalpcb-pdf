package com.akmcircuits.pedalpcb.pdf;

import com.akmcircuits.pedalpcb.pdf.exception.PedalPcbPdfException;
import com.akmcircuits.pedalpcb.pdf.extractor.StringExtractor;
import com.akmcircuits.pedalpcb.pdf.factory.ComponentsFactory;
import com.akmcircuits.pedalpcb.pdf.model.Components;
import com.akmcircuits.pedalpcb.pdf.model.MultiPedalPcbPdf;
import com.akmcircuits.pedalpcb.pdf.model.PedalPcbPdf;
import com.akmcircuits.pedalpcb.pdf.util.DocumentUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class PedalPcbPdfExtractor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PedalPcbPdfExtractor.class);

    /**
     * Regex string to extract pedal name.
     */
    private static final String REGEX_NAME_BASE = "(Revision.*)\\s(.*)";

    /**
     * Regex string to extract build document revision.
     */
    private static final String REGEX_REVISION_BASE = "(?:Revision.*) (.*)";

    private static final StringExtractor EXTRACTOR_NAME = new StringExtractor(REGEX_NAME_BASE, Pattern.MULTILINE);
    private static final StringExtractor EXTRACTOR_REVISION = new StringExtractor(REGEX_REVISION_BASE, Pattern.MULTILINE);

    private static final ComponentsFactory COMPONENTS_FACTORY = new ComponentsFactory();

    public PedalPcbPdf extractPcb(String filePath) throws PedalPcbPdfException {
        PDDocument document = DocumentUtils.loadDocument(filePath);
        String documentText = DocumentUtils.extractDocumentText(document);

        DocumentUtils.closeDocument(document);

        List<String> names = EXTRACTOR_NAME.extract(documentText);
        List<String> revisions = EXTRACTOR_REVISION.extract(documentText);

        if (names.isEmpty() || revisions.isEmpty()) {
            throw new PedalPcbPdfException("unable to identify pedal");
        }

        String name = names.get(2);
        String revision = revisions.get(1);
        LOGGER.info("found {}, Revision {}", name, revision);

        Components components = COMPONENTS_FACTORY.create(documentText);

        return new PedalPcbPdf(name, revision, components);
    }

    public MultiPedalPcbPdf extractPcbs(List<String> filePaths) throws PedalPcbPdfException {
        List<PedalPcbPdf> pcbPdfs = new ArrayList<>(filePaths.size());
        List<String> successFiles = new ArrayList<>();
        List<String> errorFiles = new ArrayList<>();

        for (String filePath : filePaths) {
            try {
                pcbPdfs.add(extractPcb(filePath));
                successFiles.add(filePath);
            } catch (Exception e) {
                LOGGER.warn("error parsing document: {}", e.getMessage());
                errorFiles.add(filePath);
            }
        }

        LOGGER.info("successfully parsed {} documents: {}", successFiles.size(), successFiles);
        LOGGER.info("failed to parse {} documents: {}", errorFiles.size(), errorFiles);

        return new MultiPedalPcbPdf(pcbPdfs);
    }
}
