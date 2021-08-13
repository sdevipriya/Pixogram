package com.ibm.media.service;
import org.springframework.util.ClassUtils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.media.dao.MediaDao;
import com.ibm.media.util.FileUtil;

@Service
public class MediaService {
	
	@Autowired
	private MediaDao mediada;
	
	public static String Upload(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public String Upload(String title, String description, String tags, String effets, MultipartFile file) {
		// TODO Auto-generated method stub
		if(!file.isEmpty()) {
			// Get the file name, including the suffix			
			String fileName = file.getOriginalFilename();		
			
			 // Store in this path: the path is under the static file in the project directory: (Note: this file may need to be created by yourself)
			 // The reason for putting it under static is that it stores static file resources, that is, you can enter the local server address through the browser, and you can access it when adding the file name
			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
 
			try {
				 // This method is a package for writing files. In the util class, import the package and use it. The method will be given later				
				FileUtil.fileupload(file.getBytes(), path, fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 // Then create the corresponding entity class, add the following path, and then write through the database operation method			
			//FilePath biaopath = new FilePath();
			Mediabkp m = new Mediabkp();
			//m.setPath("http://localhost:8080/"+fileName);
			m.setTitle(title);
			m.setDescription(description);
			m.setEffets(effets);
			m.setTags(tags);
			m.setTags(tags);
			mediada.save(m);
			
		}
		return "success";
		
		
	}

	public String upload(String title, String description, String tags, String effets) {
		// TODO Auto-generated method stub
		Mediabkp m = new Mediabkp();
		//m.setPath("http://localhost:8080/"+fileName);
		m.setTitle(title);
		m.setDescription(description);
		m.setEffets(effets);
		m.setTags(tags);
		m.setTags(tags);
		mediada.save(m);
		
		return m.toString();
	}
	*/
}
