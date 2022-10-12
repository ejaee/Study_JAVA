class Tv {
    boolean power;
    int channel;

    void power() {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}
// 1. 각각의 기능을 class의 멤버로 생성한다

class CaptionTv extends Tv {
    boolean caption;
    void displayCaption (String text) {
        if (caption) {
            System.out.println(text);
        }
        else {
            System.out.println("turn on the caption");
        }
    }
}
// 2. 기능을 모두 가지는 하나의 객체를 생성한다

public class Main {
    public static void main(String[] args)
    {
        CaptionTv ctv = new CaptionTv();
//        자손 클래스의 인스턴스를 생성하면 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성된다
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println("pre channel : " + ctv.channel);
        ctv.displayCaption("The captions are working");
        ctv.caption = true;
        ctv.displayCaption("The captions are working");
        ctv.channelDown();
    }
}