package com.spb.springboot.filetools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    //跳转界面
    @RequestMapping(value = "/fileupload",method = RequestMethod.GET)
    public String index(){
        return "fileupload";
    }

    /**
     * 上传文件方法--测试单个文件上传
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(HttpServletRequest request, MultipartFile file){
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }

            //调用上传方法
            executeUpload(uploadDir,file);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 上传多个文件
     * @param request
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] file){
        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/")+"/upload/";
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for(int i=0;i<file.length;i++){
                if(file[i] != null){
                    executeUpload(uploadDir,file[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }



    /**
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir,MultipartFile file) throws Exception {
        /**
         * 自定义文件名
         *  一般情况下我们不会使用上传时文件的名字作为存储在服务器端的名字，一般都会采用UUID或者时间戳的形式来保存
         */
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

}
