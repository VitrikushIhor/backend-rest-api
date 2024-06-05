package ua.flowerista.shop.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import jakarta.annotation.PostConstruct;

@Service
public class CloudinaryService {


    @Value("${cloudinary.url}")
    private String url;

    private Cloudinary cloudinary;

    @PostConstruct
    public void init() {
        this.cloudinary = new Cloudinary(url);
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return (String) result.get("secure_url");
    }

    public void deleteImage(String publicId) throws IOException {
        cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }

    public String extractPublicId(String imageUrl) {
        String withoutProtocol = imageUrl.replaceFirst("^(https?://)?[^/]+/", "");

        int index = withoutProtocol.indexOf('/');
        if (index != -1) {
            return withoutProtocol.substring(0, index);
        } else {
            return withoutProtocol;
        }
    }

}
