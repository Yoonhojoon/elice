package chapter3_1.practice3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Menu {
    static private final Map<String, Integer> menuMap = new HashMap<>();

    static public void execute(int instruction, String key, Integer value) {
        // 이곳에 답안을 작성해 주세요.

        // 0 은 메뉴 추가, 가격 수정
        if (instruction == 0 ){
            menuMap.put(key,value);
            return;
        }

        // 1 메뉴 삭제
        if (instruction == 1 ){
            menuMap.remove(key);
            return;
        }

        // 2 손님 주문
        Integer price = menuMap.get(key);

        if (!Objects.isNull(price)){
            System.out.println(price * value);
        }else {
            System.out.println(0);
        }

    }

    private Menu() {}
}
