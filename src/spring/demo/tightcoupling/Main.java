package spring.demo.tightcoupling;

import spring.demo.tightcoupling.Client;

public class Main {
  public static void main(String[] args) {
  Client client = new Client();
  client.processMessage("Hello there");
  }
}
