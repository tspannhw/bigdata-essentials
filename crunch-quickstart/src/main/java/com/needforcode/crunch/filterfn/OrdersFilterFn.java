package com.needforcode.crunch.filterfn;

import org.apache.avro.generic.GenericData.Record;
import org.apache.crunch.FilterFn;

public class OrdersFilterFn extends FilterFn<Record> {

  private static final long serialVersionUID = 1L;

  @Override
  public boolean accept(Record record) {
    if(Integer.parseInt(record.get("order_item_quantity").toString()) > 1) {
    return true;
    }
    return false;
  }

}
