package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerAdapter;

import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    // ControllerV3 를 처리할 수 있는 어댑터를 뜻한다.
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // supports를 통해 handler는 ControllerV3만 지원하는것을 알기 때문에 타입 변환등에 문제가 없다.
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }

//    private void initHandlerMappingMap() {
//        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new
//                MemberFormControllerV3());
//        handlerMappingMap.put("/front-controller/v5/v3/members/save", new
//                MemberSaveControllerV3());
//        handlerMappingMap.put("/front-controller/v5/v3/members", new
//                MemberListControllerV3());
//            //V4 추가
//        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new
//                MemberFormControllerV4());
//        handlerMappingMap.put("/front-controller/v5/v4/members/save", new
//                MemberSaveControllerV4());
//        handlerMappingMap.put("/front-controller/v5/v4/members", new
//                MemberListControllerV4());
//    }
//
//    private void initHandlerAdapters() {
//        handlerAdapters.add(new ControllerV3HandlerAdapter()); handlerAdapters.add(new ControllerV4HandlerAdapter()); //V4 추가
//    }

}
