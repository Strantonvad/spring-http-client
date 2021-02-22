package ru.gb.http;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpClient {

  public static void main(String[] args) throws IOException {
    sendRequest("localhost", 8080, "POST");
  }

  public static void sendRequest(String host, int port, String method) throws IOException {
    try(Socket socket = new Socket(host, port)) {
      String sb = method + " /page HTTP/1.1" + "\r\n" +
          "Host: " + host +":" + port + "\r\n" +
          "Accept: " + "text/plain;charset=UTF-8" + "\r\n" +
          "Connection: " + "close" + "\r\n" +
          "Content-Type: " + "text/plain;charset=UTF-8" + "\r\n" +
          "\r\n";
      socket.getOutputStream().write(sb.getBytes(StandardCharsets.UTF_8));
      socket.getOutputStream().flush();

      new Response(socket.getInputStream());
    }
  }
}
