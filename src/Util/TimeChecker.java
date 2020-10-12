package Util;

public class TimeChecker {

    private static long start = 0;

    public static void setStartTime() {
        start = System.currentTimeMillis(); //시작하는 시점 계산
    }

    public static void printEndTime() {
        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "sec"); //실행 시간 계산 및 출력
    }
}
