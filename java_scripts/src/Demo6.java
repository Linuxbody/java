/*
    接口实现（工厂模式设计）
 */



// 声明一个Fruit 接口，定义一个 eat() 方法
interface Fruit{
    public void eat() ;
}


// 定义一个 Apple 类 去实现 Fruit 接口的方法
class Apple implements Fruit {
    public void eat() {
        System.out.println("eat Apple .");
    }
}


// 定义 Orange 类 去实现 Fruit 接口的方法
class Orange implements Fruit {
    public void eat() {
        System.out.println("eat Orange .");
    }
}

//工厂模式，里面提供实现的类做判断，要啥就给啥，没有就不提供
class FruitFactory {
    public static Fruit getInfo(String className) {
        // 使用 if 判断
//        if ("Apple".equals(className)) {
//            return new Apple() ;
//        } else if ("Orange".equals(className)) {
//            return new Orange() ;
//        } else {
//            return null;
//        }

        // 使用 switch 和上面 if 语句功能一样
//        switch (className) {
//            case "Apple" :
//                return new Apple() ;
//            case "Orange" :
//                 return new Orange() ;
//            default:
//                return null;
//        }

        // 或者不返回 null 返回 自定义的方法
        switch (className) {
            case "Apple" :
                return new Apple() ;
            case "Orange" :
                default:
                    return new Orange() ;
        }

    }
}


public class Demo6 {
    public static void main(String args[]) {
        // 生成一个实现 Fruit 接口的 FruitFactory 的对象，然后调动 eat() 方法
        Fruit f = FruitFactory.getInfo("Apple") ;
        f.eat();


        // 调用 Apple 的 eat()方法

    }
}
