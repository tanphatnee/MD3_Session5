import java.util.Scanner;

public class Cactutrongchuoi {
    public static void main(String[] args) {
        // Tạo một đối tượng Scanner để đọc dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String inputString = scanner.nextLine();

        // Sử dụng phương thức split() để tách các từ trong chuỗi
        String[] words = inputString.split(" ");

        System.out.println("Các từ trong chuỗi:");

        // In từng từ trên một dòng
        for (String word : words) {
            System.out.println(word);
        }

        // Đóng đối tượng Scanner sau khi sử dụng xong
        scanner.close();
    }
}
