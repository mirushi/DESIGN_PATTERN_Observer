public class EmailSender implements Observer {

    private double price;

    private int observerID;

    private Subject priceSubject;

    public EmailSender (Subject subject) {
        //Lưu trữ đến đối tượng priceSubject để có thể tiến hành gọi các phương thức của nó khi cần thiết.
        this.priceSubject = subject;
        //Lấy ID để gán cho chính mình.
        this.observerID = subject.getObserverID();
        //Đăng ký với Subject chính mình.
        this.priceSubject.register(this);
    }

    @Override
    public void update(double newPrice) {
        //Gán giá hiện tại bằng giá mới nhận từ Subject.
        this.price = newPrice;
        //Gửi email báo giá mới.
        sendEmail();
    }

    private void sendEmail() {
        //Thực hiện gửi email đến cho người dùng mỗi khi có sự thay đổi được Subject gửi đến.
        System.out.println("Email is sent ! New price: " + price);
    }
}
