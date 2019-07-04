/*
    类的继承
*/

class People{
    private String name ;
    private int age ;

    public void setName(String name) {
        this.name = name ;
    }
    public void setAge(int age) {
        this.age = age ;
    }

    public String getName() {
        return this.name ;
    }
    public int getAge() {
        return age ;
    }

}
//  Boy 继承 People
class Boy extends People{
    private String young ;
    public void setYoung(String young) {
        this.young = young ;
    }

    public String getYoung() {
        return this.young ;
    }

}

// Child 继承 Boy
class Child extends Boy{
    private String school ;

    public void setSchool(String school) {
        this.school = school ;
    }

    public String getSchool() {
        return this.school ;
    }
}

public class Demo3 {
    public static void main(String args[]) {
        Boy bb = new Boy() ;
        bb.setName("Vic");
        bb.setAge(20) ;
        bb.setYoung("青年");

        System.out.println("姓名：" + bb.getName() + " 年龄：" + bb.getAge() + " 归属：" + bb.getYoung());


        Child cc = new Child() ;
        cc.setName("Tor") ;
        cc.setAge(16) ;
        cc.setYoung("少年") ;
        cc.setSchool("高中");
        System.out.println("姓名：" + cc.getName() + " 年龄：" + cc.getAge() + " 归属：" + cc.getYoung() + " 学校：" + cc.getSchool());

    }

}
