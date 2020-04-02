package com.sample.files;

import com.sample.product.ProductRegister;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOpenerJobj implements FileOpener {
  @Override
  public ProductRegister readProductRegister(String path) throws IOException, ClassNotFoundException {
    InputStream is = Files.newInputStream(Paths.get(path));
    ObjectInputStream in = new ObjectInputStream(is);
    return (ProductRegister) in.readObject();
  }
}
