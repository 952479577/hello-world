package com.yc.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class FileUploadUtils {
	private String allowedFilesList ="gif,jpg,png,bmp";
	private String deniedFileList="jsp,asp,php,aspx,html,htm,exe,bat,js,py,sh";
	private long singleFileSize=20 * 1024 * 1024;
	private long totalMaxFileSize= 5 * singleFileSize;
	//������ҳ����<img src="" />����·������һ�����·��
	private String dirName = "../upload/";//upload\1.png
	
	private DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");

	public Map<String,String> uploadFiles(PageContext pageContext,HttpServletRequest request) throws ServletException, IOException, SQLException, SmartUploadException{
		Map<String,String> result=new HashMap<String,String>();
		SmartUpload su=new SmartUpload();
		su.setCharset("utf-8");
		su.initialize(pageContext);//ҳ���ʼ��
		
		//���������ϴ��ļ�������
		su.setAllowedFilesList(allowedFilesList);
		//�������ϴ����ļ�����
		su.setDeniedFilesList(deniedFileList);
		//�����ļ��������
		su.setMaxFileSize(singleFileSize);
		//�����ϴ��ļ�������������
		su.setTotalMaxFileSize(totalMaxFileSize);
		su.upload();
		
		//ȡjspsmartupload�е�request����һȡ��uname,message
		com.jspsmart.upload.Request req=su.getRequest();
		Enumeration<String> enu=req.getParameterNames();  //������  
		while(enu.hasMoreElements()){  //ѭ�� ö��
			String key=enu.nextElement();
			result.put(key, req.getParameter(key));   
			
		}
		String relativepath="";
		if(su.getFiles().getCount()>0){
			Files files=su.getFiles();
			int count =files.getCount();
			
			for(int i = 0 ; i < count; i++){
				//��ȡ�����ϴ��ļ�
				com.jspsmart.upload.File file=files.getFile(i);
				String oldname=file.getFieldName();
				String newname=df.format(new Date())+"."+file.getFileExt();
				relativepath = dirName +newname;// ...webapp/upload/xxx.jpg
				//�����ļ��ڷ������ı���λ��
				//ȡ������·����
				//ȡTomcat�µ�webapp�µ�upload�ľ���·���������ڴ�ͼƬ
				String rootpath = pageContext.getRequest().getRealPath("/");//webapp/talkroom/
				String filepath = rootpath + dirName;//webapp/talkroom/../upload/xxx.jpg
				java.io.File f=new java.io.File(filepath);
				if(f.exists() == false){
					f.mkdirs();
				}
				String absolutepath =filepath+newname;
				//�ļ����Ϊ
				file.saveAs(absolutepath,SmartUpload.SAVE_PHYSICAL);
				
				//������ļ�����Ϣ�浽result�� ���ù����ǣ�����_relativepath
				//����_absolutepath
				result.put(file.getFieldName()+"_relativepath",relativepath);
				result.put(file.getFieldName()+"_absolutepath",absolutepath);
				result.put(file.getFieldName()+"_oldname",oldname);
				result.put(file.getFieldName()+"_newname",newname);
				
				
			}
		}
		return  result;
	}

	public String getAllowedFilesList() {
		return allowedFilesList;
	}

	public void setAllowedFilesList(String allowedFilesList) {
		this.allowedFilesList = allowedFilesList;
	}

	public String getDeniedFileList() {
		return deniedFileList;
	}

	public void setDeniedFileList(String deniedFileList) {
		this.deniedFileList = deniedFileList;
	}

	public long getSingleFileSize() {
		return singleFileSize;
	}

	public void setSingleFileSize(long singleFileSize) {
		this.singleFileSize = singleFileSize;
	}

	public long getTotalMaxFileSize() {
		return totalMaxFileSize;
	}

	public void setTotalMaxFileSize(long totalMaxFileSize) {
		this.totalMaxFileSize = totalMaxFileSize;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirname(String dirName) {
		dirName = dirName;
	}


	
}
