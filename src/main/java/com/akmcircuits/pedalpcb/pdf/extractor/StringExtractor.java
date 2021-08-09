package com.akmcircuits.pedalpcb.pdf.extractor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

public final class StringExtractor extends AbstractExtractor<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringExtractor.class);

    public StringExtractor(String regexString) {
        super(regexString);
    }

    public StringExtractor(String regexString, int flags) {
        super(regexString, flags);
    }

    @Override
    public List<String> extract(String text) {
        Matcher matcher = getRegex().matcher(text);

        if (matcher.find()) {
            LOGGER.debug("found {} matches", matcher.groupCount());
            List<String> matches = new ArrayList<>(matcher.groupCount());

            for (int i = 0; i <= matcher.groupCount(); i++) {
                LOGGER.debug("found match {}", matcher.group(i));
                matches.add(matcher.group(i));
            }

            return matches;
        }

        LOGGER.debug("found no matches");
        return Collections.emptyList();
    }
}
