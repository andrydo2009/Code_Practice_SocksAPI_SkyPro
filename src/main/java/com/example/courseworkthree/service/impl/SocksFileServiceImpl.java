package com.example.courseworkthree.service.impl;

import com.example.courseworkthree.service.SocksFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class SocksFileServiceImpl implements SocksFileService {

    @Value("${path.to.data.files}")
    private String socksFilePath;

    @Value("${name.of.socks.file}")
    private String socksFileName;

    @Value("${path.to.data.files}")
    private String socksOperationFilePath;

    @Value("${name.of.operations.file}")
    private String socksOperationFileName;


    @Override
    public boolean cleanSocksDataFile() { //метод удаляет/обновляет файл
        try {
            Path path = Path.of ( socksFilePath , socksFileName ); // class Path предназначен для работы с файлами, в скобках имя файла затем путь
            Files.deleteIfExists ( path );// удаляем старый файл если он есть
            Files.createFile ( path );// создаем новый файл
            return true;
        } catch (IOException e) {
            e.printStackTrace ();
            return false;
        }
    }

    @Override
    public boolean cleanOperationDataFile() { //метод удаляет/обновляет файл
        try {
            Path path = Path.of ( socksOperationFilePath , socksOperationFileName ); // class Path предназначен для работы с файлами, в скобках имя файла затем путь
            Files.deleteIfExists ( path );// удаляем старый файл если он есть
            Files.createFile ( path );// создаем новый файл
            return true;
        } catch (IOException e) {
            e.printStackTrace ();
            return false;
        }
    }

    @Override
    public File getDataSocksFile() {
        return new File ( socksFilePath + "/" + socksFileName );
    }

    @Override
    public File getOperationDataSocksFile() {
        return new File ( socksOperationFilePath + "/" + socksOperationFileName );
    }

}


