package com.needforcode.crunch.dofn;

import org.apache.avro.generic.GenericData.Record;
import org.apache.crunch.DoFn;
import org.apache.crunch.Emitter;
import org.apache.crunch.Pair;

public class OrderTotalDoFn extends DoFn<Pair<String,Iterable<Pair<Record,Record>>>,Pair<String,Double>>{

  private static final long serialVersionUID = 1L;
  
  double total = 0.0;

  @Override
  public void process(Pair<String, Iterable<Pair<Record, Record>>> input,
      Emitter<Pair<String, Double>> emitter) {
    System.out.println(input.second());
      for(Pair<Record,Record> it: input.second()) {
        if (it.first().get("order_item_subtotal") != null)
        total = total + Double.parseDouble(it.first().get("order_item_subtotal").toString());
          //emitter.emit(new Pair<String, Record>(input.first(),it.second()));
          //break;
      }
      emitter.emit(new Pair<String, Double>(input.first(), total));
      }
    }
