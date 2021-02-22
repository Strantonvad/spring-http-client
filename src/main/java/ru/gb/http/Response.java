package ru.gb.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Response {
  private String httpVersion;
  private int statusCode;

  public Response(InputStream input) throws IOException {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
      String inputLine;
      inputLine = reader.readLine();

      parseStatusLine(inputLine);

      while ((inputLine = reader.readLine()) != null) {
        System.out.println(inputLine);
      }
    }
  }

  private void parseStatusLine(String line) {
    String[] tokens = line.split("\\s+");
    httpVersion = tokens[0];
    statusCode = Integer.parseInt(tokens[1]);
    System.out.println("httpVersion: " + httpVersion);
    System.out.println("statusCode: " + statusCode);
  }

}
