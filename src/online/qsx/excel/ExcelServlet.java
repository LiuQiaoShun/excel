package online.qsx.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import online.qsx.model.User;

/**
 * Servlet implementation class ExcelServlet
 */
@WebServlet("/excelServlet")
public class ExcelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setCharacterEncoding("utf-8");
	        req.setCharacterEncoding("utf-8");

	        List<User> list=new ArrayList<>();
	        User u=new User("桃老师","24","编码","长沙");
	        for (int i=0;i<10;i++){
	            list.add(u);
	        }
	        //让异常出之外
	        String path=null;
	        try{
	            path=ExeclExport.export(list);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        req.setAttribute("path",path);
	        req.setAttribute("list",list);
	        req.getRequestDispatcher("index.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
