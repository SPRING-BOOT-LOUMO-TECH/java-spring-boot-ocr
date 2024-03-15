package com.loumotech.controllers;

import com.loumotech.servicves.OcrService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE)
public class OcrController {

    private final OcrService ocrService;

    public OcrController(OcrService ocrService) {
        this.ocrService = ocrService;
    }

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> hello(){
        Map<String, String> text = new HashMap<>();
        text.put("status", "Success");
        text.put("text", "Hello......");
        return ResponseEntity.ok(text);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> recognizeText(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, String> text = new HashMap<>();
        var ocr = ocrService.recognizeText(file.getInputStream());
        if ("".equals(ocr)) {
            text.put("status", "Error");
            text.put("text", "failed");
        } else {
            text.put("status", "Success");
            text.put("text", ocr);
        }

        return ResponseEntity.ok(text);
    }
}
