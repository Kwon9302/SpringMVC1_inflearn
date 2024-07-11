package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // V2 -> V3
    // MyView -> ModelView ( HttpServletRequest -> paramMap )
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        // 여기까지 modelV2와 동일
        // V2
        // request.setAttribute("member", member);
        // return new MyView("/WEB-INF/views/save-result.jsp");
        // V3변경 사항
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
