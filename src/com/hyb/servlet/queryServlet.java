package com.hyb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.hyb.entiy.Entiy;

/**
 * Servlet implementation class queryServlet
 */
@WebServlet("/queryServlet")
public class queryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置返回字符编码
				response.setCharacterEncoding("UTF-8");
				// 以下一般为查询数据库返回的结果，这里静态设置几个
				Entiy d1 = new Entiy();
				d1.setName("鱼香肉丝");
				d1.setPrice(18.8);
				Entiy d2 = new Entiy();
				d2.setName("糖醋排骨");
				d2.setPrice(28.8);
				Entiy d3 = new Entiy();
				d3.setName("青椒炒肉");
				d3.setPrice(38.8);

				// 新建JSONArray对象
				JSONArray jsonArray = new JSONArray();
				// 把菜品对象添加到JSON数组中
				jsonArray.add(d1);
				jsonArray.add(d2);
				jsonArray.add(d3);

				// 一个好的编程习惯，如果要输出，先建一个空的PrintWriter
				PrintWriter out = null;
				// 在try-catch中把JSON数组写到response输出流
				try {
					out = response.getWriter();
					// 返回给page
					out.write(jsonArray.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 最后，把流关闭
				finally {
					try {
						if (out != null) {
							out.close();
						}
					} catch (Exception e) {
					}
				}
			}
}
