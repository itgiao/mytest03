package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 */
@Controller
public class upload {
    @RequestMapping("/upload")
    public String load(MultipartFile file, HttpServletRequest request) throws IOException {
        //得到servletContext对象
        //在路径下面创建一个文件夹，在这个文件夹的名字叫做files，用来保存等一会收到的文件
        String destPath = request.getServletContext().getRealPath("files");
        File destDir = new File(destPath);
        if (!destDir.exists()){
            //如果这个文件夹不存在，就创建这个文件夹
            destDir.mkdirs();
        }
        //获取原始的文件名字
        String filename = file.getOriginalFilename();
        //改造这个文件的名字，组成新的文件名字。新的文件名字=当前时间戳+后缀名
        filename=System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."));
        //构建一个文件对象，再具体的目录下。有这样一个文件夹，文件夹没有内容
        File destfile = new File(destDir, filename);
        //把springmvc收到的文件，保存到我们上面构建好的目标文件中去
        file.transferTo(destfile);
        return "success";
    }

    /**
     * 跨服务器上传
     */
    @RequestMapping("/upload02")
    public  String upload01(MultipartFile file) throws Exception{
        //文件名称转换：转换成不含中文的名字
        String filename = file.getOriginalFilename();
        filename=System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."));
        //创建一个客户端
        Client client = new Client();
        //构建一个资源参数；即表示要上传到哪个服务器
        WebResource resource=client.resource("http://localhost:8081/files/" + filename);
        //开始上传
        resource.put(file.getBytes());
        return "success";
    }
}
