/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain.enumeration;

import java.util.Arrays;

/**
 * The GeneralQuestion enumeration.
 */
public enum GeneralQuestion {
    Yes, No, NA, Other, UNKNOWN;

    public static GeneralQuestion fromString(String text) {

        //check if it's a match ignoring case
        return Arrays.stream(GeneralQuestion.values())
                .filter(val -> val.name().equalsIgnoreCase(text))
                .findFirst()
                .orElseGet(() -> { //otherwise try these synonyms
                    if (text == null || text.isEmpty() || text.equalsIgnoreCase("unknown")) {
                        return GeneralQuestion.UNKNOWN;
                    } else if (text.equalsIgnoreCase("true") || text.equalsIgnoreCase("t")) {
                        return GeneralQuestion.Yes;
                    } else if (text.equalsIgnoreCase("false") || text.equalsIgnoreCase("f")) {
                        return GeneralQuestion.No;
                    } else if (text.equalsIgnoreCase("n/a") || text.equalsIgnoreCase("na")) {
                        return GeneralQuestion.NA;
                    } else {
                        return GeneralQuestion.Other;
                    }
                });
    }

}
