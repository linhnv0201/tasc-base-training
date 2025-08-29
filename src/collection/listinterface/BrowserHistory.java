package collection.listinterface;

import java.util.Stack;

public class BrowserHistory {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage;

    public BrowserHistory(String homepage) {
        currentPage = homepage;
        System.out.println("Trang hiện tại: " + currentPage);
    }

    // Truy cập trang mới
    public void visit(String url) {
        backStack.push(currentPage);   // lưu trang hiện tại vào backStack
        currentPage = url;
        forwardStack.clear();          // clear forward stack
        System.out.println("Truy cập: " + currentPage);
    }

    // Nhấn nút Back
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            System.out.println("Quay lại: " + currentPage);
        } else {
            System.out.println("Không thể quay lại, đã ở trang đầu tiên.");
        }
    }

    // Nhấn nút Forward
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("Đi tới: " + currentPage);
        } else {
            System.out.println("Không thể đi tới trang tiếp theo.");
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("TrangChu");

        browser.visit("Trang1");
        browser.visit("Trang2");
        browser.visit("Trang3");

        browser.back();     // Quay lại Trang2
        browser.back();     // Quay lại Trang1
        browser.forward();  // Đi tới Trang2

        browser.visit("Trang4"); // Truy cập Trang4, forwardStack bị clear
        browser.back();     // Quay lại Trang2
    }
}
