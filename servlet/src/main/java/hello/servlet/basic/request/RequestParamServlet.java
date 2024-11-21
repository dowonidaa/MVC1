package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getParameterNames().asIterator()
                .forEachRemaining(name ->
                        System.out.println(name + "=" + req.getParameter(name)));
        System.out.println();

        req.getParameterNames().asIterator()
                .forEachRemaining(name ->
                        {
                            String[] parameterValues = req.getParameterValues(name);
                            for (String parameterValue : parameterValues) {
                                System.out.println(name + "=" + parameterValue);
                            }
                        }
                );
    }
}
