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
		req.setCharacterEncoding("UTF-8");//����request�ı��뷽ʽ����ֹ��������
		String fname = "mini" + getTimeStamp(); // Excel�ļ���  
		String fileName ="��������";//���õ������ļ�����
		 StringBuffer sb = new StringBuffer(req.getParameter("tableInfo"));//�������Ϣ�����ڴ�
//		 String contentType = "application/vnd.ms-excel";//���嵼���ļ��ĸ�ʽ���ַ���
		 String recommendedName = new String(fileName.getBytes(),"iso_8859_1");//�����ļ����Ƶı����ʽ
//		 resp.setContentType(contentType);//���õ����ļ���ʽ
//		 resp.setHeader("Content-Disposition", "attachment; filename=" + recommendedName + "\"");//
		 resp.setHeader("Content-disposition", "attachment; filename=" + fname + ".xls"); // �趨����ļ�ͷ,�÷����������������ֱ��ʾӦ��ͷ�����ֺ�ֵ��  
		 resp.setContentType("application/msexcel");  
		 resp.resetBuffer();
         //������������������ļ�
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
