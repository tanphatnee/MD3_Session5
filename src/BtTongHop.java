import java.util.Scanner;

public class BtTongHop {
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3}, // Mảng 1
                {4, 5, 6}, // Mảng 2
                {7, 8, 9}  // Mảng 3
        };
        Scanner scanner = new Scanner(System.in); // Khởi tạo đối tượng Scanner để đọc dữ liệu từ người dùng
        int choice;
        do {
            System.out.println("------ MENU ------");
            System.out.println("1. Hiển thị 3 mảng số nguyên");
            System.out.println("2. Hiển thị mảng được gộp từ 2 mảng số nguyên");
            System.out.println("3. Hiển thị mảng được gộp từ 3 mảng số nguyên");
            System.out.println("4. Chọn 1 mảng số nguyên để in ra");
            System.out.println("5. Thêm phần tử vào mảng được chọn");
            System.out.println("6. Xóa phần tử khỏi mảng được chọn");
            System.out.println("7. Dừng chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt(); // Đọc lựa chọn từ người dùng
            switch (choice) {
                case 1:
                    displayArrays(arrays); // Hiển thị 3 mảng số nguyên
                    break;
                case 2:
                    displayMergedArray(arrays, scanner); // Hiển thị mảng được gộp từ 2 mảng số nguyên
                    break;
                case 3:
                    displayMergedArray(arrays); // Hiển thị mảng được gộp từ 3 mảng số nguyên
                    break;
                case 4:
                    int arrayChoice = selectArray(scanner); // Chọn mảng số nguyên để in ra
                    if (arrayChoice >= 1 && arrayChoice <= arrays.length) {
                        displayArray(arrays[arrayChoice - 1]); // In ra mảng được chọn
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 5:
                    arrayChoice = selectArray(scanner); // Chọn mảng số nguyên để thêm phần tử vào
                    if (arrayChoice >= 1 && arrayChoice <= arrays.length) {
                        arrays[arrayChoice - 1] = addElement(arrays[arrayChoice - 1], scanner); // Thêm phần tử vào mảng được chọn
                        displayArray(arrays[arrayChoice - 1]); // Hiển thị mảng sau khi thêm phần tử
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 6:
                    arrayChoice = selectArray(scanner); // Chọn mảng số nguyên để xóa phần tử khỏi
                    if (arrayChoice >= 1 && arrayChoice <= arrays.length) {
                        arrays[arrayChoice - 1] = removeElement(arrays[arrayChoice - 1], scanner); // Xóa phần tử khỏi mảng được chọn
                        displayArray(arrays[arrayChoice - 1]); // Hiển thị mảng sau khi xóa phần tử
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;
                case 7:
                    System.out.println("Đã dừng chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
            System.out.println();
        } while (choice != 7);
    }

    private static void displayArrays(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("Mảng " + (i + 1) + ": ");
            displayArray(arrays[i]); // Hiển thị mảng số nguyên
        }
    }

    private static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " "); // Hiển thị các phần tử trong mảng
        }
        System.out.println();
    }

    private static void displayMergedArray(int[][] arrays, Scanner scanner) {
        System.out.println("Chọn mảng để gộp (1 - Mảng 1, 2 - Mảng 2): ");
        int mergeChoice = scanner.nextInt(); // Chọn mảng để gộp
        if (mergeChoice == 1 || mergeChoice == 2) {
            int[] mergedArray = arrays[mergeChoice - 1];
            displayArray(mergedArray); // Hiển thị mảng được gộp
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void displayMergedArray(int[][] arrays) {
        int[] mergedArray = new int[arrays.length * arrays[0].length];
        int index = 0;

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                mergedArray[index] = arrays[i][j];
                index++;
            }
        }
        displayArray(mergedArray); // Hiển thị mảng được gộp
    }

    private static int selectArray(Scanner scanner) {
        System.out.println("Chọn mảng (1 - Mảng 1, 2 - Mảng 2, 3 - Mảng 3): ");
        return scanner.nextInt(); // Chọn mảng số nguyên
    }

    private static int[] addElement(int[] array, Scanner scanner) {
        System.out.print("Nhập phần tử mới: ");
        int element = scanner.nextInt(); // Nhập phần tử mới
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element; // Thêm phần tử mới vào cuối mảng
        System.out.println("Phần tử đã được thêm vào mảng.");
        return newArray;
    }

    private static int[] removeElement(int[] array, Scanner scanner) {
        System.out.print("Nhập vị trí phần tử muốn xóa: ");
        int index = scanner.nextInt(); // Nhập vị trí phần tử muốn xóa
        if (index >= 0 && index < array.length) {
            int[] newArray = new int[array.length - 1];
            int newIndex = 0;

            for (int i = 0; i < array.length; i++) {
                if (i != index) {
                    newArray[newIndex] = array[i];
                    newIndex++;
                }
            }
            System.out.println("Phần tử đã được xóa khỏi mảng.");
            return newArray; // Trả về mảng mới sau khi xóa phần tử
        } else {
            System.out.println("Vị trí không hợp lệ!");
            return array;
        }
    }
}
