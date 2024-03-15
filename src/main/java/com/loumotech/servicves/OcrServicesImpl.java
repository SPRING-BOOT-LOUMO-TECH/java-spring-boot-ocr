package com.loumotech.servicves;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Service
public class OcrServicesImpl implements OcrService {

    private final Tesseract tesseract;

    public OcrServicesImpl(Tesseract tesseract) {
        this.tesseract = tesseract;
    }
    public String recognizeText(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        try {
            tesseract.setDatapath("src/main/resources/tessdata");
            tesseract.setLanguage("eng");
            tesseract.setPageSegMode(1);
            tesseract.setOcrEngineMode(1);

            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return "failed";
    }

}
