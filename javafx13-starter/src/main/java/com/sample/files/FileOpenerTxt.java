package com.sample.files;

import com.sample.product.ProductRegister;
import com.sample.product.ProductRegisterParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOpenerTxt implements FileOpener {
  public ArrayList<String> readFile(String path) throws IOException {
    ArrayList<String> lines = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (!line.isEmpty()) {
          lines.add(line);
        }
      }
    }

    return lines;
  }

  @Override
  public ProductRegister readProductRegister(String path) throws IOException {
    return ProductRegisterParser.parse(readFile(path));
  }
}
