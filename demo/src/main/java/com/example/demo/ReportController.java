package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ReportController {
	
	@Autowired
	DataSource datasource;
	
	@GetMapping("fileDown")
	public void filedown(HttpServletResponse response) throws IOException {
		FileInputStream fi = new FileInputStream("C:/Temp/data.txt");
		int readByte;
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setHeader("Content-Disposition", "attachment; filename=" + "data.txt"); // 파일 다운받을 때 파일명 지정해줘야 제대로 받아짐.
		while((readByte = fi.read()) != -1) {
			response.getOutputStream().write((char)readByte); // 타입 캐스팅 안 해주면 int 값 그대로 (115...) 숫자 나옴.
		}
		fi.close();
	};
	
	// 오류
	@GetMapping("report")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 레포트 파일 읽기
		InputStream jasperStream = getClass().getResourceAsStream("/reports/emp.jasper");
		
		// 레포트 파일 + 데이터 연결
		Connection conn = datasource.getConnection();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, null, conn);
		conn.close();
		
		// 출력
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
	// PdfView, PdfViewDown
	@GetMapping("pdfView")
	public ModelAndView pdfview() throws Exception {
		return new ModelAndView("pdfView", "filename", "/reports/emp.jasper");
	}
	
	@GetMapping(value = "pdfViewDown")
	public ModelAndView pdfViewDown() throws Exception {
		return new ModelAndView("pdfViewDown", "filename", "/reports/emp.jasper");
	}
	
}
