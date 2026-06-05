package src.com.gjl.finalClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyMain3 {
    public static void main(String[] args) {

        // 로컬 PC를 기준으로, 날짜를 출력
        LocalDate myLocalDate = LocalDate.now();
        System.out.println(myLocalDate);

        // 로컬 PC를 기준으로, 시간을 출력
        LocalTime myLocalTime = LocalTime.now();
        System.out.println(myLocalTime);

        // 로컬 PC를 기준으로, 날짜와 시간을 출력
        LocalDateTime myLocalDateTime = LocalDateTime.now();
        System.out.println(myLocalDateTime);

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy년 MM월 dd알 HH:mm:ss");
        String str = myLocalDateTime.format(myFormat);
        System.out.println(str);

    }
}
