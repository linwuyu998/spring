package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;

import cn.zcbigdata.mybits_demo.entity.Video;
import cn.zcbigdata.mybits_demo.service.FileService;
import cn.zcbigdata.mybits_demo.service.FilepathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传页面
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    private static final String NULL_FILE = "";


    @Value("${define.nginx.path}")
    private String nginxPath;

    @Autowired
    private FileService fileService;

    @Autowired
    private FilepathService filepathService;


    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("fileName = {}", file.getOriginalFilename());
        }
        try {
            if (file == null || NULL_FILE.equals(file.getOriginalFilename())) {
                return "upload failure1";
            }
            fileService.saveFile(file.getBytes(), nginxPath, file.getOriginalFilename());
        } catch (Exception e) {
            return "upload failure2";
        }
        return "upload success";
    }

    /**
     * 文件批量上传
     * @param files
     * @return
     */
    @PostMapping("/uploadFiles")
    @ResponseBody
    public String multiFileUpload(@RequestParam("file") MultipartFile[] files) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("fileName = {}", files[0].getOriginalFilename());
        }
        try {

            for (int i = 0; i < files.length; i++) {
                //check file
                if (NULL_FILE.equals(files[i].getOriginalFilename())) {
                    continue;
                }
                fileService.saveFile(files[i].getBytes(), nginxPath, files[i].getOriginalFilename());
            }
        } catch (Exception e) {
            return "upload failure";
        }
        return "upload success";
    }

    /**
     * 文件查看
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("showFiles")
    public String showFiles(HttpServletRequest request) throws Exception {
        List<Video> videos = filepathService.showFiles();
        String[] Parameter = new String[]{"id","filepath"};
        String jsonString = ObjtoLayJson.ListtoJson(videos,Parameter);
        return jsonString;
    }

    /**
     * 文件下载
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="/download", method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String  testDownload(HttpServletRequest request ,HttpServletResponse response , Model model) {
        String filepath = request.getParameter("filepath");
        //System.out.println(nginxPath + filepath + "**************");
        fileService.download(response,filepath,model);

        //成功后返回成功信息
        model.addAttribute("result","下载成功");
        return "employee/EmployeeDownloadFile";
    }
}
