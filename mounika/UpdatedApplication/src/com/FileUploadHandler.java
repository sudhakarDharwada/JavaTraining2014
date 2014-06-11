package com;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class FileUploadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "/home/valuelabs/Desktop/uploadedfiles/";

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				Map<String, List<FileItem>> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseParameterMap(request);
				List<FileItem> l = multiparts.get("file");
				for (FileItem item : l) {
					if (!item.isFormField()) {
						System.out.println(item.getName());
						String name = item.getName();
						item.write(new File(UPLOAD_DIRECTORY + name));
					}
				}

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}

		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/dis");
		rd.forward(request, response);
		// response.sendRedirect("/dis");

	}
}