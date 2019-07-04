/*
    接口实现（代理模式设计）
 */


//声明一个接口School  定义 以下方法
interface School{
    public void make() ;

}

class Teacher implements School {
    public void make() {
        System.out.println("老师正在教学生 。");
    }
}

class ProxySchool implements School {
    private School school ;

    // 要接收一个真实主题的操作对象
    public ProxySchool(School school) {
        this.school = school ;
    }

    public void prepare() {
        System.out.println("start learniing。");
    }

    public void make() {
        this.prepare();
        this.school.make();
        this.destroy();
    }

    public void destroy() {
        System.out.println("stop learning。");
    }
}

public class Demo7 {
    public static void main(String args[]) {
        // 定义 一个 School 接口的 ProxySchool 的对象，接收Teacher() 对象
        School sc = new ProxySchool(new Teacher()) ;

        //调用的是代理的操作方法
        sc.make();

    }
}

