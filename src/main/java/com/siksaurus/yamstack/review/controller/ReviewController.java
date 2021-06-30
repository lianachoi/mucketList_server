package com.siksaurus.yamstack.review.controller;

import com.siksaurus.yamstack.global.CommonResponse;
import com.siksaurus.yamstack.review.s3upload.S3Uploader;
import com.siksaurus.yamstack.review.domain.Review;
import com.siksaurus.yamstack.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    private final S3Uploader s3Uploader;

//    /* 여기얌 - 리뷰 리스트 조회*/
//    @GetMapping("/list")
//    public ResponseEntity<List<ReviewVO>> list() {
//        List<ReviewVO> reviews = reviewService.getReviewList();
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(reviews);
//    }
    /* 여기얌 - 리뷰 리스트 조회*/
    @GetMapping("/list")
    public ResponseEntity list(final Pageable pageable) {
        Page<Review> reviews = reviewService.getReviewList(pageable);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(reviews);
    }
    /* 얌/여기얌 - 리뷰 상세 조회*/
    @GetMapping("/{review_id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("review_id")  Long review_id) {
        Review review = reviewService.getReviewById(review_id);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(review);
    }

    /* 얌 - 리뷰 등록*/
    @PostMapping("")
    public ResponseEntity<CommonResponse> createReview(@RequestPart("reviewdata") ReviewDTO.CreateReviewDTO dto,
                                                       @RequestPart("image") MultipartFile multipartFile//List<MultipartFile> multipartFiles
                                                                        ) throws IOException {

        String filePath = s3Uploader.upload(multipartFile, "user-upload");
        dto.setImagePath(filePath);
        Long new_id = reviewService.createReview(dto);

        CommonResponse response =  CommonResponse.builder()
                .code("REVIEW_CREATED")
                .status(200)
                .message("review [" + new_id + "] has bean created")
                .build();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
//    /* 얌 - 리뷰 등록*/
//    @PostMapping("")
//    public ResponseEntity<CommonResponse> createReview(@ModelAttribute FormWrapper formWrapper) throws IOException {
//
//        String filePath = s3Uploader.upload(formWrapper.getImage(), "user-upload");
//
//        ReviewDTO.CreateReviewDTO dto = new ReviewDTO.CreateReviewDTO();
//        dto.setImagePath(filePath);
//        Long new_id = reviewService.createReview(dto);
//
//        CommonResponse response =  CommonResponse.builder()
//                .code("REVIEW_CREATED")
//                .status(200)
//                .message("review [" + new_id + "] has bean created")
//                .build();
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(response);
//    }

//    @PostMapping("/upload")
//    @ResponseBody
//    public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
//        return s3Uploader.upload(multipartFile, "user-upload");
//    }
}
