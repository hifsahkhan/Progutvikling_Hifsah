package com.sample.files;

import com.sample.product.ProductRegister;
import com.sample.product.ProductRegisterFormatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSaverTxt implements FileSaver {
  public void writeFile(String path, String str) throws IOException {
    Files.write(Paths.get(path), str.getBytes());
  }

  @Override
  public void writeProductRegister(String path, ProductRegister register) throws IOException {
    writeFile(path, ProductRegisterFormatter.formater(register));
  }
}
