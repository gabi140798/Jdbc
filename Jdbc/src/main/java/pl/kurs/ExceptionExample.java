package pl.kurs;

public class ExceptionExample {
    public static void main(String[] args) {

        try{
            throw new IllegalArgumentException("wyjatek");
        } catch (ArithmeticException e){
            System.out.println("naprawione");
        } finally {
            System.out.println("finally");
        }
    }
}
