package com.bigdataguide.hdfsclients;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * HDFS Client util.
 */
public class HDFSClientUtil {

    public static void createHDFSDir(FileSystem fs,Path src) throws Exception {
        try {
            fs.mkdirs(src);
            System.out.println("created: " + src);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fs.close();
        }
    }

    public static void renameHDFS(FileSystem fs,Path src, Path dest) throws IOException {

        if (fs.exists(dest)) {
            System.out.println("destination already exists" + dest);
            return;
        }
        try {
            fs.rename(src, dest);
            System.out.println("renamed: " + src +" to " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fs.close();
        }
    }

    public static void deleteHDFS(FileSystem fs,Path path) throws IOException {

        if (fs.exists(path)) {
            fs.delete(path, true);
        }
    }
}
