public class Interface {

    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        CSSstudent cssStudent = new CSSstudent();

        String[] stackList = programmer.getTechStack();
        for(String stack : stackList){
            System.out.println(stack+",");
        }
        stackList = cssStudent.getTechStack();
        for(String stack : stackList){
            System.out.println(stack+",");
        }

    }
}



interface Programmable{
    String[] getTechStack();
    void doProgramming();
}

class Programmer extends Person implements Programmable{
    String[] techStack = {"Java", "C", "Python"};

    Programmer(){
        this.doProgramming();
        this.sayJob();
    }

    @Override
    public String[] getTechStack() {
        return techStack;
    }

    @Override
    public void doProgramming() {
        System.out.println("저는 홈페이지 작업을 하고있어요.");
    }
    public void earnMoney(int money){

    }

    @Override
    void sayJob() {
        System.out.println("저는 프로그래머예요.");
    }
}

class CSSstudent extends Person implements Programmable {
    String[] techStack = {"CSS", "HTML5"};

    CSSstudent(){
        this.doProgramming();
        this.sayJob();
    }

    @Override
    public String[] getTechStack() {
        return techStack;
    }

    @Override
    public void doProgramming() {
        System.out.println("저는 홈페이지 작업을 하고있어요.");
    }

    @Override
    void sayJob() {
        System.out.println("저는 웹 디자이너예요.");
    }
}