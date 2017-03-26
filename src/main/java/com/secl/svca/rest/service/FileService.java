package com.secl.svca.rest.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FilenameUtils;

import com.secl.svca.bean.ResponseBean;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


@Path("/fileupload") 
public class FileService {
	
	@Context ServletContext servletContext;
	private final String ROOT_FOLDER_IMAGES = "images";
	
	@POST
	@Path("/upload") 
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ResponseBean uploadFile(@FormDataParam("file") InputStream is,	
			@FormDataParam("file") FormDataContentDisposition formData, 
			@QueryParam("folderName") String folderName) {
		ResponseBean response = new ResponseBean();
		String rootPath = servletContext.getRealPath(ROOT_FOLDER_IMAGES);
		File file = new File(rootPath + File.separator + folderName);
		try {
			String fileName = saveFile(is, file, formData);
			response.setSuccess(true);
			response.setData("images/" + folderName +"/" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
 
	private String saveFile(InputStream is, File file, FormDataContentDisposition formData) throws IOException {
		if(!file.exists()){
			file.mkdir();
		}
		String fileLocation = file.getAbsolutePath()+ File.separator + formData.getFileName();
		
		OutputStream os = new FileOutputStream(new File(fileLocation));
		byte[] buffer = new byte[256];
	    int bytes = 0;
	    while ((bytes = is.read(buffer)) != -1) {
	        os.write(buffer, 0, bytes);
	    }
	    os.close();
	    String ext = FilenameUtils.getExtension(fileLocation);
		File oldfile = new File(fileLocation);
		File newfile = new File(file.getAbsolutePath()+ File.separator + UUID.randomUUID().toString()+"."+ext);
		oldfile.renameTo(newfile);
		return newfile.getName();
	}
	
	
}
 





