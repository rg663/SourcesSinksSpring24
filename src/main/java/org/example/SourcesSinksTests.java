package org.example;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;

import java.util.Objects;

@RunWith(Enclosed.class)
public class SourcesSinksTests {
    public static class SinkTests {
        @Test
        @DisplayName("println() is indeed a sink")
        public void testHelloWorld() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("helloworld").get("<java.io.PrintStream: void println(java.lang.String)>");
            assert Objects.equals(printOutput, "SINK");
        }

        @Test
        @DisplayName("println() is indeed a sink")
        public void testBFS() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("bfs").get("<java.io.PrintStream: void println(java.lang.Object)>");
            assert Objects.equals(printOutput, "SINK");
        }

        @Test
        @DisplayName("write() is indeed a sink")
        public void testWriter() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("writerfiles").get("<java.io.Writer: void write(java.lang.String)>");
            assert Objects.equals(printOutput, "SINK");
        }

        @Test
        @DisplayName("URL init() is indeed a sink")
        public void testURL() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("urls").get("<java.net.URL: void <init>(java.lang.String)>");
            assert Objects.equals(printOutput, "SINK");
        }

        @Test
        @DisplayName("Process start() is indeed a sink")
        public void testProcessBuilder() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("processes").get("<java.lang.ProcessBuilder: java.lang.Process start()>");
            assert Objects.equals(printOutput, "SINK");
        }
    }

    public static class SourceTests {
        @Test
        @DisplayName("FileOutputStream init() is indeed a source")
        public void testOutputStream() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("readerfiles").get("<java.io.FileOutputStream: void <init>(java.lang.String)>");
            assert Objects.equals(printOutput, "SOURCE");
        }

        @Test
        @DisplayName("getInputStream() is indeed a source")
        public void testInputStream() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("urls").get("<java.net.URLConnection: java.io.InputStream getInputStream()>");
            assert Objects.equals(printOutput, "SOURCE");
        }

        @Test
        @DisplayName("URL openConnection() is indeed a source")
        public void testOpenConnection() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("urls").get("<java.net.URL: java.net.URLConnection openConnection()>");
            assert Objects.equals(printOutput, "SOURCE");
        }

        @Test
        @DisplayName("Get time zone is indeed a source")
        public void testTimeZone() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("calendar").get("<java.util.Calendar: java.util.TimeZone getTimeZone()>");
            assert Objects.equals(printOutput, "SOURCE");
        }

        @Test
        @DisplayName("getCountry() is indeed a source")
        public void testGetCountry() {
            String printOutput = SourcesAndSinksAnalysis.SourcesSinks("locale").get("<java.util.Locale: java.lang.String getCountry()>");
            assert Objects.equals(printOutput, "SOURCE");
        }
    }
}