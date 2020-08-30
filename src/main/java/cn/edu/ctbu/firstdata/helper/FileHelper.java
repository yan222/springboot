package cn.edu.ctbu.firstdata.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/*文件助手类*/
@Slf4j
public class FileHelper {
    /*保存文件到文件夹中
    @param file
    @return    */
    public static String saveFile(MultipartFile file){
        return saveFile(file,"upload");

    }
    public static String saveFile(MultipartFile file,String path){
        UUID uuid=UUID.randomUUID();
        String originalFilename=file.getOriginalFilename();
        String extendName=originalFilename.substring(originalFilename.lastIndexOf("."),
                originalFilename.length());
        String fileName=uuid.toString()+extendName;
        try{
            String staticPath= ResourceUtils.getURL("classpath:static").getPath()
                    .replace("%20"," ");
            File newFileName=new File(staticPath+"/"+path+"/"+fileName);
            if(!newFileName.getParentFile().exists())
                newFileName.getParentFile().mkdirs();
            file.transferTo(newFileName);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return "/"+path+"/"+fileName;
    }
}
