package com.example.android;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckWord {
    private Set<String> commonWords;

    public CheckWord(Context context) throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("common_words.txt");
        commonWords = new HashSet<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            commonWords.add(scanner.nextLine().toLowerCase());
        }
        scanner.close();
    }

    public boolean isCommon(String str){
        return commonWords.contains(str);
    }
}
