package br.dev.thinkers.employee.controller.error;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class ErrorCustomView implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
        ModelAndView view = new ModelAndView("/error");
        view.addObject("status", status.value());
        switch (status.value()) {
            case 404:
                view.addObject("error", "Página não encontrada");
                view.addObject("message", "A URL para página '"+map.get("path")+ "' não existe.");
                break;
            case 500:
                view.addObject("error", "Ocorreu um error interno no servidor");
                view.addObject("message", "Ocorreu um error inexperado, por favor, tente mais tarde.");
                 break;
            default:
                view.addObject("error", map.get("error"));
                view.addObject("message", map.get("message"));
                break;
        }
        return view;
    }
}
