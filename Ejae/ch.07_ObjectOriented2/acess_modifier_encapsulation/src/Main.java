class Time {
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour) {
        if (isNotVaildHour(hour)) {
            System.out.println(hour + " is invalid number");
            return ;
        }

        this.hour = hour;
    }

    // 위 조건식에의한 메서드이므로 public 일 필요가 없다
    // private 로 코드를 짜면 코드 보수에 확인할 범위가 좁혀진다
    // 즉, class 범위 내에서만 확인하면 된다s
    private static boolean isNotVaildHour(int hour) {
        return hour < 0 || hour > 23;
    }

    public int getHour() {
        return hour;
    }
}

public class Main {
    public static void main(String[] args) {
        Time t = new Time();
//        t.hour = 30;
        t.setHour(21);
        System.out.println(t.getHour());
        t.setHour(40);
        System.out.println(t.getHour());
        // 메서드로 값을 받아오게 한다 -> 캡슐화
    }
}