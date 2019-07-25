package com.example.thread;

/**
 * @ClassName synchron
 * @Deseiption
 * @Author AYOU
 * @Date 2019/7/11 15:14
 * @Version 1.0
 **/
public class synchron {

   public static Integer count = new Integer(300);

    public void demo(){
        synchronized (Integer.class){
            for (int i = 0; i < 10; i++) {
                System.out.println("count: " + count++);
            }
        }
    }
    enum Size{
        SMALL("S"),MEDIU("M"),LARGE("L"),EXTR("E"),ADC("A");

        private String str;
        Size(String str){
            this.str = str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }
    public static void main(String[] args) {
        synchron synchron = new synchron();
        synchron synchron1 = new synchron();
        /*synchron.demo();
        synchron1.demo();*/

       /* if("MEDIU" == Size.MEDIU.toString()){
            System.out.println(520);
            Size size = Size.valueOf("EXTR");
            System.out.println(size.getStr());
        }*/
        String str = "LARGE";
        switch (Size.valueOf(str)){
            case MEDIU:
                Size size = Size.valueOf(str);
                System.out.println(size.getStr());
                break;
            case ADC:
                Size size1 = Size.valueOf(str);
                System.out.println(size1.getStr());
                break;
                default:
                    System.out.println(1);
        }
    }
}
