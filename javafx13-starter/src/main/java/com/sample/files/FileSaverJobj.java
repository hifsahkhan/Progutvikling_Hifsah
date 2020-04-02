package com.sample.files;

import com.sample.product.ProductRegister;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSaverJobj implements FileSaver {
  @Override
  public void writeProductRegister(String path, ProductRegister register) throws IOException {
    OutputStream os = Files.newOutputStream(Paths.get(path));
    ObjectOutputStream out = new ObjectOutputStream(os);
    out.writeObject(register);
  }
}
