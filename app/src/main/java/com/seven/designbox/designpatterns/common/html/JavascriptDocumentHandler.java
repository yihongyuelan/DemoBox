package com.seven.designbox.designpatterns.common.html;

import android.text.TextUtils;

public class JavascriptDocumentHandler implements DocumentHandler {

    @Override
    public String getFileExtension() {
        return "js";
    }

    @Override
    public String getFileFormattedString(String fileString) {
        return TextUtils.htmlEncode(fileString).replace("\n", "<br>");
    }

    @Override
    public String getFileMimeType() {
        return "text/html";
    }

    @Override
    public String getFilePrettifyClass() {
        return "prettyprint";
    }

    @Override
    public String getFileScriptFiles() {
        return "";
    }

}
