package com.amirmasri.pedalpcb.pdf.extractor;

import com.amirmasri.pedalpcb.pdf.factory.ComponentFactory;
import com.amirmasri.pedalpcb.pdf.component.Component;
import com.amirmasri.pedalpcb.pdf.component.ComponentType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AbstractComponentExtractor<T extends Component> extends
    AbstractExtractor<T> implements ComponentExtractor<T> {
  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractComponentExtractor.class);

  private static final String REGEX_COMPONENT_BASE = "^(%s\\d+)\\s+(\\w+)";

  private final ComponentFactory<T> componentFactory;

  protected AbstractComponentExtractor(String regexBase, ComponentType type,
      ComponentFactory<T> componentFactory) {
    super(String.format(regexBase, type.getPrefix()), Pattern.MULTILINE);
    this.componentFactory = componentFactory;
  }

  protected AbstractComponentExtractor(ComponentType type, ComponentFactory<T> componentFactory) {
    this(REGEX_COMPONENT_BASE, type, componentFactory);
  }

  @Override
  public List<T> extract(String text) {
    List<T> components = new ArrayList<>();
    Matcher matcher = getRegex().matcher(text);

    while (matcher.find()) {
      String name = matcher.group(1);
      String value = sanitizeUnits(matcher.group(2));

      LOGGER.debug("found match {}={}", name, value);
      components.add(componentFactory.create(name, value));
    }

    LOGGER.debug("found {}", components.size());
    return components;
  }

  private String sanitizeUnits(String value) {
    return value
        .replace("nF", "n")
        .replace("uF", "u")
        .replace("pF", "p")
        .replace("R", "");
  }
}
