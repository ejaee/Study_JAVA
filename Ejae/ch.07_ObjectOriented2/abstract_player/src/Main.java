abstract class Player {
    abstract void play(int pos);
    abstract void stop();
}

// 추상 클래스는 상속을 통해 완성해야 객체 생성이 가능
class AudioPlayer extends Player {
    // 추상클래스를 상속 받았으면 모든 추상 메서드를 구현해야 한다!
    void play(int pos) {
        System.out.println(pos + "위치 부터 play 합니다.");
    }
    void stop() {
        System.out.println("재생을 멈춥니다.");
    }
}

public class Main {
    public static void main(String[] args) {
//        Player p = new Player(); ERROR
        AudioPlayer ap = new AudioPlayer();
        ap.play(100);
        ap.stop();
        System.out.println();
        // Player 는 리모컨이다! 다형성!
        Player p = new AudioPlayer();
        p.play(50);
        p.stop();



    }
}