package com.hyb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static List<String> datas = new ArrayList<String>();
	static{
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("ajax bill");
		datas.add("post");
		datas.add("james");
		datas.add("jerry");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.取参数
				//2.检查参数是否有问题
				//3.校验操作
				//4.ajax返回相应数据

				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
	          
	        /* 
	         * 返回数据格式必须是json数据，如下所示，本次重点不是json，不做json转换，使用土办法实现 
	         * {  
	            query:'Li',  
	            suggestions:['Liberia','Libyan Arab Jamahiriya','Liechtenstein','Lithuania'],  
	            data:['LR','LY','LI','LT'] 
	           } 
	         * */  
	        String keyWord = request.getParameter("query");//获取的属性必须是“query”，这是jquery插件规定的  
	          
	        System.out.println("关键是："+keyWord);  
	          
	        StringBuilder sb = new StringBuilder();  
	        sb.append("{");  
	        sb.append("query:'"+keyWord+"',");  
	       /* 下面一行中的4个数据一般是通过查询关键子keyWord从数据库中获取,本次则模拟静态数据 
	         * 本次模拟的是输入关键字‘Li’产生的数据，但本次只是为了做范例，所以无论输入什么关键字，都将在浏览器中显示下面的4个数据 
	         *  */ 
	        sb.append("suggestions:['Liberiag','Libyan Arab Jamahiriyaz','Liechtensteinf','Lithuania'],");  
	      /*  下面一行数据是推荐关键字,可要可不要，建议不要，占网速啊  */
	        sb.append("data:['LR','LY','LI','LT']");  
	        sb.append("}");  
	        out.write(sb.toString()); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}
