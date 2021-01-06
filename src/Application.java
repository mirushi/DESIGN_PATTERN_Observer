public class Application {
    public static void main(String[] args) {
        //Tạo ra một Subject mới là giá.
        Price price = new Price();

        //Tạo ra hai observer mới.
        Observer emailSender = new EmailSender(price);
        Observer smsSender = new SmsSender(price);

        //Thực hiện thay đổi giá.
        price.setPrice(1000d);
        //Thực hiện thay đổi giá.
        price.setPrice(2000d);
    }
}
