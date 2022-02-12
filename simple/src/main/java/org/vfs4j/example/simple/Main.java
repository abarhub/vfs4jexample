package org.vfs4j.example.simple;

import com.google.common.base.Verify;
import io.github.abarhub.vfs.core.api.VFS4JFiles;
import io.github.abarhub.vfs.core.api.path.VFS4JPathName;
import io.github.abarhub.vfs.core.api.path.VFS4JPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        LOGGER.info("main");

        int noTest = 1;

        if (args != null && args.length > 0) {
            if (Objects.equals(args[0], "test1")) {
                noTest = 1;
            } else if (Objects.equals(args[0], "test2")) {
                noTest = 2;
            }
        }

        if (noTest == 1) {
            test1();
        }

        LOGGER.info("Fin du programme");
    }

    private static void test1() throws IOException {

        VFS4JPathName file1 = VFS4JPaths.get("dir1", "fichier1.txt");
        VFS4JPathName file2 = VFS4JPaths.get("dir1", "fichier2.txt");
        byte[] buf = "abc".getBytes(StandardCharsets.UTF_8);
        VFS4JPathName file01 = VFS4JPaths.get("dir2", "fichier1.txt");
        VFS4JPathName file02 = VFS4JPaths.get("dir2", "fichier2.txt");

        // delet if exists
        VFS4JFiles.deleteIfExists(file1);
        VFS4JFiles.deleteIfExists(file2);
        VFS4JFiles.deleteIfExists(file01);
        VFS4JFiles.deleteIfExists(file02);

        // check not exist
        Verify.verify(!VFS4JFiles.exists(file1));
        Verify.verify(!VFS4JFiles.exists(file2));
        Verify.verify(!VFS4JFiles.exists(file01));
        Verify.verify(!VFS4JFiles.exists(file02));

        // create files
        VFS4JFiles.createFile(file1);
        LOGGER.info("create {}", file1);
        VFS4JFiles.write(file2, buf);
        LOGGER.info("create {}", file2);

        // check exist
        Verify.verify(VFS4JFiles.exists(file1));
        LOGGER.info("file {} exists", file1);
        Verify.verify(VFS4JFiles.exists(file2));
        LOGGER.info("file {} exists", file2);
        Verify.verify(!VFS4JFiles.exists(file01));
        Verify.verify(!VFS4JFiles.exists(file02));

        // copy
        LOGGER.info("copy from {} to {}", file1, file01);
        VFS4JFiles.copy(file1, file01);
        LOGGER.info("copy from {} to {}", file2, file02);
        VFS4JFiles.copy(file2, file02);

        // check copy exist
        Verify.verify(VFS4JFiles.exists(file01));
        LOGGER.info("file {} exists", file01);
        Verify.verify(VFS4JFiles.exists(file02));
        LOGGER.info("file {} exists", file02);

        byte[] buf2 = VFS4JFiles.readAllBytes(file02);
        Verify.verify(Arrays.equals(buf, buf2));
        LOGGER.info("files {} and {} are equals", file2, file02);
    }

}
