package online.qsx.excel;

import jxl.Workbook;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import online.qsx.model.User;

import java.io.File;
import java.util.Date;
import java.util.List;
/**
 * 导出Execl
 */
public class ExeclExport {
	 /**
     * 文件导出方法（生成excel)
     * @param list
     * @return
     */
    public static String export(List<User> list){
        //创建当前毫秒值
        long l=new Date().getTime();
        //让excel的名字不重复
        String path ="D:/"+l+".xls";
        File file=new File(path);
        try{
            //判断是否创建文件
            if(file.createNewFile()){
                //创建工作符
                WritableWorkbook workbook= Workbook.createWorkbook(file);
                //给工作簿命名
                WritableSheet createSheet=workbook.createSheet("用户管理",0);
                //创建标签，表格
                String[] titles={"名字","年龄","爱好","地址"};
                Label label=null;
                //优化for循环
                for (int i=0,len=titles.length;i<len;i++){
                    //向excel第一行添加数据
                    label=new Label(i,0,titles[i]);
                    //向工作簿里面添加
                    createSheet.addCell(label);
                }
                //这个方法的参数是list集合 就是添加的内容 ，因此要根据list长度去添加内容
                for (int i=0,len=list.size();i<len;i++){
                    //根据list获取对象
                    User user=list.get(i);
                    //添加到label里面去
                    label=new Label(0,i,user.getUsername());
                    //向工作簿里面添加
                    createSheet.addCell(label);

                    //添加到label里面去
                    label=new Label(1,i,user.getAge());
                    //向工作簿里面添加
                    createSheet.addCell(label);

                    //添加到label里面去
                    label=new Label(2,i,user.getHobby());
                    //向工作簿里面添加
                    createSheet.addCell(label);

                    //添加到label里面去
                    label=new Label(3,i,user.getPosition());
                    //向工作簿里面添加
                    createSheet.addCell(label);
                }
                //把我们的数据写入
                workbook.write();
                //关掉流
                workbook.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }
}
