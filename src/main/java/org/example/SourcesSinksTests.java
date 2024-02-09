package org.example;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.Objects;

public class SourcesSinksTests {
    @Test
    @DisplayName("Println is indeed a sink")
    public void testHelloWorld() {
        String printOutput = SourcesAndSinksAnalysis.SourcesSinks("helloworld").get("<java.io.PrintStream: void println(java.lang.String)>");
        assert Objects.equals(printOutput, "SINK");
    }
    @Test
    @DisplayName("BFS is indeed a sink")
    public void testBFS() {
        String printOutput = SourcesAndSinksAnalysis.SourcesSinks("bfs").get("<java.io.PrintStream: void println(java.lang.Object)>");
        System.out.println(SourcesAndSinksAnalysis.SourcesSinks("bfs"));
        assert Objects.equals(printOutput, "SINK");
    }
    @Test
    @DisplayName("Output stream is indeed a source")
    public void testFileWriter() {
        String printOutput = SourcesAndSinksAnalysis.SourcesSinks("readerfiles").get("<java.io.FileOutputStream: void <init>(java.lang.String)>");
        assert Objects.equals(printOutput, "SOURCE");
    }
    @Test
    @DisplayName("Write is indeed a sink")
    public void testWriter() {
        String printOutput = SourcesAndSinksAnalysis.SourcesSinks("writerfiles").get("<java.io.Writer: void write(java.lang.String)>");
        assert Objects.equals(printOutput, "SINK");
    }
    @Test
    @DisplayName("URL init is indeed a sink")
    public void testURL() {
        String printOutput = SourcesAndSinksAnalysis.SourcesSinks("urls").get("<java.net.URL: void <init>(java.lang.String)>");
        assert Objects.equals(printOutput, "SINK");
    }
}