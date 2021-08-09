package com.akmcircuits.pedalpcb.pdf.extractor;

import java.util.regex.Pattern;

abstract class AbstractExtractor<T> implements Extractor<T> {
    private final Pattern regex;

    protected AbstractExtractor(String regexString, int flags) {
        this.regex = constructRegexFromString(regexString, flags);
    }

    protected AbstractExtractor(String regexString) {
        this(regexString, -1);
    }

    private Pattern constructRegexFromString(String regexString, int flags) {
        if (flags == -1) {
            return Pattern.compile(regexString);
        } else {
            return Pattern.compile(regexString, flags);
        }
    }

    protected Pattern getRegex() {
        return regex;
    }
}
