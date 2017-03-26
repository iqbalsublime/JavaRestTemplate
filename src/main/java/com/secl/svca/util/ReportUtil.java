package com.secl.svca.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.core.UriInfo;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.secl.svca.bean.LoginBean;
import com.secl.svca.bean.ReportParamBean;

public class ReportUtil implements Constant {

	private String folderName;
	private DriverManagerDataSource dataSource;
	
	@SuppressWarnings("unused")
	private void init() {
		if(folderName == null || folderName.isEmpty()){
			folderName = "generatereport";
		}
    }
	
	public ReportParamBean getReportParamBean(UriInfo info) {
		ReportParamBean model = new ReportParamBean();
		model.reportName = info.getQueryParameters().getFirst("reportName");
		model.destinationFolder = info.getQueryParameters().getFirst("destinationFolder");
		model.fromDate = info.getQueryParameters().getFirst("fromDate");
		model.toDate = info.getQueryParameters().getFirst("toDate");
		if(info.getQueryParameters().getFirst("oid") != null) {
			model.oid = info.getQueryParameters().getFirst("oid");			
		}
		if(info.getQueryParameters().getFirst("oids") != null) {
			model.oids = info.getQueryParameters().getFirst("oids").split(",");			
		}
		model.loginBean = info.getQueryParameters().getFirst("loginBean") == null ? 
				null : (LoginBean) GsonUtil.parseObject(info.getQueryParameters().getFirst("loginBean"), LoginBean.class);
        return model;
    }
	
	public Map<String, Object> getParam(ServletContext context, String personImagePath, String subReportDir){
		Map<String, Object> params = new HashMap<String, Object>();
		if(personImagePath != null && !personImagePath.isEmpty()){
			params.put("imagePath", context.getRealPath(personImagePath));
		}
		if(subReportDir != null && !subReportDir.isEmpty()){
			params.put("SUBREPORT_DIR", subReportDir);
		}
		return params;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String generateReport(ServletContext servletContext, String destinationFolder, 
			String sourceFileName, String reportFileName, String fileType, Map params, List data, 
			String reportDataSource) throws Exception {
		JasperPrint jasperPrint = null;
		String rootPath = servletContext.getRealPath("");
		File file = new File(rootPath + File.separator + folderName);
		if(!file.exists()){
			file.mkdir();
		} else {
			delete(file);
		}
		String sourceFileDestination = rootPath + File.separator + REPORT + File.separator + destinationFolder + File.separator + sourceFileName;
		String reportFileDestination = rootPath + File.separator + folderName + File.separator + reportFileName;
		JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(sourceFileDestination);
		if(reportDataSource.equalsIgnoreCase(JAVA_BEAN)) {
			jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(data));
		} else {
			jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());
		}
        if(fileType.equalsIgnoreCase(PDF)){
        	JasperExportManager.exportReportToPdfFile(jasperPrint, reportFileDestination);
        }
        return folderName + "/" + reportFileName;
	}
	

	private void delete(File file) {
		String[] fileList = file.list();
        int size = fileList.length;
        for(int i = 0 ; i < size ; i++) {
            File fileOrFolder = new File(file.getPath()+"/"+fileList[i]);
            fileOrFolder.delete();
        }
	}
	
	
	// Setter
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	
}









