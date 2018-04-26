package online.qsx.excel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExportExcelServlet
 */
@WebServlet("/exportExcelServlet")
public class ExportExcelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//设置request的编码方式，防止中文乱码
		String fname = "mini" + getTimeStamp(); // Excel文件名  
		String fileName ="导出数据";//设置导出的文件名称
		 StringBuffer sb = new StringBuffer(req.getParameter("tableInfo"));//将表格信息放入内存
//		 String contentType = "application/vnd.ms-excel";//定义导出文件的格式的字符串
		 String recommendedName = new String(fileName.getBytes(),"iso_8859_1");//设置文件名称的编码格式
//		 resp.setContentType(contentType);//设置导出文件格式
//		 resp.setHeader("Content-Disposition", "attachment; filename=" + recommendedName + "\"");//
		 resp.setHeader("Content-disposition", "attachment; filename=" + fname + ".xls"); // 设定输出文件头,该方法有两个参数，分别表示应答头的名字和值。  
		 resp.setContentType("application/msexcel");  
		 resp.resetBuffer();
         //利用输出输入流导出文件
		 ServletOutputStream sos = resp.getOutputStream();
		 sos.write(sb.toString().getBytes());
		 sos.flush();
         sos.close();
	}
	
	 public static String getTimeStamp() {  
	        SimpleDateFormat dateFormat = new SimpleDateFormat(  
	                "yyyy-MM-dd hh:MM:ss");  
	        Date date = new Date();  
	        return dateFormat.format(date);  
	    }  
}
