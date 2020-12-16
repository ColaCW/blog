package com.lgq.common.qiniuUpload;

import com.lgq.constants.CommonConstants;
import com.qiniu.util.Auth;

public class QiniuUploadUtil {

	public static String getQiniuUpToken() {
		try {
			Auth auth = Auth.create(CommonConstants.AccessKey, CommonConstants.SecretKey);
			return(auth.uploadToken(CommonConstants.Bucket));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
