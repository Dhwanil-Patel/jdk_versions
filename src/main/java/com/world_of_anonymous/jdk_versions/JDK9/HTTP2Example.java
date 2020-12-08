package com.world_of_anonymous.jdk_versions.JDK9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTP2Example {
  public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("//howtodoinjava.com/")).GET().build();
//    HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
//    System.out.println(httpResponse.body());
//    if(httpResponse.isDone()) {
//      System.out.println(httpResponse.get().statusCode());
//      System.out.println(httpResponse.get().body());
//    } else {
//      httpResponse.cancel(true);
//    }
  }
}
