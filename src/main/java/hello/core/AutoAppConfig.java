package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//컴포넌트 스캔하면 자동으로 등록해줌.
@Configuration
@ComponentScan(
        //베이지 스캐너는 해당 위치에 있는 컴포넌트만 조회
        //모든 자바 코드를 뒤지기 때문에, 걍 지정하는게 속도면에서 굿
        //basePackages = {"hello.core.member", "hello.core.order"},

        //강사 권장 사항
        //페키지를 지정하지 않고, 클래스 위치를 지정해. 클래스 위치를 프로젝트 최상단에 위치 .
        //Appconfig같은걸 걍 hello.core에 넣기하면 굿

        //config가 붙은 애는 필터하기. 스캔하면 기존 appconfig도 자동으로 스캔되기 때문에. 이럼 수동이랑 충돌
        //얘를 하는 이유는 configura가 component가 자동으로 붙기때문에.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {

}
