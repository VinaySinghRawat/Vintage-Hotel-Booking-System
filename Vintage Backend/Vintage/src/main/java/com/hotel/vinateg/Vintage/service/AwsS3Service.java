package com.hotel.vinateg.Vintage.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.hotel.vinateg.Vintage.exception.OurException;

import java.io.InputStream;

@Service
public class AwsS3Service {

    private final String bucketName = "vintage-hotel-bucket-images";

    @Value("${aws.s3.access.key}")
    private String awsS3AccessKey;
    @Value("${aws.s3.secrete.key}")
    private String awsS3SecreteKey;


    public String saveImageToS3(MultipartFile photo) {
        String s3LocationImage = null;

        try {
            String s2FileName = photo.getOriginalFilename();
            BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIA6GBMDG6HFFOVEJA5", "+Ti8W1lJD+MomFAxnKTiKL5ZrKA/Dc+bqdu777kh");

            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(Regions.US_EAST_1)
                    .build();

            InputStream inputStream = photo.getInputStream();

            ObjectMetadata metadata = new ObjectMetadata();

            metadata.setContentType("image/jpeg");
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s2FileName, inputStream, metadata);
            s3Client.putObject(putObjectRequest);
            return "https://" + bucketName + ".s3.amazonaws.com/" + s2FileName;


        } catch (Exception e) {
            e.printStackTrace();
            throw new OurException("Unable to upload image to s3 bucket");
        }
    }

}