package com.demo.user;

import com.demo.factory.ServiceFactory;
import com.demo.service.UserService;
import com.demo.vo.Task;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserUploadServlet", urlPatterns = {"/submit/UserUploadServlet"})
public class UserUploadServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40;
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            request.setAttribute("message", "请上传文件！");
            request.getRequestDispatcher("/submit/userContent.jsp").forward(request, response);
            return;
        }
        ArrayList<String> inform = getSolveInform(request);
        UserService userService = ServiceFactory.getUserServiceImpl();
        if(!userService.checkTaskByID(inform.get(1))) {
            request.setAttribute("message", "任务已结束！");
            request.getRequestDispatcher("/submit/userContent.jsp").forward(request, response);
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8");
        String basePath = UPLOAD_DIRECTORY + "\\" + inform.get(1) + "\\" + inform.get(0);
        String uploadPath = getServletContext().getRealPath("/WEB-INF/") + basePath;
//        System.out.println(uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        try {
            List<FileItem> formItems = upload.parseRequest(request);
//            System.out.println(formItems.size());
            int count = formItems.size();
            for (FileItem item : formItems) {
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);
                    System.out.println(filePath);
                    item.write(storeFile);
                }
            }
            request.setAttribute("message", count + " 个文件上传成功!");
            userService.addTaskTotal(inform.get(0), inform.get(1));
        } catch (Exception e) {
            request.setAttribute("message", "上传文件失败！");
        }
        request.getRequestDispatcher("/submit/userContent.jsp").forward(request, response);
    }



    private ArrayList<String> getSolveInform(HttpServletRequest request) throws ServletException, IOException {
        ArrayList<String> result = new ArrayList<>();
        HttpSession session = request.getSession();
        Task task = (Task) session.getAttribute("user-task");
        ArrayList<String> inform = (ArrayList<String>) session.getAttribute("user-inform");
        result.add(inform.get(0));
        result.add(task.getID());
        return result;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
