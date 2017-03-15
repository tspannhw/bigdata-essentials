package com.needforcode.hbase.clients;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.util.Arrays;

/**
 * <arg1> operation. Ex: get , put
 * <arg2> table_name
 * <arg3> col_family
 * <arg4> column
 */
public class HbaseClient {
  
  private static String operation;
  private static String tableName;
  private static String columnFamily;
  private static String row;
  private static String qualifier;
  private static String value;
  
  public static void main(String[] args) throws Exception {
    
    System.out.println("Hbase Client started");

    validateAndPopulateArgs(args); // validate input args passed.
    
    Configuration conf = HBaseConfiguration.create();
    HBaseAdmin admin = new HBaseAdmin(conf);
    
    switch (operation) {
      case "list": HbaseClientUtil.listTables(admin); admin.close();
               break;
      case "delete": HbaseClientUtil.deleteTable(admin, tableName); admin.close();
               break;
      case "get" : HbaseClientUtil.get(admin, tableName, row, columnFamily, qualifier); admin.close();
               break;
      case "put" : HbaseClientUtil.put(admin, tableName, row, columnFamily, qualifier, value); admin.close();
               break;
      default: admin.close(); throw new Exception("Invalid operator");
  }
  }

  private static void validateAndPopulateArgs(String[] args) throws Exception {
    if (args.length == 0) throw new Exception("Usage: ");
    else if (!Arrays.asList("list","delete","get","put").contains(args[0])) throw new Exception("operation not permitted");
    
    operation = args[0];
    switch (args[0]) {
      case "list": if (args.length !=1) throw new Exception("Usage:");
               break;
      case "delete": if (args.length != 2) throw new Exception("Usage: ");
               break;
      case "get" : if (args.length !=5) throw new Exception("Usage: ");
               break;
      case "put" : if (args.length !=6) throw new Exception("Usage: ");
  }
  }
}
