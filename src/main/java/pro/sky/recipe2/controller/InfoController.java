package pro.sky.recipe2.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
@Tag(name="ИНФО controller", description = "Информация о проекте")
@RestController
public class InfoController {
@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
    return "<br><br><br><br><br><br><br><h1 style=\"text-align: center\">" +
            "Hello, People !!!<br><br>"+"(Приложение запущено)";
    }
    @GetMapping("/info")
    public String about() {
        return "Имя ученика: Дмитрий. <br>" +
                " Название проекта: Рецепты. <br>" +
                " Дата создания проекта: 10.01.2023г. <br>"+
                " Описание: (Рецепты для кулинарии)";
    }
}
