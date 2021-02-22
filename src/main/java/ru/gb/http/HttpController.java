package ru.gb.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {

  @GetMapping("/page")
  public String getRequest() {
    return "GET request received!";
  }

  @PostMapping("/page")
  public String postRequest() {
    return "POST request received!";
  }

}
