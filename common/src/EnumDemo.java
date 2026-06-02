/**
 * @author lyf
 */
public class EnumDemo {
    public static void main(String[] args) {
   for(Weekday w : Weekday.values()){
       System.out.println(w + "中文名是" + w.getChineseName());
   }
        Weekday s = Weekday.valueOf("FRIDAY");
        System.out.println(s);
    }

    enum Weekday{
        MONDAY("星期一"), TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");
        private String desc;
        Weekday(String desc){this.desc = desc;}
        public String getChineseName(){return desc;}
    }

}
