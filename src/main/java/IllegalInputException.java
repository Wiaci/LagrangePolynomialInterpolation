public class IllegalInputException extends Exception {
    @Override
    public String getMessage() {
        return "Неверный формат ввода!";
    }
}
