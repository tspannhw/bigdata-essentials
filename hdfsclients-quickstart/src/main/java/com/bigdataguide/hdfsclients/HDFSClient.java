package com.bigdataguide.hdfsclients;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * HDFS Java Client
 *
 */
public class HDFSClient
{

    static Path destPath;
    static FileSystem fs;

    public static void main( String[] args ) throws Exception {
        if(!(args.length==2 || args.length == 3)){
            System.out.println("Use HDFSClient <src> <dest>");
            System.exit(-1);
        }
        String command = args[0];
        Path srcPath = new Path(args[1]);
        if (args.length == 3)
        destPath = new Path(args[2]);

        fs = FSUtil.getDFS();

        switch (command) {
            case "mkdir":
                HDFSClientUtil.createHDFSDir(fs,srcPath);
                break;
            case "rename":
                HDFSClientUtil.renameHDFS(fs,srcPath,destPath);
                break;
            case "delete":
                HDFSClientUtil.deleteHDFS(fs,srcPath);
                break;
            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }
}
