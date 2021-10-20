package Ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Item09 {
    public static void main(String[] args) throws IOException {
        /**
         * Try-finally 보다 try-with-resource를 사용하라
         *
         * try-finally의 문제 ( Catch 시 close 메서드를 실패시키는)
         * 를 해결하는 AutoCloseable (해당 자원이 implement )
         * 닫을 자원이 존재한다면 AutoCloseable을 구현하도록 한다
         *
         * try-with-resource 를 이용하여 코드 가독성과 실속을 챙기자.
         */

        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
    // BAD CASE
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }
    // GOOD CASE
    static String firstLineOfFile2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

}

