import kotlinInAction.chapter2.StringFunctions;
import kotlinInAction.chapter3.Demo3_3Kt;

import java.util.ArrayList;
import java.util.List;

/**
 * java调用kotlin代码示例
 */
public class JavaCallKotlin {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(StringFunctions.joinToString(list));

        char c = Demo3_3Kt.lastChar("Java");
    }
}
