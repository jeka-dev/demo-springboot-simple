import dev.jeka.core.tool.*;
import dev.jeka.core.tool.builtins.project.ProjectKBean;
import dev.jeka.plugins.springboot.SpringbootKBean;

@JkDep("dev.jeka:springboot-plugin") // import from Maven central
class Build extends KBean {

    @JkPostInit(required = true)
    private void postInit(ProjectKBean projectKBean) {
        projectKBean.project.flatFacade.dependencies.compile
                .add("org.springframework.boot:spring-boot-dependencies::pom:4.2.0")
                .add("org.springframework.boot:spring-boot-starter-webmvc");
        projectKBean.project.flatFacade.dependencies.test
                .add("org.springframework.boot:spring-boot-starter-webmvc-test");
    }

    @JkPostInit(required = true)
    private void postInit(SpringbootKBean springbootKBean) {}

}
