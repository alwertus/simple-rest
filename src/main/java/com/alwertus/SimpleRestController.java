package com.alwertus;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class SimpleRestController {
    List<RestResponse> data;

    public SimpleRestController() {
        long i = 0L;
        data = new LinkedList<>();
        data.add(new RestResponse(i++,"Абажур", "составная часть светильника, используется в дизайне интерьеров, художественном оформлении помещений."));
        data.add(new RestResponse(i++,"Аббревиатура", " слово, образованное сокращением слова или словосочетания и читаемое по алфавитному названию начальных букв или по начальным звукам слов, входящих в него"));
        data.add(new RestResponse(i++,"Абзац", "отрезок письменной речи, состоящий из одного или нескольких предложений"));
        data.add(new RestResponse(i++,"Абитуриент", "в большинстве государств и стран лицо, заканчивающее среднее учебное заведение, держащее выпускные испытания или получившее абитур — аттестат зрелости."));
        data.add(new RestResponse(i++, "Абонемент", " договор, по которому одна сторона (абонент[1]) имеет право пользоваться каким-либо имуществом или право требовать оказания определённых услуг от другой стороны периодически, в течение срока действия договора абонемента"));
        data.add(new RestResponse(i++, "Абонент", "договор, по которому одна сторона (абонент[1]) имеет право пользоваться каким-либо имуществом или право требовать оказания определённых услуг от другой стороны периодически, в течение срока действия договора абонемента."));
        data.add(new RestResponse(i, "Шпиён", "Шампиньён"));
    }

    @GetMapping("")
    public List<RestResponse> GetRequest() {
        return data;
    }

    @PostMapping("")
    public List<RestResponse> PostResponse(@RequestBody FindRq rq) {
        if (rq.getFindText() == null || rq.getFindText().isEmpty()) {
            throw new RuntimeException("request text is empty");
        }
        return data
                .stream()
                .filter(e -> e
                        .title()
                        .toUpperCase(Locale.ROOT)
                        .startsWith(rq.findText.toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }
}
