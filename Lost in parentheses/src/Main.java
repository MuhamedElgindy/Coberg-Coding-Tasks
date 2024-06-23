import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public boolean LostInParentheses(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }
//        System.out.println("Number of difference parantheses: "+cnt);
        if (cnt == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {

        List<String> inputs = new ArrayList<String>();
        Main result = new Main();
        int numTestCase = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Test Cases: ");
        numTestCase = sc.nextInt();

        sc.nextLine();
        System.out.println("Please Enter Parentheses: ");
        for(int i=0; i<numTestCase; i++){
            String str = sc.nextLine();
            inputs.add(str);
        }
//        System.out.println(inputs);
        for(String inp: inputs){
//            System.out.println(inp);
            System.out.println(result.LostInParentheses(inp));
        }
    }
}
