import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                k = k * 10 + c - '0';
            } else if (c == '['){
                countStack.push(k);
                stringStack.push(currentString);
                k = 0;
                currentString = new StringBuilder();
            } else if (c == ']'){
                StringBuilder decodedString = stringStack.pop();
                int currK = countStack.pop();
                while(currK > 0){
                    decodedString.append(currentString);
                    currK--;
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
