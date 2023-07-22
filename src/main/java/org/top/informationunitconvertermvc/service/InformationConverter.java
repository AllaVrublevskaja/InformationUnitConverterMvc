package org.top.informationunitconvertermvc.service;

import org.springframework.stereotype.Service;

@Service
public interface InformationConverter {
    String converter(String from, String to, String quantity);
}

