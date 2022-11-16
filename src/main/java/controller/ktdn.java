package controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ktdn
 */
@WebServlet("/ktdn")
public class ktdn extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ktdn() {
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
    String un = request.getParameter("txtun");
    String pass = request.getParameter("txtpass");
    dangnhapbo dnbo = new dangnhapbo();
    ArrayList<dangnhapbean> dsdn = dnbo.getdangnhap();
    khachhangbo khbo = new khachhangbo();
    ArrayList<khachhangbean> dskh = khbo.getkh();
    int check1 = dnbo.Kiemtra(un, pass);
    int check2 = khbo.Kiemtra(un, pass);
    if (un != null && pass != null) {
      if (check1 == 1 || check2 == 1) {
        // Tao ra session
        HttpSession session = request.getSession();
        session.setAttribute("dn", un);
        // response.sendRedirect("htsach.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("htsachController");
        rd.forward(request, response);
      } else {
        // response.sendRedirect("dangnhap.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
        rd.forward(request, response);
      }
    }
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