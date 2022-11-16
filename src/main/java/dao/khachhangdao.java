package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.khachhangbean;

public class khachhangdao {

  public ArrayList<khachhangbean> getkh() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from KhachHang";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        int makh = rs.getInt("makh");
        String hoten = rs.getString("hoten");
        String diachi = rs.getString("diachi");
        String sodt = rs.getString("sodt");
        String email = rs.getString("email");
        String tendn = rs.getString("tendn");
        String pass = rs.getString("pass");
        ds.add(new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass));
      }
      // b4: dong ket noi
      rs.close();
      kn.cn.close();
      return ds;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
