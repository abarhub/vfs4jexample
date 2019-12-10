package org.vfs4j.example.simple;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() throws IOException {
        Path p= Paths.get("./target/test");
        if(Files.exists(p)) {
            FileUtils.deleteDirectory(p.toFile());
        }
        assertFalse(Files.exists(p));
    }

    @Test
    void main() throws IOException {
        Main.main(null);
    }
}