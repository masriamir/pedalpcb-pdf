package com.akmcircuits.pedalpcb.pdf.model;

import com.akmcircuits.pedalpcb.pdf.component.Component;
import com.akmcircuits.pedalpcb.pdf.component.ComponentType;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class representing multiple PedalPCB pdfs.
 */
public final class MultiPedalPcbPdf {
    private final List<PedalPcbPdf> pcbPdfs;

    public MultiPedalPcbPdf(List<PedalPcbPdf> pcbPdfs) {
        this.pcbPdfs = pcbPdfs;
    }

    public void printBOM() {
        System.out.println("Bill of Materials");
        System.out.println("====================");
        System.out.println();
        System.out.println();

        for (ComponentType type : ComponentType.values()) {
            aggregateComponents(type);
            System.out.println();
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (PedalPcbPdf pcbPdf : pcbPdfs) {
            sb.append(pcbPdf).append(System.lineSeparator());
        }

        return sb.toString();
    }

    private void aggregateComponents(ComponentType type) {
        Map<String, List<Component>> allComponentTypeValuesMap = new TreeMap<>();

        for (PedalPcbPdf pcb : pcbPdfs) {
            Map<String, List<Component>> componentTypeValueMap = pcb.getComponents()
                    .getComponentTypeValueMap().get(type);

            componentTypeValueMap.forEach((componentValue, componentList) -> allComponentTypeValuesMap
                    .merge(componentValue, componentList,
                            (oldList, newList) -> Stream.concat(oldList.stream(), newList.stream())
                                    .collect(Collectors.toList())));
        }

        System.out.println(type.getLabel());
        System.out.println("--------------------");

        allComponentTypeValuesMap
                .forEach((key, value) -> System.out.println(String.format("%-8s\t%d", key, value.size())));
    }

    public List<PedalPcbPdf> getPcbPdfs() {
        return pcbPdfs;
    }
}
