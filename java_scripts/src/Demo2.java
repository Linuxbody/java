/*
    双向一对多映射（类型-子类型-商品）

    类型 ：类型Id、名称、 描述
    子类型：子类型Id 、名称、描述、类型ID
    商品：商品Id、名称、价格、子类型Id、 类型Id

    需求：
        1、通过一个类型找到它所对应的全部子类型
        2、通过一个类型找到它所对应的全部商品，一家每个商品对应的子类型
        3、通过一个子类型找到所有对应的全部商品
 */


class Item{
    private int iid ;
    private String iname ;
    private String inote ;

    // 定义关系，一个类型包涵多个子类型
    private Subitme subitems[] ;

    public void setSubitems(Subitme subitems[]) {
        this.subitems = subitems ;
    }
    public Subitme [] getSubitems() {
        return subitems ;
    }

    // 定义关系，一个类型包涵多个商品
    private Product products[] ;
    public void setProducts(Product products[]) {
        this.products = products ;
    }
    public Product[] getProducts() {
        return this.products ;
    }


    // 定义 setter 方法
    public void setIid(int iid) {
        this.iid = iid ;
    }
    public void setIname(String iname) {
        this.iname = iname ;
    }
    public void setInote(String inote) {
        this.inote = inote ;
    }

    // 定义 getter 方法
    public int getIid() {
        return this.iid ;
    }
    public String getIname() {
        return this.iname ;
    }
    public String getInote() {
        return this.inote ;
    }

    // 定义 无参 构造方法
    public Item() {}

    //定义 传参 构造方法
    public Item(int iid, String iname, String inote) {
        this.iid = iid ;
        this.iname = iname ;
        this.inote = inote ;
    }

    // 定义获得所有信息的方法
    public String getInfo() {
        return " 类型编号：" + iid + " 类型名称：" + iname + " 类型描述" + inote ;
    }


}

class Subitme{
    private int sid ;
    private String sname ;
    private String snote ;


    // 一个子类型 对应一个类型
    private Item items ;
    public void setItems(Item items) {
        this.items = items ;
    }
    public Item getItems() {
        return this.items ;
    }

    // 一个子类型 对应 多个商品
    private Product products[] ;
    public void setProducts(Product products[]) {
        this.products = products ;
    }

    public Product[] getProducts() {
        return this.products ;
    }


    // 定义 setter 方法
    public void setSid(int sid) {
        this.sid = sid ;
    }
    public void setSname(String sname) {
        this.sname = sname ;
    }
    public void setSnote(String snote) {
        this.snote = snote ;
    }

    // 定义 getter 方法
    public int getSid() {
        return this.sid ;
    }
    public String getSname() {
        return this.sname ;
    }
    public String getSnote() {
        return this.snote ;
    }


    // 定义 无参 构造方法
    public Subitme() {}

    //定义 传参 构造方法
    public Subitme(int sid, String sname, String snote) {
        this.sid = sid ;
        this.sname = sname ;
        this.snote = snote ;
    }

    // 定义获得所有信息的方法
    public String getInfo() {
        return " 子类型编号：" + sid + " 子类型名称：" + sname + " 子类型描述：" + snote ;
    }

}

class Product{
    private int pid ;
    private String pname ;
    private double price ;

    // 一个商品对应一个子类型
    private Subitme subitmes ;
    public void setSubitmes(Subitme subitmes){
        this.subitmes = subitmes ;
    }
    public Subitme getSubitmes() {
        return this.subitmes ;
    }

    // 一个商品对应一个类型
    private Item items ;
    public void setItems(Item items) {
        this.items = items ;
    }
    public Item getItems() {
        return this.items ;
    }

    // 定义 setter 方法
    public void setPid(int pid) {
        this.pid = pid ;
    }
    public void setPname(String pname) {
        this.pname = pname ;
    }
    public void setPrice(double price) {
        this.price = price ;
    }

    // 定义 getter 方法
    public int getPid() {
        return pid ;
    }
    public String getPname() {
        return pname ;
    }
    public double getPrice() {
        return price ;
    }

    // 定义 无参 构造方法
    public Product() {}

    //定义 传参 构造方法
    public Product(int pid, String pname, double price) {
        this.pid = pid ;
        this.pname = pname ;
        this.price = price ;
    }

    // 定义获得所有信息的方法
    public String getInfo() {
        return " 商品编号：" + pid + " 商品名称：" + pname + " 商品价格：" + price ;
    }

}

// 主方法
public class Demo2 {
    public static void main(String args[]) {

        // 1、填充基础数据
        Item i1 = new Item(001, "手机", "手机相关用品") ;

        Subitme s1 = new Subitme(001, "手机通讯", "品牌手机") ;
        Subitme s2 = new Subitme(002,"手机配件","手机辅助") ;

        Product p1 = new Product(001,"苹果",5000.99) ;
        Product p2 = new Product(002,"华为",6000.66) ;
        Product p3 = new Product(003,"手机壳", 88.88) ;
        Product p4 = new Product(004,"手机膜",66.66) ;
        Product p5 = new Product(005,"手机饰品", 128.88) ;

        // 2、 设置数据对应关系
        // 商品对应关系
        p1.setSubitmes(s1);
        p2.setSubitmes(s1);
        p3.setSubitmes(s2);
        p4.setSubitmes(s2);
        p5.setSubitmes(s2);

        p1.setItems(i1);
        p2.setItems(i1);
        p3.setItems(i1);
        p4.setItems(i1);
        p5.setItems(i1);

        // 子类型对应关系
        s1.setItems(i1);
        s2.setItems(i1);

        s1.setProducts(new Product[] {p1, p2}) ;
        s2.setProducts(new Product[] {p3, p4, p5});

        // 类型对应关系
        i1.setSubitems(new Subitme[] {s1, s2});
        i1.setProducts(new Product[] {p1, p2, p3, p4, p5});


        // 通过类型找到对应的子类型，再找到子类型商品
        System.out.println(i1.getInfo());
        for (int x = 0; x < i1.getSubitems().length; x++) {
            System.out.println("\t |-" + i1.getSubitems()[x].getInfo());

            for (int k = 0; k < i1.getSubitems()[x].getProducts().length; k++) {
                System.out.println("\t\t |- " + i1.getProducts()[k].getInfo());
            }
        }

        // 通过商品查找归属子类型
        System.out.println("-----------\n");

        for (int x = 0; x < i1.getProducts().length; x++){
            System.out.println("\t |- " + i1.getProducts()[x].getInfo());
            System.out.println("\t\t|- " + i1.getProducts()[x].getSubitmes().getInfo());
        }


    }
}
