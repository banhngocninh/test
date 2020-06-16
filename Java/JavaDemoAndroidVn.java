import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDemoAndroidVn {
 
    public static void main(String[] args) {
        //Vd2
   
        //Lay gio he thong
        Date thoiGian = new Date();
 
        //Khai bao dinh dang ngay thang
        SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
 
        //parse ngay thang sang dinh dang va chuyen thanh string.
        String showTime = dinhDangThoiGian.format(thoiGian.getTime());
 
        System.out.println("" + showTime);
    }
}