/*
    要求
        可以通过一个城市找到它所对应的省份信息
        通过省份找到所有城市信息
      省份(province) pid 、 pname
      城市(city) cid 、 cname 、
 */

class Province {
    private int pid ;
    private String pname ;

//    设置对应关系 ,一个省份对应多个城市，所以设置成数组
    private City citys[] ;

    public void setCitys(City citys[]) {
        this.citys = citys ;
    }

    public City[] getCitys() {
        return this.citys ;
    }


    // 设置setter信息
    public void setPid(int pid) {
        this.pid = pid ;
    }
    public void setPname(String pname) {
        this.pname = pname ;
    }

    // 设置getter信息
    public int getPid() {
        return this.pid ;
    }
    public String getPname() {
        return this.pname ;
    }

     // 设置无参构造
    public Province() {}

    // 设置有参构造
    public Province(int pid, String pname) {
        this.pid = pid ;
        this.pname = pname ;
    }

    // 设置获取所有信息的方法
    public String getInfo() {
        return "省份编号：" + this.pid + "省份名称：" + this.pname;
    }

}


class City {
    private int cid ;
    private String cname ;

    // 设置对应关系,一个城市对应一个省份
    private Province province ;
    public void setProvince(Province province) {
        this.province = province ;
    }
    public Province getProvince() {
        return this.province ;
    }

    // 设置setter信息
    public void setCid(int cid) {
        this.cid = cid ;
    }
    public void setCname(String cname) {
        this.cname = cname ;
    }

    // 设置getter信息
    public int getCid() {
        return this.cid ;
    }
    public String getCname() {
        return this.cname ;
    }

    // 设置无参构造
    public City() {}

    // 设置有参构造
    public City(int cid, String cname) {
        this.cid = cid ;
        this.cname = cname ;
    }


    // 设置获取所有信息的方法
    public String getInfo() {
        return "城市编号：" + this.cid + "城市名称：" + this.cname ;
    }


}



public class Demo1 {
    public static void main(String args[]) {
        // 1、设置数据
        Province pro1 = new Province(001, "北京") ;
        Province pro2 = new Province(002,"河南") ;

        City ct1 = new City(001, "郑州") ;
        City ct2 = new City(002,"周口") ;
        City ct3 = new City(003,"海淀") ;

        // 2、设置对应关系
        ct1.setProvince(pro2);
        ct2.setProvince(pro2);
        ct3.setProvince(pro1);

        pro1.setCitys(new City[] {ct3});
        pro2.setCitys(new City[] {ct1, ct2});

        // 根据省份列出包涵的城市信息
        System.out.println(pro1.getInfo());
        for (int x = 0; x < pro1.getCitys().length; x++) {
            System.out.println("\t |-" + pro1.getCitys()[x].getInfo() );
        }

        System.out.println(pro2.getInfo());
        for (int x = 0; x < pro2.getCitys().length; x++) {
            System.out.println("\t |-" + pro2.getCitys()[x].getInfo());
        }

        System.out.println("\n----------------\n");

        // 根据城市找到归属城市
        System.out.println(ct2.getInfo());
        System.out.println("\t |-" + ct2.getProvince().getInfo());
    }

}
