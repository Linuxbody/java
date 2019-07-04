
/*
    简单异常处理
        try...catch
 */


public class Demo8 {

    public static void main(String args[]) {
        System.out.println("开始整数运算：");

        try {
            System.out.println("除法运算：" + (10/0));
        } catch (Exception e) {
            System.out.println("****** 出现异常了 *******");

            // 使用printStackTrace 可以打印错误详细信息
            e.printStackTrace();
        } finally {
            System.out.println("不管是否出现异常都要执行 。");
        }

        System.out.println("运算结束 。");

    }
}


