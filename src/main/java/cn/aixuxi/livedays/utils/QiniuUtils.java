package cn.aixuxi.livedays.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Region;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * 类描述 七牛云图片上传处理工具类
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/7/9 15:06
 */
public class QiniuUtils {
    /**
     * 功能描述: 上传图片到七牛云，并返回图片地址
     *
     * @param file 待上传的图片
     * @return : 返回的图片地址
     * @author : ruozhuliufeng
     * @date : 2020/7/9 15:11
     */
    public static String imgUplad(MultipartFile file) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        // 后续从配置文件中读取
        String accessKey = "TiTA_El6_eUVW6Dnx4mOoh7zBLFsPCnClwQQANsk";
        String secretKey = "dD0QTaE84XO5ywVx3cKdChKRzi0ApOroOrwG_W69";
        String bucket = "ruozhuliufeng";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        try {
            // 基于文件file对象构建输入流对象
            InputStream inputStream = file.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                key = "http://img.aixuxi.cn/" + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore

        }
        return key;
    }
}
