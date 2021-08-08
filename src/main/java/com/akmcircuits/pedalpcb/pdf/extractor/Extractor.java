package com.akmcircuits.pedalpcb.pdf.extractor;

import java.util.List;

interface Extractor<T> {
  List<T> extract(String text);
}
