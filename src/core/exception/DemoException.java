package core.exception;

class DemoException {

    // khai báo throws → caller biết method có thể ném Exception
    void checkNumber(int n) throws Exception {
        if (n < 0) {
            // throw → ném exception cụ thể
            throw new Exception("Negative number not allowed: " + n);
        } else {
            System.out.println("Number is: " + n);
        }
    }
}
