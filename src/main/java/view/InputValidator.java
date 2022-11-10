package view;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private static Pattern PATTERN = Pattern.compile("^[1-45],[1-45],[1-45],[1-45],[1-45],[1-45]$");

    private InputValidator(){
    }

    public static int validateInt(String str){
        try {
            int stringToInt = Integer.parseInt(str);
            return stringToInt;
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수로 입력하해야 합니다.");
        }
    }

    public static void validatePrice(int price){
        if (price%1000!=0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    public static void validateLottoNumbers(String lottoNumbers) {
        if (!PATTERN.matcher(lottoNumbers).matches()) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자를 형식에 맞게 입력해야 합니다.");
        }
    }

    public static void validateDifferentLottoNumbers(List<Integer> lottoNumberList){
        Integer userNumberLen = Math.toIntExact(lottoNumberList.stream().distinct().count());
        if (userNumberLen!=6){
            throw new IllegalArgumentException("[ERROR] 중복없는 6가지 수로 입력해야 합니다.");
        }
    }

}