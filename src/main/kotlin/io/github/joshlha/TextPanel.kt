package io.github.joshlha

import io.github.paulgriffith.kindling.core.ToolPanel
import java.io.File
import javax.swing.Icon
import javax.swing.JScrollPane
import javax.swing.JTextArea

class TextPanel(file: File) : ToolPanel() {
    override val icon: Icon? = null

    private val text = file.readText()

    init {
        name = file.name
        add(
            JScrollPane(
                JTextArea(text).apply {
                    lineWrap = true
                }
            ), "push, grow, span"
        )
    }
}