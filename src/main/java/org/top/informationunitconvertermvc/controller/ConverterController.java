package org.top.informationunitconvertermvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.informationunitconvertermvc.service.InformationConverter;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ConverterController {
    public final InformationConverter informationConverter;

    @GetMapping("")
    public String index(Model model) {
        LocalDateTime currentTime = LocalDateTime.now();
        model.addAttribute("curTime", currentTime); // добавить атрибут на страницу
        return "index";
    }

    @GetMapping("convert")
    public String getSolveForm() {
        return "converter";
    }

    @PostMapping("convert")
    public String processSolveForm(@RequestParam String from,
                                   @RequestParam String to,
                                   @RequestParam String quantity,
                                   RedirectAttributes ra) {
        String result = informationConverter.converter(from, to, quantity);
        ra.addFlashAttribute("result", result);
        return "redirect:convert";
    }
}

