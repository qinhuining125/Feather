package com.feather.system.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author feather
 */
@Service
public class WebfontsSvgParserService {
    public static final String AWESOME_SVG_PATH_PREFIX = "static/def/libs/font-awesome5.15.1/webfonts/";

    private final Logger logger = LoggerFactory.getLogger(WebfontsSvgParserService.class);

    private static List<String> solid;
    private static List<String> brands;
    private static List<String> regular;

    public List<String> getSolid() {
        if (solid == null) {
            solid = get(AWESOME_SVG_PATH_PREFIX + "fa-solid-900.svg");
        }
        return solid;
    }

    public List<String> getBrands() {
        if (brands == null) {
            brands = get(AWESOME_SVG_PATH_PREFIX + "fa-brands-400.svg");
        }
        return brands;
    }

    public List<String> getRegular() {
        if (regular == null) {
            regular = get(AWESOME_SVG_PATH_PREFIX + "fa-regular-400.svg");
        }
        return regular;
    }

    protected List<String> get(String file) {
        String text = getFileContent(file);
        List<String> list = new ArrayList<>();
        if (text != null) {
            String[] arr = StringUtils.splitByWholeSeparator(text, "<glyph glyph-name=\"");
            for (int i = 1; i < arr.length; i++) {
                int at = arr[i].indexOf('"');
                String item = "fa-" + arr[i].substring(0, at);
                // System.out.println(item);
                list.add(item);
            }
        }
        return list;
    }

    protected String getFileContent(String filePath) {
        byte[] bytes = null;
        byte[] b = new byte[1024 * 4];
        int len;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); //
                InputStream is = getClass().getClassLoader().getResourceAsStream(filePath) //
        ) {
            while ((len = is.read(b)) > 0) {
                baos.write(b, 0, len);
                bytes = baos.toByteArray();
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return bytes != null ? new String(bytes) : null;
    }
}
