package com.akmcircuits.pedalpcb.pdf.extractor;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringExtractorTests {
  private static final String REGEX_REVISION_SUCCESS = "(Revision\\s+)(.*)";
  private static final String REGEX_REVISION_FAIL = "revision.*";

  private static String text = null;

  @BeforeAll
  public static void initAll() {
    text = "Copyright © 2019 - PedalPCB.com 1\n"
        + "Revision 12.27.19\n"
        + "Provocateur Fuzz\n"
        + "All trademarks and registered trademarks are the property of their respective owners. The company, product, and service names used in \n"
        + "this web site are for identification purposes only. Use of these names, logos, and brands does not imply endorsement.\n"
        + "Controls\n"
        + "•\t Volume\n"
        + "•\t Gain\n"
        + "•\t Treble\n"
        + "•\t Bass/Mids\n"
        + "•\t Spark/Flame\t(Toggle\tSwitch)\n"
        + "Copyright © 2019 - PedalPCB.com 2\n"
        + "RESISTORS\t(1/4W)\n"
        + "R1        1M    \n"
        + "R2        120K  \n"
        + "R3        2K2   \n"
        + "R4        12K   \n"
        + "R6        10K   \n"
        + "R7        2K7   \n"
        + "R8        2K    \n"
        + "R9        330K  \n"
        + "R10       10K   \n"
        + "R11       1M    \n"
        + "R12       39K   \n"
        + "R13       10K   \n"
        + "R17       1K    \n"
        + "R100     4K7   \n"
        + "Provocateur Fuzz\n"
        + "Parts List\n"
        + "Common offboard components (enclosure, footswitch, jacks, etc) are not listed\n"
        + "CAPACITORS\n"
        + "C1        220n  \n"
        + "C2        22u   \n"
        + "C3        30n   \n"
        + "C4        22u   \n"
        + "C5        20n   \n"
        + "C6        4u7   \n"
        + "C7        2u2   \n"
        + "C8        1n    \n"
        + "C9        1u    \n"
        + "C100     22u   \n"
        + "TRANSISTORS\n"
        + "Q1        BS170 \n"
        + "Q2        BS170 \n"
        + "Q3        2N5457\n"
        + "INTEGRATED\tCIRCUITS\n"
        + "IC1   TL072  \n"
        + "IC2   TL072  \n"
        + "DIODES\n"
        + "D1 9V1   \n"
        + "D100     1N5817\n"
        + "POTENTIOMETERS\n"
        + "VOL       A100K \n"
        + "GAIN      C10K  \n"
        + "TREBLE    A100K \n"
        + "BASS/MIDS B100K \n"
        + "SWITCHES\n"
        + "SW1       SPDT (ON/ON)\n"
        + "Copyright © 2019 - PedalPCB.com 3\n"
        + "P\n"
        + "ro\n"
        + "v\n"
        + "o\n"
        + "ca\n"
        + "te\n"
        + "u\n"
        + "r \n"
        + "F\n"
        + "u\n"
        + "zz\n"
        + "Copyright © 2019 - PedalPCB.com 4\n"
        + "Provocateur Fuzz\n"
        + "Wiring Diagram\n"
        + "Copyright © 2019 - PedalPCB.com 5\n"
        + "Provocateur Fuzz\n"
        + "Drill Template\n"
        + "125B Enclosure";
  }

  @AfterAll
  public static void tearDownAll() {
    text = null;
  }

  @Test
  public void extractRevisionSuccessTest() {
    StringExtractor extractor = new StringExtractor(REGEX_REVISION_SUCCESS, Pattern.MULTILINE);
    List<String> revisions = extractor.extract(text);
    Assertions.assertNotNull(revisions);
    Assertions.assertFalse(revisions.isEmpty());
    Assertions.assertEquals(3, revisions.size());
    Assertions.assertEquals("Revision 12.27.19", revisions.get(0));
    Assertions.assertEquals("Revision ", revisions.get(1));
    Assertions.assertEquals("12.27.19", revisions.get(2));
  }

  @Test
  public void extractRevisionFailTest() {
    StringExtractor extractor = new StringExtractor(REGEX_REVISION_FAIL, Pattern.MULTILINE);
    List<String> revisions = extractor.extract(text);
    Assertions.assertNotNull(revisions);
    Assertions.assertTrue(revisions.isEmpty());
  }
}
