package com.company.paymentapp.service.photo;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.company.paymentapp.exception.BaseException.unexpected;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl {
    private final Storage storage;
    public String getUrls(MultipartFile multipartFiles) {
        String photoUrls = null;


        try {
            BlobId blobId = BlobId.of("car_image_1", System.currentTimeMillis() + "_" + multipartFiles.getOriginalFilename());
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();
            byte[] arr = multipartFiles.getBytes();
            storage.create(blobInfo, arr);
            photoUrls = storage.get(blobId).getMediaLink();

        } catch (IOException e) {
            throw unexpected();
        }



        return photoUrls;
    }
}
