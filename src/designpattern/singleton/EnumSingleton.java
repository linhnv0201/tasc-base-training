package designpattern.singleton;
// Khi dùng enum thì các params chỉ được khởi tạo 1 lần duy nhất, đây cũng là cách giúp bạn tạo ra
// Singleton instance.
// Lưu ý:
//
// Enum có thể sử dụng như một Singleton, nhưng nó có nhược điểm là không thể extends từ một lớp
// được, nên khi sử dụng cần xem xét vấn đề này.
// Hàm constructor của enum là lazy, nghĩa là khi được sử dụng mới chạy hàm khởi tạo và nó chỉ chạy
// duy nhất một lần. Nếu muốn sử dụng như một eager singleton thì cần gọi thực thi trong một static
// block khi start chương trình.
// So sánh giữa 2 cách sử dụng enum initialization và static block initialization method, enum có
// một điểm rất mạnh khi giải quyết về vấn đề Serialization/ Deserialization.
public enum EnumSingleton {
  INSTANCE;
}
