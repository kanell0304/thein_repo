package src.com.gjl.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMain4 {
    public static void main(String[] args) {

        ArrayList<String> products = new ArrayList<>();

        products.add("노트북");
        products.add("마우스");
        products.add("키보드");

        Scanner sc = new Scanner(System.in);

        System.out.print("검색어 입력: ");
        String keyword = sc.nextLine();

        if (products.contains(keyword)) {
            System.out.println("상품이 존재합니다.");
        } else {
            System.out.println("상품이 없습니다.");
        }

        sc.close();

    }
}
