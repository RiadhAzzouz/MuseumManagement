package com.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

import com.dao.ArticleIDao;
import com.dao.imp.ArticleDaoImp;
import com.model.Article;

@ManagedBean(name="articleB")
@SessionScoped
public class ArticleBean {
	
	
	private ArticleIDao artDao = new ArticleDaoImp();
	private Article art = new Article();
	private UploadedFile uploadedFile;
	private List<Article> listArticle = new ArrayList();
	
	
	public List<Article> getListArticle() {
		listArticle = artDao.findAll(Article.class);
		return listArticle;
	}

	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}
	
	public ArticleIDao getArtDao() {
		return artDao;
	}

	public void setArtDao(ArticleIDao artDao) {
		this.artDao = artDao;
	}

	public Article getArt() {
		return art;
	}

	public void setArt(Article art) {
		this.art = art;
	}
	 
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
 
    public void setUploadedFile(UploadedFile uploadedfile) {
        this.uploadedFile = uploadedfile;
    }
     
   
    
    
    
    public void upload() throws IOException {
        if(uploadedFile != null) {
            FacesMessage message = new FacesMessage("Succesful", uploadedFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            Path folder = Paths.get("C:\\Users\\azzouz\\eclipse-workspace\\TP\\WebContent\\resources\\default\\images");
            String filename = FilenameUtils.getBaseName(uploadedFile.getFileName()); 
            String extension = FilenameUtils.getExtension(uploadedFile.getFileName());
            Path myFile = Files.createTempFile(folder, filename, "." + extension);
            
            try (InputStream input = uploadedFile.getInputstream()) {
                Files.copy(input, myFile, StandardCopyOption.REPLACE_EXISTING);
            }
            
            System.out.println("Uploaded file "+filename+"."+extension+" successfully saved in " + myFile);
            
            File savedFile = new File("C:\\Users\\azzouz\\eclipse-workspace\\TP\\WebContent\\resources\\default\\images\\"+myFile.getFileName());
            
            File newFile = new File("C:\\Users\\azzouz\\eclipse-workspace\\TP\\WebContent\\resources\\default\\images\\"+filename+"."+extension);
            savedFile.renameTo(newFile);
            
            //ON TRAVAILLE SUR NEWFILE
            byte[] bFile = new byte[(int) newFile.length()];
            
            try {
            	FileInputStream fileInputStream = new FileInputStream(newFile);
            	fileInputStream.read(bFile);
            	fileInputStream.close();
            }catch(Exception e) {
            	e.printStackTrace();
            }

            art.setImage(bFile);
        	
        	artDao.saveOrUpdate(art);
            art = new Article();
      
        }
    }

}
