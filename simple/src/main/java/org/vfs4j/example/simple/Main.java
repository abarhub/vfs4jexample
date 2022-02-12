package org.vfs4j.example.simple;

import com.google.common.base.Verify;
import io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager;
import io.github.abarhub.vfs.core.api.VFS4JFileManager;
import io.github.abarhub.vfs.core.api.path.VFS4JPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        LOGGER.info("main");
        Path path1 = Paths.get("./target/test/dir1");
        Files.createDirectories(path1);
        Path path2 = Paths.get("./target/test/dir2");
        Files.createDirectories(path2);
        Path file1 = path1.resolve("fichier1.txt");
        Path file2 = path2.resolve("fichier2.txt");

        Files.deleteIfExists(file1);
        Files.deleteIfExists(file2);

        Verify.verify(!Files.exists(file1));
        Verify.verify(!Files.exists(file2));

        VFS4JFileManager fileManager = VFS4JDefaultFileManager.get();
        fileManager.getCommand().createFile(VFS4JPaths.get("dir1", "fichier1.txt"));
        fileManager.getCommand().createFile(VFS4JPaths.get("dir2", "fichier2.txt"));

        Verify.verify(Files.exists(file1));
        Verify.verify(Files.exists(file2));

        LOGGER.info("OK");
    }

}
