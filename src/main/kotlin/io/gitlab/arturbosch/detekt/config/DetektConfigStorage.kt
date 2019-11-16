package io.gitlab.arturbosch.detekt.config

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.annotations.Tag
import java.io.File

/**
 * @author Dmytro Primshyts
 */
@State(
    name = "DetektProjectConfiguration",
    storages = [Storage("detekt.xml")]
)
class DetektConfigStorage : PersistentStateComponent<DetektConfigStorage> {

    @Tag
    var enableDetekt: Boolean = false

    @Tag
    var enableFormatting: Boolean = false

    @Tag
    var autoCorrect: Boolean = false

    @Tag
    var buildUponDefaultConfig: Boolean = false

    @Tag
    var failFast: Boolean = false

    @Tag
    var treatAsError: Boolean = false

    @Tag
    var rulesPath: String = ""

    @Tag
    var baselinePath: String = ""

    override fun getState(): DetektConfigStorage? = this

    override fun loadState(state: DetektConfigStorage) {
        this.enableDetekt = state.enableDetekt
        this.enableFormatting = state.enableFormatting
        this.autoCorrect = state.autoCorrect
        this.buildUponDefaultConfig = state.buildUponDefaultConfig
        this.failFast = state.failFast
        this.rulesPath = state.rulesPath
        this.baselinePath = state.baselinePath
        this.treatAsError = state.treatAsError
}

    companion object {

        /**
         * Get instance of [DetektConfigStorage] for given project.
         *
         * @param project the project
         */
        fun instance(project: Project): DetektConfigStorage =
            ServiceManager.getService(project, DetektConfigStorage::class.java)
    }

}


