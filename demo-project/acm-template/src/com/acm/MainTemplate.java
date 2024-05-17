import java.util.Scanner;

/**
 * ACM 输入模版
 * @author 请输入作者
 */
public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int n = scanner.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int sum = 0;
            for(int num : arr){
                sum += num;
            }

            System.out.println("请输入输出内容="+sum);
        }
        scanner.close();
    }
}