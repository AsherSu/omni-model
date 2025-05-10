package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.DeleteResult;
import cn.ashersu.omni.model.file.File;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.util.List;

public class FileService extends BaseOpenAIService {

    public FileService(OpenAIConfig config) {
        super(config);
    }

    public List<File> listFiles() {
        return execute(getApi().listFiles()).getData();
    }

    public File uploadFile(String purpose, String filepath) {
        java.io.File file = new java.io.File(filepath);
        RequestBody purposeBody = RequestBody.create(MultipartBody.FORM, purpose);
        RequestBody fileBody = RequestBody.create(MediaType.parse("text"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", filepath, fileBody);

        return execute(getApi().uploadFile(purposeBody, body));
    }

    public DeleteResult deleteFile(String fileId) {
        return execute(getApi().deleteFile(fileId));
    }

    public File retrieveFile(String fileId) {
        return execute(getApi().retrieveFile(fileId));
    }

    public ResponseBody retrieveFileContent(String fileId) {
        return execute(getApi().retrieveFileContent(fileId));
    }

}
