import java.util.ArrayList;

public class Price implements Subject {

    private ArrayList<Observer> observers = new ArrayList<>();
    private double price;
    private int observerIDTracker = 0;

    @Override
    public void register(Observer observer) {
        //Thêm một observer vào danh sách observer khi gọi đến hàm register observer.
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        //Bỏ đi một observer khi bên ngoài gọi đến loại bỏ observer này.
        int observerIndex = observers.indexOf(observer);
        if (observerIndex > 0) {
            observers.remove(observerIndex);
        }
    }

    @Override
    public void notifyObserver() {
        //Gọi đến hàm update của tất cả các observers mỗi khi có sự thay đổi về giá.
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    @Override
    public int getObserverID() {
        //Trong ví dụ đơn giản này, ta sẽ tiến hành track ID của observer chỉ bằng một biến duy nhất.
        //Trong thực tế, có thể ta sẽ phải thực hiện những giải pháp phức tạp hơn nhiều.
        return observerIDTracker++;
    }

    public void setPrice (double price) {
        //Cập nhật lại giá với giá mới.
        this.price = price;

        //Sau đó thông báo đến tất cả observer về giá vừa mới cập nhật này.
        notifyObserver();
    }

}


