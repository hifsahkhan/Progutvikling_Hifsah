package com.sample.files;

import com.sample.product.ProductRegister;

import java.io.IOException;

public interface FileOpener {
  ProductRegister readProductRegister(String path) throws IOException, ClassNotFoundException;
}
