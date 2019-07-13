import java.io.File
import javax.inject.Inject
import org.gradle.api.artifacts.transform.ArtifactTransform

/**
 * Transform to go from one artifact type to one or multiple other artifact types without changing
 * the artifact's contents.
 */
class GleanMetricsYamlTransform @Inject constructor() : ArtifactTransform() {
    override fun transform(file: File): List<File> {
        val out = File(file, "metrics.yaml")
        if (out.exists()) {
           return listOf(out, File(file, "pings.yaml"))
        }
        return emptyList()
    }
}
