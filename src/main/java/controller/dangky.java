package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.dangnhapbean;
import bean.khachhangbean;
import bo.dangnhapbo;
import bo.khachhangbo;

/**
 * Servlet implementation class dangky
 */
@WebServlet("/dangky")
public class dangky extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public dangky() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    HttpSession session = request.getSession();
    Random random = new Random();
    int makh = random.nextInt(100 - 1) + 1;
    String hoten = request.getParameter("txtht");
    String diachi = request.getParameter("txtdc");
    String sodt = request.getParameter("txtsdt");
    String email = request.getParameter("txtemail");
    String tendn = request.getParameter("txtun");
    String pass = request.getParameter("txtpass");

    dangnhapbo dnbo = new dangnhapbo();
    ArrayList<dangnhapbean> dsdn = dnbo.getdangnhap();
    khachhangbo khbo = new khachhangbo();
    ArrayList<khachhangbean> dskh = khbo.getkh();

    if (makh >= 0 && hoten != null && tendn != null && pass != null) {
      khbo.ThemKH(makh, hoten, diachi, sodt, email, tendn, pass);
      dnbo.ThemDN(tendn, pass);
    }

    RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
