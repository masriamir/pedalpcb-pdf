package com.akmcircuits.pedalpcb.pdf.model;

/**
 * Class representing a single PedalPCB pdf.
 */
public final class PedalPcbPdf {
    private final String name;
    private final String revision;
    private final Components components;

    public PedalPcbPdf(String name, String revision, Components components) {
        this.name = name;
        this.revision = revision;
        this.components = components;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append(System.lineSeparator())
                .append(revision)
                .append(System.lineSeparator())
                .append("====================")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(components)
                .toString();
    }

    public String getName() {
        return name;
    }

    public String getRevision() {
        return revision;
    }

    public Components getComponents() {
        return components;
    }
}
