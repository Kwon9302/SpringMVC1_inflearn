package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    // ObjectMapper는 JSON변환 라이브러리(Jackson)가 포함되어 있다.
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Http요청(request)를 바이트코드로 변환한다.
        ServletInputStream inputStream = request.getInputStream();

        // String으로 볼수 있도록(사람이 볼수 있도록) 변환한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        // HelloData에 정의해놓은 Getter,Setter을 통해 username, age를 호출하여 출력한다.
        System.out.println("helloData.username = " + helloData.getUsername());

        System.out.println("helloData.age = " + helloData.getAge());
        response.getWriter().write("ok");
    }
}
