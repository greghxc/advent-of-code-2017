package org.hacksy.util;

import com.google.common.collect.Lists;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
    static public List<Integer> fileToList(File file) {
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            return stream.map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            return Lists.newArrayList();
        }
    }

    static public List<String> fileToStringList(File file) {
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {
            return stream.collect(Collectors.toList());
        } catch (Exception e) {
            return Lists.newArrayList();
        }
    }
}
