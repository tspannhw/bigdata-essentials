package com.bigdataguide.crunch.mapfn;

import org.apache.avro.generic.GenericData.Record;
import org.apache.crunch.MapFn;
import org.apache.crunch.Pair;

public class OrderItemsMapFn extends MapFn<Record,Pair<String,Record>>{

  private static final long serialVersionUID = 1L;

  @Override
  public Pair<String, Record> map(Record record) {
    return new Pair<String, Record>(record.get("order_item_order_id").toString(), record);
  }

}
