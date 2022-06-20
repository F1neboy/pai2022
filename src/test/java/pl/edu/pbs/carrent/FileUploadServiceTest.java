package pl.edu.pbs.carrent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.pbs.carrent.payload.request.ResultInfo;
import pl.edu.pbs.carrent.service.FileUploadService;

import java.io.IOException;
import java.nio.file.Path;

@SpringBootTest
public class FileUploadServiceTest {

    @Autowired
    private FileUploadService fileUploadService;




    @Test
    public void fileUpload() throws IOException {


        String localPath = "C:\\Users\\Dehrono\\Desktop\\1.png";
        System.out.println("+++++++++++++++++++++"+localPath);
        String fileName = "1.png";
        String userid = "23";
ResultInfo resultInfo = fileUploadService.fileUpload(localPath,userid,fileName);

        System.out.println(resultInfo.getPathFolder()+"\\"+fileName);
        resultInfo.setPathFile(Path.of(resultInfo.getPathFolder() + "\\" + fileName));
        System.out.println(resultInfo.getPathFile());
        System.out.println(resultInfo.getResultCode());

    }


}
