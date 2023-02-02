package io.github.joshlha

import com.formdev.flatlaf.extras.FlatSVGIcon
import io.github.paulgriffith.kindling.core.Tool
import io.github.paulgriffith.kindling.core.ToolPanel
import java.nio.file.Path

object TextTool : Tool {
    override val extensions = listOf("txt")
    override val description = "Opens a text file."
    override val icon: FlatSVGIcon = FlatSVGIcon("Placeholder")
    override val title = "TextTool"
    override fun open(path: Path): ToolPanel {
        return TextPanel(path.toFile())
    }
}

class TextToolProxy : Tool by TextTool