package com.example.demo.io;

import java.io.*;

/**
 * @author blindskipper
 */
public class FileStreamIOTest {

    public  final File file = new File("");
    private FileNameFilters nameFilters;

    public FileStreamIOTest() {
        this.nameFilters = new FileNameFilters(file);
    }

    public static void main(String[] args) throws IOException {
        final FileStreamIOTest streamIOTest = new FileStreamIOTest();
        final File[] files = streamIOTest.file.listFiles(streamIOTest.nameFilters);
        System.out.println(files.length);

        if (files.length == 0) {
            return;
        }

        InputStream in = new FileInputStream(streamIOTest.file);
        BufferedInputStream bf = new BufferedInputStream(in);
        int size;
        while ((size = bf.read(new byte[1024])) == -1) {
            System.out.println(size);
        }
    }

    static class FileNameFilters implements FilenameFilter {
        private File dir;

        public FileNameFilters(File path) {
            this.dir = path;
        }

        @Override
        public boolean accept(File dir, String name) {
            return dir.getPath().startsWith(name);
        }
    }
}
