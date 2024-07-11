package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    // 생성자
    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    // getter
    public String getViewName() {
        return viewName;
    }
    // setter
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    // getter
    public Map<String, Object> getModel() {
        return model;
    }
    // setter
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
