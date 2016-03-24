package com.bigdataguide.pig.filterfn;

import org.apache.pig.FilterFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;

import java.io.IOException;

public class isGoodPackage extends FilterFunc {

    @Override
    public Boolean exec(Tuple args) throws IOException {
        if (args == null || args.size() == 0) {
            return false;
        }
        try {
            Object object = args.get(0);
            if (object == null) {
                return false;
            }
            Double salary = (Double) object;
            return salary > 100.0 ? true : false;
        } catch (ExecException e) {
            throw new IOException(e);
        }
    }


}
