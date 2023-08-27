package com.ljw.servlet;

import com.ljw.bean.Article;
import com.ljw.bean.User;
import com.ljw.service.ArticleService;
import com.ljw.service.UserService;
import com.ljw.service.impl.ArticleServiceImpl;
import com.ljw.service.impl.UserServiceImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
@MultipartConfig
@WebServlet("/excel")
public class DownloadServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("id"));
        System.out.println("/download id=" + articleId);
        Article article = articleService.queryArticleById(articleId);
        User user = userService.queryUserById(article.getAuthor_id());

        //创建工作簿对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

        //创建表格，指定工作簿名称为文章题目
        XSSFSheet sheet = xssfWorkbook.createSheet(article.getTitle());

        //行的索引数值
        XSSFRow row = sheet.createRow(0);
        //将数据库表的字段名放入一个数组中
        String[] employee = {"题目", "作者", "内容", "更新时间"};

        for (int i = 0; i < employee.length; i++) {
            //通过遍历employee数组给工作簿定义表头
            row.createCell(i).setCellValue(employee[i]);
            //第一次遍历时工作簿最左上角的一个框中set数据为姓名
        }

        //行的索引数值
        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(article.getTitle());
        row1.createCell(1).setCellValue(user.getUsername());
        row1.createCell(2).setCellValue(article.getContent());
        row1.createCell(3).setCellValue(article.getTitle_time());

        //设置表格的名称，通过时间设置名称
        String fileName = article.getTitle() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        fileName = URLEncoder.encode(fileName, "UTF-8");
        System.out.println(fileName);


//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\" + fileName+".xlsx");
//        xssfWorkbook.write(fileOutputStream);


        //下面的是Excel导出中HttpServletResponse消息头参数设置

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Transfer-Encoding", "binary");

        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");

        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".xlsx\"");
        xssfWorkbook.write(response.getOutputStream());

        xssfWorkbook.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获取上传的Excel文件");

//        InputStream inputStream = request.getInputStream();
        // 获取上传的 Excel 文件
        Part filePart =  request.getPart("file");
        System.out.println(filePart.getName());
        // 读取 Excel 文件并保存到服务器上
        InputStream inputStream = filePart.getInputStream();
//        System.out.println(inputStream);
//        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // 获取第一个Sheet
        XSSFSheet sheet = workbook.getSheetAt(0);


        // 迭代行
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // 迭代单元格
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // 输出单元格的值
                System.out.print(cell.toString() + "\t");
            }

            System.out.println();
        }

         //关闭Workbook和输入流
        workbook.close();
        inputStream.close();
    }
}


