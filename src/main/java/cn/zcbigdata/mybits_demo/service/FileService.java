package cn.zcbigdata.mybits_demo.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
    void saveFile(byte[] file, String filePath, String fileName) throws Exception;

    void download(HttpServletResponse response, String filename, Model model);
}
