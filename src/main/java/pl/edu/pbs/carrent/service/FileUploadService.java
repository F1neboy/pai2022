package pl.edu.pbs.carrent.service;

import pl.edu.pbs.carrent.payload.request.ResultInfo;

import java.io.IOException;

public interface FileUploadService {
     public ResultInfo fileUpload(String localPath, String fileName) throws IOException;
}
