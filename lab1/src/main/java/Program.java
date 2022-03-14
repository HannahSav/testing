public class Program {
    public static void main(String[] args){
        Function function = new Function();
        double atan = function.atan(40, 0.1);
        System.out.println("result is " + atan + " "+ Math.atan(1900001));
    }
}
