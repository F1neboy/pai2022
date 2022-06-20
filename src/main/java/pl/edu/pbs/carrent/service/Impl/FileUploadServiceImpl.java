package pl.edu.pbs.carrent.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.edu.pbs.carrent.payload.request.ResponseCode;
import pl.edu.pbs.carrent.payload.request.ResultInfo;
import pl.edu.pbs.carrent.service.FileUploadService;
import pl.edu.pbs.carrent.service.utils.FtpUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public ResultInfo fileUpload(String localPath, String userid, String fileName) throws IOException {
        ResultInfo resultInfo = new ResultInfo();
        FtpUtil ftpUtil = new FtpUtil();
        Boolean aBoolean = ftpUtil.ftpLogin();
        if (!aBoolean){
            log.error("FTPLogowanie użytkownika nie powiodło się");
            resultInfo.setResultCode(ResponseCode.FTP_LOGIN_ERROR);
            return resultInfo;
        }

        FileInputStream inputStream = new FileInputStream(new File(localPath));



        Boolean isChangeUserSuccess = ftpUtil.changeWorkingDirectory(userid);
        if (!isChangeUserSuccess){
            log.error("FTPNie udało się przełączyć katalogu użytkownika, katalog użytkownika nie istnieje, najpierw utwórz katalog użytkownika");
            ftpUtil.makeDirectory(userid);
        }
        Boolean isStoreFile = ftpUtil.storeFile(fileName, inputStream,userid);
        String  s= ftpUtil.printWorkingDirectory();

        resultInfo.setPathFolder(Path.of(s));
        if(!isStoreFile){
            log.error("FTP\n" +
                    "Nie udało się przesłać pliku po stronie serwera");

            resultInfo.setResultCode(ResponseCode.FTP_STOREFILE_ERROR);

            return resultInfo;
        }
        Boolean isLogout = ftpUtil.ftpLogout();
        if (!isLogout){
            log.error("FTPWylogowanie z serwera FTP nie powiodło się");
            resultInfo.setResultCode(ResponseCode.FTP_LOGOUT_ERROR);
            return resultInfo;
        }

        resultInfo.setResultCode(ResponseCode.SUCCESS);
        return resultInfo;
    }
}
