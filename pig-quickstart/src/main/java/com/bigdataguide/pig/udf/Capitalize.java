package com.bigdataguide.pig.udf;

import org.apache.commons.lang.WordUtils;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

import java.io.IOException;

/*
  input: john smith
  output: John Smith
 */
public class Capitalize extends EvalFunc<String> {

    public String exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0)
            return null;
        try {
            String str = (String) input.get(0);
            String capStr = WordUtils.capitalize(str);
            return capStr;

        } catch (Exception e) {
            throw new IOException(e);
        }
    }

}
