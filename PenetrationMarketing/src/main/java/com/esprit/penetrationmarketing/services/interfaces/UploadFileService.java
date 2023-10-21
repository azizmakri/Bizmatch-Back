package com.esprit.penetrationmarketing.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
	public boolean addFile(MultipartFile file);
}