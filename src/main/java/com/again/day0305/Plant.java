package com.again.day0305;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plant {

    private int consumeCount = 0;
    private Logger logger = Logger.getLogger("Plant");

    public int getConsumeCount() {
        return consumeCount;
    }

    public void consumeMolecule(StringBuffer molecules){

        String CO2 = molecules.substring(0,3);
        molecules.delete(0,3);

        Pattern pattern = Pattern.compile("C");
        Matcher matcher = pattern.matcher(CO2);

        int countC = 0;
        while (matcher.find()) {
            countC++;
        }

        pattern = Pattern.compile("O");
        matcher = pattern.matcher(CO2);

        int countO = 0;
        while (matcher.find()) {
            countO++;
        }

        if (!(countO == 2 && countC == 1)) {
            throw new IllegalArgumentException("Contain Wrong C02 Molecule");
        }

        logger.log(Level.INFO, "광합성 완료");
        consumeCount++;
    }

}