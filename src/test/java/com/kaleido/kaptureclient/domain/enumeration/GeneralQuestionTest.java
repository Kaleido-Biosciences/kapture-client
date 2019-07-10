/*
 * Copyright (c) 2019. Kaleido Biosciences. All Rights Reserved
 */

package com.kaleido.kaptureclient.domain.enumeration;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralQuestionTest {

    @Test
    public void fromString() {
        assertEquals(GeneralQuestion.NA, GeneralQuestion.fromString("NA"));
        assertEquals(GeneralQuestion.NA, GeneralQuestion.fromString("na"));
        assertEquals(GeneralQuestion.NA, GeneralQuestion.fromString("n/a"));
        assertEquals(GeneralQuestion.NA, GeneralQuestion.fromString("N/A"));

        assertEquals(GeneralQuestion.No, GeneralQuestion.fromString("No"));
        assertEquals(GeneralQuestion.No, GeneralQuestion.fromString("NO"));
        assertEquals(GeneralQuestion.No, GeneralQuestion.fromString("no"));
        assertEquals(GeneralQuestion.No, GeneralQuestion.fromString("false"));
        assertEquals(GeneralQuestion.No, GeneralQuestion.fromString("FALSE"));
        assertEquals(GeneralQuestion.No, GeneralQuestion.fromString("f"));
        assertEquals(GeneralQuestion.No, GeneralQuestion.fromString("F"));

        assertEquals(GeneralQuestion.Yes, GeneralQuestion.fromString("T"));
        assertEquals(GeneralQuestion.Yes, GeneralQuestion.fromString("t"));
        assertEquals(GeneralQuestion.Yes, GeneralQuestion.fromString("true"));
        assertEquals(GeneralQuestion.Yes, GeneralQuestion.fromString("TRUE"));
        assertEquals(GeneralQuestion.Yes, GeneralQuestion.fromString("yes"));
        assertEquals(GeneralQuestion.Yes, GeneralQuestion.fromString("YES"));
        assertEquals(GeneralQuestion.Yes, GeneralQuestion.fromString("Yes"));

        assertEquals(GeneralQuestion.UNKNOWN, GeneralQuestion.fromString("UNKNOWN"));
        assertEquals(GeneralQuestion.UNKNOWN, GeneralQuestion.fromString("unknown"));
        assertEquals(GeneralQuestion.UNKNOWN, GeneralQuestion.fromString(""));
        assertEquals(GeneralQuestion.UNKNOWN, GeneralQuestion.fromString(null));

        assertEquals(GeneralQuestion.Other, GeneralQuestion.fromString("Other"));
        assertEquals(GeneralQuestion.Other, GeneralQuestion.fromString("OTHER"));
        assertEquals(GeneralQuestion.Other, GeneralQuestion.fromString("foo"));
    }
}