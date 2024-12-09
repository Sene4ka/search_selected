package com.github.sene4ka.searchplugin

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

class SearchAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val editor = event.getData(PlatformDataKeys.EDITOR)
        if (editor != null) {
            val selected = editor.selectionModel.selectedText
            var encoded = ""
            try {
                encoded = URLEncoder.encode(selected, "UTF-8")
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }
            val url = String.format("https://www.google.com/search?q=%s", encoded)
            BrowserUtil.browse(url)
        }
    }
}