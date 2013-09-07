/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.yourcompany.struts.form.FileForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-04-2013
 * 
 * XDoclet definition:
 * @struts.action path="/file" name="fileForm" scope="request"
 */
public class FileAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		FileForm fileForm = (FileForm) form;// TODO Auto-generated method stub
		FormFile myfile=fileForm.getMyfile();
		String path=this.getServlet().getServletContext().getRealPath("/file");
		String filename=myfile.getFileName();
		InputStream is=null;
		FileOutputStream fos=null;
		try {
			is=myfile.getInputStream();
			fos=new FileOutputStream(path+"\\"+filename);
			System.out.println(path+"\\"+filename);
			int len=0;
			byte [] buff=new byte[1024];
			while((len=is.read(buff))>0){
				fos.write(buff, 0,len);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}		
		return mapping.findForward("ok");
	}
}