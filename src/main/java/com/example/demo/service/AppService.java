package com.example.demo.service;

import com.example.demo.model.FullName;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AppService {

    private final File directoryBean;

    public AppService(File directoryBean) {
        this.directoryBean = directoryBean;
    }

    public List<List<String>> getReversedNames() throws IOException {
        List<List<String>> names = new ArrayList<>();

        List<File> fileList = new ArrayList<>();
        for (File file1 : Objects.requireNonNull(directoryBean.listFiles())) {
            if (!file1.isDirectory()) {
                fileList.add(file1);
            }
        }

        for (File file : fileList) {
            List<String> ls = FileUtils.readLines(file, "UTF-8");
            List<String> ls2 = new ArrayList<>();
            for (String s : ls) {
                FullName nm = new FullName(s);
                ls2.add(nm.getReversedName());
            }
            names.add(ls2);
        }
        return names;
    }
}
