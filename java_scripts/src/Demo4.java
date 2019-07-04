
/*
    方法覆写
        在子类中定义属性和方法的时候又可能和父类中定义的属性和方法同名，那么此种情况下就称为 覆写
            1、 方法的覆写
 */



class A{
    public void say() {
        System.out.println("这是 A 类中的 say() 方法 .");
    }

    public void sayHello() {
        System.out.println("这是 A 类中的 sayHello() 方法 .");
    }
}

class B extends A{
    public void say() {  // 次 方法为 覆写
        super.say() ;
        this.sayHello();
        System.out.println("这是 B 类中的方法 .");
    }
}

/*
    super 方法和 this 方法的区别
        super.方法() ：不会再子类中查找，直接调用父类中指定的方法
        this.方法() : 会在本类中先先查找是否存在，如果存在直接调用，如果不存在会调用父类中的方法，
                      如果父类不存在此方法，则会发生编译报错
 */

public class Demo4 {
    public static void main(String args[]) {
        // 如果 B 类中没有say() 方法，b1.say() 将调用父类中的方法，但是此时 B 类中进行了方法的覆写
        // 所以此时运行的是 B 类中的方法
        B b1 = new B() ;
        b1.say() ;
    }
}
