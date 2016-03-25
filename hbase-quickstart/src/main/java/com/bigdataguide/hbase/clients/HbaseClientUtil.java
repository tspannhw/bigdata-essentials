package com.bigdataguide.hbase.clients;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.Arrays;

public class HbaseClientUtil {

  public static void listTables(HBaseAdmin admin) throws IOException {
    for (TableName name : admin.listTableNames()) {
      System.out.println(name.getNameAsString());
    }
  }

  public static void get(HBaseAdmin admin, String tableName, String row, String columnFamily,
      String qualifier) throws IOException {
    HTable table = new HTable(admin.getConfiguration(), tableName);
    try {
      Get get = new Get(row.getBytes());
      if ((columnFamily != null || columnFamily != "") && (qualifier == null || qualifier == ""))
        get.addFamily(columnFamily.getBytes());
      else if ((columnFamily != null || columnFamily != "")
          && (qualifier != null || qualifier != ""))
        get.addColumn(columnFamily.getBytes(), qualifier.getBytes());

      Result result = table.get(get);
      for (Cell cell : result.rawCells()) {
        System.out.println("CF: " + Arrays.toString(cell.getFamilyArray()));
        System.out.println("ROW: " + Arrays.toString(cell.getRowArray()));
        System.out.println("QUALIFIER: " + Arrays.toString(cell.getQualifierArray()));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      table.close();
    }
  }

  public static void put(HBaseAdmin admin, String tableName, String row, String colFamily, String qualifier, String value) throws IOException {
    HTable table = new HTable(admin.getConfiguration(), tableName);
    try {
      Put put = new Put(row.getBytes());
      put.add(colFamily.getBytes(), qualifier.getBytes(), value.getBytes());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      table.close();
    }
  }

  public static void deleteTable(HBaseAdmin admin, String tableName) throws Exception {
    admin.disableTable(tableName);
    admin.deleteTable(tableName);
    System.out.println("deleted the table " + tableName);
  }
}
