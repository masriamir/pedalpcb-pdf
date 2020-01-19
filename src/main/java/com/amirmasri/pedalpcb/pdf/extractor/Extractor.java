package com.amirmasri.pedalpcb.pdf.extractor;

import java.util.List;

interface Extractor<T> {
  List<T> extract(String text);
}
