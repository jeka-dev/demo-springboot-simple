import dev.jeka.core.tool.JkInjectClasspath;
import dev.jeka.core.tool.JkInjectRunbase;
import dev.jeka.core.tool.KBean;
import dev.jeka.core.tool.builtins.project.ProjectKBean;
import dev.jeka.plugins.springboot.SpringbootKBean;

@JkInjectClasspath("dev.jeka:springboot-plugin") // import from Maven central
public class Build extends KBean {

    @JkInjectRunbase
    ProjectKBean projectKBean;

    @Override
    protected void init() {
        load(SpringbootKBean.class);  // SpringbootKBean.class comes from dev.jeka:springboot-plugin lib
        projectKBean.project.flatFacade.compileDependencies
                .add("org.springframework.boot:spring-boot-dependencies::pom:3.3.5")
                .add("org.springframework.boot:spring-boot-starter-web");
        projectKBean.project.flatFacade.testDependencies
                .add("org.springframework.boot:spring-boot-starter-test");
    }

}
