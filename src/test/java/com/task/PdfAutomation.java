package com.task;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;



public class PdfAutomation extends BaseClass {

	String url = "file:///C:/Users/VDI003/Downloads/sample.pdf";

	@BeforeTest

	public void environmentSetUp() {

		BaseClass.browserLaunch();

		BaseClass.loadUrl("file:///C:/Users/VDI003/Downloads/sample.pdf");

	}

	@Test

	public void pdfPageCount() throws IOException {

		URL pdfUrl = new URL(url);

		InputStream ip = pdfUrl.openStream();

		BufferedInputStream bf = new BufferedInputStream(ip);

		PDDocument pdDocument = PDDocument.load(bf);

		int numberOfPages = pdDocument.getNumberOfPages();

		System.out.println(numberOfPages);

	}

	@Test

	public void pdfReadAllData() throws IOException {

		URL pdfUrl = new URL(url);

		InputStream ip = pdfUrl.openStream();

		BufferedInputStream bf = new BufferedInputStream(ip);

		PDDocument pdDocument = PDDocument.load(bf);

		PDFTextStripper pdfStripper = new PDFTextStripper();

		String pdfText = pdfStripper.getText(pdDocument);

		System.out.println(pdfText);

	}

	@Test
	public void PdfParticularPageContent() throws IOException {

		URL pdfUrl = new URL(url);

		InputStream ip = pdfUrl.openStream();

		BufferedInputStream bf = new BufferedInputStream(ip);

		PDDocument pdDocument = PDDocument.load(bf);

		PDFTextStripper pdfStripper = new PDFTextStripper();

		pdfStripper.setStartPage(2);

		String pdfTxt = pdfStripper.getText(pdDocument);

		System.out.println(pdfTxt);

	}

}
