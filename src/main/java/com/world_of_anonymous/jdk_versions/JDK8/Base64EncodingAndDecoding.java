package com.world_of_anonymous.jdk_versions.JDK8;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64EncodingAndDecoding {
  public static void main(String[] args) {
    String str = "username:password";
    Base64.Encoder encoder = Base64.getEncoder();
    String encodedStr = encoder.encodeToString(str.getBytes(StandardCharsets.UTF_8));
    System.out.println(encodedStr);
    Base64.Decoder decoder = Base64.getDecoder();
    System.out.println(new String(decoder.decode(encodedStr)));

    // Don’t want to directly work with data and rather prefer to work with streams, you can wrap the output stream
    Path originalPath = Paths.get(".", "temp1.txt");
    Path targetPath = Paths.get(".", "temp2.txt");
    Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
    try (OutputStream out = Files.newOutputStream(targetPath)) {
      Files.copy(originalPath, mimeEncoder.wrap(out));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
