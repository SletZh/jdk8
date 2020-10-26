package base.logic.If;

/**
 * @author SletZh
 * @Date 2020-10-14-14:36
 */
public class Demo1 {
    public static void main(String[] args) {
        if((false||true)&&false){
            System.out.println("No.1 is "+true);
        }

        if((false||true)&&true){
            System.out.println("No.2 is "+true);
        }


        if((false||false)&&true){
            System.out.println("No.3 is "+true);
        }
    }
}
