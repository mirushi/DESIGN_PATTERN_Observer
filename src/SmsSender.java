public class SmsSender implements Observer {

    private double price;

    private int observerID;

    private Subject priceSubject;

    public SmsSender (Subject subject){
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
        //Gửi SMS báo giá mới.
        sendSMS();
    }

    private void sendSMS () {
        //Thực hiện gửi SMS đến người dùng mỗi khi có sự thay đổi được Subject gửi đến.
        System.out.println("SMS is sent ! New price: " + price);
    }

}
