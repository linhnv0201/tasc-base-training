package designpattern.factorymethod.demofactory;

public class Client {
  public static void main(String[] args) {
    Bank bank = BankFactory.getBank(BankType.TPBANK);
    System.out.println(bank.getBankName());
  }
}
