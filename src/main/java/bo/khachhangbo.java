package bo;

import java.util.ArrayList;
import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {

  ArrayList<khachhangbean> ds;
  khachhangdao khdao = new khachhangdao();

  public ArrayList<khachhangbean> getkh() {
    ds = khdao.getkh();
    return ds;
  }

  public void ThemKH(int makh, String hoten, String diachi, String sodt, String email, String tendn,
      String pass) {
    for (khachhangbean h : ds)
      if (h.getMakh() == makh) {
        return;
      }
    ds.add(new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass));
  }

  public int Kiemtra(String tendn, String pass) {
    int check = 0;
    for (khachhangbean kh : ds)
      if (kh.getTendn().equals(tendn) && kh.getPass().equals(pass))
        check = 1;
    return check;
  }

}
