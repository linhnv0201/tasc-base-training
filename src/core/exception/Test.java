//package core.exception;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.io.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class Test {
//
//  // 1. Đọc file (có thể ném FileNotFoundException)
//  static void readFile(String fileName) throws FileNotFoundException   {
//    Scanner sc = new Scanner(new File(fileName)); // Checked Exception
//    System.out.println("File content:");
//    while (sc.hasNextLine()) {
//      System.out.println(sc.nextLine());
//    }
//    sc.close();
//  }
//
//  // xử lý exception trong method thì k cần throws
//  static void readFile2(String fileName) throws FileNotFoundException   {
//    try{
//    Scanner sc = new Scanner(new File(fileName)); // Checked Exception
//    System.out.println("File content:");
//    while (sc.hasNextLine()) {
//      System.out.println(sc.nextLine());
//    }} catch (FileNotFoundException e){
//      System.out.println(e.getMessage());
//    }
//  }
//
//  public static void main(String[] args) {
//    try {
//      // Thử đọc file không tồn tại
//      readFile("abc.txt");
//    } catch (FileNotFoundException e) {
//      System.out.println("❌ Lỗi đọc file: " + e.getMessage());
//    }
//    readFile2("a.txt");
//    System.out.println("✅ Program continues...");
//  }
//}
