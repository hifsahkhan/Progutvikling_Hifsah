package com.sample.files;

import com.sample.product.ProductRegister;

import java.io.IOException;

public interface FileSaver {
  void writeProductRegister(String path, ProductRegister register) throws IOException;
}
