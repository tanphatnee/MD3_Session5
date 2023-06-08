import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checkemail {
    public static void main(String[] args) {
        // Tạo một đối tượng Scanner để nhận dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập địa chỉ email: ");
        String email = scanner.nextLine();

        // Mẫu regex để kiểm tra tính hợp lệ của địa chỉ email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Tạo một đối tượng Pattern từ mẫu regex
        Pattern pattern = Pattern.compile(emailRegex);

        // Tạo một đối tượng Matcher để so khớp địa chỉ email với mẫu regex
        Matcher matcher = pattern.matcher(email);

        // Kiểm tra xem địa chỉ email có khớp với mẫu regex hay không
        if (matcher.matches()) {
            System.out.println("Địa chỉ email hợp lệ.");
        } else {
            System.out.println("Địa chỉ email không hợp lệ.");
        }

        // Đóng đối tượng Scanner sau khi sử dụng xong
        scanner.close();
    }
}
