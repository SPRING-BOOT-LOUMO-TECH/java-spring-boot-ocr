package com.loumotech.servicves;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface OcrService {
    public String recognizeText(InputStream inputStream) throws IOException;


}
