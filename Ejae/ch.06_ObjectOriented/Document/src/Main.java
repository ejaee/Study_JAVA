class Document {
    static int count = 0;
    String name;

    // 문서 제목을 입력하지 않았을 경우
    Document() {
        this("제목없음" + ++count);
    }

    Document(String name) {
        this.name = name;
        System.out.println("문서 " + this.name + " 이(가) 생성되었습니다.");
    }
}

class Main {
    public static void main(String[] args) {
        Document d1 = new Document();
        Document d2 = new Document("test.java");
        Document d3 = new Document();
        Document d4 = new Document();
    }
}