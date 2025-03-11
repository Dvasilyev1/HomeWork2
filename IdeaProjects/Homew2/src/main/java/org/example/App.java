package org.example;


    class MyException extends Exception {
        public MyException(String message) { // В класс передается сообщение, которое пробрасывается в исключение
            super(message);
        }
    }

    class DemoException {
        public void method (int value) throws MyException { // Передает сообшене в родитель, потому что не умеет выкидывать сообщение
            if(value < 0){
                throw new MyException("Значение не может быть отрицательным");
            }
            System.out.println("Значение корректное: " + value);
        }
        public void anyMethod(int value) {
            try {
                method(value);
            }catch (MyException e){
                System.out.println("Перехвачено исключение: " + e.getMessage());
            }
        }
    }
public class App {
    public static void main (String[] args) {
        DemoException demo = new DemoException();
        demo.anyMethod(-2);
        demo.anyMethod(13);
        try {
            demo.method(-1);
        }catch (MyException e) {
            System.out.println("Обработано исключение: " + e.getMessage());
        }
    }
}



