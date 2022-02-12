package org.vfs4j.example.simple;

import com.google.common.base.Verify;
import io.github.abarhub.vfs.core.api.VFS4JDefaultFileManager;
import io.github.abarhub.vfs.core.api.VFS4JFileManager;
import io.github.abarhub.vfs.core.api.VFS4JFiles;
import io.github.abarhub.vfs.core.api.path.VFS4JPathName;
import io.github.abarhub.vfs.core.api.path.VFS4JPaths;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

    @BeforeEach
    void setUp() throws IOException {
        Path p= Paths.get("./target/test");
        if(Files.exists(p)) {
            FileUtils.deleteDirectory(p.toFile());
        }
        assertFalse(Files.exists(p));
    }

    @Test
    void test1() throws IOException{

        LOGGER.info("test1");
        Path path1 = Paths.get("./workspace/dir1");
        Files.createDirectories(path1);
        Path path2 = Paths.get("./workspace/dir2");
        Files.createDirectories(path2);
        Path file1 = path1.resolve("fichier1.txt");
        Path file2 = path2.resolve("fichier2.txt");

        Files.deleteIfExists(file1);
        Files.deleteIfExists(file2);

        Verify.verify(!Files.exists(file1));
        Verify.verify(!Files.exists(file2));

        VFS4JFileManager fileManager = VFS4JDefaultFileManager.get();
        VFS4JPathName vfile1=VFS4JPaths.get("dir1", "fichier1.txt");
        VFS4JPathName vfile2=VFS4JPaths.get("dir2", "fichier2.txt");
        fileManager.getCommand().createFile(vfile1);
        fileManager.getCommand().createFile(vfile2);

        Verify.verify(Files.exists(file1));
        Verify.verify(Files.exists(file2));

        LOGGER.info("OK");
    }

    @Test
    void test2() throws IOException{

        LOGGER.info("test2");
        Path path1 = Paths.get("./workspace/dir1");
        Files.createDirectories(path1);
        Path path2 = Paths.get("./workspace/dir2");
        Files.createDirectories(path2);
        Path file1 = path1.resolve("fichier1.txt");
        Path file2 = path2.resolve("fichier2.txt");

        Files.deleteIfExists(file1);
        Files.deleteIfExists(file2);

        Verify.verify(!Files.exists(file1));
        Verify.verify(!Files.exists(file2));

        VFS4JPathName vfile1=VFS4JPaths.get("dir1", "fichier1.txt");
        VFS4JPathName vfile2=VFS4JPaths.get("dir2", "fichier2.txt");
        VFS4JFiles.createFile(vfile1);
        VFS4JFiles.createFile(vfile2);

        Verify.verify(Files.exists(file1));
        Verify.verify(Files.exists(file2));

        LOGGER.info("OK");
    }
}