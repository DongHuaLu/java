package test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private File[] input;

	private String[] inputContentType;

	private String[] inputFileName;

	@Override
	public String execute() throws Exception {
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/file");
		for (int i = 0; i < input.length; i++) {
			if (input != null) {
				System.out.println(realPath);
				File savefile = new File(new File(realPath), inputFileName[i]);
				if (!savefile.getParentFile().exists())
					savefile.getParentFile().mkdirs();
				FileUtils.copyFile(input[i], savefile);
			}

		}
		return SUCCESS;
	}

	public File[] getInput() {
		return input;
	}

	public void setInput(File[] input) {
		this.input = input;
	}

	public String[] getInputContentType() {
		return inputContentType;
	}

	public void setInputContentType(String[] inputContentType) {
		this.inputContentType = inputContentType;
	}

	public String[] getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String[] inputFileName) {
		this.inputFileName = inputFileName;
	}
}
